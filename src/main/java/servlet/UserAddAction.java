package servlet;

import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;
import data.handle;
import model.User;
import model.risk;

public class UserAddAction extends ActionSupport{
	private String userName;
	private String passwd;
	private boolean isadmin;
	private User loginuser;
	private ArrayList<risk> risklist; 
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public boolean isIsadmin() {
		return isadmin;
	}

	public void setIsadmin(boolean isadmin) {
		this.isadmin = isadmin;
	}

	public User getLoginuser() {
		return loginuser;
	}

	public void setLoginuser(User loginuser) {
		this.loginuser = loginuser;
	}

	public ArrayList<risk> getRisklist() {
		return risklist;
	}

	public void setRisklist(ArrayList<risk> risklist) {
		this.risklist = risklist;
	}

	public String addUser(){
		handle h=new handle();
		int result=h.addUser(userName, passwd, isadmin);
		
		switch(result){
			case 0:
				loginuser=new User(userName);
				risklist=h.getAllRisk();
				return "success";
			case 1:
				return "already exist";
			case 2:
				return "too short";
			case -1:
				return "fail";
			default:
				return "fail";
		}
	}
}
