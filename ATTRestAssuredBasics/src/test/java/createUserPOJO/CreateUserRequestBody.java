package createUserPOJO;

public class CreateUserRequestBody {
	
// Keeping the Request body to create user with setter and getter method and this class object will be created into "Create_User_GetterSetter" class
	
	Integer id; 
//	The Integer class wraps a value of the primitive type int in an object. An object of type Integer contains a single field whose type is int. 
//  In addition, this class provides several methods for converting an int to a String and a String to an int, as well as other constants and methods useful when dealing with an int. 
    String username;
    String firstName;
    String lastName;
    String email;
    String password;
    String phone;
    Integer userStatus;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Integer getUserStatus() {
		return userStatus;
	}
	public void setUserStatus(Integer UserStatus) {
		this.userStatus = UserStatus;
	}

}
