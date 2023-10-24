package usermanage;

public class user {

	private String userName;
	private String fName;
	private String lName;
	private String email;
	private String uCountry;
	private String uCity;
	private String uDOB;
	
	
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
