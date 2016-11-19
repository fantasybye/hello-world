package data;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.risk;

public class riskFollowLogic {
	static String sql = null;  
    static ConnectMySQL db = null;  
    static ResultSet ret = null;
    
	public risk getLatestRiskInfo(int riskId,int projectId){
		risk r=new risk();
		userLogic u=new userLogic();
		
		sql="select * from risk where id="+riskId;
		db=new ConnectMySQL(sql);
		
		try {  
            ret = db.pst.executeQuery();
            while (ret.next()) {  
                r.setId(ret.getInt(1)); 
                r.setRiskName(ret.getString(2));
                r.setRiskContent(ret.getString(3));
                r.setCreateTime(ret.getDate(4));
                r.setCreatorName(u.getUserNameById(ret.getInt(5)));
            } 
            ret.close();  
            db.close();
        } catch (SQLException e) {  
            e.printStackTrace();  
        } 
		
		sql="select * from riskFollow where riskId="+riskId+" and projectId="+projectId+" order by createTime desc limit 1";
		db=new ConnectMySQL(sql);
		
		try {  
            ret = db.pst.executeQuery();
            while (ret.next()) {  
            	r.setFollower(u.getUserNameById(ret.getInt(4)));
                r.setRiskPossibility(ret.getInt(7));
                r.setRiskEfficiency(ret.getInt(8));
                r.setRiskTrigger(ret.getString(9));
            } 
            ret.close();  
            db.close();
        } catch (SQLException e) {  
            e.printStackTrace();  
        } 
		
		return r;
	}
	
	public risk getLatestRiskInfo2(int riskId){
		risk r=new risk();
		userLogic u=new userLogic();
		
		sql="select * from risk where id="+riskId;
		db=new ConnectMySQL(sql);
		
		try {  
            ret = db.pst.executeQuery();
            while (ret.next()) {  
                r.setId(ret.getInt(1)); 
                r.setRiskName(ret.getString(2));
                r.setRiskContent(ret.getString(3));
                r.setCreateTime(ret.getDate(4));
                r.setCreatorName(u.getUserNameById(ret.getInt(5)));
            } 
            ret.close();  
            db.close();
        } catch (SQLException e) {  
            e.printStackTrace();  
        } 
		
		sql="select * from riskFollow where riskId="+riskId+" order by createTime desc limit 1";
		db=new ConnectMySQL(sql);
		
		try {  
            ret = db.pst.executeQuery();
            while (ret.next()) {  
            	r.setFollower(u.getUserNameById(ret.getInt(4)));
                r.setRiskPossibility(ret.getInt(7));
                r.setRiskEfficiency(ret.getInt(8));
                r.setRiskTrigger(ret.getString(9));
            } 
            ret.close();  
            db.close();
        } catch (SQLException e) {  
            e.printStackTrace();  
        } 
		
		return r;
	}
}
