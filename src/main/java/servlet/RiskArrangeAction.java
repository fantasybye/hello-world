package servlet;

import java.util.ArrayList;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import data.projectLogic;
import model.project;

public class RiskArrangeAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String creatorName;
	private ArrayList<project> projectlist;
	private String plan_name;
	private String message;
	
	public ArrayList<project> getProjectlist() {
		return projectlist;
	}

	public void setProjectlist(ArrayList<project> projectlist) {
		this.projectlist = projectlist;
	}


	public String getPlan_name() {
		return plan_name;
	}

	public void setPlan_name(String plan_name) {
		this.plan_name = plan_name;
	}
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	
	public String getRiskArrange(){
		projectLogic p=new projectLogic();
		
		ActionContext actionContext = ActionContext.getContext();			  
	    Map session = actionContext.getSession();  			  
	    creatorName=(String)session.get("username");		  
		projectlist= p.getAllProject(creatorName);
		if(projectlist.size()>=0){
			return "success";
		}
		else{
			return "fail";
		}
	}
	
	public String addProject(){
		projectLogic p=new projectLogic();
		boolean duplicate=false;
		for(int i=0;i<projectlist.size();i++){
			if(projectlist.get(i).getProjectName().equals(plan_name)){
				duplicate=true;
			}
		}
		if(duplicate){
			message="同名管理计划已存在";
			return "fail";
		}
		int result=p.addProject(plan_name, creatorName);
		if(result>=0){
			getRiskArrange();
		}
		return "success";
	}
}
