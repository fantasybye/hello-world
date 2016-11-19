package data;

import java.sql.Date;
import java.util.ArrayList;

import model.risk;
import model.riskNum;

public interface riskInterface {
	public ArrayList<risk> getAllRisk();//获得所有风险
	public ArrayList<risk> getExistRisk(int projectId);//获得已有风险
	public ArrayList<risk> getNotExistRisk(int projectId);//获得未有风险
	
	public ArrayList<risk> getSelectedProjectRisk(Date beginTime,Date endTime,int projectId,int type);//导入风险时，选择，
	
	public ArrayList<riskNum> getSelectedRisk(Date beginTime,Date endTime,int type);//绘制图表时
	
	public int addProjectRisk(risk r,int projectId);//添加新的风险
	public int removeProjectRisk(int riskId,int projectId);//移除项目风险
	
	public int putInRisk(ArrayList<Integer> r,int projectId,Date time);//根据riskId向计划中导入风险
	
}
