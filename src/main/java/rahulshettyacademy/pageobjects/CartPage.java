package rahulshettyacademy.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindBy;


import rahulshettyacademy.AbstractComponents.AbstractComponent;

public class CartPage extends AbstractComponent {
	
	WebDriver driver;
	
		
	@FindBy(css=".totalRow button")
	WebElement checkoutEle;
	
	@FindBy(css=".cartSection h3")
	private List<WebElement> cartList;
	
	@FindBy(css="input[placeholder='Select Country']")
	WebElement inputCountry;
	
	@FindBy(xpath="(//span[@class='ng-star-inserted'])[2]")
	WebElement selectCountry;
	
	@FindBy(css=".btnn.action__submit.ng-star-inserted")
	WebElement finalSubmit;
	
	public CartPage (WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public Boolean VerifyProductDisplay(String productName)
	{
		Boolean match = cartList.stream().anyMatch(product->product.getText().equalsIgnoreCase(productName));
		return match;
	}
	
	public void goToCheckout()
	{
		checkoutEle.click();
	}
	
	public void selectCountries () throws InterruptedException
	{
		Thread.sleep(1000);
		inputCountry.sendKeys("Ind");
		Thread.sleep(1000);
		selectCountry.click();
	}

	public ConfirmationPage submitOrder()
	{
		finalSubmit.click();
		return new ConfirmationPage(driver);
	}
}
