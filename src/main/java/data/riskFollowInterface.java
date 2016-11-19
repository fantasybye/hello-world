package data;

import java.util.ArrayList;

import model.riskFollow;

public interface riskFollowInterface {
	public ArrayList<riskFollow> getRiskFollow(int projectId,int riskid);
	public int modifyRiskFollow(riskFollow r);//
	public int deleteRiskFollow(int riskFollowId);//
}
