import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.BasicConfigurator;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Pages.AddToCart;
import Pages.Login;
import Pages.Register;
import Pages.SearchBox;

public class Scenario_4_Verify_Cart_Functionality {
	
	 static WebDriver driver = null;
		public static void main(String[] args) throws IOException {
			BasicConfigurator.configure();
			
			//System.setProperty("webdriver.chrome.driver", projectPath+"Drivers/ChromeDriver/chromedriver.exe");
			 driver = new ChromeDriver();
			driver.get("https://demo.nopcommerce.com/");
			driver.manage().window().maximize();
			  
			    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
			    // Check if the user is already logged in
		/*	    if (isUserLoggedIn()) {
			        // Registration Process
			        Register.RegisterLink(driver).click();
			        Register.FirstName(driver).sendKeys("Eric");
			        Register.LastName(driver).sendKeys("Walton");
			        Register.Email(driver).sendKeys("eric.walton@gmail.com");
			        Register.Password(driver).sendKeys("password123");
			        Register.ConfirmPassword(driver).sendKeys("password123");

			        Register.RegistrationButton(driver).click();
			        Register.RegistrationCompleted(driver);
			        Register.ContinueAfterRegistration(driver).click();
			    }
			    
		*/	    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			    // Login Process
			    Login.LoginLink(driver).click();
			    Login.Email(driver).sendKeys("eric.walton@gmail.com");
			    Login.Password(driver).sendKeys("password123");
			    Login.LoginButton(driver).click();

			 
			    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
			  
			  
			SearchBox.Searchbar(driver).sendKeys("Lenovo Thinkpad X1 Carbon Laptop");
			SearchBox.SearchButton(driver).click();
			AddToCart.Addtobucket(driver).click();
			
			SearchBox.Searchbar(driver).sendKeys("Lenovo IdeaCentre 600 All-in-One PC");
			SearchBox.SearchButton(driver).click();
			AddToCart.Addtobucket(driver).click();
			
			driver.get("https://demo.nopcommerce.com/cart");
			AddToCart.AssertProductAdded(driver);	
			AddToCart.AssertOtherProductAdded(driver);
			driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

			//Modify the quantity of a product
			driver.findElement(By.xpath("//tr[descendant::*[text()='Lenovo IdeaCentre 600 All-in-One PC']]//*[@class=\"quantity\" and descendant::*[@value=\"1\"]]"));
			SearchBox.Searchbar(driver).sendKeys("Lenovo IdeaCentre 600 All-in-One PC");
			SearchBox.SearchButton(driver).click();
			AddToCart.Addtobucket(driver).click();
			driver.get("https://demo.nopcommerce.com/cart");
			AddToCart.AssertOtherProductAdded(driver);
			driver.findElement(By.xpath("//tr[descendant::*[text()='Lenovo IdeaCentre 600 All-in-One PC']]//*[@class=\"quantity\" and descendant::*[@value=\"2\"]]"));
			driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
			
			//Remove Product from Cart
			driver.findElement(By.xpath("//tr[descendant::*[text()='Lenovo Thinkpad X1 Carbon Laptop']]//*[@class=\"remove-btn\"]")).click();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			
			List<WebElement> myListToCheck=driver.findElements(By.xpath("//tr[descendant::*[contains(text(),'Lenovo')]]"));
			if(myListToCheck.size()<=1){
				System.out.println("Product removed successfully from the cart");
			}else{
				System.out.println("Product is still present in the cart");
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

		private static void logout() {
		
	        driver.findElement(By.xpath("//a[text()='Log out']")).click();
	    		
		}
		
		
	}




