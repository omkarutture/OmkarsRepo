package campaignTagsRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		
		features = {"src\\test\\resources\\campaignTags\\campaignwithTags.feature"},
		
		glue = {"campaignTagsSteps", "tagsHooks"},
		
		plugin = {"pretty"},
		
		tags = "@retesting"
		
		//Tags are applied on scenarios and features, 
		//so that tester can execute specific scenario only & he can also execute w.r.t. features at project level.
		//While applying tag, it should start with alphabets only & they are case sensitive 
		//It works same like "groups" in testng
				//TAG and Hook:-
		// Tags can be used with Hooks as well, & All those hooks will be applied to respective tags while execution
		//To apply hook on specific Scenario, then need to 1st establish relation of hooks with tags & This hook will 
		//execute only when we will perform the execution relates to this tag.
		
		)

public class CampaignRunner extends AbstractTestNGCucumberTests {
}

//We can run this via testng suite: rightclick on the class>> TestNG>> Convert To TestNG>>
//This will create a "xml" file and under this we can run/execute any class just by passing
//"package_name.class_name" under class tag of xml file.
