package model;

public class User {
	private String userName;
	//private int userId;
	
	public User(String name){
		this.userName=name;
		//this.userId=userId;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
//	public int getUserId() {
//		return userId;
//	}
//	public void setUserId(int userId) {
//		this.userId = userId;
//	}	
	
}
