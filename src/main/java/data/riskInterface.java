package data;

import java.sql.Date;
import java.util.ArrayList;

import model.risk;

public interface riskInterface {
	public ArrayList<risk> getExistRisk(int projectId);//获得已有风险
	public ArrayList<risk> getNotExistRisk(int projectId);//获得未有风险
	
	public ArrayList<risk> getSelectedProjectRisk(Date beginTime,Date endTime,int projectId,int type);//导入风险时，选择，
	
	public ArrayList<risk> getSelectedRisk(Date beginTime,Date endTime,int type);//绘制图表时
	
	public int addProjectRisk(risk r);
	public int removeProjectRisk(int riskId);
	public int modifyProjectRisk(risk r);
	
	public int putInRisk(ArrayList<Integer> r,int projectId);//根据riskId向计划中导入风险
	
}
