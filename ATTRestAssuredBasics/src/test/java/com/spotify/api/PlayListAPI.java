package com.spotify.api;

import static io.restassured.RestAssured.given;

import com.spotify.pojo.Playlist;

import io.restassured.response.Response;

public class PlayListAPI {
	
	public static Response post(Playlist requestPalylist, String token) 
	{	
		return given(Req_Res_Builder.requestBuilder())
				
		//.header("Authorization", "Bearer "+token)
		//Another way to pass token is below
		.auth().oauth2(token)
				
		.body(requestPalylist)
		 
		.when().post("/users/31tocmmck5zchznpcnp2rbi32lvy/playlists")
		
		.then().spec(Req_Res_Builder.responseBuilder()).extract().response();
	//Here from given() to response() method. this will return us response. hence the return type is Response 
	}

	public static Response get(String playlisId, String token) 
	{
        return given(Req_Res_Builder.requestBuilder())
        		
        .header("Authorization", "Bearer "+token)
		
		.when().get("/playlists/"+playlisId)
		//+playlistId is a argument type instead of hardcoding it. So, that every time it'll take a present value
		
		.then().spec(Req_Res_Builder.responseBuilder())
		.extract()
		.response();	
		
	}
	
	public static Response update(String playlisId, Playlist requestPalylist, String token) {
		
         return given(Req_Res_Builder.requestBuilder())
        		 
        .body(requestPalylist)
		 
        .header("Authorization", "Bearer "+token)
        		 
		.when().put("/playlists/"+playlisId)
		
		.then()
		//.spec(Req_Res_Builder.responseBuilder())// Here, we're not using this becasue, this contains the assertion of content-type.Json
		//And here, this response is empty.
		.extract()
		.response();	
	}
}
