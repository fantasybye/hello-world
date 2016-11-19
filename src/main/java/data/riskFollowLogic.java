package data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.risk;
import model.riskFollow;

public class riskFollowLogic implements riskFollowInterface{
	static String sql = null;  
    static ConnectMySQL db = null;  
    static ResultSet ret = null;
    
    public ArrayList<riskFollow> getRiskFollow(int projectId,int riskId){
    	ArrayList<riskFollow> result=new ArrayList<riskFollow>();
		userLogic u=new userLogic();
		riskLogic rl=new riskLogic();
    	
		sql="select * from riskFollow where projectId="+projectId+" and riskId="+riskId;
		db=new ConnectMySQL(sql);
		try {  
            ret = db.pst.executeQuery();
            while (ret.next()) {  
                riskFollow r=new riskFollow();
                r.setId(ret.getInt(1)); 
                r.setProjectId(ret.getInt(2));
                r.setRiskName(rl.getRiskNameById(ret.getInt(3)));
                r.setFollower(u.getUserNameById(ret.getInt(4)));
                r.setDescription(ret.getString(5));
                r.setCreateTime(ret.getDate(6));
                r.setRiskPossibility(ret.getInt(7));
                r.setRiskEfficiency(ret.getInt(8));
                r.setRiskTrigger(ret.getString(9));
                r.setProblem(ret.getBoolean(10));
                result.add(r);
            } 
            ret.close();  
            db.close();
        } catch (SQLException e) {  
            e.printStackTrace();  
        } 
		return result;  	
    }
    
    public int addRiskFollow(riskFollow f){
    	userLogic u=new userLogic();
		riskLogic rl=new riskLogic();
    	sql="insert into riskFollow (projectId,riskId,followerId,description,createTime,riskPossibility,riskEfficiency,riskTrigger,problem) values(?,?,?,?,?,?,?,?,?)";
		db=new ConnectMySQL(sql);
		try {
	        db.pst.setInt(1, f.getProjectId());
	        db.pst.setInt(2, rl.getRiskIdByName(f.getRiskName()));
	        db.pst.setInt(3, u.getUserIdByName(f.getFollower()));
	        db.pst.setString(4, f.getDescription());
	        db.pst.setDate(5, f.getCreateTime());
	        db.pst.setInt(6, f.getRiskPossibility());
	        db.pst.setInt(7, f.getRiskEfficiency());
	        db.pst.setString(8, f.getRiskTrigger());
	        db.pst.setBoolean(9, f.isProblem());
	        db.pst.executeUpdate();
	        db.close();
	    } catch (SQLException e) {
	    	e.printStackTrace();
	    }
    	return 0;
    }
    
	public int deleteRiskFollow(int riskFollowId){
		sql="delete from riskFollow where id='" +riskFollowId+ "'";
		db=new ConnectMySQL(sql);
		try {
	        db.pst.executeUpdate();
	        db.close();
	    } catch (SQLException e) {
	    	e.printStackTrace();
	    }
		return 0;
	}
    
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
