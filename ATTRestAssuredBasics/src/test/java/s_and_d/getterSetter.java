package s_and_d;

public class getterSetter {
//Getters and setters are used to protect your data, particularly when creating classes. 
//For each instance variable, a getter method returns its value while a setter method sets or updates its value. 
//Given this, getters and setters are also known as accessors and mutators
	
	int i;
	String name;
	String city;
	
	public int getI() //with getter method will get the variable/value
	{
		return i;
	}
	
	public void setI(int a) //with setter method will set the variable/value
	{
		i= a;
	}
	
	public String getName() //with getter method will get the variable/value
	{
		return name;
	}
	
	public void setName(String nameofuser) //with setter method will set the variable/value
	{
		name= nameofuser;
	}
	
	//Above one can observe for each variable we'll have get and set method i.e., getter and setter
	//on the same principle, POJO class says: for multiple variables will have getter & setter method resp.
	//POJO: Plan Old Java Object: with help of this POJO class will create "body" for serialization and De-serialization.
	//POJO: Is used to just create Request/Response body in terms of javaObject. So, that we can access them as per requirement 
	
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public static void main(String[] args) {
		
		getterSetter getset = new getterSetter();
		
		getset.setI(96);
		getset.setName("Pragati");
		
		System.out.println(getset.getI());
		System.out.println(getset.getName());
	}
	
}
