package data;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.risk;

public class riskLogic implements riskInterface{
	static String sql = null;  
    static ConnectMySQL db = null;  
    static ResultSet ret = null;

	public ArrayList<risk> getExistRisk(int projectId){
		ArrayList<risk> result=new ArrayList<risk>();
		userLogic u=new userLogic();
		
		sql="select * from risk where risk.id in (select riskId from riskToProject where projectId="+projectId+")";
		db=new ConnectMySQL(sql);
		
		try {  
            ret = db.pst.executeQuery();
            while (ret.next()) {  
                risk r=new risk();
                r.setId(ret.getInt(1)); 
                r.setRiskName(ret.getString(2));
                r.setRiskContent(ret.getString(3));
                r.setCreateTime(ret.getDate(4));
                r.setCreatorName(u.getUserNameById(ret.getInt(5)));
                result.add(r);
            } 
            ret.close();  
            db.close();
        } catch (SQLException e) {  
            e.printStackTrace();  
        } 
		
		return result;
	}
	
	public ArrayList<risk> getNotExistRisk(int projectId){
		ArrayList<risk> result=new ArrayList<risk>();
		userLogic u=new userLogic();
		
		sql="select * from risk where risk.id not in (select riskId from riskToProject where projectId="+projectId+")";
		db=new ConnectMySQL(sql);
		
		try {  
            ret = db.pst.executeQuery();
            while (ret.next()) {  
                risk r=new risk();
                r.setId(ret.getInt(1)); 
                r.setRiskName(ret.getString(2));
                r.setRiskContent(ret.getString(3));
                r.setCreateTime(ret.getDate(4));
                r.setCreatorName(u.getUserNameById(ret.getInt(5)));
                result.add(r);
            } 
            ret.close();  
            db.close();
        } catch (SQLException e) {  
            e.printStackTrace();  
        } 
		return result;
	}
	
	public ArrayList<risk> getSelectedProjectRisk(Date beginTime,Date endTime,int projectId,int type){
		if(type==0){
			
		}else if(type==1){
			
		}else if(type==2){
			
		}
		return null;
	}
	
	public ArrayList<risk> getSelectedRisk(Date beginTime,Date endTime,int type){
		return null;
	}
	
	public int addProjectRisk(risk r){
		return 0;
	}
	
	public int removeProjectRisk(int riskId){
		return 0;
	}
	
	public int modifyProjectRisk(risk r){
		return 0;
	}
	
	
	public int putInRisk(ArrayList<Integer> r,int projectId){
		return 0;
	}
}
