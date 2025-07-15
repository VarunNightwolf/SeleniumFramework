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

public class StandaloneTest2 extends AbstractComponent  {

	public StandaloneTest2(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws InterruptedException {

		String productName = "ZARA COAT 3";
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		Landingpage page = new Landingpage(driver);
		page.goTo(); // 	goTo replaces the get URL step ->driver.get("https://rahulshettyacademy.com/client/");
		page.actionMethod("abcd1t1t1t@gmail.com", "Jiracode3");
		//driver.findElement(By.id("userEmail")).sendKeys("abcd1t1t1t@gmail.com");
		//driver.findElement(By.id("userPassword")).sendKeys("Jiracode3");
		//driver.findElement(By.id("login")).click();


		ProductCatalogue productCatalogue = new ProductCatalogue(driver);
		List<WebElement> products = productCatalogue.getProductList();
		Thread.sleep(2000);
		//List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
		productCatalogue.addProductToCart(productName);

		//WebElement prod = products.stream().filter(product->
		//product.findElement(By.xpath("//div//div//h5")).getText().equals(productName)).findFirst().orElse(null);

		//prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();



		Thread.sleep(2000);

		CartPage cartPage = productCatalogue.goToCartPage();
		//driver.findElement(By.cssSelector("[routerlink='/dashboard/cart']")).click();

		Thread.sleep(2000);

		Boolean match = cartPage.VerifyProductDisplay(productName);
		Assert.assertTrue(match);

		Thread.sleep(3000);
		cartPage.goToCheckout();

		//List<WebElement> cartList = driver.findElements(By.cssSelector(".cartSection h3"));
		//Boolean match = cartList.stream().anyMatch(cartProduct -> cartProduct.getText().equalsIgnoreCase(productName));

		//driver.findElement(By.cssSelector(".totalRow button")).click();
		//Thread.sleep(1000);
		//driver.findElement(By.cssSelector("input[placeholder='Select Country']")).sendKeys("Ind");
		cartPage.selectCountries();


		//Thread.sleep(1000);
		//driver.findElement(By.xpath("(//span[@class='ng-star-inserted'])[2]")).click();
		//driver.findElement(By.cssSelector(".btnn.action__submit.ng-star-inserted")).click();
		ConfirmationPage confirmOrder = cartPage.submitOrder();
		//String orderID = driver.findElement(By.cssSelector("label[class='ng-star-inserted']")).getText();
		//System.out.println(orderID);
		//Thread.sleep(1000);
		confirmOrder.getID();


	}}
