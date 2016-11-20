package servlet;

import java.util.ArrayList;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import data.userLogic;
import model.User;
import model.risk;

public class UserAddAction extends ActionSupport{
	private String rusername;
	private String rpassword;
	private String crpassword;
	private boolean isadmin;
	private User loginuser;
	private String message;
	private ArrayList<risk> risklist; 
	
	
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

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
		userLogic u=new userLogic();
		if(!rpassword.equals(crpassword)){
			message="密码不相同";
			return "fail";
		}
		int result=u.addUser(rusername, rpassword, true);
		
		switch(result){
			case 0:
				ActionContext actionContext = ActionContext.getContext();			  
			    Map session = actionContext.getSession();  			  
			    session.put("username", rusername);			  
				return "success";
			case -1:
				message="用户名已存在";
				return "already exist";
			case -2:
				message="密码少于6位";
				return "too short";
			default:
				message="注册失败";
				return "fail";
		}
	}
}
