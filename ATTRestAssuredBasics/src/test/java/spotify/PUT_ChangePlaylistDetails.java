package spotify;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class PUT_ChangePlaylistDetails {
	
	RequestSpecification requestSpecification;
	
	@BeforeClass
	public void specBuilder() {
	RequestSpecBuilder requestBuilder = new RequestSpecBuilder();
	requestBuilder.setBaseUri("https://api.spotify.com");
	requestBuilder.setBasePath("/v1/playlists/43TciK96pVMxH2lhjhcvZi");
	requestBuilder.addHeader("Authorization", "BQDqiILqHk3xxUykf9sZBoKJkhM6ktWwnaHKawFAaIi1-lJ9CnxYnHF7YBigKo2MITd2AujoFn1kcXAnMmAxD5Q8vb7PojG1fpG6hSXMAUFzKID1mW6Vex8S6XqeTpBGhI4kG6OBN5n1UCtx4C9HRkXWGkBxvfLnEoe5_qLehazV48zKF98qLUG-blM-btaP5MKMHAxjIWuCJmdDWPvJOPFvPBLWzlxGwF1QQolZZOUPmVvw6MNFJitioog85jZuYgq__cd304BE4zZn");
	requestBuilder.setContentType(ContentType.JSON);
	requestBuilder.log(LogDetail.ALL);
	requestSpecification = requestBuilder.build();
    }
	
	@Test
	public void updateplaylistdetails() {
		
		given(requestSpecification)
		.body("{\r\n"
				+ "    \"name\": \"Silent\",\r\n"
				+ "    \"description\": \"New Silent Songs List.\",\r\n"
				+ "    \"public\": false\r\n"
				+ "}")
		
		.when().put()
		
		.then().extract().response();
	}
}
