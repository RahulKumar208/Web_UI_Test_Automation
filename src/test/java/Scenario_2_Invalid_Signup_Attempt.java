import java.io.FileInputStream;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.BasicConfigurator;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Pages.Register;

public class Scenario_2_Invalid_Signup_Attempt {
	
	static WebDriver driver = null;
	public static void main(String[] args) throws IOException {
	
		BasicConfigurator.configure();
	
	 	driver = new ChromeDriver();
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		
		FileInputStream file = new FileInputStream("C:\\Users\\pc\\eclipse-workspace\\GoogleSearchTests\\Book1.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Sheet2");
		
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
		        

		     // Verification: Check if an error message is displayed
		     if (isErrorMessageDisplayed()) {
		         System.out.println("Registration failed. Error message displayed.");
		     } else {
		         System.out.println("Registration succeeded. Error message not displayed.");
		     }

		      //  Register.ContinueAfterRegistration(driver).click();
		    }
		
		}
	
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
		
		private static boolean isErrorMessageDisplayed() {
		    try {
		        return driver.findElement(By.xpath("//*[contains(text(),'required')]")).isDisplayed();
		    } catch (NoSuchElementException e) {
		        return false;
		    }
		}

}
