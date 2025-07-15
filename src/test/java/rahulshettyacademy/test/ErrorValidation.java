package rahulshettyacademy.test;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import rahulshettyacademy.AbstractComponents.AbstractComponent;
import rahulshettyacademy.pageobjects.CartPage;
import rahulshettyacademy.pageobjects.ConfirmationPage;
import rahulshettyacademy.pageobjects.Landingpage;
import rahulshettyacademy.pageobjects.ProductCatalogue;
import rahulshettyacademy.TestComponents.*;
import org.testng.annotations.Test;

public class ErrorValidation extends BaseTest  {

	
	
	@Test(groups = {"ErrorHandling"}, retryAnalyzer=Retry.class)
	public void submitOrder() throws InterruptedException
	{
		String productName = "ZARA COAT 3";

		ProductCatalogue productCatalogue =	landingPage.actionMethod("abcd1t1t1t@gmail.com", "Jiracode3");

}
	
	
}