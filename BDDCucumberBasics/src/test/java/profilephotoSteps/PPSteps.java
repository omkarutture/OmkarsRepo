package profilephotoSteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PPSteps {
	
	@Given("At profilr photo page")
	public void at_profilr_photo_page() {
	    System.out.println("At Profile Photo Page");
	}

	@When("click on upload photo button")
	public void click_on_upload_photo_button() {
		System.out.println("click upload photo");
	}

	@When("choose photo")
	public void choose_photo() {
		System.out.println("choose photo");
	}

	@When("click upload button")
	public void click_upload_button() {
		System.out.println("click upload button");
	}

	@Then("successfully uploaded photo")
	public void successfully_uploaded_photo() {
		System.out.println("succussfully uploaded");
	}

	@When("click on update photo button")
	public void click_on_update_photo_button() {
		System.out.println("At Profile Photo Page");
	}

	@When("click update button")
	public void click_update_button() {
		System.out.println("click update button");
	}

	@Then("successfully updeated photo")
	public void successfully_updeated_photo() {
		System.out.println("succussfully updated");
	}


	@When("click on edit photo button")
	public void click_on_edit_photo_button() {
		System.out.println("click edit button");
	}
	
	@When("click delete button")
	public void click_delete_button() {
		System.out.println("click delete button");
	}

	@Then("successfully delete photo")
	public void successfully_delete_photo() {
		System.out.println("succussfully deleted");
	}

}
