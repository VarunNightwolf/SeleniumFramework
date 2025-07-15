package rahulshettyacademy.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindBy;


import rahulshettyacademy.AbstractComponents.AbstractComponent;

public class ConfirmationPage extends AbstractComponent{

	WebDriver driver;
	
	@FindBy(css="label[class='ng-star-inserted']")
	WebElement orderID;
	
	public ConfirmationPage (WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void getID()
	{
		String id =orderID.getText();
		System.out.println(id);
		driver.close();
	}
	
}
