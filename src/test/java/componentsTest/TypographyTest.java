package componentsTest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

public class TypographyTest {
	IOSDriver driver;
	
	@Test
	public void mobileTest() throws MalformedURLException, InterruptedException{
		
		final String USERNAME = System.getenv("SAUCE_USERNAME");
		final String ACCESS_KEY = System.getenv("SAUCE_ACCESS_KEY");
		
		URL sauceUrl = new URL("http://" + USERNAME + ":"+ ACCESS_KEY + "@ondemand.saucelabs.com:80/wd/hub");
		
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability("tunnel-identifier", System.getenv("TRAVIS_JOB_NUMBER"));
		cap.setCapability("build", System.getenv("TRAVIS_BUILD_NUMBER"));
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "7.1");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone Simulator");
	    cap.setCapability("appiumVersion", "1.3.4");
	    
		cap.setCapability(CapabilityType.BROWSER_NAME, "safari");
		driver = new IOSDriver(sauceUrl,cap);
		
		driver.get("http://localhost:8000/src/main/java/fixtures/index.html");
		Thread.sleep(5000);
		
	    driver.close();
		driver.quit();
	}
}
