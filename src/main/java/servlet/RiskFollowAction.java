package servlet;

import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;

import data.handle;
import model.risk;
import model.riskFollow;

public class RiskFollowAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int selectedriskid;
	
	private String riskname;
	private String riskcontent;
	private String description;
	private int riskfollow_id;
	private String riskfollow_follower;
	
	private riskFollow riskfollow;
	
	public riskFollow getRiskfollow() {
		return riskfollow;
	}
	public void setRiskfollow(riskFollow riskfollow) {
		this.riskfollow = riskfollow;
	}
	public int getSelectedriskid() {
		return selectedriskid;
	}
	public void setSelectedriskid(int selectedriskid) {
		this.selectedriskid = selectedriskid;
	}
	
	public String getRiskname() {
		return riskname;
	}
	public void setRiskname(String riskname) {
		this.riskname = riskname;
	}
	public String getRiskcontent() {
		return riskcontent;
	}
	public void setRiskcontent(String riskcontent) {
		this.riskcontent = riskcontent;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	public int getRiskfollow_id() {
		return riskfollow_id;
	}
	public void setRiskfollow_id(int riskfollow_id) {
		this.riskfollow_id = riskfollow_id;
	}
	
	public String getRiskfollow_follower() {
		return riskfollow_follower;
	}
	public void setRiskfollow_follower(String riskfollow_follower) {
		this.riskfollow_follower = riskfollow_follower;
	}
	
	public String getRiskFollow(){
		System.out.println("riskfollow!");
		handle h=new handle();
		risk ri=h.getOneRisk(selectedriskid);
		ArrayList <riskFollow>result=h.getRiskFollow(selectedriskid);
		if(result.size()==0){
			return "fail";
		}
		else{
			riskfollow=h.getRiskFollow(selectedriskid).get(0);
			riskfollow.setRiskContent(ri.getRiskContent());
			return "success";
		}
	}
	
	public String modifyRiskFollow(){
		
		System.out.println("modify");

		handle h=new handle();
		riskFollow r=new riskFollow();
		r.setId(riskfollow_id);
		//System.out.println(riskfollow_id);
		r.setRiskName(riskname);
		//System.out.println(riskname);
		r.setRiskContent(riskcontent);
		r.setDescription(description);
		r.setFollower(riskfollow_follower);
		boolean result=h.modifyRiskFollow(r);
		if(result==true){
			System.out.println("success");
			return "success";
		}else{
			return "fail";
		}
	}
	
}
