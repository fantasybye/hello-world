package data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.project;

public class projectLogic implements projectInterface{
	static String sql = null;  
    static ConnectMySQL db = null;  
    static ResultSet ret = null;
    
    public int addProject(String projectName,String creatorName){
    	sql="insert into project (projectName,creatorId) values(?,?)";
		db=new ConnectMySQL(sql);
		
		projectLogic p=new projectLogic();
		try {  
			db.pst.setString(1, projectName);
	        db.pst.setInt(2, p.getUserId(creatorName));
	        db.pst.executeUpdate();
	        db.close();
        } catch (SQLException e) {  
        	e.printStackTrace(); 
        }
		return 0;
    }//添加风险管理计划
    
	public int deleteProject(int projectId){
		sql="delete from project where id='" +projectId+ "'";
		db=new ConnectMySQL(sql);
		try {
	        db.pst.executeUpdate();
	        db.close();
	    } catch (SQLException e) {
	    	e.printStackTrace(); 
	    }
		return 0;
	}//删除风险管理计划
	
	public int modifyProject(project p){
		return 0;
	}
	
	public ArrayList<project> getAllProject(int creatorId){
		return null;
	}
	
	private int getUserId(String name){
		int result=-1;
		String sql="select * from user where user.userName='"+name+"'";
		ConnectMySQL db=new ConnectMySQL(sql);
		
		try {  
			ResultSet ret = db.pst.executeQuery();
            while (ret.next()) {  
                result=ret.getInt("id");
            } 
            ret.close();  
            db.close();
        } catch (SQLException e) {  
            e.printStackTrace();  
        } 
		return result;
	}//根据用户名获得用户Id
}
