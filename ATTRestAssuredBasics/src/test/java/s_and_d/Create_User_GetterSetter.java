package s_and_d;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import createUserPOJO.CreateUserRequestBody;
import createUserPOJO.CreateUserResponseBody;
import io.restassured.RestAssured;

//Creating User via Getter/Setter method. and the Request & Response body needs to be kept in "Pojo" package within "CreateUserRequestBody" class

public class Create_User_GetterSetter {
	

	@Test(priority = 1)
	public void createuser() {
		
		CreateUserRequestBody requestBody = new CreateUserRequestBody();
		requestBody.setId(007);
		requestBody.setUsername("Bond007");
		requestBody.setFirstName("James");
		requestBody.setLastName("Bond");
		requestBody.setEmail("jb007@hidden.com");
		requestBody.setPassword("jb@007");
		requestBody.setPhone("987654321");
		requestBody.setUserStatus(1);
		
		RestAssured.baseURI = "https://petstore.swagger.io/v2";
		
		CreateUserResponseBody responseBody = given()
		                                     .header("Content-Type", "application/json")
		                                     .body(requestBody)
		                                     .log().all()
		
		                                     .when()
		                                     .post("/user")
		                 
		                                     .then().extract().response().as(CreateUserResponseBody.class);
		//"as" : Get the body and map it to a Java object. For JSON responses this requires that you have either "Jackson" or "Gson"
		
		Integer statuscode = responseBody.getCode();
		System.out.println(statuscode);
		
		System.out.println(responseBody.getMessage());
		System.out.println(responseBody.getType());
	}
}
