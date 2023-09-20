package fileUploadingAndDownloading;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import io.restassured.RestAssured;

public class Download {

	@Test
	public void downloadFile() throws IOException {
		
		RestAssured.baseURI = "https://github.com";
		
		byte[] bytearray = given()
		
		.log().all()
		
		.when().post("/Vimannagar/ATTRestassuredBasics/raw/master/BDD flow2.png")
		
		.then().log().all().extract().response().asByteArray(); 
		
		//".asByteArray()" : Get the body as a byte array. Returns:The body as a array.
		
		FileOutputStream fileStream = new FileOutputStream(new File("C:\\Users\\user\\Desktop\\downloadFile"));
		
		fileStream.write(bytearray);
		
		fileStream.close();
		//"close()" : Closes this file output stream and releases any system resources associated with this stream. 
		//This file output stream may no longer be used for writing bytes. 
		//If this stream has an associated channel then the channel is closed as well.

	}
	
}
