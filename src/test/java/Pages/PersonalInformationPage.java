package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PersonalInformationPage {
	
private static WebElement element = null;
	
	public static WebElement SelectCountry(WebDriver driver) {
		
		element =	driver.findElement(By.xpath("//select[@data-trigger=\"country-select\"]"));
		return element;
		
	}
	
	public static WebElement City(WebDriver driver) {
		
		element =	driver.findElement(By.xpath("//*[@id=\"BillingNewAddress_City\"]"));
		return element;
		
	}
	
	public static WebElement Address(WebDriver driver) {
		
		element =	driver.findElement(By.xpath("//*[@id=\"BillingNewAddress_Address1\"]"));
		return element;
		
	}

	public static WebElement ZipCode(WebDriver driver) {
	
	element =	driver.findElement(By.xpath("//*[@id=\"BillingNewAddress_ZipPostalCode\"]"));
	return element;
	
}

	public static WebElement PhoneNo(WebDriver driver) {
	
	element =	driver.findElement(By.xpath("//*[@id=\"BillingNewAddress_PhoneNumber\"]"));
	return element;
	
}

	public static WebElement ContinueButton(WebDriver driver) {
	
	element =	driver.findElement(By.xpath("//button[text()='Continue' and ancestor::*[@id=\"billing-buttons-container\"]]"));
	return element;
	
}

}
