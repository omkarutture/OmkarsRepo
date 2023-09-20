package sbddSteps;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import driverFactory.DriverFactoryHomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import seleniumbddpages.HomePage;

public class HomepageSteps {

	HomePage homepage = new HomePage(DriverFactoryHomePage.getDriver());
	// This object needs driver as a argument, & here the method
	// "DriverFactoryHomePage.getDriver()" gives us driver.

	@Given("User is at landing page")
	public void user_is_at_landing_page() {
		WebDriver driver = DriverFactoryHomePage.getDriver();
		driver.get("https://www.amazon.in/");
	}

	@Then("page title should contains {string}")
	public void page_title_should_contains(String titleString) { // here the "Shopping" word is coming with
																	// "titleString"
		String title = homepage.getTitle();
		boolean ispresent = title.contains(titleString);
		Assert.assertTrue(ispresent); // Hard Assert from Testng
		// Here we're asserting just one value that to for true condition. Hence using
		// assertTrue().
	}

	@Then("cart icon should get display")
	public void cart_icon_should_get_display() {
		boolean isdispaly = homepage.verifyCartIcon();
		Assert.assertTrue(isdispaly);
	}

	@Then("user click on deal section")
	public void user_click_on_deal_section() {
		homepage.deals();
	}

	@When("User click in signin button")
	public void user_click_in_signin_button() {
		homepage.hoversigninbutton();
	}

	@When("user enters username {string} in box")
	public void user_enters_username_in_box(String uname) {
		homepage.enterusername(uname);
	}

	@When("user enters password {string} in box")
	public void user_enters_password_in_box(String pwd) {
		homepage.enterpwd(pwd);
	}

	// @Then("user should get logged in")
	// public void user_should_get_logged_in() {
	// homepage.
	// }
}
