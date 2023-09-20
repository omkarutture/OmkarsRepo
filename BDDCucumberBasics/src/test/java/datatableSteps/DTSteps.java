package datatableSteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;

import io.cucumber.datatable.DataTable;

public class DTSteps {

	@Given("User at Registration page")
	public void user_at_registration_page() {
		System.out.println("At registration page");
	}

	@When("User enters following data")
	public void user_enters_following_data(DataTable string) {
		// Write code here that turns the phrase above into concrete actions
		// For automatic transformation, change DataTable to one of
		// E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or Map<K, List<V>>. E,K,V must be a String, Integer, Float, Double, Byte, Short, Long, BigInteger or BigDecimal.
		// For other transformations you can register a DataTableType.
		List<List<String>> data = string.asLists(String.class);
		// OR use can use below Overloaded method when we don't want it in string or integer form.
		// Also here, we don't need to pass anything in it's argument.
		// List<List<String>> data1 = dataTable.asLists();
		// Here, the list of string gets converted into ".class" which is machine readable language with help of "asList" method.

		for (List<String> listvalue : data) { // to get whole data as a list
			System.out.println(listvalue);
		}

		List<String> value = data.get(1); // to get unit data from list
		String email = value.get(2);
		System.out.println(email);
	}

	@When("click on create button")
	public void click_on_create_button() {
		System.out.println("clicking create button");
	}

	@Then("account creation done")
	public void account_creation_done() {
		System.out.println("Done with account");
	}
}
//DataTable & Scenario Outline can be combined in a single feature file.
//In Data Table, we use multiple data into single step. 
//In Scenario Outline, used to define different scenario w.r.t. multiple data 
//Scenario Outline & background can be coupled too.
//Background is kind of pre-condition steps in feature file. 