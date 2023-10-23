package usermanage;

public class user {

	String userName;
	String fName;
	String lName;
	String email;
	String uCountry;
	String uCity;
	String uDOB;
	
	
	
	public user(String userName, String fName, String lName, String email, String uCountry, String uCity, String uDOB) {
		this.userName = userName;
		this.fName = fName;
		this.lName = lName;
		this.email = email;
		this.uCountry = uCountry;
		this.uCity = uCity;
		this.uDOB = uDOB;
	}
	
	
	public String getuCountry() {
		return uCountry;
	}

	public String getuCity() {
		return uCity;
	}

	public String getuDOB() {
		return uDOB;
	}

	public String getUserName() {
		System.out.println(userName);
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
