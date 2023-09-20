package mockServer;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class POSTMockResponse {
	
	@Test
	public void postresponse() {
		
		//Short trick: While creating JSON Object: if it's Json use HashMap & when it's a Array use List.
		//For JSON:
		HashMap<String, String> Obj1 = new HashMap<String, String>();
		Obj1.put("name", "Om");
		Obj1.put("gender", "M");
		
		HashMap<String, String> Obj2 = new HashMap<String, String>();
		Obj2.put("name", "Sai");
		Obj2.put("gender", "F");
		
		//For Array:
		ArrayList<HashMap<String, String>> JSONObject = new ArrayList<HashMap<String, String>>();
		//OR also we can write it as
		//List<Map<String, String>> JSONObject = new ArrayList<Map<String, String>>();
		
		JSONObject.add(Obj1);
		JSONObject.add(Obj2);
		
		
		RestAssured.baseURI = "https://297dc1df-7b2b-48c5-b65f-5573b8772823.mock.pstmn.io";
		
		Response response = given()
				
				//Passing body via JSON Object
				.body(JSONObject)
				
				//OR you can pass body directly as below
//				.body("[\r\n"
//						+ "    {\"name\": \"Om\", \"gender\": \"M\"},\r\n"
//						+ "    {\"name\": \"Sai\", \"gender\": \"F\"}\r\n"
//						+ "]")
				
				.log().all()
		
		.when().post("/post")
		
		.then().extract().response();
		
		String pretty = response.asPrettyString();
		System.out.println(pretty);
	}

}
