package servlet;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import data.riskLogic;
import model.risk;

public class ImportRiskAction extends ActionSupport{
	
	private java.util.Date startTime;
	private java.util.Date endTime;
	private ArrayList<risk> risklist;
	private String[] checkedValue;
	private String type;
	
	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public ArrayList<risk> getRisklist() {
		return risklist;
	}

	public void setRisklist(ArrayList<risk> risklist) {
		this.risklist = risklist;
	}

	public String[] getCheckedValue() {
		return checkedValue;
	}

	public void setCheckedValue(String[] checkedValue) {
		this.checkedValue = checkedValue;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getIniRisk(){
		ActionContext actionContext = ActionContext.getContext();			  
	    Map session = actionContext.getSession();  			  
	    int projectid=(Integer)session.get("projectid");	
		
		riskLogic r=new riskLogic();
		risklist=r.getNotExistRisk(projectid);
		
		return "success";
	}
	
	public String getChoiceRisk(){
		ActionContext actionContext = ActionContext.getContext();			  
	    Map session = actionContext.getSession();  			  
	    int projectid=(Integer)session.get("projectid");
	    
	    int typeint=0;
	    if(type.equals("volvo")){
	    	typeint=0;
	    }else if(type.equals("saab")){
	    	typeint=1;
	    }else if(type.equals("opel")){
	    	typeint=2;
	    }
		
		riskLogic r=new riskLogic();
		risklist=r.getSelectedProjectRisk(new java.sql.Date(startTime.getTime()), new java.sql.Date(endTime.getTime()), projectid, typeint);
		
		return "success";
	}
}
