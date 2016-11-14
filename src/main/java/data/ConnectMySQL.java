package data;

import java.sql.*;

public class ConnectMySQL {
	public static final String url = "jdbc:mysql://192.168.43.103/PRM?useUnicode=true&characterEncoding=gbk";  
    public static final String name = "com.mysql.jdbc.Driver";  
    public static final String user = "333";  
    public static final String password = "333";  
  
    public Connection conn = null;  
    public PreparedStatement pst = null;  
  
    public ConnectMySQL(String sql) {  
        try {  
            Class.forName(name);//指定连接类型  
            conn = DriverManager.getConnection(url, user, password);//获取连接  
            pst = conn.prepareStatement(sql);//准备执行语句  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
    }  
  
    public void close() {  
        try {  
            this.conn.close();  
            this.pst.close();  
        } catch (SQLException e) {  
            e.printStackTrace();  
        }  
    }  
}
