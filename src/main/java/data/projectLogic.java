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
		
		userLogic u=new userLogic();
		try {  
			db.pst.setString(1, projectName);
	        db.pst.setInt(2, u.getUserIdByName(creatorName));
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
		sql="update project set projectName="+p.getProjectName()+"' where id="+p.getId();
		db=new ConnectMySQL(sql);
		try {
	        db.pst.executeUpdate();
            db.close();
	    } catch (SQLException e) {
	    	e.printStackTrace();
	    }
		return 0;
	}//修改风险管理计划
	
	public ArrayList<project> getAllProject(String creatorName){
		ArrayList<project> result=new ArrayList<project>();
		userLogic u=new userLogic();
		
		sql="select * from project where creatorId="+u.getUserIdByName(creatorName);
		db=new ConnectMySQL(sql);
		try {  
            ret = db.pst.executeQuery();
            while (ret.next()) {  
                project p=new project();
                p.setId(ret.getInt(1));
                p.setProjectName(ret.getString(2));
                p.setCreatorName(ret.getString(3));
                result.add(p);
            } 
            ret.close();  
            db.close();
        } catch (SQLException e) {  
            e.printStackTrace();  
        } 
		return result;
	}//获得用户所有风险管理计划

}
