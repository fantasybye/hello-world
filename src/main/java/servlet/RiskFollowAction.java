package servlet;

import java.util.ArrayList;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import data.riskFollowLogic;
import data.riskLogic;
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
	private String risktrigger;
	private String rpos;
	private String reff;
	private String ishap;
	private String description;
	
	private risk risk;
	
	private ArrayList<riskFollow> riskfollowlist;
	
	public risk getRisk() {
		return risk;
	}
	public void setRiskfollow(risk risk) {
		this.risk = risk;
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
	
	public String getRisktrigger() {
		return risktrigger;
	}
	public void setRisktrigger(String risktrigger) {
		this.risktrigger = risktrigger;
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
	public String getIshap() {
		return ishap;
	}
	public void setIshap(String ishap) {
		this.ishap = ishap;
	}
	public ArrayList<riskFollow> getRiskfollowlist() {
		return riskfollowlist;
	}
	public void setRiskfollowlist(ArrayList<riskFollow> riskfollowlist) {
		this.riskfollowlist = riskfollowlist;
	}
	
	
	public String getRiskFollow(){
		ActionContext actionContext = ActionContext.getContext();			  
	    Map session = actionContext.getSession();  			  
	    int projectid=(Integer)session.get("projectid");	
		
		riskFollowLogic rf=new riskFollowLogic();
		if(selectedriskid>0){
			risk=rf.getLatestRiskInfo2(selectedriskid);
			riskfollowlist=rf.getRiskFollow(projectid,selectedriskid);
			session.put("riskid",selectedriskid);
		}else{
			int riskid=(Integer)session.get("riskid");
			risk=rf.getLatestRiskInfo2(riskid);
			riskfollowlist=rf.getRiskFollow(projectid,riskid);
		}
		return "success";
	}
	
	public String addRiskFollow(){
		ActionContext actionContext = ActionContext.getContext();			  
	    Map session = actionContext.getSession();  			  
	    int projectid=(Integer)session.get("projectid");
	    String creatorName=(String)session.get("username");
	    
	    riskFollow riskfollow=new riskFollow();
	    riskfollow.setCreateTime(new java.sql.Date(System.currentTimeMillis()));
	    riskfollow.setDescription(description);
		riskfollow.setFollower(creatorName);
		if(ishap.equals("ishappneed")){
			riskfollow.setProblem(true);
		}else if(ishap.equals("nothappened")){
			riskfollow.setProblem(false);
		}
		riskfollow.setProjectId(projectid);
		if(rpos.equals("low")){
			riskfollow.setRiskPossibility(1);
		}else if(rpos.equals("medium")){
			riskfollow.setRiskPossibility(2);
		}else if(rpos.equals("high")){
			riskfollow.setRiskPossibility(3);
		}
		
		if(reff.equals("low")){
			riskfollow.setRiskEfficiency(1);
		}else if(reff.equals("medium")){
			riskfollow.setRiskEfficiency(2);
		}else if(reff.equals("high")){
			riskfollow.setRiskEfficiency(3);
		}
		
		riskfollow.setRiskName(riskname);
		riskfollow.setRiskTrigger(risktrigger);
	    
		riskFollowLogic rf=new riskFollowLogic();
		int result=rf.addRiskFollow(riskfollow);
		return "success";
	}
	
//	public String modifyRiskFollow(){
//		
//		System.out.println("modify");
//
//		handle h=new handle();
//		riskFollow r=new riskFollow();
//		r.setId(riskfollow_id);
//		//System.out.println(riskfollow_id);
//		r.setRiskName(riskname);
//		//System.out.println(riskname);
//		r.setRiskContent(riskcontent);
//		r.setDescription(description);
//		r.setFollower(riskfollow_follower);
//		boolean result=h.modifyRiskFollow(r);
//		if(result==true){
//			System.out.println("success");
//			return "success";
//		}else{
//			return "fail";
//		}
//	}
	
}
