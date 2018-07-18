package cn.edu.lingnan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Vector;

import cn.edu.lingnan.dto.clientDTO;
import cn.edu.lingnan.util.dataAccess;


public class clientDAO {
	//查询所有记录
	public Vector<clientDTO> findAllclientTnfo()  {
		Vector<clientDTO> v = new Vector<clientDTO>();
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		try {
			conn = dataAccess.getConnection();
			stat = conn.createStatement(); //创建sql语句对象并执行
			String sql = "select * from client where state=1";
			rs = stat.executeQuery(sql);
			while(rs.next()){//处理结果集
				clientDTO c = new clientDTO();
				c.setClientID(rs.getString("clientID"));
				c.setName(rs.getString("name"));
				c.setTel(rs.getString("tel"));
				v.add(c);
			}
		} catch (SQLException e) {
			System.out.println("运行SQL语句时出现错误");
				e.printStackTrace();
		}finally{
			dataAccess.closeconn(conn, stat, null, rs);		
     	}
		return v;
    }
	
	
	//根据ID号进行查询记录
	public void findclientbyID(String id ){
    	Connection conn = null;
		Statement stat = null;
		PreparedStatement prep = null;
		ResultSet rs = null;
		try {
			conn = dataAccess.getConnection();
			prep = conn.prepareStatement("select * from client where clientID = ? and state=1");
			prep.setString(1, id);	
			rs = prep.executeQuery();
			if(rs.next()) {
                System.out.println("用户名 : "+rs.getString("name")+"   "+"电话:"+rs.getString("tel"));
            }
			else{
				System.out.println("没有该用户");
			}
			
		} catch (SQLException e) {
			System.out.println("运行SQL语句时出现错误");
				e.printStackTrace();
		}finally{
			dataAccess.closeconn(conn, stat, prep, rs);	
		}	
    }
	
	//删除记录
	public boolean deleteclientBuId(String id){
		boolean flag = false;
		Connection conn = null;
		PreparedStatement prep = null;
		Statement stat = null;
		Statement stat1 = null;
		ResultSet rs = null;
		ResultSet rs1 = null;
		try {
			conn = dataAccess.getConnection();
			stat = conn.createStatement(); //创建sql语句对象并执行
			stat1 = conn.createStatement();
			String sql2 = "select * from orderform where clientID='"+id+"'";
			String sql3 = null;
			rs = stat.executeQuery(sql2);
			String ticketID = null;
			HashSet<String> hs = new HashSet<String>();
			while (rs.next()){
				ticketID = rs.getString(2);
				sql3 = "select count(*) as num from orderform where ticketID ='"+ticketID+"'";
				rs1 = stat1.executeQuery(sql3);
				rs1.next();
				if(rs1.getInt("num")==1){
					hs.add(ticketID);
//					stat.executeUpdate("delete from orderform where ticketID = '"+ticketID+"'");
//					stat.executeUpdate("delete from ticket where ticketID = '"+ticketID+"'");
				}		
				 rs1.close();
			}
			conn.setAutoCommit(false);
			//stat.executeUpdate("delete from orderform where clientID='"+id+"'");
			stat.executeUpdate("update orderform set state = 0 where clientID='"+id+"'");
			//stat.executeUpdate("delete from client where clientID='"+id+"'");
			stat.executeUpdate("update client set state = 0 where clientID='"+id+"'");
			Iterator<String> it = hs.iterator();
			while (it.hasNext()){
				//stat.executeUpdate("delete from ticket where ticketID = '"+it.next()+"'");
				stat.executeUpdate("update ticket set state = 0 where ticketID = '"+it.next()+"'");
				//it.next();
			}
			conn.commit();
			conn.setAutoCommit(true);
			flag = true;
			if(flag = true)
			   System.out.println("删除成功！");
			else
				System.out.println("删除不成功！");
		} catch (SQLException e) {
			try{
				conn.rollback();
			}catch(SQLException e1){
				e.printStackTrace();
			}
			System.out.println("运行SQL语句时出现错误");
				e.printStackTrace();
		}
		finally{
			dataAccess.closeconn(conn, stat, prep, rs);
		}
		return flag;
	
	}
	
	//插入记录
	 public boolean InsertIntoclient(String id,String name,String tel,String password,int superuser,int state){
	       boolean flag = false;
	       Connection conn = null;
	    	PreparedStatement prep = null;
	       try{
	      // 获得数据库连接
	    	conn = dataAccess.getConnection();
			prep = conn.prepareStatement("insert into client values(?,?,?,?,?,?)");
			prep.setString(1, id);
			prep.setString(2, name);
			prep.setString(3, tel);
			prep.setString(4, password);
			prep.setInt(5, superuser);
			prep.setInt(6, state);
			prep.executeUpdate();
			flag = true;
			System.out.println("插入成功！");
			   
			} catch (SQLException e) {
				System.out.println("运行SQL语句时出现错误");
					e.printStackTrace();
			}finally{
				dataAccess.closeconn(conn, null, prep, null);	
			}
	       return flag;
	    }
	 
	 
	//修改数据
	 public boolean Updateclient(String name,String id){
	        boolean flag = false;
	        Connection conn = null;
	     	PreparedStatement prep = null;
	        try{
	       // 获得数据库连接
	     	conn = dataAccess.getConnection();
	        prep = conn.prepareStatement
	        		("update client set name =? where clientID=? and state=1");
			prep.setString(1,id );
	 		prep.setString(2,name);

	 		prep.execute();
	 		flag = true;
	 		System.out.println("修改成功！");
	 		} catch (SQLException e) {
	 			System.out.println("运行SQL语句时出现错误");
	 				e.printStackTrace();
	 		}finally{
	 			dataAccess.closeconn(conn,null, prep, null);	
	 		}
	        return flag;
	     }
	 
	//核对账户密码
	    public int findclientByNameAndPassword(String _name,String _password){
//	    	boolean flag = false;
	    	int superValue = 0;
	    	Connection conn = null;
			Statement stat = null;
			PreparedStatement prep = null;
			ResultSet rs = null;
			try {
				conn = dataAccess.getConnection();
				prep = conn.prepareStatement("select * from client where name = ? and password =? and state=1");
				prep.setString(1, _name);
				prep.setString(2, _password);
				rs = prep.executeQuery();
				if (rs.first()){
					superValue=Integer.parseInt(rs.getString("superuser"));
					System.out.println("--1--"+superValue); 
				}
//					flag = true;			
			} catch (SQLException e) {
				System.out.println("运行SQL语句时出现错误");
					e.printStackTrace();
			}finally{
					dataAccess.closeconn(conn,null, prep, rs);
			}	
//		return flag;
			return superValue;
	    }
	    
	  //插入记录
		 public boolean registerIntoclient(clientDTO sdto){
		       boolean flag = false;
		       String clientID=sdto.getClientID();
				String name =sdto.getName();
				String tel=sdto.getTel();
				String password = sdto.getPassword();
				int superuser=sdto.getSuperuser();
				int state=sdto.getState();
				String sql = "insert into client values('"+clientID+"','"+name+"',"+tel+ ",'"+
				password+"','"+superuser+"','"+state+"')";				
		       Connection conn = null;
		       Statement stat = null;
		       try{
		      // 获得数据库连接
		    	conn = dataAccess.getConnection();
		    	stat = conn.createStatement(); //创建sql语句对象并执行
				stat.executeUpdate(sql);
				flag = true;
				System.out.println("插入成功！");
				   
				} catch (SQLException e) {
					System.out.println("运行SQL语句时出现错误");
						e.printStackTrace();
				}finally{
					dataAccess.closeconn(conn, stat, null, null);	
				}
		       return flag;
		    }
		 
		 
		 public Vector<clientDTO> findAllclient()  {
				Vector<clientDTO> v = new Vector<clientDTO>();
				Connection conn = null;
				Statement stat = null;
				ResultSet rs = null;
				try {
					conn = dataAccess.getConnection();
					stat = conn.createStatement(); //创建sql语句对象并执行
					String sql = "select * from client ";
					rs = stat.executeQuery(sql);
					while(rs.next()){//处理结果集
						clientDTO c = new clientDTO();
						c.setClientID(rs.getString("clientID"));
						c.setName(rs.getString("name"));
						c.setTel(rs.getString("tel"));
						c.setPassword(rs.getString("password"));
						c.setSuperuser(rs.getInt("superuser"));
						c.setState(rs.getInt("state"));
						v.add(c);
					}
					
					
				} catch (SQLException e) {
					System.out.println("运行SQL语句时出现错误");
						e.printStackTrace();
				}finally{
					dataAccess.closeconn(conn, stat, null, rs);		
		     	}
				return v;
		    }
		 
		 
		 public boolean updateclient(clientDTO cdto){
		       boolean flag = false;
		       String clientID=cdto.getClientID();
				String name =cdto.getName();
				String tel=cdto.getTel();
				String password = cdto.getPassword();
				int superuser = cdto.getSuperuser();
				int state = cdto.getState();
				String sql = "update client set name='"+name+"',tel="+tel+ ",password='"
				               +password+"',superuser='"+superuser+"',state='"+state+"' where clientID='"+clientID+"'";				
		       Connection conn = null;
		       Statement stat = null;
		       try{
		      // 获得数据库连接
		    	conn = dataAccess.getConnection();
		    	stat = conn.createStatement(); //创建sql语句对象并执行
				stat.executeUpdate(sql);
				flag = true;
				System.out.println("修改成功！");
				   
				} catch (SQLException e) {
					System.out.println("运行SQL语句时出现错误");
						e.printStackTrace();
				}finally{
					dataAccess.closeconn(conn, stat, null, null);	
				}
		       return flag;
		    }
		 
		 //在登录时判断用户名否存在
		 public boolean findclientByName(String _name){
		    	boolean flag = false;
		    	Connection conn = null;
				Statement stat = null;
				PreparedStatement prep = null;
				ResultSet rs = null;
				try {
					conn = dataAccess.getConnection();
					prep = conn.prepareStatement("select * from client where name = ?");
					prep.setString(1, _name);
					rs = prep.executeQuery();
					if (rs.first()){
						flag = true;
					}			
				} catch (SQLException e) {
					System.out.println("运行SQL语句时出现错误");
						e.printStackTrace();
				}finally{
						dataAccess.closeconn(conn,null, prep, rs);
				}	
     		return flag;
		    }
		 
		 public Vector<clientDTO> findclientbyname(String name)  {
				Vector<clientDTO> v = new Vector<clientDTO>();
				Connection conn = null;
				Statement stat = null;
				ResultSet rs = null;
				try {
					conn = dataAccess.getConnection();
					stat = conn.createStatement(); //创建sql语句对象并执行
					String sql = "select * from client where name = '"+name+"' and state=1";
					rs = stat.executeQuery(sql);
					while(rs.next()){//处理结果集
						clientDTO c = new clientDTO();
						c.setClientID(rs.getString("clientID"));
						c.setName(rs.getString("name"));
						c.setTel(rs.getString("tel"));
						c.setPassword(rs.getString("password"));
						c.setSuperuser(rs.getInt("superuser"));
						v.add(c);
					}
					
					
				} catch (SQLException e) {
					System.out.println("运行SQL语句时出现错误");
						e.printStackTrace();
				}finally{
					dataAccess.closeconn(conn, stat, null, rs);		
		     	}
				return v;
		    }
		 
		    public String findclientByNandP(String _name,String _password){
//		    	boolean flag = false;
		    	String clientID = null;
		    	Connection conn = null;
				Statement stat = null;
				PreparedStatement prep = null;
				ResultSet rs = null;
				try {
					conn = dataAccess.getConnection();
					prep = conn.prepareStatement("select * from client where name = ? and password =? and state=1");
					prep.setString(1, _name);
					prep.setString(2, _password);
					rs = prep.executeQuery();
					if (rs.first()){
						clientID=rs.getString("clientID");
						System.out.println("--clientID--"+clientID); 
					}
//						flag = true;			
				} catch (SQLException e) {
					System.out.println("运行SQL语句时出现错误");
						e.printStackTrace();
				}finally{
						dataAccess.closeconn(conn,null, prep, rs);
				}	
//			return flag;
				return clientID;
		    }
		    
		    public String findclientByNP(String name,String password){
		    	String tel = null;
		    	Connection conn = null;
				PreparedStatement prep = null;
				ResultSet rs = null;
				try {
					conn = dataAccess.getConnection();
					prep = conn.prepareStatement("select * from client where name = ? and password =? and state=1");
					prep.setString(1, name);
					prep.setString(2, password);
					rs = prep.executeQuery();
					if (rs.first()){
						tel=rs.getString("tel");
						System.out.println("--tel--"+tel); 
					}			
				} catch (SQLException e) {
					System.out.println("运行SQL语句时出现错误");
						e.printStackTrace();
				}finally{
						dataAccess.closeconn(conn,null, prep, rs);
				}	
				return tel;
		    }
		    
			public Vector<clientDTO> findAllclienbyName(String name)  {
				Vector<clientDTO> v = new Vector<clientDTO>();
				Connection conn = null;
				Statement stat = null;
				ResultSet rs = null;
				  PreparedStatement prpstmt = null;	
				try {
					conn = dataAccess.getConnection();
					String sql = "select * from client";
					 prpstmt = conn.prepareStatement("select * from client where name=?");
					 prpstmt.setString(1,name);
					rs = prpstmt.executeQuery();
					while(rs.next()){//处理结果集
						clientDTO c = new clientDTO();
						c.setClientID(rs.getString("clientID"));
						c.setName(rs.getString("name"));
						c.setTel(rs.getString("tel"));
						c.setPassword("password");
						c.setSuperuser(rs.getInt("superuser"));
						c.setState(rs.getInt("state"));
						v.add(c);
					}
				} catch (SQLException e) {
					System.out.println("运行SQL语句时出现错误");
						e.printStackTrace();
				}finally{
					dataAccess.closeconn(conn, stat, null, rs);		
		     	}
				return v;
		    }
			
}