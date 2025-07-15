package rahulshettyacademy.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindBy;

import rahulshettyacademy.AbstractComponents.AbstractComponent;

import java.util.List;

import org.openqa.selenium.By;

public class OrderPage extends AbstractComponent {

	WebDriver driver;
	
	public OrderPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
 
	@FindBy(css="td td:nth-child(3)")
	private List<WebElement> orderList;
	
	@FindBy(css=".totalRow button")
	 WebElement checkoutEle;
	
	
	public Boolean VerifyProduct(String productName)
	{
		Boolean match =	orderList.stream().anyMatch(product->product.getText().equalsIgnoreCase(productName));
		return match;
	}
	
}
