package swaggerRestAssured;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import junit.framework.Assert;

import static io.restassured.RestAssured.*;

public class POST_CreateUser {
	
	static String message; //this has declared static so that it doesn't get change any movement.
	
	@Test(priority = 1)
	public void createuser() {
		
		RestAssured.baseURI = "https://petstore.swagger.io/v2";
		
		Response response = given()
		.header("Content-Type", "application/json")
		.body("{\r\n"
				+ "  \"id\": 0,\r\n"
				+ "  \"username\": \"GoldenFarms1\",\r\n"
				+ "  \"firstName\": \"Pragati1\",\r\n"
				+ "  \"lastName\": \"Utture1\",\r\n"
				+ "  \"email\": \"g1f@gmail.com\",\r\n"
				+ "  \"password\": \"Golden@12341\",\r\n"
				+ "  \"phone\": \"99886655441\",\r\n"
				+ "  \"userStatus\": 0\r\n"
				+ "}")
		
		.when()
		.post("/user")
		
		.then().extract().response();
		
		String pretty = response.asPrettyString();
		System.out.println(pretty);
		
    	JsonPath js = response.jsonPath();
    	
		String name = js.getString("code");
		System.out.println("code value from CREATE request is:"+" "+name);
		
		message = js.getString("message"); //will validate this value with id & as it's a local variable and to use it in another method needs to make it static at class level.
		System.out.println("Message value from CREATE request is:"+" "+message);
				
	}
	
	//Here, will create 2nd method to GET details and then will validate one of a response from CREATE response with GET response.
	//This example shows that API Chaining is possible, as we're validating from one response to another one. NOT PERFECT API CHANING: It's just an example. 
	
	@Test(priority = 2)
	public void getcreateduser() {
		
		RestAssured.baseURI = "https://petstore.swagger.io/v2";
		
		Response response = given().header("Content-Type", "application/json")
		
		.when()
		.get("/user/GoldenFarms1")
		
		.then().extract().response();
		
		String pretty = response.asPrettyString();
		System.out.println(pretty);
		
		JsonPath js = response.jsonPath();
		String id = js.getString("id");
		System.out.println("id value from GET request:"+" "+id);
		Assert.assertEquals(message, id); //to validate will use assertion.

}
}
