package servlet;

import java.util.ArrayList;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import data.userLogic;
import model.User;
import model.risk;



public class LoginAction extends ActionSupport{

	/**
	 * 
	 */
	
	//justtest
	private static final long serialVersionUID = 1L;
	
	private User loginuser;
	private String username;
	private String password;
	private String message;
	private ArrayList<risk> risklist; 
	
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	
	public String toLogin(){
		return "success";
	}
	
	public String judgeLogin(){
		userLogic u=new userLogic();
		int result=u.judgeLogin(username,password);
		switch(result){
			case 0:	
				ActionContext actionContext = ActionContext.getContext();			  
			    Map session = actionContext.getSession();  			  
			    session.put("username", username);			  
				return "success";
			case -1:
				message="ÓÃ»§Ãû²»´æÔÚ";
				return "not found";
			case -2:
				message="ÃÜÂë´íÎó";
				return "wrong";
			default:
				message="µÇÂ¼Ê§°Ü";
				return "fail";
		}
	} 
}
