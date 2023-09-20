package fileUploadingAndDownloading;

import static io.restassured.RestAssured.given;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class Uploading {
	
	@Test
	public void fileUploafing() {
		
		RestAssured.baseURI = "https://the-internet.herokuapp.com";
		
		File image = new File("C:\\Users\\user\\Desktop\\PP.jpg");
		
		given()
		//.multiPart("file", new File("C:\\Users\\user\\Desktop\\PP.jpg"))//Here with new keyword, we created the obj of file class. //OR
		.multiPart("file", image)
		//Specify a file to upload to the server using multi-part form data uploading with a specific control name.
		//Parameters:file The file to uploadcontrolName Defines the control name of the body part. In HTML this is the attribute name of the input tag.
		
		.log().all()
		
		.when().post("/upload")
		
		.then().log().all().extract().response();
		
	}
}
//Here, the uploaded API returns the response as HTML. Hence, we receive the response as HTML as well.