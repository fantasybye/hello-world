package data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.risk;
import model.riskFollow;

public class handle implements haddleInterface{
	
	static String sql = null;  
    static ConnectMySQL db = null;  
    static ResultSet ret = null;
    
	public ArrayList<risk> getAllRisk(){
		ArrayList<risk> result=new ArrayList<risk>();
		
		sql="select * from risk";
		db=new ConnectMySQL(sql);
		
		handle h=new handle();
		try {  
            ret = db.pst.executeQuery();//执行语句，得到结果集  
            while (ret.next()) {  
                risk r=new risk();
                r.setId(ret.getInt(1)); 
                r.setRiskName(ret.getString(2));
                r.setRiskContent(ret.getString(3));
                r.setRiskPossibility(ret.getInt(4));
                r.setRiskEfficiency(ret.getInt(5));
                r.setRiskTrigger(ret.getString(6));
                r.setCreatorName(h.getName(ret.getInt(7)));
                r.setFollower(h.getName(ret.getInt(8)));
                result.add(r);
            } 
            ret.close();  
            db.close();//关闭连接  
        } catch (SQLException e) {  
            e.printStackTrace();  
        } 
		return result;
	}//获得所有risk
	
	public ArrayList<risk> getSingleRisk(String s){
		ArrayList<risk> result=new ArrayList<risk>();
		
		sql="select * from risk when id LIKE '%"+s+"%' or riskName LIKE '%"+s+"%' or riskContent LIKE '%"+s+"%'"
				+ " or riskPossibility LIKE '%"+s+"%' or riskEfficiency LIKE '%"+s+"%' or riskTrigger LIKE '%"+s+"%'"
				+ " or creatorId LIKE '%"+s+"%' or riskFollower LIKE '%"+s+"%'";
		db=new ConnectMySQL(sql);
		
		handle h=new handle();
		try {  
            ret = db.pst.executeQuery();//执行语句，得到结果集  
            while (ret.next()) {  
                risk r=new risk();
                r.setId(ret.getInt(1)); 
                r.setRiskName(ret.getString(2));
                r.setRiskContent(ret.getString(3));
                r.setRiskPossibility(ret.getInt(4));
                r.setRiskEfficiency(ret.getInt(5));
                r.setRiskTrigger(ret.getString(6));
                r.setCreatorName(h.getName(ret.getInt(7)));
                r.setFollower(h.getName(ret.getInt(8)));
                result.add(r);
            } 
            ret.close();  
            db.close();//关闭连接  
        } catch (SQLException e) {  
            e.printStackTrace();  
        } 
		return result;
	}//获得单个risk
	
	public boolean modifyRisk(risk r){
		handle h=new handle();
		int id=r.getId();
		
		sql="update risk set riskName= "+r.getRiskName()+",riskContent= "+r.getRiskContent()+",riskPossibility= "
				+r.getRiskPossibility()+",riskEfficiency= "+r.getRiskEfficiency()+",riskTrigger= "+r.getRiskTrigger()
				+",creatorId= "+h.getId(r.getCreatorName())+",riskFollower= "+h.getId(r.getFollower())+"when id="+id;
		db=new ConnectMySQL(sql);
		try {
	        db.pst.executeUpdate();
            db.close();//关闭连接 
	    } catch (SQLException e) {
	        return false;
	    }
		return true;
	}//修改单个risk
	
	public boolean addRisk(risk r){
		handle h=new handle();
		sql="insert into risk (riskName,riskContent,riskPossibility,riskEfficiency,riskTrigger,creatorId,riskFollower) values(?,?,?,?,?,?,?)";
		db=new ConnectMySQL(sql);
		try {
	        db.pst.setString(1, r.getRiskName());
	        db.pst.setString(2, r.getRiskContent());
	        db.pst.setInt(3, r.getRiskPossibility());
	        db.pst.setInt(4, r.getRiskEfficiency());
	        db.pst.setString(5, r.getRiskTrigger());
	        db.pst.setInt(6, h.getId(r.getCreatorName()));
	        db.pst.setInt(7, h.getId(r.getFollower()));
	        db.pst.executeUpdate();
	        db.close();//关闭连接
	    } catch (SQLException e) {
	        return false;
	    }
		return true;
	}//添加单个risk
	
	public boolean deleteRisk(int riskId){
		sql="delete from risk where id='" +riskId+ "'";
		db=new ConnectMySQL(sql);
		try {
	        db.pst.executeUpdate();
	        db.close();
	    } catch (SQLException e) {
	        return false;
	    }
		return true;
	}//删除单个risk
	
//--------------------------------------------------------------------------------------------------//	
	public ArrayList<riskFollow> getAllRiskFollow(){
		ArrayList<riskFollow> result=new ArrayList<riskFollow>();
		
		sql="select * from riskFollow";
		db=new ConnectMySQL(sql);
		handle h=new handle();
		try {  
            ret = db.pst.executeQuery();//执行语句，得到结果集  
            while (ret.next()) {  
                riskFollow r=new riskFollow();
                r.setId(ret.getInt(1)); 
                r.setRiskName(h.getName(ret.getInt(2)));
                r.setFollower(h.getName(ret.getInt(3)));
                r.setDescription(ret.getString(4));
                result.add(r);
            } 
            ret.close();  
            db.close();//关闭连接  
        } catch (SQLException e) {  
            e.printStackTrace();  
        } 
		return result;
	}//获得所有riskFollow
	
	public ArrayList<riskFollow> getSingleRiskFollow(String s){
		ArrayList<riskFollow> result=new ArrayList<riskFollow>();
		
		sql="select * from riskFollow when id LIKE '%"+s+"%' or riskId LIKE '%"+s+"%' or followerId LIKE '%"+s+"%'"
				+ " or description LIKE '%"+s+"%'";
		db=new ConnectMySQL(sql);
		handle h=new handle();
		try {  
            ret = db.pst.executeQuery();//执行语句，得到结果集  
            while (ret.next()) {  
            	riskFollow r=new riskFollow();
                r.setId(ret.getInt(1)); 
                r.setRiskName(h.getName(ret.getInt(2)));
                r.setFollower(h.getName(ret.getInt(3)));
                r.setDescription(ret.getString(4));
                result.add(r);
            } 
            ret.close();  
            db.close();//关闭连接  
        } catch (SQLException e) {  
            e.printStackTrace();  
        } 
		return result;
	}//获得单个riskFollow
	
	public boolean modifyRiskFollow(riskFollow r){
		handle h=new handle();
		int id=r.getId();
		
		sql="update riskFollow set riskId= "+h.getId(r.getRiskName())+",followerId= "+h.getId(r.getFollower())+",description= "
				+r.getDescription()+"when id="+id;
		db=new ConnectMySQL(sql);
		try {
	        db.pst.executeUpdate();
            db.close();//关闭连接 
	    } catch (SQLException e) {
	        return false;
	    }
		return true;
	}//修改单个riskFollow
	
	public boolean addRiskFollow(riskFollow r){
		sql="insert into riskFollow (riskId,followerId,description) values(?,?,?)";
		db=new ConnectMySQL(sql);
		handle h=new handle();
		try {
	        db.pst.setInt(1, h.getId(r.getRiskName()));
	        db.pst.setInt(2, h.getId(r.getFollower()));
	        db.pst.setString(3, r.getDescription());
	        db.pst.executeUpdate();
	        db.close();//关闭连接
	    } catch (SQLException e) {
	        return false;
	    }
		return true;
	}//添加单个riskFollow
	
	public boolean deleteRiskFollow(int riskFollowId){
		sql="delete from riskFollow where id='" +riskFollowId+ "'";
		db=new ConnectMySQL(sql);
		try {
	        db.pst.executeUpdate();
	        db.close();
	    } catch (SQLException e) {
	        return false;
	    }
		return true;
	}//删除单个riskFollow
//--------------------------------------------------------------------------------------------------//	
	public int judgeLogin(String userName,String pwd){
		sql="select * from user when userName= "+userName;
		db=new ConnectMySQL(sql);
		
		int result=2;
		int temp=0;
		try {  
            ret = db.pst.executeQuery();//执行语句，得到结果集  
            while (ret.next()) {  
                temp=1;
                String p=ret.getString("password");
                if(pwd.equals(p)){
                	result=0;
                }
            } 
            ret.close();  
            db.close();//关闭连接  
        } catch (SQLException e) {  
            return -1;
        } 
		if(temp==0){
			return 1;
		}else{
			return result;
		}
	}//判断用户名密码
	
	public int addUser(String name,String psw,boolean is){
		if(psw.length()<6)
			return 2;
		sql="select * from user when userName= "+name;
		db=new ConnectMySQL(sql);
		int temp=0;
		try {  
            ret = db.pst.executeQuery();//执行语句，得到结果集  
            while (ret.next()) {  
                temp=1;
            } 
            ret.close();  
            db.close();//关闭连接  
        } catch (SQLException e) {  
            e.printStackTrace();  
        } 
		if(temp==1)
			return 1;
		sql="insert into user (userName,password,administrator) values(?,?,?)";
		db=new ConnectMySQL(sql);
		try {  
			db.pst.setString(1, name);
	        db.pst.setString(2, psw);
	        db.pst.setBoolean(3, is);
	        db.pst.executeUpdate();
	        db.close();//关闭连接 
        } catch (SQLException e) {  
            return -1; 
        } 
		return 0;
	}//添加用户
	
	private String getName(int id){
		String result="";
		sql="select * from risk where risk.id="+id;
		db=new ConnectMySQL(sql);
		
		try {  
            ret = db.pst.executeQuery();//执行语句，得到结果集  
            while (ret.next()) {  
                result=ret.getString("userName");
            } 
            ret.close();  
            db.close();//关闭连接  
        } catch (SQLException e) {  
            e.printStackTrace();  
        } 
		return result;
	}//根据userId得到userName
	
	private int getId(String name){
		int result=-1;
		sql="select * from risk where risk.userName="+name;
		db=new ConnectMySQL(sql);
		
		try {  
            ret = db.pst.executeQuery();//执行语句，得到结果集  
            while (ret.next()) {  
                result=ret.getInt("id");
            } 
            ret.close();  
            db.close();//关闭连接  
        } catch (SQLException e) {  
            e.printStackTrace();  
        } 
		return result;
	}//根据userId得到userName
}
