package spotify;

//import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class NegativeValidations {
	
	RequestSpecification RequestSpecification;
	ResponseSpecification ResponseSpecification;
	
	@BeforeClass
	public void reqres() {
		
		RequestSpecBuilder RequestBuilder = new RequestSpecBuilder();
		RequestBuilder.setBaseUri("https://api.spotify.com");
		RequestBuilder.setBasePath("/v1/users/");
		RequestBuilder.setContentType(ContentType.JSON);
		RequestBuilder.addHeader("Authorization", "Bearer BQCUHmKtqZ65r4U8xA3ZnbM5QS0IwkwIwXTHazS56CawugmGOv5xi7uMBqP0dlRIVHB4He1h1htXxiCeo8RJVtgeCutLlivb7CQ00VNQAD0WdDudZLeB-ZfZDi5YnKSgm4ZYE4zGih_Z-cKgEonmFslbp1U-BJfSWkZXR20V-QPcgbykh9WYyj0YJRttHjJMtFRlMkBw8EnjxpYb_jIh7PH4__L17iZGc3wRTaVF8lKEunN94YZFiEjNGWfanwTbX34cplDnSSsI8yTe");
	    RequestBuilder.log(LogDetail.ALL);
	    RequestSpecification = RequestBuilder.build();
	
	    ResponseSpecBuilder ResponseBuilder = new ResponseSpecBuilder();
	    ResponseBuilder.expectContentType(ContentType.JSON);
	    ResponseBuilder.log(LogDetail.ALL);
	    ResponseSpecification = ResponseBuilder.build();
	}

	
	@Test(priority = 1, enabled = false)
	public void shouldNotBeAbleToCreatePlaylist() {
		
		given(RequestSpecification)
		.body("{\r\n"
				+ "    \"name\": \"\",\r\n"
				+ "    \"description\": \"Mashup Songs Collection\",\r\n"
				+ "    \"public\": false\r\n"
				+ "}")
		
		.when().post("31tocmmck5zchznpcnp2rbi32lvy/playlists")
		
		.then().spec(ResponseSpecification).assertThat().statusCode(400);
	}
	
	@Test(priority = 2)
	public void shouldNotBeAuthorized() {
		
		given(RequestSpecification)
		.body("{\r\n"
				+ "    \"name\": \"MASHUP\",\r\n"
				+ "    \"description\": \"Old & New Mashup Songs Collection\",\r\n"
				+ "    \"public\": false\r\n"
				+ "}")

		.when().post("6kKRGuN1arJkb21ef8og5K/playlists")
		
		.then().spec(ResponseSpecification).assertThat().statusCode(401);
		
	}
}
