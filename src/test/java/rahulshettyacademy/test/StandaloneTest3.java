package rahulshettyacademy.test;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
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
import rahulshettyacademy.pageobjects.OrderPage;
import rahulshettyacademy.pageobjects.ProductCatalogue;
import rahulshettyacademy.TestComponents.*;
import rahulshettyacademy.data.DataReader;

import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;
import org.testng.annotations.DataProvider;
import org.openqa.selenium.TakesScreenshot;


public class StandaloneTest3 extends BaseTest  {

	String productName;


	@Test(dataProvider="getData", groups = {"Purchase"})
	public void submitOrder(HashMap<String,String> input) throws InterruptedException, IOException 
	{

		ProductCatalogue productCatalogue =	landingPage.actionMethod(input.get("email"),input.get("password"));


		List<WebElement> products = productCatalogue.getProductList();
		Thread.sleep(2000);

		productCatalogue.addProductToCart(input.get("productName"));


		Thread.sleep(2000);

		CartPage cartPage = productCatalogue.goToCartPage();

		Thread.sleep(2000);

		Boolean match = cartPage.VerifyProductDisplay(input.get("productName"));
		Assert.assertTrue(match);

		Thread.sleep(3000);
		cartPage.goToCheckout();


		cartPage.selectCountries();


		ConfirmationPage confirmOrder = cartPage.submitOrder();

		confirmOrder.getID();
		Thread.sleep(2000);

	}
	@Test(dataProvider = "getData", dependsOnMethods = {"submitOrder"})
	public void OrderHistory(HashMap<String,String> input)
	{
		ProductCatalogue productCatalogue =	landingPage.actionMethod(input.get("email"), input.get("password"));
		OrderPage orderPage = productCatalogue.goToOrdersPage();
		Assert.assertFalse(orderPage.VerifyProduct(productName));

	}

	
	
	@DataProvider
	public Object[][] getData() throws IOException {
	    DataReader reader = new DataReader();
	    List<HashMap<String, String>> data = reader.getJsonDataToMap();
	    return new Object[][] { { data.get(0) }, { data.get(1) } };
	}


	//	HashMap<String,String> map = new HashMap();
	//	map.put("email", "abcd1t1t1t@gmail.com"); abcd1t1t1t@gmail.com
	//	map.put("password", "Jiracode3");
	//	map.put("productName","ZARA COAT 3");
	//	
	//	HashMap<String,String> map1 = new HashMap();
	//	map1.put("email", "shetty@gmail.com");
	//	map1.put("password", "Iamking@000");
	//	map1.put("productName","ADIDAS ORIGINAL");


}
