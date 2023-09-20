package spotify;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;

public class GET_UserDetails {
	
	@Test
	public void userDetais() {
		
		RestAssured.baseURI = "https://api.spotify.com";
		
		given().header("Authorization", "Bearer BQCUHmKtqZ65r4U8xA3ZnbM5QS0IwkwIwXTHazS56CawugmGOv5xi7uMBqP0dlRIVHB4He1h1htXxiCeo8RJVtgeCutLlivb7CQ00VNQAD0WdDudZLeB-ZfZDi5YnKSgm4ZYE4zGih_Z-cKgEonmFslbp1U-BJfSWkZXR20V-QPcgbykh9WYyj0YJRttHjJMtFRlMkBw8EnjxpYb_jIh7PH4__L17iZGc3wRTaVF8lKEunN94YZFiEjNGWfanwTbX34cplDnSSsI8yTe")
		.log().all()
		
		.when().get("/v1/me")
		
		.then().log().all().extract().response();
	}

}
