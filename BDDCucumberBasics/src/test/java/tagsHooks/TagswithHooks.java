package tagsHooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class TagswithHooks {

	@Before("@retesting")
	public void beforeretestingHook() {
		System.out.println("This is retesting Scenario based hook");
	}
	
	@Before("@regression")
	public void beforeregressionHook() {
		System.out.println("This is regression Scenario based hook");
	} 
	
	@After("@retesting")
	public void afterretestingHook() {
		System.out.println("This is retesting Scenario based hook");
	}
	
	@After("@regression")
	public void afterregressionHook() {
		System.out.println("This is regression Scenario based hook");
	}
}
