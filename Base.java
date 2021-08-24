package madisonIsland;

import org.testng.annotations.BeforeTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

public class Base {

	WebDriver wd;
	
	@BeforeTest
	public void beforeTest() throws FileNotFoundException, IOException {
		
		// Loading the property file
		Properties prop = new Properties();
		prop.load(new FileInputStream("src/test/resources/madisonIsland.property"));
		
		// Setting path of chrome executable driver
		System.setProperty(prop.getProperty("ckey"), prop.getProperty("cvalue"));
		wd = new ChromeDriver();
		
		// maximize the window
		wd.manage().window().maximize();
		
		// add implicit wait
		wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		// fetch the page
		wd.get(prop.getProperty("url"));
	}

	@AfterTest
	public void afterTest() {
		
		// close the window
		wd.close();
	}
	
	@AfterMethod
	public void afterMethod() {
		
		// delete all cookies
		wd.manage().deleteAllCookies();
		
		// refresh the page
		wd.navigate().refresh();
	}

}
