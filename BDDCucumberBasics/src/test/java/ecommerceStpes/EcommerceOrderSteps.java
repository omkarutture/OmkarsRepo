package ecommerceStpes;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EcommerceOrderSteps {
	
	@Given("User should logged into application")
	public void user_should_logged_into_application() {
	    System.out.println("Given Statement for Log In");
	}

	@When("User should be at oders page")
	public void user_should_be_at_oders_page() {
	    System.out.println("When Statement for User at Orders Page");
	}

	@When("User Clicks on Past Orders button")
	public void user_clicks_on_past_orders_button() {
	   System.out.println("When Statement for Past Orders click button");
	}

	@Then("User should be able to view past orders info")
	public void user_should_be_able_to_view_past_orders_info() {
	   System.out.println("Then Statement to view Past Orders");
	}

	@When("User Clicks on Current Orders button")
	public void user_clicks_on_current_orders_button() {
		 System.out.println("When Statement for Current Orders click button");
	}

	@Then("User should be able to view current orders info")
	public void user_should_be_able_to_view_current_orders_info() {
		System.out.println("Then Statement to view Current Orders");
	}

	@When("User Clicks on Cancelled Orders button")
	public void user_clicks_on_cancelled_orders_button() {
		 System.out.println("When Statement for Cancelled Orders click button");
	}

	@Then("User should be able to view Cancelled orders info")
	public void user_should_be_able_to_view_cancelled_orders_info() {
		System.out.println("Then Statement to view Cancelled Orders");
	}

}
