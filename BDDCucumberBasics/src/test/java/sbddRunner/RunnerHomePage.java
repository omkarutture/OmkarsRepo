package sbddRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(

		features = { "src\\test\\resources\\SeleniumBDDFeature" },

		glue = { "sbddSteps", "sbddHooks" },

		plugin = { "pretty" }

)

public class RunnerHomePage extends AbstractTestNGCucumberTests {

}

//Here, we're just executing via eclipse "tengNg".But, practically we execute project via Maven.
//To execute maven: We need to have 2 plugins : which helps to execute via any method like CMD, Jenkines or any such other method. 
//1. Compiler: Which compiles the project in any environment. Here, needs to provide version of Java on which we need to compile.
//Also need to provide under "configuration" tag: 
//a. "encoding" std property to the set o/p to follow a particular encoding i.e., "UTF-8" which is same for all projects. 
//b. To define java-version we use "source" tag with with version and another tag "target" to target java version.
//2. SureFire: used to state what to execute. Here, needs to provide Testng.xml file, which ultimately triggers Runner file.
//Under SureFire, as to state what to execute, just below "version" tag, we use tag "configuration" under which we use
//"suiteXmlFiles">>"suiteXmlFile" as file_name with .xml extension.

//If you don't have Eclipse, then for execution we can use "cmd".
//Need to have some Pre-requisite:
//1. Need to have maven installed; 2. We should have java available on your m/c.
//Installing Maven: Search "Download Maven" >> Download "Binary zip archive" after extracting need to place the folder inside C>>Programfiles>>apache-maven-version
//Download Java: Ensure Java version is above 8. Most favorite 8, 11, OR 17.
//Go to Control Panel>>System>>Advance Window System>>Click Environment Variable>>SystemVariable-Path>>Add bin path of JDK & Maven>>Ok
//Need to define user variable with M2_Home for maven with bin path.
//to verify: java --version & mvn -v
//To execute the project via CMD: copy the project path. OR open cmd at project location path.
//commands: 1. mvn clean, 2. mvn test
//To execute with tags via cmd: mvn test -Dcucumber.filter.tags="@tag_name".
//To execute with specific browser: 1st set the value in script via System.getProperty() & mvn test -D<argument_name>=browser_name
//To pass url via cmd: -Duel
