package com.spotify.test;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.spotify.api.Req_Res_Builder;
import com.spotify.pojo.Playlist;

public class CreatePlaylistWithReqAndResSpec {
	
	static String playlistId;

	@Test(priority = 1)
	public void createPlaylist() {
		
		Playlist reqplaylist = new Playlist(); 
		reqplaylist.setName("Omkar1995");
		reqplaylist.setDescription("Collection of 90's fav songs");
		reqplaylist.setPublic(false);
		
		Playlist responseplaylist = given(Req_Res_Builder.requestBuilder())
		.body(reqplaylist)
		
		.when().post("/users/31tocmmck5zchznpcnp2rbi32lvy/playlists")
		
		.then().spec(Req_Res_Builder.responseBuilder()).extract().response()
		.as(Playlist.class); //De-serialization
		
		String requestNameValue = reqplaylist.getName(); //Excepted Value 
		String responseNameValue = responseplaylist.getName(); //Actual Value
		Assert.assertEquals(requestNameValue, responseNameValue);
		
		playlistId = responseplaylist.getId(); 
		System.out.println("Playlist Id:"+ " " +playlistId);
		//Here, with the help of Serialization & De-Serialization. We can call the methods directly and get the values and use this values as per our requirement.
		//This is possible because everything is present in the form of JavaObject
		//No, need to have JSONPath class here.	
	}
	
	@Test(priority = 2)
	public void getPlaylistDetails() {
		
		given(Req_Res_Builder.requestBuilder())
		
		.when().get("/playlists/"+playlistId)
		//Here we're fetching the playlistId from create method. This is example of API Chaining 
		
		.then().spec(Req_Res_Builder.responseBuilder())
		.extract()
		.response();	
	}
}
