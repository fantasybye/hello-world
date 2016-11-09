package data;

public class risk {
	private int id;
	private String riskName;
	private String riskContent;
	private int riskPossibility;
	private int riskEfficiency;
	private String riskTrigger;
	private int creatorId;
	private int riskFollower;
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
	public int getCreatorId() {
		return creatorId;
	}
	public void setCreatorId(int creatorId) {
		this.creatorId = creatorId;
	}
	public int getRiskFollower() {
		return riskFollower;
	}
	public void setRiskFollower(int riskFollower) {
		this.riskFollower = riskFollower;
	}

}
