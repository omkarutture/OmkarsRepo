package sbddSteps;

import org.openqa.selenium.WebDriver;

import driverFactory.DriverFactoryHomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import seleniumbddpages.SearchProduct;

public class SeachProductSteps {
	
	SearchProduct search = new SearchProduct(DriverFactoryHomePage.getDriver());

	@Given("user is at landing Page")
	public void user_is_at_landing_page() {
		 WebDriver driver = DriverFactoryHomePage.getDriver();
		    driver.get("https://www.amazon.in/");
	}

	@When("User Enters Product Name as {string}")
	public void user_enters_product_name_as(String productname) {
		search.searchproduct(productname);
	}

	@When("click on Search Icon")
	public void click_on_search_icon() {
	   search.searchbutton();
	}
	
}
