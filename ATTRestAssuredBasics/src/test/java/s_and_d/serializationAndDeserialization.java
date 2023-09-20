package s_and_d;

//To perform Serialization & De-Serialization. need to add following dependencies to pom.xml file
// 1. JacksonCore: Core Jackson processing abstractions (aka Streaming API), implementation for JSON
// 2. JacksonDatabind: General data-binding functionality for Jackson, works on core streaming API
// 3. JacksonAnnotation: Core annotations used for value types, used by Jackson data binding package.
// 4. Gson: used to convert Java Objects into their JSON representation. It can also be used to convert a JSON string to an equivalent Java object.

// Serialization and Deserialization:
//The process to convert from java object to byte stream of data is called as serialization. We need serialization because it is recommended to configure the values instead of sending the whole json into the body.
//The process to convert from bytestream of data into java object is called as de-serialization. 

//POJO class: It is an abbreviation for Plain Old Java Object in which we have the variables or data members with their corresponding getter and setter method so that we can easily add the values and get the values whichever are required.
//POJO: Plan Old Java Object: with help of this POJO class will create "body" for serialization and Deserialization.
//POJO: Is used to just create Request/Response body in terms of javaObject. So, that we can access them as per requirement

//Reason to use Serialization and Deserialization:
//The main purpose of serialization and deserialization is to persist the data and recreate it whenever needed and make it configurable as per requirement so that we can use it easily anywhere.
//1. We can represent each data in the form of Object.
// As object is a collection of Methods which consists of variables. Hence we can easily update/change this variable values at any point of moment and also it is in readable format.
// But, JSON is not in readable format also it's difficult to maintain, update/change the variable values within JOSN 

public class serializationAndDeserialization {
	
	int age;
	String name;
	String city;
//Click ALT+Shift+S >> Generate getter & Setter : to get ready getter and setter methods
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
public static void main(String[] args) {
		
	serializationAndDeserialization getset = new serializationAndDeserialization();
		
		getset.setAge(96);
		getset.setName("Omkar");
		getset.setCity("Kolhapur");
		
		System.out.println(getset.getAge());
		System.out.println(getset.getName());
		System.out.println(getset.getCity());
	}
	
	
}
