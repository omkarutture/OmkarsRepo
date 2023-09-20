package basicsRestAssured;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*; //Here, we apply static import to RestAssured class. So that, we can call any method from restAssued directly.
//i.e., w/o "classname.methodname", we call call them as "methodname".

public class GET_Request {
	
	@Test //to consider this case as a testcase we're using @test annotation.
	public void GET_All_Useres() {
		
		RestAssured.baseURI = "https://reqres.in/";//restAssured is a class.
		
		Response response = given() //It's a Given method, which consist of "pre-requisite","header", "body" and "params", if any.
		
		                    .when() //It's a When method, which consist of "request type" and "endpoints", if any.
		
	       	                .get("api/users?page=2") //API request method with endpoint
		
		                    .then() //It's a Then method, Returns a validatable response that's lets you validate the response
		                    //But to extract the response will with extract method along with response method.
		                    .extract() //Extract values from the response or return the response instance itself.
		                    .response();//The entire response object including headers, cookies and body etc. //This will return as a response
		
		System.out.println(response); //This will give us a response in encoded form and to convert it into readable format will us "asPrittyString" method
		
		//To get response in pretty view:
		String prittyresponse = response.asPrettyString(); //Get the body Or Response as a pretty formatted string, i.e., readable form of string
		System.out.println(prittyresponse);//this will print in readable format.
		
		//Status Code:
		int statuscode = response.getStatusCode();//Get the status code of the response.//return type is "int"
		System.out.println("Status Code is: " +statuscode);
		
		//Time Validation:
		long time = response.getTime();//The response time in milliseconds (or -1 if no response time could be measured) //return type is "long"
		System.out.println("Response Time taken:" +time);
	}
}

//here, from given to response method: Is a example of method chaining as all of them have same return type 
//In pom.xml: required dependencies are 
//1. Rest Assured; 2. json-simple : this is used to extract the data from json; 3. testng: to control execution and for validation purpose
