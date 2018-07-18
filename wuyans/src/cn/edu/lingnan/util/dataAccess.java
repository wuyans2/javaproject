package cn.edu.lingnan.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

public class dataAccess {
    //第二版
	private static String driver = null;
	private static String url = null;
	private static String user = null;
	private static String password = null;
	private static String  xmlPath = "database.conf.xml";
	private static String  xsdPath = "database.conf.xsd";
	private static Connection conn = null;
	private static HashMap<String,String> hm = new HashMap<String,String>();
	static{
		
		if(XmlValidator.validator(xmlPath, xsdPath)){
			hm = XmlParser.parser(xmlPath);
			driver = hm.get("driver");
			url = hm.get("url");
			user = hm.get("user");
			password = hm.get("password");
		}
	}
	public static Connection getConnection(){	
		try{
			Class.forName(driver);
			conn = DriverManager.getConnection
					(url,user,password);
		}catch (ClassNotFoundException e) {
			System.out.println("MySQL的驱动程序找不到了，看一看是不是对应的jar包没有加载呀？");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("获取数据库连接事出现sql语句错误");
				e.printStackTrace();
		} 
		System.out.println("数据库连接获取成功......");
		return conn;
	}
	public static void closeconn(Connection conn,Statement stat,PreparedStatement prep,ResultSet rs){
		try {
			if(rs!=null)
			{
				rs.close();
				rs=null;
			}
			if(prep!=null)
			{
				prep.close();
				prep=null;
			}
			if(stat!=null)
			{
				stat.close();
				stat=null;
			}
			if(conn!=null)
			{
				conn.close();
				conn=null;
			}

			
		} catch (SQLException e) {
			System.out.println("关闭连接、语句及结果时出现错误");
			e.printStackTrace();
		}
	}

}

/*public class dataAccess {
        //第一版
		private static String driver = "com.mysql.jdbc.Driver";
		private static String url = "jdbc:mysql://localhost:3306/airticket";
		private static String username = "root";
		private static String password = "123456";
		
		public static Connection getConnection(){
			Connection conn = null;
			try{
				Class.forName(driver);
				conn = DriverManager.getConnection
						(url,username,password);
			}catch (ClassNotFoundException e) {
				System.out.println("MySQL的驱动程序找不到了，看一看是不是对应的jar包没有加载呀？");
				e.printStackTrace();
			} catch (SQLException e) {
				System.out.println("获取数据库连接事出现sql语句错误");
					e.printStackTrace();
			} 
			System.out.println("数据库连接获取成功......");
			return conn;
		}
		public static void closeconn(Connection conn,Statement stat,PreparedStatement prep,ResultSet rs){
			try {
				if(rs!=null)
				{
					rs.close();
					rs=null;
				}
				if(prep!=null)
				{
					prep.close();
					prep=null;
				}
				if(stat!=null)
				{
					stat.close();
					stat=null;
				}
				if(conn!=null)
				{
					conn.close();
					conn=null;
				}

				
			} catch (SQLException e) {
				System.out.println("关闭连接、语句及结果时出现错误");
				e.printStackTrace();
			}
		}

	}
*/
