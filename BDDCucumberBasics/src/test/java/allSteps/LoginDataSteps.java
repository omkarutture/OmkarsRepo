package allSteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginDataSteps {
	
	//use clt+shift+O : will import all the required import files.
	
	@Given("user at login page")
	public void user_at_login_page() {
	    System.out.println("Given Statement for user at login page");
	}

	@When("user enters username as {string}")
	public void user_enters_username_as(String UName) {
	    System.out.println("Entering username as" +UName);
	}

	@When("user enters password as {string}")
	public void user_enters_password_as(String PWord) {
	    System.out.println("Entering password as" +PWord);
	}

	@When("user clicks on login button below login screen")
	public void user_clicks_on_login_button_below_login_screen() {
	   System.out.println("User clicking on Login Button");
	}

	@Then("successfully logged in")
	public void successfully_logged_in() {
	   System.out.println("User gets logged in successfully");
	}

}
