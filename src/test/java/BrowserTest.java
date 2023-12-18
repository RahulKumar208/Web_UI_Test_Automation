import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;


import org.apache.log4j.BasicConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import Pages.AddToCart;
import Pages.CheckoutPage;
import Pages.Login;
import Pages.PersonalInformationPage;
import Pages.Register;
import Pages.SearchBox;
import Pages.ShippingAddress;


public class BrowserTest {
	
	 static WebDriver driver = null;
	
	public static void main(String[] args) throws IOException {
		BasicConfigurator.configure();
		
		//System.setProperty("webdriver.chrome.driver", projectPath+"Drivers/ChromeDriver/chromedriver.exe");
		 driver = new ChromeDriver();
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		
		FileInputStream file = new FileInputStream("C:\\Users\\pc\\eclipse-workspace\\Book1.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		
		int rowcount = sheet.getLastRowNum(); // return raw count
		int columncount = sheet.getRow(0).getLastCellNum(); // return column count
		
		for (int row = 1; row <= rowcount; row++) {
		    XSSFRow currentrow = sheet.getRow(row); // focus on the current row

		    String first_Name = currentrow.getCell(0).getStringCellValue();
		    String last_Name = currentrow.getCell(1).getStringCellValue();
		    String email = currentrow.getCell(2).getStringCellValue();
		    String password = currentrow.getCell(3).getStringCellValue();
		    String confirm_Password = currentrow.getCell(4).getStringCellValue();
		    
		    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		    // Check if the user is already logged in
		    if (isUserLoggedIn()) {
		        // Registration Process
		        Register.RegisterLink(driver).click();
		        Register.FirstName(driver).sendKeys(first_Name);
		        Register.LastName(driver).sendKeys(last_Name);
		        Register.Email(driver).sendKeys(email);
		        Register.Password(driver).sendKeys(password);
		        Register.ConfirmPassword(driver).sendKeys(confirm_Password);

		        Register.RegistrationButton(driver).click();
		        Register.RegistrationCompleted(driver);
		        Register.ContinueAfterRegistration(driver).click();
		    }
		    
		    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		    // Login Process
		    Login.LoginLink(driver).click();
		    Login.Email(driver).sendKeys(email);
		    Login.Password(driver).sendKeys(password);
		    Login.LoginButton(driver).click();

		    // Perform actions after login
		    SearchBox.Searchbar(driver).sendKeys("Lenovo Thinkpad X1 Carbon Laptop");
		    SearchBox.SearchButton(driver).click();
		    
		    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		    // Logout if not the last iteration
		    if (row < rowcount) {
		        logout();
		    }
		}
	
		
		
		AddToCart.Addtobucket(driver).click();
		driver.get("https://demo.nopcommerce.com/cart");
		AddToCart.AssertProductAdded(driver);		
		
		CheckoutPage.ClickOnCheckbox(driver).click();
		CheckoutPage.CheckoutButton(driver).click();
		
		Select drpCountry = new Select(PersonalInformationPage.SelectCountry(driver));
		drpCountry.selectByVisibleText("Germany");
		
		PersonalInformationPage.City(driver).sendKeys("Berlin");
		PersonalInformationPage.Address(driver).sendKeys("Alexa");
		PersonalInformationPage.ZipCode(driver).sendKeys("10969");
		PersonalInformationPage.PhoneNo(driver).sendKeys("+4917612345678");
		PersonalInformationPage.ContinueButton(driver).click();

		
		//Shipping Method
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		ShippingAddress.ClcikOnShipping(driver).click();
		ShippingAddress.ShippingType(driver).click();
		ShippingAddress.ContinueShipping(driver).click();
		ShippingAddress.SelectPaymentMethod(driver).click();
		ShippingAddress.ContinuePayment(driver).click();
		ShippingAddress.ContinuePaymentInfo(driver).click();
		ShippingAddress.AssertOrderReviewData(driver);
		ShippingAddress.ConfirmOrder(driver).click();
		ShippingAddress.OrderNo(driver);
		ShippingAddress.ContinueOrderComplete(driver).click();
			
		
		
		// driver.close();
	//	driver.quit();
		
	}

	private static boolean isUserLoggedIn() {
	    try {
	        // Check for elements that are specific to the logged-in state
	        return driver.findElement(By.xpath("//a[text()='Register']")).isDisplayed();
	    } catch (NoSuchElementException e) {
	        // Elements specific to the logged-in state not found, user is not logged in
	        return true;
	    }
	}

	private static void logout() {
		
	        driver.findElement(By.xpath("//a[text()='Log out']")).click();
	    		
	}
    
}