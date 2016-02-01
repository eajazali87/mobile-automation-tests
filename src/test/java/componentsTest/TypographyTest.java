package componentsTest;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

import com.saucelabs.common.SauceOnDemandAuthentication;

public class TypographyTest {
	IOSDriver driver;
	DesiredCapabilities cap;
	final String USERNAME = System.getenv("SAUCE_USERNAME");
	final String ACCESS_KEY = System.getenv("SAUCE_ACCESS_KEY");
	SauceOnDemandAuthentication authentication = new SauceOnDemandAuthentication(USERNAME, ACCESS_KEY);
	URL sauceUrl;
	
	
	@BeforeClass
	public void beforeClass() throws MalformedURLException{
	    sauceUrl = new URL("http://" + authentication.getUsername() + ":"+ authentication.getAccessKey() + "@ondemand.saucelabs.com:80/wd/hub");
		cap=new DesiredCapabilities();
		cap.setCapability("tunnel-identifier", System.getenv("TRAVIS_JOB_NUMBER"));
		cap.setCapability("build", System.getenv("TRAVIS_BUILD_NUMBER"));
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "7.1");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone Simulator");
		cap.setCapability("appiumVersion", "1.3.4");
		cap.setCapability(CapabilityType.BROWSER_NAME, "safari");
	}
	
	@BeforeTest
	public void setUp(){
		driver = new IOSDriver(sauceUrl,cap);	
	}
	
	@Test
	public void mobileTest() throws MalformedURLException, InterruptedException{
		driver.get("http://localhost:8000/src/main/java/fixtures/Typography.html");		
	}
	
	@AfterClass
	public void tearDown(){
	    driver.close();
		driver.quit();
	}
}