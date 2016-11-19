package model;

import java.sql.Date;

public class riskFollow {
	private int id;
	private int projectId;
	private String riskName;
	private String riskContent;
	private String follower;
	private String description;
	private Date createTime;
	private int riskPossibility;
	private int riskEfficiency;
	private String riskTrigger;
	private boolean problem;
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
	public String getFollower() {
		return follower;
	}
	public void setFollower(String follower) {
		this.follower = follower;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
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
	public boolean isProblem() {
		return problem;
	}
	public void setProblem(boolean problem) {
		this.problem = problem;
	}
	public int getProjectId() {
		return projectId;
	}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}
