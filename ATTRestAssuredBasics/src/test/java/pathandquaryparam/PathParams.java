package pathandquaryparam;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class PathParams {
	
	@Test
	public void GET_Single_User() {
		
       RestAssured.baseURI = "https://reqres.in/";
		
		 Response response = given().pathParam("usernumber", "2")//Path parameters are used to improve readability of the request path
				 //With path params, we just a value always. so need to create temporarily key and which needs to pass within"{ }" under HTTP method >> when()
		
		                    .when() 
	       	                .get("api/users/{usernumber}") //username is key 
		
		                    .then()
		                    .extract()
		                    .response();
		
		System.out.println(response);
		String prittyresponse = response.asPrettyString();
		System.out.println(prittyresponse);
		
	}

}
