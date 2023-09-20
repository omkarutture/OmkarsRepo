package seleniumbddpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchProduct {
	
WebDriver driver;
	
	@FindBy(xpath = "//*[@id=\"twotabsearchtextbox\"]")
	private WebElement searchfield; 
	
	@FindBy(xpath = "//*[@id=\"nav-search-submit-button\"]")
	private WebElement searchbutton; 
	
	public SearchProduct(WebDriver driver) { 
		this.driver = driver;
		PageFactory.initElements(driver, this);
		}
	
	public void searchproduct(String text) {
		searchfield.sendKeys(text);
	}
	
	public void searchbutton() {
		searchbutton.click();
	}
	
}