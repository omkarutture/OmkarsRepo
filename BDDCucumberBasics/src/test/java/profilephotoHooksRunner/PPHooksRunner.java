package profilephotoHooksRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		
		features = {"src\\test\\resources\\profilephotowithHooks\\pphooks.feature"},
		
		glue = {"profilephotoSteps", "hooks"},
		
		plugin = {"pretty"},
		
		dryRun = true //With DryRun one can check whether all steps are mapped or not.
		//true if glue code execution should be skipped.
		//default value of dryRun is false
		//After execution, it'll show the mapped steps in green color under console.
		//So, dryRun: Actually it'll not perform the execution, instead it'll ensure whether all steps are mapped or not.
		//to get execute with dryRun we need to set dryRun at false.
		)


public class PPHooksRunner extends AbstractTestNGCucumberTests{

}
