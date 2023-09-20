package dataproviderSteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MultidataSteps {
	
	@Given("User is at Signup Page")
	public void user_is_at_signup_page() {
	    System.out.println("User at Signup Page");
	}

	@When("User enters {string}")
	public void user_enters(String name) {
	    System.out.println("Enter name" +name);
	}

	@When("User enters {string} in age bar")
	public void user_enters_in_age_bar(String age) {
		System.out.println("Enter age" +age);
	}

	@When("User enters {string} to disclose")
	public void user_enters_to_disclose(String gender) {
		System.out.println("Enter gender" +gender);
	}

	@When("User enters {string} point of contact")
	public void user_enters_point_of_contact(String mailId) {
		System.out.println("Enter emailId" +mailId);
	}
	
	@When("User lucky number is {int}")
	public void user_lucky_number_is(Integer luckyNo) {
		System.out.println("Enter lucky no." +luckyNo);
	}


	@When("User clicks submit button")
	public void user_clicks_submit_button() {
		System.out.println("user clicks submit button");
	}

	@Then("user gets Signup successfully")
	public void user_gets_signup_successfully() {
		System.out.println("Signup successfull");
	}

}
