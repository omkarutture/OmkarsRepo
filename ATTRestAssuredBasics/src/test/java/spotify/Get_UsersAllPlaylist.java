package spotify;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;

public class Get_UsersAllPlaylist {
	
	@Test
	public void allPlaylist() {
		
		RestAssured.baseURI = "https://api.spotify.com/v1/me/playlists";
		
		given()
		.header("Authorization", "Bearer BQDqiILqHk3xxUykf9sZBoKJkhM6ktWwnaHKawFAaIi1-lJ9CnxYnHF7YBigKo2MITd2AujoFn1kcXAnMmAxD5Q8vb7PojG1fpG6hSXMAUFzKID1mW6Vex8S6XqeTpBGhI4kG6OBN5n1UCtx4C9HRkXWGkBxvfLnEoe5_qLehazV48zKF98qLUG-blM-btaP5MKMHAxjIWuCJmdDWPvJOPFvPBLWzlxGwF1QQolZZOUPmVvw6MNFJitioog85jZuYgq__cd304BE4zZn")
	    .log().all()
	    .when().get()
	    .then().log().all().extract().response();
	
	}

}
