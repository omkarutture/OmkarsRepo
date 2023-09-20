package reqresGETResponseViaPOJO;

import static io.restassured.RestAssured.given;

import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import reqresResponsePOJO.Data;
import reqresResponsePOJO.Support;
import reqresResponsePOJO.VariableDataBody;

public class Response_GAndS_POJO {
	
	@Test
	public void getUserData() {
		
		RestAssured.baseURI = "https://reqres.in/";
		
		VariableDataBody responsedataBody = given()
		
		.when().log().all().get("api/users?page=2")
		
		.then().log().all().extract().response().as(VariableDataBody.class);
		
		//Fetching Data from Variable
		Integer pageNo = responsedataBody.getPage();
		System.out.println(pageNo);
		
		//Fetching Data from Data List Array
		List<Data> dataArray = responsedataBody.getData();
		String emailOf3rdIndex = dataArray.get(3).getEmail();
		System.out.println(emailOf3rdIndex);
		
		//Fetching Data from Support variable
		Support supportvar = responsedataBody.getSupport();
		//String supportURL = supportvar.getUrl();
		System.out.println(supportvar.getUrl()); //Here, you can write in this way OR you can use getURL methods ref.veriable.
	}

}
