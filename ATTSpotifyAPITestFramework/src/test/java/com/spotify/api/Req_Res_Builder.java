package com.spotify.api;

import io.qameta.allure.Step;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Req_Res_Builder {
	
//**This is traditional way to represent obj and to use it further via ref.veriable
	
//RequestSpecification RequestSpecification;
//ResponseSpecification ResponseSpecification;

//   public void reqres() {
//		RequestSpecBuilder RequestBuilder = new RequestSpecBuilder();
//		RequestBuilder.setBaseUri("https://api.spotify.com");
//		RequestBuilder.setBasePath("/v1");
//		RequestBuilder.setContentType(ContentType.JSON);
//		RequestBuilder.addHeader("Authorization", "Bearer BQAExIhcb-O5IBWpMRLIj9rJhAZy1ZjlRU0y_I_P3cse5uG9c2YoZjk5qwjj6U7eSyexPfk7sj955UELblrfNMoraYA0BdnabQu2fYpuoT5UqleNQ216_NL_OgVXdCIbSlAzbDqBXVGk8YKh-WzeOI-GtOXHQGmp-YgTIz7DCbs-6YuKm0fhIwhVyHk4FBy1bDdcZLB7zA__WiImYX61WQmVuQsf9hU0lVR3YrwSbs50FM991EaD_oBymNl07IL7bPquJzFhqEPjWhJS");
//	    RequestBuilder.log(LogDetail.ALL);
//	    RequestSpecification = RequestBuilder.build();
//	
//	    ResponseSpecBuilder ResponseBuilder = new ResponseSpecBuilder();
//	    ResponseBuilder.expectContentType(ContentType.JSON);
//	    ResponseBuilder.log(LogDetail.ALL);
//	    ResponseSpecification = ResponseBuilder.build();
//	}

	
//**Advance way to represent methods on the basis of object and to use it via return type. As below:
	
	@Step
	public static RequestSpecification requestBuilder() {
		return new RequestSpecBuilder()
		.setBaseUri("https://api.spotify.com")
		.setBasePath("/v1")
		.setContentType(ContentType.JSON)
		.addFilter(new AllureRestAssured()) //This constructor from Allure-rest-assured dependency will help to get the data in reports
		//This filter will be applied to request. no need to apply in response. As it'll fetch the data from req & res both in reports. 
		.log(LogDetail.ALL)
	    .build();
	}
	//Above here, at last .build() method will compile and store the values in "RequestSpecification" variable which returns the obj type "RequestSpecification"
	//And any method with return type will execute logic and finally returns the value via return type which is placed for void in method
	@Step
	public static ResponseSpecification responseBuilder() {
		return new ResponseSpecBuilder()
	    .expectContentType(ContentType.JSON)
	    .log(LogDetail.ALL)
	    .build();
		
	}
}
