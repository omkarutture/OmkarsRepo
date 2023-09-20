package seleniumbddpages;
//POM: is a design pattern on basis of which we can separate test classes & base classes. so that to achieve 
//any change in functionality, we'll update directly in page class. 
//And to initialize the element we use page factory class.
//page factory: 

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	
	WebDriver driver;
	
	@FindBy(xpath = "//img[@alt=\"op\"]")
	private WebElement samsung; //private. so that the context of this class doesn't reach to any other class.

	@FindBy(xpath = "//span[@class=\"nav-cart-icon nav-sprite\"]") //tag_name[contains(text(),'attributevalue')]
	private WebElement cartIcon; //tag_name[text()='attributevalue']
	
	@FindBy(xpath = "//*[@class=\"nav-line-2 \"]")
	private WebElement signinhoverElement;
	
	@FindBy(xpath = "//span[text()=\"Sign in\"]")
	private WebElement signinbuttonElement;
	
	@FindBy(xpath = "//input[@id='ap_email']")
	private WebElement enterusername;
	
	@FindBy(xpath = "//input[@id='continue']")
	private WebElement continuebutton;
	
	@FindBy(xpath = "//input[@id=\"ap_password\"]")
	private WebElement enterpwd;
	
	@FindBy(xpath = "//input[@id=\"signInSubmit\"]")
	private WebElement clicksigninbutton;
	
	WebDriverWait wait;

	//To initialize all above web-elements we need constructor
	//And to initialize all this web-elements we need to the value of web driver
	//Will take this web driver from driver factory in our class, for which we use constructor and within it's arguments will pass driver
	//But this driver is at local level 
	//So, we need to have a global variable via which we can make use of data within local driver at project level
	//and that global veritable is a non static variable which is webdriver driver at class level.
	//Now, to transfer the data from local driver to globle driver we have line no.49 (transfers from right to left)
	//line 50, on basis of driver will initialize web-elements which are defined at class level i.e., via page factory & initElements
	public HomePage(WebDriver driver) { 
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(150));
	}
	
	public String getTitle() {
		String title = driver.getTitle();
		return title; //to use this in future we need to return it.
	}
	
	public boolean verifyCartIcon() {
		boolean isDisplayed = cartIcon.isDisplayed();
		return isDisplayed;
	}
	
	public void hoversigninbutton() {
		Actions act = new Actions(driver);
		act.moveToElement(signinhoverElement).perform();
		signinbuttonElement.click();
	}
	
	public void enterusername(String uname) {
		enterusername.sendKeys(uname);
		continuebutton.click();
	}
	
	public void enterpwd(String pwd) {
		enterusername.sendKeys(pwd);
		clicksigninbutton.click();
	}
	
	public void deals() {
		wait.until(ExpectedConditions.visibilityOf(samsung));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("argument[0].click", "samsung");
		//To resolve "ElementClickInterceptedException" use clicking via Java Script Executor
		//JavaScriptExecutor: type-cast >> call method executeScript >> with Argu ("argument[0].click", "elementtoclick")
		//JavaScriptExecutor is a interface which works directly on DOM level 
	}
	
}


