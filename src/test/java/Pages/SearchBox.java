package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchBox {
	
private static WebElement element = null;
	
	public static WebElement Searchbar(WebDriver driver) {
		
		element =	driver.findElement(By.xpath("//input[@placeholder=\"Search store\"]"));
		return element;
		
	}
	
	public static WebElement SearchButton(WebDriver driver) {
		
		element =	driver.findElement(By.xpath("//button[text()='Search' and @type=\"submit\"]"));
		return element;
		
	}

}
