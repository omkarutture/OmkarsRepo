package authorizationAuthentication;

import static io.restassured.RestAssured.given;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class CreateUser_BearerToken {
	
	@Test
	public void Postman_Workspace() {
		
		RestAssured.baseURI = "https://api.github.com/";
		
		Response response = given()
				            .header("Accept","application/vnd.github+json")
				            .header("Authorization","Bearer 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")
				            .header("X-GitHub-Api-Version","2022-11-28")
				            .body("{\r\n"
				            		+ "    \"name\":\"AuthoAuthen\",\r\n"
				            		+ "    \"description\":\"Authorization & Authentication workspace\",\r\n"
				            		+ "    \"homepage\":\"https://github.com\",\r\n"
				            		+ "    \"private\":false,\r\n"
				            		+ "    \"is_template\":true\r\n"
				            		+ "}")
				            
				            .log().all()
				            
		                    .when()
		                    .get("user/repos")
		
		                    .then().log().all().extract().response();
		
		System.out.println(response);
		String prittyresponse = response.asPrettyString();
		System.out.println(prittyresponse);
	}

}
