package data;

import java.util.ArrayList;

import model.risk;

public interface riskInterface {
	public risk getOneRisk(int riskid);
	
	public ArrayList<risk> getExistRisk(int projectId);
	public ArrayList<risk> getNotExistRisk(int projectId);
	
	public ArrayList<risk> getSelectedProjectRisk(String beginTime,String endTime,int projectId,int type);
	public ArrayList<risk> getSelectedRisk(String beginTime,String endTime,int type);
	
	public int addProjectRisk(risk r);
	public int removeProjectRisk(int riskId);
	public int modifyProjectRisk(risk r);
	
	public int putInRisk(ArrayList<Integer> r);
	
}
