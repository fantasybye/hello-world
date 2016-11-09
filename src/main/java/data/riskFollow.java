package data;

public class riskFollow {
	private int id;
	private int riskId;
	private int followerId;
	private String description;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getRiskId() {
		return riskId;
	}
	public void setRiskId(int riskId) {
		this.riskId = riskId;
	}
	public int getFollowerId() {
		return followerId;
	}
	public void setFollowerId(int followerId) {
		this.followerId = followerId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
