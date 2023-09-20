package spotify;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import static io.restassured.RestAssured.*;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
//import io.restassured.RestAssured;
//import io.restassured.http.ContentType;
import static org.hamcrest.Matchers.*;

public class Create_PlaylistWithReqResSpec {
	
	RequestSpecification RequestSpecification;
	ResponseSpecification ResponseSpecification;
	
	@BeforeClass
	public void reqres() {
		
		RequestSpecBuilder RequestBuilder = new RequestSpecBuilder();
		RequestBuilder.setBaseUri("https://api.spotify.com");
		RequestBuilder.setBasePath("/v1/users/");
		RequestBuilder.setContentType(ContentType.JSON);
		RequestBuilder.addHeader("Authorization", "Bearer BQBs-hWfXBerMs4gOS5ChZAy1VrDDiVElVqoMfm1gh6fAYgQhQkwBJzY7uFLP3RqCU5HfURMm-Nh_i_ZDOZbEOPNY-Bkab1FyabLOz9eUKRqIvDJM_mfy2dSDhovHFVILQHbi-fca5bry9_G4byIRaR-nM4ALwtSvDZ7Y1XYbbrxyTxDuOsASmLxRqdr9SFXMTIbhL3rrl1fRyatZax-qz3O2aYFI_jAFt-dfEYhGKBpPirkO2RmZoL3OAiMNauxz27GZlHUkr2Gaj4X");
	    RequestBuilder.log(LogDetail.ALL);
	    RequestSpecification = RequestBuilder.build();
	
	    ResponseSpecBuilder ResponseBuilder = new ResponseSpecBuilder();
	    ResponseBuilder.expectContentType(ContentType.JSON);
	    ResponseBuilder.log(LogDetail.ALL);
	    ResponseSpecification = ResponseBuilder.build();
	}

	@Test
	public void createPlaylist() {
		
		given(RequestSpecification)
		.body("{\r\n"
				+ "    \"name\": \"MASHUP\",\r\n"
				+ "    \"description\": \"Old & New Mashup Songs Collection\",\r\n"
				+ "    \"public\": false\r\n"
				+ "}")
		
		.when().post("31tocmmck5zchznpcnp2rbi32lvy/playlists")
		
		.then().spec(ResponseSpecification)
		.body("name", equalTo("MASHUP"));
		
	}
	
}
