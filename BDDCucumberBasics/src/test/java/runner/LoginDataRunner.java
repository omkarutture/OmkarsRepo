package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//Each project has only one Runner class.
//But here, for study and understanding purpose and to get each concept cleared, we're creating different runner class 

@CucumberOptions(
		
		features = {"src\\test\\resources\\applicationtest"},
		
		glue = {"allSteps"},
		
		plugin = {"pretty"}
		)

public class LoginDataRunner extends AbstractTestNGCucumberTests{

}
