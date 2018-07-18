package cn.edu.lingnan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import cn.edu.lingnan.dto.TicketDTO;
import cn.edu.lingnan.dto.clientDTO;
import cn.edu.lingnan.util.dataAccess;

public class TicketDAO {
		//查询所有记录
		    public Vector<TicketDTO> findAllTicketTnfo()  {
			Vector<TicketDTO> v = new Vector<TicketDTO>();
			Connection conn = null;
			Statement stat = null;
			ResultSet rs = null;
			try {
				conn = dataAccess.getConnection();
				stat = conn.createStatement(); //创建sql语句对象并执行
				String sql = "select * from ticket where state=1";
				rs = stat.executeQuery(sql);
				while(rs.next()){//处理结果集
					TicketDTO t = new TicketDTO();
					t.setTicketID(rs.getString("ticketID"));
					t.setOfftime(rs.getString("offtime"));
					t.setFalltime(rs.getString("falltime"));
					t.setAddress(rs.getString("address"));
					t.setPrice(rs.getString("price"));
					t.setSurplus(rs.getString("surplus"));
					v.add(t);
				}				
			} catch (SQLException e) {
				System.out.println("运行SQL语句时出现错误");
					e.printStackTrace();
			}finally{
				dataAccess.closeconn(conn, stat, null, rs);		
	     	}
			return v;
	    }
		  //根据clientID号进行查询记录
			public void findticketbyID(String ticketID ){
			    	Connection conn = null;
					Statement stat = null;
					PreparedStatement prep = null;
					ResultSet rs = null;
					try {
						conn = dataAccess.getConnection();
						prep = conn.prepareStatement("select * from ticket where ticketID = ? and state=1");
						prep.setString(1, ticketID);	
						rs = prep.executeQuery();
						if(rs.next()) {
			                System.out.println("机票ID:"+rs.getString("ticketID")+"   "+"起飞时间:"+rs.getString("offtime")+"   "+"降落时间:"+rs.getString("falltime")
			                		+"   "+"目的地:"+rs.getString("address")+"   "+"价格:"+rs.getString("price"));
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
        	public boolean deleteticketBuId(String tid){
				boolean flag = false;
				Connection conn = null;
				PreparedStatement prep = null;
				Statement stat = null;
				try {
					conn = dataAccess.getConnection();
					stat = conn.createStatement(); //创建sql语句对象并执行

					stat.executeUpdate("update orderform set state = 0 where ticketID='"+tid+"'");
					stat.executeUpdate("update ticket set state = 0 where ticketID='"+tid+"'");
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
					dataAccess.closeconn(conn, stat, prep, null);
				}
				return flag;
			
			}

/*			 public boolean deleteticketBuId1(String ticketID ){
					boolean flag = false;
					Connection conn = null;
					PreparedStatement prep = null;
					try{
					       // 获得数据库连接
					     	conn = dataAccess.getConnection();					     	
					        prep = conn.prepareStatement("update orderform set state=0 where ticketID = ? ");				    					        
					        prep.setString(1,ticketID );
					 		prep.execute();
					 		flag = true;
					 		System.out.println("删除成功！");
					 		} catch (SQLException e) {
					 			System.out.println("运行SQL语句时出现错误");
					 				e.printStackTrace();
					 		}
					 try{
					       // 获得数据库连接
					     	conn = dataAccess.getConnection();					     					    
					        prep = conn.prepareStatement("update ticket set state=0 where ticketID = ? ");					        
					        prep.setString(1,ticketID );
					 		prep.execute();
					 		flag = true;
					 		System.out.println("删除成功！");
					 		} catch (SQLException e) {
					 			System.out.println("运行SQL语句时出现错误");
					 				e.printStackTrace();
					 		}finally{
					 			dataAccess.closeconn(conn,null, prep, null);	
					 		}
					        return flag;
				
				}
	*/
        	
        	
			//插入记录
			 public boolean InsertIntoticket(String ticketID,String offtime,String falltime,String address,int price,int surplus,int state){
			       boolean flag = false;
			       Connection conn = null;
			    	PreparedStatement prep = null;
			       try{
			      // 获得数据库连接
			    	conn = dataAccess.getConnection();
					prep = conn.prepareStatement("insert into ticket values(?,?,?,?,?,?,?)");
					prep.setString(1, ticketID);
					prep.setString(2, offtime);
					prep.setString(3, falltime);
					prep.setString(4, address);
					prep.setInt(5, price);
					prep.setInt(6, surplus);
					prep.setInt(7, state);
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
			 public boolean Updateticket(int price,String ticketID){
			        boolean flag = false;
			        Connection conn = null;
			     	PreparedStatement prep = null;
			        try{
			       // 获得数据库连接
			     	conn = dataAccess.getConnection();
			        prep = conn.prepareStatement
			        		("update ticket set price = ? where ticketID= ? and state=1");
			        prep.setInt(1,price);
					prep.setString(2,ticketID );
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
			//查询所有记录
			    public Vector<TicketDTO> findAllTicket()  {
				Vector<TicketDTO> v = new Vector<TicketDTO>();
				Connection conn = null;
				Statement stat = null;
				ResultSet rs = null;
				try {
					conn = dataAccess.getConnection();
					stat = conn.createStatement(); //创建sql语句对象并执行
					String sql = "select * from ticket";
					rs = stat.executeQuery(sql);
					while(rs.next()){//处理结果集
						TicketDTO t = new TicketDTO();
						t.setTicketID(rs.getString("ticketID"));
						t.setOfftime(rs.getString("offtime"));
						t.setFalltime(rs.getString("falltime"));
						t.setAddress(rs.getString("address"));
						t.setPrice(rs.getString("price"));
						t.setSurplus(rs.getString("surplus"));
						t.setState(rs.getString("state"));
						v.add(t);
					}				
				} catch (SQLException e) {
					System.out.println("运行SQL语句时出现错误");
						e.printStackTrace();
				}finally{
					dataAccess.closeconn(conn, stat, null, rs);		
		     	}
				return v;
		    }
			    
			    public boolean updateticket(TicketDTO tdto){
				       boolean flag = false;
				       String ticketID=tdto.getTicketID();
						String offtime=tdto.getOfftime();
						String falltime=tdto.getFalltime();
						String address=tdto.getAddress();
						String price = tdto.getPrice();
						String surplus = tdto.getSurplus();
						String state = tdto.getState();
						String sql = "update ticket set offtime='"+offtime+"',falltime='"+falltime+ "',address='"
						               +address+"',price='"+price+"',surplus='"+surplus+"',state='"+state+"' where ticketID='"+ticketID+"'";				
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
			    
			    public boolean insertticket(TicketDTO tdto){
				       boolean flag = false;
				       String ticketID=tdto.getTicketID();
						String offtime=tdto.getOfftime();
						String falltime=tdto.getFalltime();
						String address=tdto.getAddress();
						String price = tdto.getPrice();
						String surplus = tdto.getSurplus();
						String state = tdto.getState();
						String sql = "insert into ticket values('"+ticketID+"','"+offtime+"','"+falltime+ "','"+address+"','"+price+"','"+surplus+"','"+state+"')";			
				       Connection conn = null;
				       Statement stat = null;
				       try{
				      // 获得数据库连接
				    	conn = dataAccess.getConnection();
				    	stat = conn.createStatement(); //创建sql语句对象并执行
						stat.executeUpdate(sql);
						flag = true;
						System.out.println("添加成功！");
						   
						} catch (SQLException e) {
							System.out.println("运行SQL语句时出现错误");
								e.printStackTrace();
						}finally{
							dataAccess.closeconn(conn, stat, null, null);	
						}
				       return flag;
				    }
			    public Vector<TicketDTO> findAllTicketbyaddress(String address )  {
					Vector<TicketDTO> v = new Vector<TicketDTO>();
					Connection conn = null;
					Statement stat = null;
					ResultSet rs = null;
					PreparedStatement prpstmt = null;	
					try {
						conn = dataAccess.getConnection();
						String sql = "select * from ticket";
						 prpstmt = conn.prepareStatement("select * from ticket where address=?");
						 prpstmt.setString(1,address);
						rs = prpstmt.executeQuery();
						while(rs.next()){//处理结果集
							TicketDTO t = new TicketDTO();
							t.setTicketID(rs.getString("ticketID"));
							t.setOfftime(rs.getString("offtime"));
							t.setFalltime(rs.getString("falltime"));
							t.setAddress(rs.getString("address"));
							t.setPrice(rs.getString("price"));
							t.setSurplus(rs.getString("surplus"));
							t.setState(rs.getString("state"));
							v.add(t);
						}				
					} catch (SQLException e) {
						System.out.println("运行SQL语句时出现错误");
							e.printStackTrace();
					}finally{
						dataAccess.closeconn(conn, stat, prpstmt, rs);		
			     	}
					return v;
			    }
				   	    
			    
			    
}
