package filmBookingSteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BookingSteps {
	
	@Given("User should login bookmyshow")
	public void user_should_login_bookmyshow() {
	    System.out.println("login bookmyshow");
	}

	@When("User should select films section")
	public void user_should_select_films_section() {
	    System.out.println("select film section");
	}

	@When("user selects theater")
	public void user_selects_theater() {
	    System.out.println("Select theater");
	}

	@When("Enter film {string}")
	public void enter_film(String filmname) {
	    System.out.println("Enter Film name" +filmname);
	}

	@When("Enter show time {string}")
	public void enter_show_time(String time) {
		System.out.println("Enter show time" +time);
	}

	@When("select seat number {int}, {int}, {int}")
	public void select_seat_number(Integer seat1, Integer seat2, Integer seat3) {
		System.out.println("Enter Gader seat" +seat1);
	}

	@When("select seat number {int}")
	public void select_seat_number(Integer seat) {
		System.out.println("Enter OMG2 seat" +seat);
	}

	@When("select seat number {int}, {int}, {int}, {int}, {int}")
	public void select_seat_number(Integer int1, Integer int2, Integer int3, Integer int4, Integer int5) {
		System.out.println("Enter Subedhar seat" +int1);
	}

	@When("click on done")
	public void click_on_done() {
	  System.out.println("click on done");
	}

	@Then("booking should get confirmed")
	public void booking_should_get_confirmed() {
	 System.out.println("confirmed");   
	}

}
