package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShippingAddress {
	
private static WebElement element = null;
	
	public static WebElement ClcikOnShipping(WebDriver driver) {
		
		element =	driver.findElement(By.xpath("//*[text()='Shipping method']"));
		return element;
		
	}
	
	public static WebElement ShippingType(WebDriver driver) {
		
		element =	driver.findElement(By.xpath("//input[@name=\"shippingoption\" and @checked=\"checked\"]"));
		return element;
		
	}
	
	public static WebElement ContinueShipping(WebDriver driver) {
		
		element =	driver.findElement(By.xpath("//*[text()='Continue' and ancestor::*[@id=\"shipping-method-buttons-container\"]]"));
		return element;
		
	}

	public static WebElement SelectPaymentMethod(WebDriver driver) {
	
	element =	driver.findElement(By.xpath("//input[@id=\"paymentmethod_0\"  and @checked=\"checked\"]"));
	return element;
	
}

	public static WebElement ContinuePayment(WebDriver driver) {
	
	element =	driver.findElement(By.xpath("//*[text()='Continue' and ancestor::*[@id=\"payment-method-buttons-container\"]]"));
	return element;
	
}

	public static WebElement ContinuePaymentInfo(WebDriver driver) {
	
	element =	driver.findElement(By.xpath("//*[text()='Continue' and ancestor::*[@id=\"payment-info-buttons-container\"]]"));
	return element;
	
}

	public static WebElement AssertOrderReviewData(WebDriver driver) {
	
	element =	driver.findElement(By.xpath("//div[@class='order-review-data' and descendant::*[text()='Billing Address'] and descendant::*[text()='Shipping Address']]"));
	return element;
	
}
	
	public static WebElement ConfirmOrder(WebDriver driver) {
		
		element =	driver.findElement(By.xpath("//button[text()='Confirm']"));
		return element;
		
	}
	
	public static WebElement OrderNo(WebDriver driver) {
		
		element =	driver.findElement(By.xpath("//*[contains(text(),'Order number:')]"));
		return element;
		
	}
	
	public static WebElement ContinueOrderComplete(WebDriver driver) {
		
		element =	driver.findElement(By.xpath("//*[text()='Continue' and contains(@class,'order-completed')]"));
		return element;
		
	}


}
