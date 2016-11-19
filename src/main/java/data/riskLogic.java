package data;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.risk;
import model.riskNum;

public class riskLogic implements riskInterface{
	static String sql = null;  
    static ConnectMySQL db = null;  
    static ResultSet ret = null;
    
    public ArrayList<risk> getAllRisk(){
    	ArrayList<risk> result=new ArrayList<risk>();
		riskFollowLogic rf=new riskFollowLogic();
		
		sql="select * from risk";
		db=new ConnectMySQL(sql);
		
		try {  
            ret = db.pst.executeQuery();
            while (ret.next()) {  
            	risk r=rf.getLatestRiskInfo2(ret.getInt(1));
                result.add(r);
            } 
            ret.close();  
            db.close();
        } catch (SQLException e) {  
            e.printStackTrace();  
        } 
		return result;
    }

	public ArrayList<risk> getExistRisk(int projectId){
		ArrayList<risk> result=new ArrayList<risk>();
		riskFollowLogic rf=new riskFollowLogic();
		
		sql="select riskId from riskToProject where projectId="+projectId;
		db=new ConnectMySQL(sql);
		
		try {  
            ret = db.pst.executeQuery();
            while (ret.next()) {  
                risk r=rf.getLatestRiskInfo(ret.getInt(1), projectId);
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
		riskFollowLogic rf=new riskFollowLogic();
		
		sql="select * from risk where risk.id not in (select riskId from riskToProject where projectId="+projectId+")";
		db=new ConnectMySQL(sql);
		
		try {  
            ret = db.pst.executeQuery();
            while (ret.next()) {  
            	risk r=rf.getLatestRiskInfo2(ret.getInt(1));
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
		ArrayList<risk> result=new ArrayList<risk>();
		riskFollowLogic rf=new riskFollowLogic();
		if(type==0){
			sql="select distinct riskId from riskFollow where projectId<>"+projectId+" and createTime>"+beginTime+" and createTime<"+endTime;
			db=new ConnectMySQL(sql);
			
			try {  
	            ret = db.pst.executeQuery();
	            while (ret.next()) {  
	            	risk r=rf.getLatestRiskInfo2(ret.getInt(1));
	                result.add(r);
	            } 
	            ret.close();  
	            db.close();
	        } catch (SQLException e) {  
	            e.printStackTrace();  
	        } 
			return result;
		}else if(type==1){
			sql="select riskId,count(riskId) as c from riskToProject where projectId<>"+projectId+" and createTime>"+beginTime+" and createTime<"+endTime+" group by riskId order by c desc";
			db=new ConnectMySQL(sql);
			
			try {  
	            ret = db.pst.executeQuery();
	            while (ret.next()) {  
	            	risk r=rf.getLatestRiskInfo2(ret.getInt(1));
	                result.add(r);
	            } 
	            ret.close();  
	            db.close();
	        } catch (SQLException e) {  
	            e.printStackTrace();  
	        } 
			return result;
		}else if(type==2){
			sql="select riskId,count(riskId) as c from riskFollow where projectId<>"+projectId+" and createTime>"+beginTime+" and createTime<"+endTime+" and problem=1 group by riskId order by c desc";
			db=new ConnectMySQL(sql);
			
			try {  
	            ret = db.pst.executeQuery();
	            while (ret.next()) {  
	            	risk r=rf.getLatestRiskInfo2(ret.getInt(1));
	                result.add(r);
	            } 
	            ret.close();  
	            db.close();
	        } catch (SQLException e) {  
	            e.printStackTrace();  
	        } 
			return result;
		}
		return null;
	}
	
	public ArrayList<riskNum> getSelectedRisk(Date beginTime,Date endTime,int type){
		ArrayList<riskNum> result=new ArrayList<riskNum>();
		riskLogic r=new riskLogic();
		if(type==1){
			sql="select riskId,count(riskId) as c from riskToProject where createTime>"+beginTime+" and createTime<"+endTime+" group by riskId order by c desc";
			db=new ConnectMySQL(sql);
			
			try {  
	            ret = db.pst.executeQuery();
	            while (ret.next()) {  
	            	riskNum rn=new riskNum();
	            	rn.setRiskName(r.getRiskNameById(ret.getInt(1)));
	            	rn.setNum(ret.getInt(2));
	                result.add(rn);
	            } 
	            ret.close();  
	            db.close();
	        } catch (SQLException e) {  
	            e.printStackTrace();  
	        } 
			return result;
		}else if(type==2){
			sql="select riskId,count(riskId) as c from riskFollow where createTime>"+beginTime+" and createTime<"+endTime+" and problem=1 group by riskId order by c desc";
			db=new ConnectMySQL(sql);
			
			try {  
	            ret = db.pst.executeQuery();
	            while (ret.next()) {  
	            	riskNum rn=new riskNum();
	            	rn.setRiskName(r.getRiskNameById(ret.getInt(1)));
	            	rn.setNum(ret.getInt(2));
	                result.add(rn);
	            } 
	            ret.close();  
	            db.close();
	        } catch (SQLException e) {  
	            e.printStackTrace();  
	        } 
			return result;
		}
		return null;
	}
	
	public int addProjectRisk(risk r,int projectId){
		userLogic u=new userLogic();
		riskLogic rl=new riskLogic();
		sql="insert into risk (riskName,riskContent,createTime,creatorId) values (?,?,?,?)";
		db=new ConnectMySQL(sql);
		try {
	        db.pst.setString(1, r.getRiskName());
	        db.pst.setString(2, r.getRiskContent());
	        db.pst.setDate(3, r.getCreateTime());
	        db.pst.setInt(4, u.getUserIdByName(r.getCreatorName()));
	        db.pst.executeUpdate();
	        db.close();
	    } catch (SQLException e) {
	    	e.printStackTrace(); 
	    }
		sql="insert into riskToProject (projectId,riskId,putInTime) values (?,?,?)";
		db=new ConnectMySQL(sql);
		try {
	        db.pst.setInt(1, projectId);
	        db.pst.setInt(2, rl.getRiskIdByName(r.getRiskName()));
	        db.pst.setDate(3, r.getCreateTime());
	        db.pst.executeUpdate();
	        db.close();
	    } catch (SQLException e) {
	    	e.printStackTrace(); 
	    }
		sql="insert into riskFollow (projectId,riskId,followerId,createTime,riskPossibility,riskEfficiency,riskTrigger,problem) values (?,?,?,?,?,?,?,?)";
		db=new ConnectMySQL(sql);
		try {
	        db.pst.setInt(1, projectId);
	        db.pst.setInt(2, rl.getRiskIdByName(r.getRiskName()));
	        db.pst.setInt(3, u.getUserIdByName(r.getFollower()));
	        db.pst.setDate(4, r.getCreateTime());
	        db.pst.setInt(5, r.getRiskPossibility());
	        db.pst.setInt(6, r.getRiskEfficiency());
	        db.pst.setString(7, r.getRiskTrigger());
	        db.pst.setInt(8, 0);
	        db.pst.executeUpdate();
	        db.close();
	    } catch (SQLException e) {
	    	e.printStackTrace(); 
	    }
		return 0;
	}
	
	public int removeProjectRisk(int riskId,int projectId){
		sql="delete from riskToProject where riskId=" +riskId+ " and projectId="+projectId;
		db=new ConnectMySQL(sql);
		try {
	        db.pst.executeUpdate();
	        db.close();
	    } catch (SQLException e) {
	    	e.printStackTrace(); 
	    }
		return 0;
	}
		
	public int putInRisk(ArrayList<Integer> r,int projectId,Date time){
		for(int i=0;i<r.size();i++){
			sql="insert into riskToProject (projectId,riskId,putInTime) values (?,?,?)";
			db=new ConnectMySQL(sql);
			try {
		        db.pst.setInt(1, projectId);
		        db.pst.setInt(2, r.get(i));
		        db.pst.setDate(3, time);
		        db.pst.executeUpdate();
		        db.close();
		    } catch (SQLException e) {
		    	e.printStackTrace(); 
		    }
		}
		return 0;
	}
	
	public String getRiskNameById(int id){
		String result="";
		String sql="select * from risk where id="+id;
		ConnectMySQL db=new ConnectMySQL(sql);
		
		try {  
			ResultSet ret = db.pst.executeQuery();
            while (ret.next()) {  
                result=ret.getString("riskName");
            } 
            ret.close();  
            db.close();
        } catch (SQLException e) {  
            e.printStackTrace();  
        } 
		return result;
	}//根据riskId获得risk名
	
	public int getRiskIdByName(String name){
		int result=-1;
		String sql="select * from risk where riskName='"+name+"'";
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
	}//根据risk名获得riskId
}
