package hooks;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;

public class SampleHooks {
	
	@Before //Feature Or Scenario level
	public void beforehook() {
		System.out.println("Before Hook is executing at Scenario level");
	}
	
	@After //Feature Or Scenario level
	public void afterhook() {
		System.out.println("after Hook is executing at Scenario level");
	}
	
	@BeforeStep //At step level
	public void beforestephook() {
		System.out.println("Before Hook is executing at Step Level");
	}
	
	@AfterStep //At step level
	public void afterstephook() {
		System.out.println("after Hook is executing at Step Level");
	}
}

//Background keyword is applicable to only one feature file & Hooks is applicable at project level.
//If we needs to apply pre & post requiest for multiple feature file, use Hooks.
//Hooks are executing, but they are not a part of scenario hence this will be not viewed in report
//for way of execution of hooks please refer notes

//Before step and After step will execute before & After each steps mentioned in step file