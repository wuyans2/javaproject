package cn.edu.lingnan.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

public class dataAccess {
    //�ڶ���
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
			System.out.println("MySQL�����������Ҳ����ˣ���һ���ǲ��Ƕ�Ӧ��jar��û�м���ѽ��");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("��ȡ���ݿ������³���sql������");
				e.printStackTrace();
		} 
		System.out.println("���ݿ����ӻ�ȡ�ɹ�......");
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
			System.out.println("�ر����ӡ���估���ʱ���ִ���");
			e.printStackTrace();
		}
	}

}

/*public class dataAccess {
        //��һ��
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
				System.out.println("MySQL�����������Ҳ����ˣ���һ���ǲ��Ƕ�Ӧ��jar��û�м���ѽ��");
				e.printStackTrace();
			} catch (SQLException e) {
				System.out.println("��ȡ���ݿ������³���sql������");
					e.printStackTrace();
			} 
			System.out.println("���ݿ����ӻ�ȡ�ɹ�......");
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
				System.out.println("�ر����ӡ���估���ʱ���ִ���");
				e.printStackTrace();
			}
		}

	}
*/
