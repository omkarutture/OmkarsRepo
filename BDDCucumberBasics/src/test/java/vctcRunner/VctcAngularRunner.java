package vctcRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		
		features = {"src\\test\\resources\\VCTC\\courses.feature"},
		
		glue = {"vctcSteps"},
		
		plugin = {"pretty"}
		
		// publish = true
		
		)


public class VctcAngularRunner extends AbstractTestNGCucumberTests {

}
