package rahulshettyacademy.TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import rahulshettyacademy.pageobjects.Landingpage;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseTest {

	
	
	public WebDriver driver;

	public Landingpage landingPage;

	public WebDriver initializeDriver () throws InterruptedException, IOException
	{

		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\fanof\\eclipse-workspace\\SeleniumFrameworkDesign\\src\\main\\java\\rahulshettyacademy\\resources\\GlobalData.properties");
		prop.load(fis);
		String browserName = prop.getProperty("browser");

		if(browserName.contains("chrome")) 
		{
			ChromeOptions options = new ChromeOptions();
			 options.addArguments("--incognito");
			 options.addArguments("--headless=new"); // for Chrome 109+, use `--headless=new`
			 options.addArguments("start-maximized");

			 options.addArguments("--disable-gpu");
			 options.addArguments("--no-sandbox");
			 options.addArguments("--disable-dev-shm-usage");
			driver = new ChromeDriver(options);
			driver.manage().window().setSize(new Dimension(1440,900));
			    // This disables Chrome's password manager prompts
			    options.setExperimentalOption("prefs", Map.of(
			        "credentials_enable_service", false,
			        "profile.password_manager_enabled", false
			    ));


		}
		else if (browserName.equalsIgnoreCase("firefox"))
		{

		}
		
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//		driver.manage().window().maximize();
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		return driver;

		

	}

	public List <HashMap<String, String>>  getJsonDataToMap(String filePath) throws IOException
	{
		String jsonContent = FileUtils.readFileToString(new File(filePath),
				StandardCharsets.UTF_8); 	
		//String to HashMap which needs dependency called Jackson databid
		ObjectMapper mapper = new ObjectMapper();

		List <HashMap<String, String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>() {
		});

		return data;


	}

	@BeforeMethod(alwaysRun=true)
	public Landingpage launchApplication() throws InterruptedException, IOException
	{
		driver =	initializeDriver();
		landingPage = new Landingpage(driver);
		landingPage.goTo();
		return landingPage;
	}

	public String getScreenshot(String testCaseName, WebDriver driver) throws IOException
	{
	TakesScreenshot ts =	(TakesScreenshot)driver;
	File source = ts.getScreenshotAs(OutputType.FILE);
	File file = new File(System.getProperty("user.dir") + "//reports//" + testCaseName + ".png");
	FileUtils.copyFile(source, file);
	return System.getProperty("user.dir") + "//reports//" + testCaseName + ".png";
	}
	
	
	
	public void close()
	{
		driver.close();
	}

	public void quit()
	{
		driver.quit();
	}

	public WebDriver getDriver() {
	    return driver;
	}



}








