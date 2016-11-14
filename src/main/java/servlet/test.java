package servlet;

import java.sql.ResultSet;

import data.ConnectMySQL;

public class test {
	public static void main(String []args){
		ConnectMySQL conn=new ConnectMySQL("show all databases");
		ConnectMySQL db=new ConnectMySQL("select * from user");
		ResultSet ret=null;
		try {  
            ret = db.pst.executeQuery();//执行语句，得到结果集  
		}catch(Exception e){
			
		}
	}
}
