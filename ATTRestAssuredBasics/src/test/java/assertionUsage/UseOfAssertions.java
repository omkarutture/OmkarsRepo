package assertionUsage;

//statically imported methods to apply assertions:
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import static org.hamcrest.Matchers.*; //on the basis of hamcrest we can apply assertion on body as well. Such kind of assertion leverage is nor available in TestNG.
import static io.restassured.RestAssured.*;


public class UseOfAssertions {
	
	@Test
	public void getuserdetails() {
	RestAssured.baseURI = "https://api.getpostman.com/";
	
	given().header("x-api-key","PMAK-64f1d9e5b52fc60029b825e7-4653a5b5bcca153b51f82cc2e2292c100a")
	
	.when().get("workspaces")
	
	//Here we'll apply assert via ".assertThat()" method which returns the response specification
	.then().assertThat() //This assert will be work as that of Hard Assert: if one fails rest will fail.
	
	//below applying assertion on response header:
	.header("Transfer-Encoding", "chunked") //header: Validate that a response header matches the supplied name and value
	.header("ETag", "W/\"1c8-SyiP/GjZG/L4yB6HijYN8HxLWtg\"").and().header("Content-Encoding", "gzip") //to apply multiple "header()" assertions, follow then by ".and()"
	.headers("Server", "nginx", "Connection", "keep-alive") //with "headers()" we can apply multiple asserts using ","
	
	//below applying assertion on response body i.e., the type of response or in technical language contentType
    .contentType(ContentType.JSON)
    //Note: "contentType" will affect the way the response is decoded.E,g. if you can't use JSON/XML matching. If you don't specify the response content type REST Assured will automatically try to figure out which content type to use.
    //"ContentType": This may be used to specify a request or response content-type more easily than specifying the full string each time. i.e. 
    //http.request( GET, JSON ) {...}
    //Is roughly equivalent to:  http.request( GET, 'application/json' )

	//Validate that the response status code matches an integer.
	.statusCode(200) //OR
	.statusCode(equalTo(200))//this can be also used with assertThat("abc", equalTo("abc"));
	
	//.statusLine(DEFAULT_BODY_ROOT_PATH);//Validate that the response status line matches the given String. 
	//E.g.  expect().statusLine("No Content").when().get("/something");
	//This is the same as: expect().statusLine(equalTo("No Content")).when().get("/something");
    //StatusLine is : "HTTP/1.1 200 OK" it's "HTTPrequest/Handshake StatusCode Message"
	//HandShake: on this basis of protocol, the data transfer is possible under OSI model.
	
	//Validating response body with hamcrest package & matchers class
	.body("workspaces.name", contains("My Workspace", "Omkars", "ATT Workspace", "PragatisWorkspace"))
	//Here, the contains method follows the insertion order, so. we need to pass as per the order.
	//contains: a series of items, each logically equal to the corresponding item in the specified items.
	//To validate OR bypass the protocol of insertion order will use "containsInAnyOrder()" method.
	.body("workspaces.name", hasItem("PragatisWorkspace"))//Here "hasItem" use to validate at least one item that is equal to the specified item.
	.body("workspaces[1]", hasKey("name"))//To check key
	.body("workspaces[3]", hasEntry("name", "PragatisWorkspace"));//contains at least one entry whose key equals the specified key and whose value equals the specified value
	//keyMatcher the key matcher that, in combination with the valueMatcher, must be satisfied by at least one entry value Matcher the value matcher that, in combination with the keyMatcher, must be satisfied by at least one entry

	}

}
//The testNg Asserts will only assert straight forward data. i.e., it dosn't assert when we apply any partial data. 
//But in Rest Assured we can do so via "hampRest" and to use this need to add some dependencies like "jackson","JSONassert" & "json schema validator".
//for serialization via jaskson, to apply assertions on the basis of JSONassert & validator to make assert on groove paths and make it capable to do so.
//In Order to use the assertions it is recommended to use the static import for the classes mentioned below:
//io.restassured.RestAssured.*
//io.restassured.matcher.RestAssuredMatchers.*
//org.hamcrest.Matchers.*
