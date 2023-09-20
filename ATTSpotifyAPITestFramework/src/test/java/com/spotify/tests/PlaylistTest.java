package com.spotify.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.spotify.api.PlayListAPI;
import com.spotify.pojo.Playlist;

import authmanager.AccessTokenCreator;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.restassured.response.Response;
import utils.ConfigReader;

@Epic("Spotify with OAuth 2.0") //Used to mark tests with epic label from Allure. //Epic is collection of multiple User Stories
@Feature("Playlist API") //Used to mark tests with feature label.
public class PlaylistTest {

	static String playlistId;

	@Story("Playlist Creation") //from allure: Used to mark test case with a story label
	@Description("Creating a Playlist")
	//Description annotation from allure: Annotation that allows to attach a description for a testn
	@Test(priority = 1)
	public void createPlaylist() throws IOException {

		Playlist reqplaylist = new Playlist();
		reqplaylist.setName(ConfigReader.readConfig("name"));
		reqplaylist.setDescription(ConfigReader.readConfig("description"));
		reqplaylist.setPublic(false);

		Response Requestresponse = PlayListAPI.post(reqplaylist, AccessTokenCreator.renewToken()); // This will return
																									// us Request
																									// Response
		Playlist responseplaylist = Requestresponse.as(Playlist.class); // This will return us Response playlist which
																		// we'll de-serialize

		String requestNameValue = reqplaylist.getName(); // Excepted Value with help of reqPlaylist
		String responseNameValue = responseplaylist.getName(); // Actual Value with help of responseplaylist
		Assert.assertEquals(requestNameValue, responseNameValue);

		playlistId = responseplaylist.getId();
		System.out.println("Playlist ID is:" + " " + playlistId);
	}

	@Story("Playlist Creation")
	@Description("Details of created Playlist")
	@Test(priority = 2)
	public void getPlaylistDetail() throws IOException {

		Playlist reqplaylist = new Playlist();
		reqplaylist.setName(ConfigReader.readConfig("name"));
		reqplaylist.setDescription(ConfigReader.readConfig("description"));
		reqplaylist.setPublic(false);
		// from above we'll get Actual value

		Response response = PlayListAPI.get(playlistId, AccessTokenCreator.renewToken());
		Playlist responsePlaylist = response.as(Playlist.class);
		// from above we'll get Excepted value

		Assert.assertEquals(responsePlaylist.getName(), reqplaylist.getName());
		// reqplaylist.getName() Actual value AND responsePlaylist.getName() Excepted
		// Value
	}

	@Story("Updateding Playlist")
	@Description("Updateding Created Playlist")
	@Test(priority = 3)
	public void updateUserPlaylist() throws IOException {

		Playlist reqplaylist = new Playlist();
		reqplaylist.setName(ConfigReader.readConfig("name")+"updated value");
		reqplaylist.setDescription(ConfigReader.readConfig("description"));
		reqplaylist.setPublic(false);

		Response response = PlayListAPI.update(playlistId, reqplaylist, AccessTokenCreator.renewToken());
		int statuscode = response.statusCode();
		Assert.assertEquals(statuscode, 200);
	}

	// Negative Testcase example:
	@Story("Playlist Creation")
	@Description("Invalid Access Token")
	@Test(priority = 4)
	public void shouldNotBeAbleToCreatePlaylist() throws IOException {

		Playlist reqplaylist = new Playlist();
		reqplaylist.setName(ConfigReader.readConfig("name"));
		reqplaylist.setDescription(ConfigReader.readConfig("description"));
		reqplaylist.setPublic(false);

		Response Requestresponse = PlayListAPI.post(reqplaylist, "12345"); // Here, sending wrong token i.e., "12345"
		// Playlist responseplaylist = Requestresponse.as(Playlist.class);
		// Here the token is wrong, hence this will not execute. therefore will not get
		// response and hence no need to de-serialize
		int actualstatuscode = Requestresponse.statusCode();
		Assert.assertEquals(actualstatuscode, 401);
	}
}
