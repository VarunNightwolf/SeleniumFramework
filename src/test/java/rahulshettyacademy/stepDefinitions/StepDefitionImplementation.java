package rahulshettyacademy.stepDefinitions;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import rahulshettyacademy.TestComponents.BaseTest;
import rahulshettyacademy.pageobjects.CartPage;
import rahulshettyacademy.pageobjects.ConfirmationPage;
import rahulshettyacademy.pageobjects.Landingpage;
import rahulshettyacademy.pageobjects.ProductCatalogue;

public class StepDefitionImplementation extends BaseTest {

	public Landingpage landingpage;
	public ProductCatalogue productCatalogue; 
	public ConfirmationPage confirmOrder;
	
	@Given("^I landed on Ecommerce Page$")
	public void I_Landed_On_Ecommerce_page () throws InterruptedException, IOException
	{
landingPage = launchApplication();
	}
	
	@Given("^Logged in with username (.+) and password (.+)$")
	public void I_logged_in(String username, String password)
	{
		ProductCatalogue productCatalogue =	landingPage.actionMethod(username,password);

	}
	
	@When("Added product (.+) to car")
	public void I_added_product_to_Cart (String productName) throws InterruptedException
	{
		List<WebElement> products = productCatalogue.getProductList();
		Thread.sleep(2000);
		productCatalogue.addProductToCart(productName);

	}
	
	@When("^Confirm product (.+) is present in checkout page (.+)$")
	public void I_confirm_order_and_checkout(String productName) throws InterruptedException
	{
		CartPage cartPage = productCatalogue.goToCartPage();

		Thread.sleep(2000);

		Boolean match = cartPage.VerifyProductDisplay(productName);
		Assert.assertTrue(match);

		Thread.sleep(3000);
		cartPage.goToCheckout();


		cartPage.selectCountries();


		ConfirmationPage confirmOrder = cartPage.submitOrder();
	}
	
	@Then("^print orderID (.+)$")
	public void I_am_able_to_verify_orderID(String orderID) throws InterruptedException
	{
		confirmOrder.getID();
Thread.sleep(1000);
driver.close();
	}
	
}
