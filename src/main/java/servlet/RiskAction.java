package servlet;

import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;

import data.handle;
import model.risk;

public class RiskAction extends ActionSupport{
	private ArrayList<risk> risklist;
	
	private String creatorName;
	private String riskName;
	private String riskContent;
	private int riskPossibility;
	private int riskEfficiency;
	private String riskTrigger;
	private String riskFollower;	
	
	public ArrayList<risk> getRisklist() {
		return risklist;
	}

	public void setRisklist(ArrayList<risk> risklist) {
		this.risklist = risklist;
	}

	public String getCreatorName() {
		return creatorName;
	}

	public void setCreatorName(String creatorName) {
		this.creatorName = creatorName;
	}

	public String getRiskName() {
		return riskName;
	}

	public void setRiskName(String riskName) {
		this.riskName = riskName;
	}

	public String getRiskContent() {
		return riskContent;
	}

	public void setRiskContent(String riskContent) {
		this.riskContent = riskContent;
	}

	public int getRiskPossibility() {
		return riskPossibility;
	}

	public void setRiskPossibility(int riskPossibility) {
		this.riskPossibility = riskPossibility;
	}

	public int getRiskEfficiency() {
		return riskEfficiency;
	}

	public void setRiskEfficiency(int riskEfficiency) {
		this.riskEfficiency = riskEfficiency;
	}

	public String getRiskTrigger() {
		return riskTrigger;
	}

	public void setRiskTrigger(String riskTrigger) {
		this.riskTrigger = riskTrigger;
	}
	
	public String getRiskFollower() {
		return riskFollower;
	}

	public void setRiskFollower(String riskFollower) {
		this.riskFollower = riskFollower;
	}
	
	
	

	public String addRisk(){
		risk r=new risk();
		r.setCreatorName(creatorName);
		return "success";
	}
}
