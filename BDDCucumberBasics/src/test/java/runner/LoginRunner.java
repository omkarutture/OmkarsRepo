package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		//This annotation is coming from Cucumber-testng. 
		//under CucumberOptions we define the step defination which needs to execute along with location of feature file		
		
		features = {"src\\test\\resources\\applicationtest\\login.feature"}, //in the form of string array //Returns: list of files or directories 
		
		glue = {"allSteps"}, //in the form of string array & used to attach any feature file with step defination //Returns: list of package names
		
		// publish = true, //This will generate the report after execution of this runner class. //we can bypass this via cucumber.properties file
		
		plugin = {"pretty"} //It takes, string array //use of pretty will simplify the o/p in console
		)

public class LoginRunner extends AbstractTestNGCucumberTests //Runs each cucumber scenario found in the features as separated test.
{
//To Run this project on TestNG basis we needs to extends "AbstractTestNGCucumberTests" class
//As this class is pre-defined & it consist of all testng components like parent-child, hence "LoginRunner" child class will bydefault gets property of parent class.
}
