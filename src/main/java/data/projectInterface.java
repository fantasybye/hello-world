package data;

import java.util.ArrayList;

import model.project;

public interface projectInterface {
	public int addProject(String projectName,String creatorName);//添加风险管理计划
	public int deleteProject(int projectId);//删除风险管理计划
	public int modifyProject(project p);
	public ArrayList<project> getAllProject(String creatorName);
}
