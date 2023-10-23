package usermanage;

public class user {

	String userName;
	String fName;
	String lName;
	String email;
	
	
	
	public user(String userName, String fName, String lName, String email) {
		this.userName = userName;
		this.fName = fName;
		this.lName = lName;
		this.email = email;
	}
	
	
	public String getUserName() {
		return userName;
	}
	public String getfName() {
		return fName;
	}
	public String getlName() {
		return lName;
	}
	public String getEmail() {
		return email;
	}
	
	
	
}
