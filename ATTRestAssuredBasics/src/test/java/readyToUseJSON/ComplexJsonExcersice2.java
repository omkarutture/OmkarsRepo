package readyToUseJSON;

public class ComplexJsonExcersice2 {

	        //body
	
			//defining the array of id:
	
			
//			List<Integer> arrayOfId = new ArrayList<Integer>();
//			arrayOfId.add(5);
//			arrayOfId.add(9);
//			
//			HashMap<String, Object> batterHashMap1 = new HashMap<String, Object>();
//			
//			batterHashMap1.put("id", "1001");
//			batterHashMap1.put("type", "Regular");
//			
//			HashMap<String, Object> batterHashMap2 = new HashMap<String, Object>();
//			
//			batterHashMap2.put("id", arrayOfId);
//			batterHashMap2.put("type", "Chocolate");
//			
//			List<HashMap<String, Object>> batterArrayList = new ArrayList<HashMap<String,Object>>();
//			
//			batterArrayList.add(batterHashMap1);
//			batterArrayList.add(batterHashMap2);
//			
//			HashMap<String, List<HashMap<String, Object>>> battersHashMap = new HashMap<String, List<HashMap<String,Object>>>();
//			
//			battersHashMap.put("batter", batterArrayList);
//			
////			toppings:
//			
//			HashMap<String, String> topping1 = new HashMap<String, String>();
//			topping1.put("id", "5001");
//			topping1.put("type", "None");
//			
//			HashMap<String, String> topping2 = new HashMap<String, String>();
//			topping2.put("id", "5002");
//			topping2.put("type", "Glazed");
//			
//			HashMap<String, String> topping3 = new HashMap<String, String>();
//			topping3.put("id", "5005");
//			topping3.put("type", "Sugar");
//			
//			
//			List<HashMap<String, String>> toppingvalue = new ArrayList<HashMap<String,String>>();
//			
//			toppingvalue.add(topping1);
//			toppingvalue.add(topping2);
//			toppingvalue.add(topping3);
//			
//			
////			HashMap<String, Object> toppings = new HashMap<String, Object>();
////			
////			toppings.put("topping", toppingvalue);
//			
//			
//			HashMap<String, Object> mainObject = new HashMap<String, Object>();
//			
//			mainObject.put("id", "0001");
//			mainObject.put("type", "donut");
//			mainObject.put("name", "Cake");
//			mainObject.put("ppu", 0.55);
//			mainObject.put("batters", battersHashMap);
//			mainObject.put("topping", toppingvalue);
//			
//			
//			RestAssured.baseURI = "https://02bb9a44-db49-4734-9c5b-7991b066bb5a.mock.pstmn.io";
//			
//			given()
//			
//			.header("Content-Type", "application/json")
//			
//			.header("x-mock-match-request-body", "true")
//			
//			.body(mainObject)
//			
//			.log().all()
//			
//			.when()
//			
//			.post("/complexjsonpost")
//			
//			.then()
//			
//			.log().all()
//			
//			.extract()
//			
//			.response();

}
