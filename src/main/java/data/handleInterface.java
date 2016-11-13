package data;

import java.util.ArrayList;

import model.risk;
import model.riskFollow;

public interface handleInterface {
	public ArrayList<risk> getAllRisk();//获得所有risk
	public ArrayList<risk> getSingleRisk(String s);//获得关键字risk
	public boolean modifyRisk(risk r);//修改risk
	public boolean addRisk(risk r);//添加risk
	public boolean deleteRisk(int riskId);//删除risk
	
	public ArrayList<riskFollow> getAllRiskFollow();//获得所有riskFollow
	public ArrayList<riskFollow> getSingleRiskFollow(String s);//获得关键字riskFollow
	public boolean modifyRiskFollow(riskFollow r);//修改riskFollow
	public boolean addRiskFollow(riskFollow r);//添加riskFollow
	public boolean deleteRiskFollow(int riskFollowId);//删除riskFollow
	
	public int judgeLogin(String userName,String pwd);//登录验证，0成功，1用户名错，2密码错,-1失败
	public int addUser(String name,String psw,boolean is);//添加用户，0成功，1用户名已存在，2密码过短，-1失败

	public risk getOneRisk(int riskid);
	public ArrayList<riskFollow> getRiskFollow(int riskid);
}
