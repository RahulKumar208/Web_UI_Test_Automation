package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Register {
	
	private static WebElement element = null;
	
	public static WebElement RegisterLink(WebDriver driver) {
		
		element =	driver.findElement(By.xpath("//a[text()='Register']"));
		return element;
		
	}
	
	public static WebElement FirstName(WebDriver driver) {
		
		element =	driver.findElement(By.xpath("//input[@id='FirstName']"));
		return element;
		
	}
	
	public static WebElement LastName(WebDriver driver) {
		
		element =	driver.findElement(By.xpath("//input[@id='LastName']"));
		return element;
		
	}

	public static WebElement Email(WebDriver driver) {
	
	element =	driver.findElement(By.xpath("//input[@id='Email']"));
	return element;
	
}

	public static WebElement Password(WebDriver driver) {
	
	element =	driver.findElement(By.xpath("//input[@id='Password']"));
	return element;
	
}

	public static WebElement ConfirmPassword(WebDriver driver) {
	
	element =	driver.findElement(By.xpath("//input[@id='ConfirmPassword']"));
	return element;
	
}

	public static WebElement RegistrationButton(WebDriver driver) {
	
	element =	driver.findElement(By.xpath("//button[@id='register-button']"));
	return element;
	
}
	
	public static WebElement RegistrationCompleted(WebDriver driver) {
		
		element =	driver.findElement(By.xpath("//*[text()='Your registration completed']"));
		return element;
		
	}
	
	public static WebElement ContinueAfterRegistration(WebDriver driver) {
		
		element =	driver.findElement(By.xpath("//a[text()='Continue']"));
		return element;
		
	}


}
