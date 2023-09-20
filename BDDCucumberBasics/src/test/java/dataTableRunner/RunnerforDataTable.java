package dataTableRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		
		features = {"src\\test\\resources\\dataTable\\DataTableFile.feature"},
		
		glue = {"datatableSteps", "hooks"},
		
		plugin = {"pretty"}
		
		)

public class RunnerforDataTable extends AbstractTestNGCucumberTests {

}
