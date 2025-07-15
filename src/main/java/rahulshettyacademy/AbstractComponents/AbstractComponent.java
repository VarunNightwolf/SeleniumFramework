package rahulshettyacademy.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import rahulshettyacademy.pageobjects.CartPage;
import rahulshettyacademy.pageobjects.OrderPage;

public class AbstractComponent {
	
	WebDriver driver;
	
	@FindBy(css="[routerlink='/dashboard/cart']")
	WebElement goToCarT;
	
	@FindBy(css="[routerlink*=myorders]")
			WebElement orderHeader;
	

	public AbstractComponent(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);

	}
	

	
	public void waitForElement(By findBy)
	{
		
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
		w.until(ExpectedConditions.visibilityOfElementLocated(findBy));
		
		
	}

	public CartPage goToCartPage()
	{
		CartPage carPage = new CartPage(driver);
		goToCarT.click();
		return carPage;
	}
	
	public void waitForElementDissappear(WebElement ele) throws InterruptedException
	{

		Thread.sleep(2000);
		//		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
//		w.until(ExpectedConditions.invisibilityOf
//				(ele));
		
	}
	
	public void waitForElementToAppear(WebElement findBy) throws InterruptedException
	{

		
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
		w.until(ExpectedConditions.visibilityOf(findBy));
		
	}

	public OrderPage goToOrdersPage()
	{
		
		OrderPage orderPage = new OrderPage(driver);
		orderHeader.click();
		return orderPage;
	}
	
	
}
