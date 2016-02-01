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
	public void mobileTest() throws MalformedURLException{
		
		final String USERNAME = "eajaz";
		final String ACCESS_KEY = "dee10cb9-6c0f-4ce1-b3b4-ff7d2854ee80";
		URL sauceUrl = new URL("http://" + USERNAME + ":"+ ACCESS_KEY + "@ondemand.saucelabs.com:80/wd/hub");
		
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "7.1");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone Simulator");
	    cap.setCapability("appiumVersion", "1.3.4");
	    
		cap.setCapability(CapabilityType.BROWSER_NAME, "safari");
		driver = new IOSDriver(sauceUrl,cap);
		
		driver.get("https://console.pearson.com/signin");
		
	    driver.quit();		
	}
}
