package campaignTagsSteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CampaignSteps {
	
	@Given("at campaign page")
	public void at_campaign_page() {
	    System.out.println("At campaign page");
	}

	@When("click on create campaign button")
	public void click_on_create_campaign_button() {
	 System.out.println("clicking on campaingn creation button");   
	}

	@When("user enter information")
	public void user_enter_information() {
	    System.out.println("Enter info of campaign");
	}

	@When("clicks on save button")
	public void clicks_on_save_button() {
	    System.out.println("click save button");
	}

	@Then("Campaign creation Done")
	public void campaign_creation_done() {
	    System.out.println("campaign created");
	}

	@When("click on Scheduling campaign button")
	public void click_on_scheduling_campaign_button() {
	    System.out.println("clicking on campaign scheduling button");
	}

	@When("user enter Schedule information")
	public void user_enter_schedule_information() {
	    System.out.println("enter schedule of campaign");
	}

	@When("clicks on Schedule button")
	public void clicks_on_schedule_button() {
	    System.out.println("click schedule button");
	}

	@Then("Campaign Scheduling Done")
	public void campaign_scheduling_done() {
	    System.out.println("campaign scheduling done");
	}

	@When("click on Sent campaign button")
	public void click_on_sent_campaign_button() {
	    System.out.println("click on sent campaign button");
	}

	@Then("Campaign should get sent.")
	public void campaign_should_get_sent() {
	    System.out.println("campaign should get sent");
	}

}
