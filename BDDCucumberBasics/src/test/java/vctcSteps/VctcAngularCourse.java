package vctcSteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class VctcAngularCourse {
	
	@Given("User should be at home page")
	public void user_should_be_at_home_page() {
	   System.out.println("At VCTC Home Page");
	}

	@When("validate title should be {string}")
	public void validate_title_should_be(String title) {
	   System.out.println("Title should be" +title);
	}

	@When("click on courses button")
	public void click_on_courses_button() {
	   System.out.println("clicking courses button");
	}

	@When("click on course option Angular Developer")
	public void click_on_course_option_angular_developer() {
	   System.out.println("Angular Dev Details");
	}

	@When("click on course option Software Testing")
	public void click_on_course_option_software_testing() {
		System.out.println("Software testing Details");
	}

	@When("click on course option React Developer")
	public void click_on_course_option_react_developer() {
		System.out.println("React Dev Details");
	}

	@Then("user should be on anguler Developer details page")
	public void user_should_be_on_anguler_developer_details_page() {
		System.out.println("User at Anguler Details page");
	}

}
