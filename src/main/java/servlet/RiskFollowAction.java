package servlet;

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
	
	
	public String getRiskFollow(){
		System.out.println("riskfollow!");
		handle h=new handle();
		risk ri=h.getOneRisk(selectedriskid);
		riskfollow=h.getRiskFollow(selectedriskid).get(0);
		riskfollow.setRiskContent(ri.getRiskContent());
		System.out.println(riskfollow.getRiskContent());
		return "success";
	}
	
	public String modifyRiskFollow(){
		handle h=new handle();
		riskFollow r=new riskFollow();
		r.setId(riskfollow.getId());
		r.setRiskName(riskname);
		r.setRiskContent(riskcontent);
		r.setDescription(description);
		r.setFollower(riskfollow.getFollower());
		boolean result=h.modifyRiskFollow(r);
		if(result==true){
			return "success";
		}else{
			return "fail";
		}
	}
	
}
