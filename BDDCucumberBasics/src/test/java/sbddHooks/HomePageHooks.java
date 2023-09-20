package sbddHooks;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import driverFactory.DriverFactoryHomePage;
import io.cucumber.java.After;
//import io.cucumber.java.After;
import io.cucumber.java.Before;

public class HomePageHooks {

	WebDriver driver;
	DriverFactoryHomePage df;

	@Before
	public void launchBrowser() throws IOException {
		// Need to call method for launch browser which is inside DriverFactoryHomePage
		// method needs to have argument which is config reader. for which need have
		// properties file available

		Properties prop = new Properties();
		String path = System.getProperty("user.dir") + "//src//test//resources//HomepageConfig.properties";
		FileInputStream fis = new FileInputStream(path);
		prop.load(fis);
		String browsername = prop.getProperty("browser"); // this is used to execute on Testng OR Maven..//Here the
															// value of browser is reading from ".property" config file.
		String cmdBrowser = System.getProperty("cmdBrowserName"); // To execute specific browser via cmd with reference
																	// variable "cmdBrowser"
		if (cmdBrowser != null) // i.e., when the value of cmdbrowser is null then read the same value as that
								// of having for browsername.
		{
			browsername = cmdBrowser;
		}

		df = new DriverFactoryHomePage(); //Obj of Driver Factory Home Page class.
		driver = df.initBrowser(browsername);
		driver.manage().window().maximize();
	}

	@After
	public void tearDown() {
		driver.quit();
	}
}
