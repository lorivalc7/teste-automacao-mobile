package runners;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import junit.framework.TestCase;
import pages.BasePage;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/features",
		glue = "steps"
)

public class Run extends TestCase {
	public static AndroidDriver<MobileElement> driver;

	public static DesiredCapabilities desiredCapabilities;
	
	@BeforeClass
	public static void antes() {
		
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("platformName", "Android");
		desiredCapabilities.setCapability("deviceName", "0045217925");
		desiredCapabilities.setCapability("automationName", "uiautomator2");
		desiredCapabilities.setCapability("appPackage", "com.google.android.calculator");
		desiredCapabilities.setCapability("appActivity", "com.android.calculator2.Calculator");
		
		try {
			driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
		} catch(MalformedURLException e) {
			e.printStackTrace();
		}
		try {
			Thread.sleep(1500);
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
		BasePage.driver = driver;
	}
	
	@AfterClass
	public static void depois() {
		driver.quit();
	}
}
