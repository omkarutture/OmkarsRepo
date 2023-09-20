package com.spotify.test;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.spotify.pojo.Playlist;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class CreatePlaylist {
	
	RequestSpecification RequestSpecification;
	ResponseSpecification ResponseSpecification;
	static String playlistId;
	
	@BeforeClass

	@Test(priority = 1)
	public void createPlaylist() {
		
		//As observed the keys "name", "description" & "public" are already been generated here.
		//so to make them use with different values we create obj of Playlist class from package com.spotify.Pojo.
		//the values in Playlist class will be from response. and here within this below obj the values will be as we define within obj itself.
		Playlist requestplaylist = new Playlist(); 
		requestplaylist.setName("Omkar");
		requestplaylist.setDescription("Collection of fav songs");
		requestplaylist.setPublic(false);
		
		Playlist responseplaylist = given(RequestSpecification)
		.body(requestplaylist)
		
		.when().post("/users/31tocmmck5zchznpcnp2rbi32lvy/playlists")
		
		.then().spec(ResponseSpecification).extract().response()
		.as(Playlist.class); //De-serialization
		
		String requestNameValue = requestplaylist.getName(); //Excepted Value 
		String responseNameValue = responseplaylist.getName(); //Actual Value
		Assert.assertEquals(requestNameValue, responseNameValue);
		
		playlistId = responseplaylist.getId();
		
	}
	
	@Test(priority = 2)
	public void getPlaylistDetails() {
		
		given(RequestSpecification)
		
		.when().get("/playlists/"+playlistId)
		
		.then().spec(ResponseSpecification)
		.extract()
		.response();
		
	}
	
}
