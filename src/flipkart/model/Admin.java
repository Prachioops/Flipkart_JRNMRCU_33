package flipkart.model;

public class Admin {

	private static String userName;
	private static String password;
	
	static {
		userName="admin";
		password="adminpassword";
	}

	public static String getUserName() {
		return userName;
	}

	public static void setUserName(String userName) {
		Admin.userName = userName;
	}

	public static String getPassword() {
		return password;
	}

	public static void setPassword(String password) {
		Admin.password = password;
	}
	
	
	
}
