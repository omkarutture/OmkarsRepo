package allSteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class loginsteps {

	//Mapping Given, When, Then with steps here:
	
	@Given("user is at login page")
	public void preconditions() 
	{
	System.out.println("Preconditions for given statements");	
	}
	
	@When("user enters username") 
	public void enterUsername()
	{
		System.out.println("Entering Username");
	}
	
	@When("user enters password")
	public void enterPassword()
	{
		System.out.println("Entering Password");
	}
	
	@When("user clicks on login button")
	public void clickingLoginButton()
	{
		System.out.println("Clicking on Login Button");
	}
	
	@Then("user should get logged in successfully")
	public void successfullLogin() 
	{
		System.out.println("Logged In Successfully");
	}
	
	
	@Given("user is at landing page")
	public void user_is_at_landing_page() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("Title verfication landing page");
	    //throw new io.cucumber.java.PendingException(); 
	    //Any exception class annotated with this annotation will be treated as a "pending" exception. 
	    //That is - if the exception is thrown from a step definition or hook, the scenario's status will be pending instead of failed.
	}

	@Then("title of page should be pageTitle")
	public void title_of_page_should_be_page_title() {
		System.out.println("Title is pageTitle");
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
	}

}
