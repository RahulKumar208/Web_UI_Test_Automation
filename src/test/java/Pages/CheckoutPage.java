package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutPage {
	private static WebElement element = null;
	
public static WebElement ClickOnCheckbox(WebDriver driver) {
		
		element =	driver.findElement(By.xpath("//*[text()='I agree with the terms of service and I adhere to them unconditionally']"));
		return element;
		
	}
	
	public static WebElement CheckoutButton(WebDriver driver) {
		
		element =	driver.findElement(By.xpath("//button[@id='checkout']"));
		return element;
		
	}

}
