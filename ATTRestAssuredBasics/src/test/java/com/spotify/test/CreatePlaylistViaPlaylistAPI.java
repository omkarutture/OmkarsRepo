package com.spotify.test;

import static io.restassured.RestAssured.given;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.spotify.api.PlayListAPI;
import com.spotify.api.Req_Res_Builder;
import com.spotify.pojo.Playlist;

import authmanager.AccessTokenCreator;
import io.restassured.response.Response;

public class CreatePlaylistViaPlaylistAPI {
	
	static String playlistId;
	
	@Test(priority = 1)
	public void createPlaylist() {
		
		Playlist reqplaylist = new Playlist(); 
		reqplaylist.setName("Raj's");
		reqplaylist.setDescription("Collection of Raj's songs");
		reqplaylist.setPublic(false);
		
        Response Requestresponse = PlayListAPI.post(reqplaylist, AccessTokenCreator.renewToken()); //This will return us Request Response 
        Playlist responseplaylist = Requestresponse.as(Playlist.class); //This will return us Response playlist which we'll de-serialize
		
		String requestNameValue = reqplaylist.getName(); //Excepted Value with help of reqPlaylist
		String responseNameValue = responseplaylist.getName(); //Actual Value with help of responseplaylist
		Assert.assertEquals(requestNameValue, responseNameValue);
		
		playlistId = responseplaylist.getId();
		System.out.println("Playlist ID is:"+ " " +playlistId);
	}
	
	@Test(priority = 2)
	public void getPlaylistDetail() {
		
		Playlist reqplaylist = new Playlist(); 
		reqplaylist.setName("Raj's");
		reqplaylist.setDescription("Collection of Raj's songs");
		reqplaylist.setPublic(false);
		//from above we'll get Actual value
		
		Response response = PlayListAPI.get(playlistId, AccessTokenCreator.renewToken());
		Playlist responsePlaylist = response.as(Playlist.class);
		//from above we'll get Excepted value
		
		Assert.assertEquals(responsePlaylist.getName(), reqplaylist.getName());
		//reqplaylist.getName() Actual value AND responsePlaylist.getName() Excepted Value
	}
	
	@Test(priority = 3)
	public void updateUserPlaylist() {
		
		Playlist reqplaylist = new Playlist(); 
		reqplaylist.setName("Rajka's updated list");
		reqplaylist.setDescription("Collection of Rajka's updated songs");
		reqplaylist.setPublic(false);
		
		Response response = PlayListAPI.update(playlistId, reqplaylist, AccessTokenCreator.renewToken());
		int statuscode = response.statusCode();
		Assert.assertEquals(statuscode, 200); 
	}

	//Negative Testcase example:
	@Test(priority = 4)
	public void shouldNotBeAbleToCreatePlaylist() {

		Playlist reqplaylist = new Playlist(); 
		reqplaylist.setName("Raj's");
		reqplaylist.setDescription("Collection of Raj's songs");
		reqplaylist.setPublic(false);
		
        Response Requestresponse = PlayListAPI.post(reqplaylist, "12345"); //Here, sending wrong token i.e., "12345" 
        //Playlist responseplaylist = Requestresponse.as(Playlist.class); 
        //Here the token is wrong, hence this will not execute. therefore will not get response and hence no need to de-serialize
        int actualstatuscode = Requestresponse.statusCode();
		Assert.assertEquals(actualstatuscode, 401);
}
}
