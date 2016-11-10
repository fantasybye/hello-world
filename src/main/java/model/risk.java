package model;

public class risk {
	private int id;
	private String riskName;
	private String riskContent;
	private int riskPossibility;
	private int riskEfficiency;
	private String riskTrigger;
	private String creatorName;
	private String follower;
	
	public risk(){
		
	}
	public risk(int id, String riskName, String riskContent, int riskPossibility, int riskEfficiency,
			String riskTrigger, String creatorName, String follower) {
		super();
		this.id = id;
		this.riskName = riskName;
		this.riskContent = riskContent;
		this.riskPossibility = riskPossibility;
		this.riskEfficiency = riskEfficiency;
		this.riskTrigger = riskTrigger;
		this.creatorName = creatorName;
		this.follower = follower;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getCreatorName() {
		return creatorName;
	}
	public void setCreatorName(String creatorName) {
		this.creatorName = creatorName;
	}
	public String getFollower() {
		return follower;
	}
	public void setFollower(String follower) {
		this.follower = follower;
	}

}
