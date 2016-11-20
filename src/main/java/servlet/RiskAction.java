package servlet;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.sql.Date;
import java.util.Map;


import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import data.riskLogic;
import model.risk;
import model.riskNum;

public class RiskAction extends ActionSupport{
	private ArrayList<risk> risklist;
	
	private String rname;
	private String rcontent;
	private String rpos;
	private String reff;
	private String risk_trigger;
	private String risk_committer;
	private String risk_tracker;
	//private int selectedprojectid;
	private int selectedriskid;
	
	private Date startTime;
	private Date endTime;
	private Date hidStart;
	private Date hidEnd;
	
	ArrayList<riskNum> recognized;
	ArrayList<riskNum> toProblem;
	
	public ArrayList<risk> getRisklist() {
		return risklist;
	}

	public void setRisklist(ArrayList<risk> risklist) {
		this.risklist = risklist;
	}
	
	
	public String getRname() {
		return rname;
	}

	public void setRname(String rname) {
		this.rname = rname;
	}

	public String getRcontent() {
		return rcontent;
	}

	public void setRcontent(String rcontent) {
		this.rcontent = rcontent;
	}

	public String getRpos() {
		return rpos;
	}

	public void setRpos(String rpos) {
		this.rpos = rpos;
	}

	public String getReff() {
		return reff;
	}

	public void setReff(String reff) {
		this.reff = reff;
	}

	public String getRisk_trigger() {
		return risk_trigger;
	}

	public void setRisk_trigger(String risk_trigger) {
		this.risk_trigger = risk_trigger;
	}

	public String getRisk_committer() {
		return risk_committer;
	}

	public void setRisk_committer(String risk_committer) {
		this.risk_committer = risk_committer;
	}

	public String getRisk_tracker() {
		return risk_tracker;
	}

	public void setRisk_tracker(String risk_tracker) {
		this.risk_tracker = risk_tracker;
	}
	
	public int getSelectedriskid() {
		return selectedriskid;
	}

	public void setSelectedriskid(int selectedriskid) {
		this.selectedriskid = selectedriskid;
	}	
	
	
	
//
//	public int getSelectedprojectid() {
//		return selectedprojectid;
//	}
//
//	public void setSelectedprojectid(int selectedprojectid) {
//		this.selectedprojectid = selectedprojectid;
//	}

	public Date getHidStart() {
		return hidStart;
	}

	public void setHidStart(Date hidStart) {
		this.hidStart = hidStart;
	}

	public Date getHidEnd() {
		return hidEnd;
	}

	public void setHidEnd(Date hidEnd) {
		this.hidEnd = hidEnd;
	}

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
	

	public ArrayList<riskNum> getRecognized() {
		return recognized;
	}

	public void setRecognized(ArrayList<riskNum> recognized) {
		this.recognized = recognized;
	}

	public ArrayList<riskNum> getToProblem() {
		return toProblem;
	}

	public void setToProblem(ArrayList<riskNum> toProblem) {
		this.toProblem = toProblem;
	}


	public String getAllRisk(){
		ActionContext actionContext = ActionContext.getContext();			  
	    Map session = actionContext.getSession();  			  
	    String name=(String)session.get("username");		
		riskLogic r=new riskLogic();
		risklist=r.getAllRisk();
		setRiskList();		
		return "success";
		
	}
	
	
	private void setRiskList(){
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
	}

	public String addProjectRisk(){
		System.out.println("addrisk!");
		int rposvalue=3;
		int reffvalue=3;
		riskLogic rl=new riskLogic();
		
		if(rpos.equals("low")){
			rposvalue=1;
		}else if(rpos.equals("medium")){
			rposvalue=2;
		}else if(rpos.equals("high")){
			rposvalue=3;
		}
		
		if(reff.equals("low")){
			reffvalue=1;
		}else if(reff.equals("medium")){
			reffvalue=2;
		}else if(reff.equals("high")){
			reffvalue=3;
		}
		ActionContext actionContext = ActionContext.getContext();			  
	    Map session = actionContext.getSession();  			  
	    String userName=(String)session.get("username");	
		risk r=new risk(1,rname,rcontent,rposvalue,reffvalue,risk_trigger,userName,risk_tracker);
		
		java.sql.Date currentDate = new java.sql.Date(System.currentTimeMillis());
		r.setCreateTime(currentDate);
		
		int projectid=(Integer)session.get("projectid");
		
		int res=rl.addProjectRisk(r,projectid);		  
	    risklist=rl.getExistRisk(projectid);		
		setRiskList();
		return "success";
	}
	
	public String delProjectRisk(){
		ActionContext actionContext = ActionContext.getContext();			  
	    Map session = actionContext.getSession();  			  
	    int projectid=(Integer)session.get("projectid");
		
		riskLogic r=new riskLogic();
		int result=r.removeProjectRisk(selectedriskid, projectid);
		
		return "success";
	}
	
	public String riskSearch(){
		System.out.println(startTime);
		System.out.println(endTime);
		
		return "success";
	}
	
	public String forChart(){
		riskLogic r=new riskLogic();
		recognized=r.getSelectedRisk(startTime, endTime, 1);
		toProblem=r.getSelectedRisk(startTime, endTime, 2);
		return "success";
	}
}
