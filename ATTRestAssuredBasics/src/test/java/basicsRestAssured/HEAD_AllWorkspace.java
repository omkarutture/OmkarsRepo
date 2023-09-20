package basicsRestAssured;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.List;

public class HEAD_AllWorkspace {

	@Test
	public void responseheaders() {
		
		RestAssured.baseURI = "https://api.getpostman.com";
		
		Response response = given().header("x-api-key", "PMAK-64f1d9e5b52fc60029b825e7-4653a5b5bcca153b51f82cc2e2292c100a")
		
		.when().head("/workspaces")
		//HEAD method is used validate response with headers, status code, time & response size. i.e., without response body.
		//this is used because, as data is crucial and 3rd party servers charges to disclose it. so, in such case use HEAD method w/o data(body).
		
		.then().extract().response();
		
		String pretty = response.asPrettyString();
		System.out.println(pretty);
		
//We can get headers response via 3 ways
		
		Headers header = response.headers();//The response headers. If there are several response headers with the same name a list of the response header values are returned.
		
		//First Way: To get specific value
		List<Header> valueheader1 = header.asList();//Returns: All headers as a list
		Header HeaderoFFirstIndex = valueheader1.get(1);//Returns the element at the specified position in this list.Parameters:index index of the element to returnReturns:the element at the specified position in this listThrows:IndexOutOfBoundsException - if the index is out of range 
		String KeyName = HeaderoFFirstIndex.getName();
		String KeyValue = HeaderoFFirstIndex.getValue();
		System.out.println(KeyName+" "+KeyValue);
		
		//Second Way: To get whole list of response headers
		String wholeheaderslist = header.toString();//Returns a string representation of the object. Overrides: toString() in Object. Returns:a string representation of the object.
		//Object: Class Object is the root of the class hierarchy.Every class has Object as a superclass. All objects,including arrays, implement the methods of this class.
	    System.out.println(wholeheaderslist);
	    
	    //Third Way: To get individual value of any response key header.
	    String individualheadervalue = response.getHeader("Content-Encoding");//Get a single header value associated with the given name. If the header is a multi-value header then you need to use "Headers.getList(String)" in order to get all values. Returns:The header value or null if value was not found.
	    System.out.println(individualheadervalue);
	}
	
}
