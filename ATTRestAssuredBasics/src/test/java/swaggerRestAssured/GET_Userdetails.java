package swaggerRestAssured;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class GET_Userdetails {
	
	@Test
	public void createuser() {
		
		RestAssured.baseURI = "https://petstore.swagger.io/v2";
		
		Response response = given().header("Content-Type", "application/json")
		
		.when()
		.get("/user/GoldenFarms1")
		
		.then().extract().response();
		
		String pretty = response.asPrettyString();
		System.out.println(pretty);
		
		//To validate any response value from response body follow the following via *Absolute JsonPath*:
		JsonPath js = response.jsonPath();//Get a JsonPath view of the response body. This will let you use the JsonPath syntax to get values from the response. 
		
		String email = js.getString("email");
		System.out.println("email:"+" "+email);//will get email key value.
		
		long phone = js.getLong("phone");
		System.out.println("phone:"+" "+phone);//will get phone key value.
		
		long id = js.getLong("id");
		System.out.println("id:"+" "+id);//will get id key value.
		
		//NOT SURE HOW TO USE "getBoolean" METHOD
//		boolean password = js.getBoolean("userStatus");
//		System.out.println("password is right"+" "+password);
	}

}
