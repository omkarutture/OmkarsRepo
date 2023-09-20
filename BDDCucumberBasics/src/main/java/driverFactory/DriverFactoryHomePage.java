package driverFactory;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebDriver;

public class DriverFactoryHomePage {

	static WebDriver driver; // make static to avoid nullpointerException. as driver will run until class
								// gets unload.

//Launching Browser & to perform action with it's return
	public WebDriver initBrowser(String browsername) {
		if (browsername.equals("Chrome")) {
			driver = new ChromeDriver();
		} else if (browsername.equals("Firefox")) {
			driver = new FirefoxDriver();
		}
//And on basis of driver, to perform some operations we need to return.
		return driver; // To launch the browser & to have reference variable with object
		// return: to run a logic with method, along with to use any value in future
		// And here, will have a browser value with variable "driver" via which will
		// perform actions
	}

//To perform only action.
	public static WebDriver getDriver() { // getter method: use to get something
		return driver;
	}

}
