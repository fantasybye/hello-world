package data;

import java.util.ArrayList;

import model.riskFollow;

public interface riskFollowInterface {
	public ArrayList<riskFollow> getRiskFollow(int projectId,int riskId);//
	public int addRiskFollow(riskFollow f);//
	public int deleteRiskFollow(int riskFollowId);//
}
