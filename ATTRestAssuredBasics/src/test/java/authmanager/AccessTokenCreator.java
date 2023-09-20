package authmanager;

import java.util.HashMap;
import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class AccessTokenCreator {
	
	public static String renewToken() {
		
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("client_id", "7653667cbb264f7598470a6f913795cc");
		param.put("client_secret", "6091f3885b934e68ae847d800d7f20cc");
		param.put("grant_type", "refresh_token");
		param.put("refresh_token", "AQBisLRCutCMnN5UxTnJ9P0EYmMgzHFxM82s--0wUiWUfO7N_PdIxLWBi7JXhJSNNfWVL4XgQX99dWEESrrgnpQdgzef-EmGRvjyymXNY3fWO7E8QFztD70QTaI_dYtiL8E");
	//As this body is encoded with x-www-form-urlenc. will use .formParam()
		
		RestAssured.baseURI = "https://accounts.spotify.com";
		
		Response response = given()
		.contentType(ContentType.URLENC) 
	//URLENC: application/x-www-form-urlencoded
	
		.formParams(param) 
	//Specify the form parameters that'll be sent with the request. Note that this method is the same as params(Map)for all http methods except for PUT where params(Map) sets the query parameters and this method sets theform parameters.Parameters:parametersMap The Map containing the form parameter names and their values to send with the request.Returns:The request specification
	//Above method will get the data from above HashMap Obj
		
		.when().post("/api/token")
		
		.then().extract().response();
		
		//is the status code is not 200 and to stop further execution. script below logic with assertion
		if(response.statusCode()!=200) 
		{
		throw new RuntimeException("Failed to Create Access Token"); 	
		}
		
		//To fetch the token, other then JsonPath method:
		String token = response.path("access_token");
		return token;
	}

}
