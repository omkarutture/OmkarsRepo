package basicsRestAssured;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class GET_FetchDataFromComplexJSON {
	
	static JsonPath js;
	
	@Test(priority = 1)
	public void datafetching() {
		
		RestAssured.baseURI = "https://reqres.in/";
		
		Response response = given()
		
		.when().get("/api/user/2")
		
		.then().extract().response();
		
		String pretty = response.asPrettyString();
		System.out.println(pretty);
		
		//To fetch any data from response, we use "jsonPath" method.
		js = response.jsonPath();
		String color = js.getString("data.color"); //Here, "data" is parent of "color" i.e., "parent.child" 
		System.out.println("color value is"+" "+color);
		
		int year = js.getInt("data.year");
		System.out.println("year value is"+" "+year);	
	
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");

	}
	
	
	@Test(priority = 2)
	public void GET_All_Useres() {
		
		RestAssured.baseURI = "https://reqres.in/";
		
		Response response = given()
		
		                    .when().get("api/users?page=2")
		
		                    .then().extract().response();
		
		String pretty = response.asPrettyString();
		System.out.println(pretty);
		
		js = response.jsonPath();
		int total = js.getInt("total");
		System.out.println("total value is"+" "+total);
		
		//Fetching the data value from xth index position of array  
		String email = js.getString("data[2].email"); //Such kind of path is known as "Groove" path. 
		System.out.println("email value of:"+" "+email);
		
		//Fetching data on the basis of value.
		int dataArrySize = js.getInt("data.size()"); //the Stringpath: "data.size" is: "data" is name variable/key and "size()" is to get it's size in int. 
		for(int i=0; i<dataArrySize; i++)//will use this when we're not aware about exact size of body or data array.
		
		//for(int i=0; i<6; i++) //Here "i<6" because the size of json is 5. //will use this when we know exact size of array.
		{
		    String lastname = js.getString("data["+i+"].last_name");//this will list down all values for "last_name".
		    //System.out.println(lastname); 
		    if(lastname.equals("Ferguson")) //Condition is if the lastname is ferguson
		    {
		    	String lastnameemail = js.getString("data["+i+"].email");//this will get down all values for "email" on the basis of "last name".
		    	System.out.println(lastnameemail);
		    }
		}
		
	}
}
