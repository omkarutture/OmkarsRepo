package requestAndresponseSpecBuilder;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class ReqResBuilder {
	
	//Request & Response Specification builders are just like utility class.
	//the pre-requisites are stored for request and response separately/in one class. So, that we call call/use them as per requirements 
	//Generally on request side: headers, base URI, parameters
	//And on response side: validations like status code, content type etc.
	//This request & Response Spec Builders needs to be at class level as they must be execute before class.
	
	
	RequestSpecification reqSpecification;
	ResponseSpecification resSpecification;
	@BeforeClass
	public void reqresbuild() 
	{
		//Request Specification:
		RequestSpecBuilder reqSpecBuilder = new RequestSpecBuilder();
		reqSpecBuilder.setBaseUri("https://api.getpostman.com/");
		reqSpecBuilder.addHeader("x-api-key","PMAK-64f1d9e5b52fc60029b825e7-4653a5b5bcca153b51f82cc2e2292c100a");
	// reqSpecBuilder.setRelaxedHTTPSValidation(); //Use relaxed HTTP validation with SSLContext protocol via bypassing it. 
		reqSpecBuilder.log(LogDetail.ALL); //"LogDetail: Determine what should be logged in a request or response.
		reqSpecification = reqSpecBuilder.build();//build: Build RequestSpecBuilder & assembled the request specification
		
		//Response Specification:
		ResponseSpecBuilder resSpecBuilder = new ResponseSpecBuilder();
		resSpecBuilder.expectStatusCode(200);
		resSpecBuilder.expectContentType(ContentType.JSON);
		resSpecBuilder.log(LogDetail.ALL);
		resSpecification = resSpecBuilder.build();
	}
		

	
	@Test(priority = 1)
	public void Postman_Workspace() {
		
		//RestAssured.baseURI = "https://api.getpostman.com/";
		
		                     given(reqSpecification)
	    //OR we can use: ".spec(reqSpecification)" This will add request data from a pre-defined specification
		//As used for responseSpecification below.
		                   
		                    .when()
		                    .get("workspaces")
		
		                    .then().spec(resSpecification).extract().response(); 
		//For .then() method we can't pass reference variable of responseSpecification i.e., "resSpecifition" directly. 
		//As this method is No Argument method by default. Hence, need to use ".spec(referenceVariable)" method
}
	
	//Example of API Chaining  
	
	@Test(priority = 2)
	public void Specifice_Workspace() {
		
		                     given(reqSpecification)
		                   
		                    .when()
		                    .get("workspaces/7493313a-9d84-4d01-bfc7-8ccd0180e91a")
		
		                    .then().spec(resSpecification).extract().response(); 
}
}