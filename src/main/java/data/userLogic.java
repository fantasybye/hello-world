package data;

import java.sql.ResultSet;
import java.sql.SQLException;

public class userLogic implements userInterface{
	static String sql = null;  
    static ConnectMySQL db = null;  
    static ResultSet ret = null;
    
	public int judgeLogin(String userName,String pwd){
		sql="select * from user where userName='"+userName+"'";
		db=new ConnectMySQL(sql);
		
		int result=-2;
		int temp=0;
		try {  
			ret = db.pst.executeQuery();
            while (ret.next()) {  
                temp=1;
                String p=ret.getString("password");
                if(pwd.equals(p)){
                	result=0;
                }
            } 
            ret.close();  
            db.close();
        } catch (SQLException e) {  
        	e.printStackTrace();  
        } 
		if(temp==0){
			return -1;
		}else{
			return result;
		}
	}//判断用户登录，0成功，-1用户名错误，-2密码错误
	
	public int addUser(String name,String psw,boolean is){
		sql="select * from user where userName= '"+name+"'";
		db=new ConnectMySQL(sql);
		int temp=0;
		try {  
            ret = db.pst.executeQuery();
            while (ret.next()) {  
                temp=1;
            } 
            ret.close();  
            db.close();
        } catch (SQLException e) {  
            e.printStackTrace();  
        } 
		if(temp==1)
			return -1;
		if(psw.length()<6)
			return -2;
		sql="insert into user (userName,password,administrator) values(?,?,?)";
		db=new ConnectMySQL(sql);
		try {  
			db.pst.setString(1, name);
	        db.pst.setString(2, psw);
	        db.pst.setBoolean(3, is);
	        db.pst.executeUpdate();
	        db.close();
        } catch (SQLException e) {  
        	e.printStackTrace(); 
        } 
		return 0;
	}//添加新用户，0成功，-1用户名已存在，-2密码少于六位
	
	public String getUserNameById(int id){
		String result="";
		String sql="select * from user where user.id="+id;
		ConnectMySQL db=new ConnectMySQL(sql);
		
		try {  
			ResultSet ret = db.pst.executeQuery();
            while (ret.next()) {  
                result=ret.getString("userName");
            } 
            ret.close();  
            db.close();
        } catch (SQLException e) {  
            e.printStackTrace();  
        } 
		return result;
	}//根据用户Id获得用户名
	
	public int getUserIdByName(String name){
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
