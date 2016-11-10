package servlet;

import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;

import data.handle;
import model.User;
import model.risk;


public class LoginAction extends ActionSupport{

	//private String message;
	private User loginuser;
	private String userName;
	private String passwd;
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


    // ���崦���û������execute����
	
	public String toLogin(){
		return "success";
	}
	
	public String judgeLogin(){
		handle h=new handle();
		int result=h.judgeLogin(userName,passwd);
		switch(result){
			case 0:	
				loginuser=new User(userName);
				risklist=h.getAllRisk();
				return "success";
			case -1:
				return "fail";
			case 1:
				return "not found";
			case 2:
				return "wrong";
			default:
				return "fail";
		}
	} 
}
