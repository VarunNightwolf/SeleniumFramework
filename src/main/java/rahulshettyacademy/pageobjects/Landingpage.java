package rahulshettyacademy.pageobjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;


import rahulshettyacademy.AbstractComponents.AbstractComponent;

public class Landingpage extends AbstractComponent {
	
	WebDriver driver;
	
	public Landingpage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	//PageFactory

@FindBy(id="userEmail")
WebElement userEmail;

@FindBy(id="userPassword")
WebElement userPassword;

@FindBy(id="login")
WebElement login;

@FindBy(css="[class*='flyInOut']")
WebElement errorMessage;


public ProductCatalogue actionMethod(String email, String password)
{
	userEmail.sendKeys(email);
	userPassword.sendKeys(password);
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	wait.until(ExpectedConditions.elementToBeClickable(login)).click();
ProductCatalogue productCatalogue = new ProductCatalogue(driver);
return productCatalogue;

}

public String getErrorMessage() throws InterruptedException
{
waitForElementToAppear(errorMessage);
	return errorMessage.getText();
}

public void goTo()
{
	driver.get("https://rahulshettyacademy.com/client/");
	
}

}
