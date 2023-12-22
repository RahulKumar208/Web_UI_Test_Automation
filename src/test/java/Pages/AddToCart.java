package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddToCart {
	
private static WebElement element = null;
	
	public static WebElement Addtobucket(WebDriver driver) {
		
		element =	driver.findElement(By.xpath("//button[text()='Add to cart']"));
		return element;
		
	}
	
	public static WebElement AssertProductAdded(WebDriver driver) {
		
		element =	driver.findElement(By.xpath("//tr[descendant::*[text()='Lenovo Thinkpad X1 Carbon Laptop']]"));
		return element;
		
	}
	
	public static WebElement AssertOtherProductAdded(WebDriver driver) {
		
		element =	driver.findElement(By.xpath("//tr[descendant::*[text()='Lenovo IdeaCentre 600 All-in-One PC']]"));
		return element;
		
	}


}

//driver.findElement(By.xpath("//span[@title='Close']")).click();
//driver.findElement(By.xpath("//span[@class='cart-qty']")).click();