package pathandquaryparam;

import static io.restassured.RestAssured.given;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class QuaryParams {

	@Test
	public void quaryParam() {
		
		HashMap<String, String> QP = new HashMap<String, String>();
		QP.put("Shivay", "Samartha");
		QP.put("Namha", "Swami");
		QP.put("Om", "Shree");
		
		 RestAssured.baseURI = "https://postman-echo.com/";
			
		 Response response = given()
				            .header("x-api-key","PMAK-64f1d9e5b52fc60029b825e7-4653a5b5bcca153b51f82cc2e2292c100a")
				            //.queryParam("Om", "Shree").queryParam("Namha", "Swami").queryParam("Shivay", "Samartha")
	     //Here, with .queryParam() method we can pass query's as a single of multiple as mentioned above.
				            
		//But, If we want to pass all query's in single line will use .queryParams() method within which we need to pass query's in terms of Map.
	    //Hence, we need to Map all the query's first,which is Mapped with help of "HashMap" class and then pass the it to the method. As below:
				            .queryParams(QP)
		
		                    .when() 
	       	                .get("get")
		
		                    .then()
		                    .extract()
		                    .response();
		
		System.out.println(response);
		String prittyresponse = response.asPrettyString();
		System.out.println(prittyresponse);
		
		
	}
	
}
