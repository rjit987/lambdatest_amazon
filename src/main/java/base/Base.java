package base;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Base {

	//public WebDriver driver;
	public RemoteWebDriver driver = null;
	String username = "rjit9395";
	String accessKey = "6s8iKqxaM5LfWGB4RNFo263GQXnDLPW4ePBK5YVhvr8lgncJYb";

	@BeforeMethod
	public WebDriver initialize() {

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("platform", "Windows 10");
		capabilities.setCapability("browserName", "Chrome");
		capabilities.setCapability("version", "87.0"); // If this cap isn't specified, it will just get the any
														// available one
		capabilities.setCapability("resolution", "1024x768");
		capabilities.setCapability("build", "First Test");
		capabilities.setCapability("name", "Sample Test");
		capabilities.setCapability("network", true); // To enable network logs
		capabilities.setCapability("visual", true); // To enable step by step screenshot
		capabilities.setCapability("video", true); // To enable video recording
		capabilities.setCapability("console", true); // To capture console logs

		try {
			driver = new RemoteWebDriver(
					new URL("https://" + username + ":" + accessKey + "@hub.lambdatest.com/wd/hub"), capabilities);
		} catch (MalformedURLException e) {
			System.out.println("Invalid grid URL");
		}

		//System.setProperty(key, value)
		//WebDriverManager.chromedriver().setup();
		//driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		return driver;

	}

	@AfterMethod
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}

	/*
	 * public static void main(String[] args) { Base ba=new Base(); ba.initialize();
	 * }
	 */
}
