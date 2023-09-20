package dataproviderRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		
		features = {"src\\test\\resources\\dataprovider\\MultiData.feature"},
		
		glue = {"dataproviderSteps"},
		
		plugin = {"pretty"}
		
		)

public class RunnerMultiData extends AbstractTestNGCucumberTests {

}
