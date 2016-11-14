package servlet;

import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;

import data.handle;
import model.risk;

public class RiskAction extends ActionSupport{
	private ArrayList<risk> risklist;
	
	private String rname;
	private String rcontent;
	private String rpos;
	private String reff;
	private String risk_trigger;
	private String risk_committer;
	private String risk_tracker;
	
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

	public String getAllRisk(){
		handle h=new handle();
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
		
	}

	public String addRisk(){
		System.out.println("addrisk!");
		int rposvalue=3;
		int reffvalue=3;
		boolean result=false;
		handle h=new handle();
		
		if(rpos.equals("low")){
			rposvalue=1;
		}else if(rpos.equals("medium")){
			rposvalue=2;
		}else if(rpos.equals("hign")){
			rposvalue=3;
		}
		
		if(reff.equals("low")){
			reffvalue=1;
		}else if(reff.equals("medium")){
			reffvalue=2;
		}else if(reff.equals("hign")){
			reffvalue=3;
		}
		System.out.println(rname);
		risk r=new risk(1,rname,rcontent,rposvalue,reffvalue,risk_trigger,risk_committer,risk_tracker);
		result=h.addRisk(r);
		if(result){
			getAllRisk();
			return "success";
		}
		else{
			return "failure";
		}
	}
}
