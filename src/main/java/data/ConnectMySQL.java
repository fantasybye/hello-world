package data;

import java.sql.*;

public class ConnectMySQL {
	public static final String url = "jdbc:mysql://localhost/prm?useUnicode=true&characterEncoding=gbk";  
    public static final String name = "com.mysql.jdbc.Driver";  
    public static final String user = "root";  
    public static final String password = "";  
  
    public Connection conn = null;  
    public PreparedStatement pst = null;  
  
    public ConnectMySQL(String sql) {  
        try {  
            Class.forName(name);
            conn = DriverManager.getConnection(url, user, password);
            pst = conn.prepareStatement(sql);
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
    }  //建立连接
  
    public void close() {  
        try {  
            this.conn.close();  
            this.pst.close();  
        } catch (SQLException e) {  
            e.printStackTrace();  
        }  
    }  //关闭连接
}
