package servlet;

import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;
import data.handle;
import model.User;
import model.risk;

public class UserAddAction extends ActionSupport{
	private String rusername;
	private String rpassword;
	private String crpassword;
	private boolean isadmin;
	private User loginuser;
	private ArrayList<risk> risklist; 
	
	
	public String getRusername() {
		return rusername;
	}

	public void setRusername(String rusername) {
		this.rusername = rusername;
	}

	public String getRpassword() {
		return rpassword;
	}

	public void setRpassword(String rpassword) {
		this.rpassword = rpassword;
	}

	public String getCrpassword() {
		return crpassword;
	}

	public void setCrpassword(String crpassword) {
		this.crpassword = crpassword;
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
		if(!rpassword.equals(crpassword)){
			return "fail";
		}
		int result=h.addUser(rusername, rpassword, true);
		
		switch(result){
			case 0:
				loginuser=new User(rusername);
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
