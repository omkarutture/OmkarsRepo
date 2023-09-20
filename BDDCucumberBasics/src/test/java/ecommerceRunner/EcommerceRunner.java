package ecommerceRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		
		features = {"src\\test\\resources\\ecommerce\\Orders.feature"},
		
		glue = {"ecommerceStpes"},
		
		plugin = {"pretty"}
		
		)

public class EcommerceRunner extends AbstractTestNGCucumberTests{

}
