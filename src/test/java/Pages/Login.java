package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Login {
	
private static WebElement element = null;
	
	public static WebElement LoginLink(WebDriver driver) {
		
		element =	driver.findElement(By.xpath("//a[text()='Log in']"));
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

	public static WebElement LoginButton(WebDriver driver) {
	
	element =	driver.findElement(By.xpath("//button[text()='Log in']"));
	return element;
	
}
	

}
