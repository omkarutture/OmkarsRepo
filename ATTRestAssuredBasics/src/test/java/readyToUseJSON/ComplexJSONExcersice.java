package readyToUseJSON;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import junit.framework.Assert;

public class ComplexJSONExcersice {
	
	@Test(priority = 1)
	public void getData() {
		//When we get just json body use following steps to use further.
		//we can't use "jsonPath" method. As we call it on the basis of response & here we don't have response such.
		//So, will create a object of "JsonPath" class and will pass the ref variable of json body as a argument here.
		//this is not a right way to do so.
		String body = "{\r\n"
				+ "  \"dashboard\": {\r\n"
				+ "    \"purchaseAmount\": 910,\r\n"
				+ "    \"website\": \"www.abc.com\"\r\n"
				+ "  },\r\n"
				+ "  \"courses\": [\r\n"
				+ "    {\r\n"
				+ "      \"title\": \"Selenium Python\",\r\n"
				+ "      \"price\": 50,\r\n"
				+ "      \"copies\": 6\r\n"
				+ "    },\r\n"
				+ "    {\r\n"
				+ "      \"title\": \"Cypress\",\r\n"
				+ "      \"price\": 40,\r\n"
				+ "      \"copies\": 4\r\n"
				+ "    },\r\n"
				+ "    {\r\n"
				+ "      \"title\": \"RPA\",\r\n"
				+ "      \"price\": 45,\r\n"
				+ "      \"copies\": 10\r\n"
				+ "    }\r\n"
				+ "  ]\r\n"
				+ "}";
		
		JsonPath JP = new JsonPath(body);
		String website = JP.getString("dashboard.website");
		System.out.println("website"+" "+website);
		System.out.println("===============================@*$*%*&*%*$*#*@==============================");
	}
	
	
	@Test(priority = 2)
	public void getDataFromJsonBody() {
	//Therefore, need to store such json body to another class and this class will return body in terms of String. And will with "classname.methodname()"
		JsonPath jsonbody = new JsonPath(JsonBody.getBody());//JsonPath is an alternative to using XPath for easily getting values from a Object document. It follows theGroovy GPath syntax when getting an object from the document. You can regard it as an alternative to XPath for JSON. 
		int coursecount;
		
		//1. Print No. of Courses returned by API.
		coursecount = jsonbody.getInt("courses.size()");
		System.out.println("Course returned by API:"+" : "+coursecount);
		System.out.println("===========================================================================");
		
		//2. Print Purchase Amount.
		int pA = jsonbody.getInt("dashboard.purchaseAmount");
		System.out.println("Total Purchase Amount is"+" : "+pA);
		System.out.println("===========================================================================");
		
		//3. Print title of the 1st course.
		String titleofcouse = jsonbody.getString("courses[0].title");
		System.out.println("Title of Course at Index 1"+" : "+titleofcouse);
		System.out.println("===========================================================================");
		
		//4. Print all course titles & their respective prices.
		coursecount = jsonbody.getInt("courses.size()");
		for(int i=0; i<coursecount; i++)
		{
			String courseTitle = jsonbody.getString("courses["+i+"].title");
			String price = jsonbody.getString("courses["+i+"].price");
			System.out.println("Course Title:"+" : "+courseTitle+" || "+"Course Amount"+" : "+price);
		}
		System.out.println("=======================================================================");
		
		//5. Print no. of copies sold by RPA course.
		int RPAcopies = jsonbody.getInt("courses[2].copies");
		System.out.println("No. of Copies sold for RPA courses"+" : "+RPAcopies);
		System.out.println("===========================================================================");
		
		//6. Verify if sum of all course prices matches with purchase amount.
		coursecount = jsonbody.getInt("courses.size()");
		int sum = 0;
		for(int i=0; i<coursecount; i++)
		{
			int copies = jsonbody.getInt("courses["+i+"].copies");
			int price = jsonbody.getInt("courses["+i+"].price");
			sum = sum + copies * price;
	    }
		
		int purchaseAomunt = jsonbody.getInt("dashboard.purchaseAmount");
		Assert.assertEquals(sum, purchaseAomunt);
		System.out.println("Sum amount value is"+" : "+sum);
		System.out.println("Purchase amount value is:"+" : "+purchaseAomunt);
	}	
}
