package servlet;

import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;

import data.handle;
import model.User;
import model.risk;



public class LoginAction extends ActionSupport{

	//private String message;
	private User loginuser;
	private String username;
	private String password;
	private ArrayList<risk> risklist; 

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


    // 定义处理用户请求的execute方法
	
	public String toLogin(){
		return "success";
	}
	
	public String judgeLogin(){
		handle h=new handle();
		int result=h.judgeLogin(username,password);
		switch(result){
			case 0:	
				loginuser=new User(username);
				risklist=h.getAllRisk();
				for(int i=0;i<risklist.size();i++){
					switch(risklist.get(i).getRiskPossibility()){
						case 1:
							risklist.get(i).setRiskPossibilityStr("低");
							break;
						case 2:
							risklist.get(i).setRiskPossibilityStr("中");
							break;
						case 3:
							risklist.get(i).setRiskPossibilityStr("高");
							break;
						default:
							System.out.println("riskPossibility false");
							break;
					}
					
					switch(risklist.get(i).getRiskEfficiency()){
						case 1:
							risklist.get(i).setRiskEfficiencyStr("低");
							break;
						case 2:
							risklist.get(i).setRiskEfficiencyStr("中");
							break;
						case 3:
							risklist.get(i).setRiskEfficiencyStr("高");
							break;
						default:
							System.out.println("riskEfficiencyStr false");
							break;
					}
				}
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
