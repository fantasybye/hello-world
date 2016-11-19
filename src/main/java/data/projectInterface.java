package data;

import java.util.ArrayList;

import model.project;

public interface projectInterface {
	public int addProject(String projectName,String creatorName);//添加风险管理计划
	public int deleteProject(int projectId);//删除风险管理计划
	public int modifyProject(project p);//修改风险管理计划
	public ArrayList<project> getAllProject(String creatorName);//获得用户所有风险管理计划
}
