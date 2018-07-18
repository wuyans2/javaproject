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
		//��ѯ���м�¼
		    public Vector<TicketDTO> findAllTicketTnfo()  {
			Vector<TicketDTO> v = new Vector<TicketDTO>();
			Connection conn = null;
			Statement stat = null;
			ResultSet rs = null;
			try {
				conn = dataAccess.getConnection();
				stat = conn.createStatement(); //����sql������ִ��
				String sql = "select * from ticket where state=1";
				rs = stat.executeQuery(sql);
				while(rs.next()){//��������
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
				System.out.println("����SQL���ʱ���ִ���");
					e.printStackTrace();
			}finally{
				dataAccess.closeconn(conn, stat, null, rs);		
	     	}
			return v;
	    }
		  //����clientID�Ž��в�ѯ��¼
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
			                System.out.println("��ƱID:"+rs.getString("ticketID")+"   "+"���ʱ��:"+rs.getString("offtime")+"   "+"����ʱ��:"+rs.getString("falltime")
			                		+"   "+"Ŀ�ĵ�:"+rs.getString("address")+"   "+"�۸�:"+rs.getString("price"));
			            }
						else{
							System.out.println("û�и��û�");
						}
						
					} catch (SQLException e) {
						System.out.println("����SQL���ʱ���ִ���");
							e.printStackTrace();
					}finally{
						dataAccess.closeconn(conn, stat, prep, rs);	
					}	
			    }
			
			//ɾ����¼
        	public boolean deleteticketBuId(String tid){
				boolean flag = false;
				Connection conn = null;
				PreparedStatement prep = null;
				Statement stat = null;
				try {
					conn = dataAccess.getConnection();
					stat = conn.createStatement(); //����sql������ִ��

					stat.executeUpdate("update orderform set state = 0 where ticketID='"+tid+"'");
					stat.executeUpdate("update ticket set state = 0 where ticketID='"+tid+"'");
					flag = true;
					if(flag = true)
					   System.out.println("ɾ���ɹ���");
					else
						System.out.println("ɾ�����ɹ���");
				} catch (SQLException e) {
					try{
						conn.rollback();
					}catch(SQLException e1){
						e.printStackTrace();
					}
					System.out.println("����SQL���ʱ���ִ���");
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
					       // ������ݿ�����
					     	conn = dataAccess.getConnection();					     	
					        prep = conn.prepareStatement("update orderform set state=0 where ticketID = ? ");				    					        
					        prep.setString(1,ticketID );
					 		prep.execute();
					 		flag = true;
					 		System.out.println("ɾ���ɹ���");
					 		} catch (SQLException e) {
					 			System.out.println("����SQL���ʱ���ִ���");
					 				e.printStackTrace();
					 		}
					 try{
					       // ������ݿ�����
					     	conn = dataAccess.getConnection();					     					    
					        prep = conn.prepareStatement("update ticket set state=0 where ticketID = ? ");					        
					        prep.setString(1,ticketID );
					 		prep.execute();
					 		flag = true;
					 		System.out.println("ɾ���ɹ���");
					 		} catch (SQLException e) {
					 			System.out.println("����SQL���ʱ���ִ���");
					 				e.printStackTrace();
					 		}finally{
					 			dataAccess.closeconn(conn,null, prep, null);	
					 		}
					        return flag;
				
				}
	*/
        	
        	
			//�����¼
			 public boolean InsertIntoticket(String ticketID,String offtime,String falltime,String address,int price,int surplus,int state){
			       boolean flag = false;
			       Connection conn = null;
			    	PreparedStatement prep = null;
			       try{
			      // ������ݿ�����
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
					System.out.println("����ɹ���");
					   
					} catch (SQLException e) {
						System.out.println("����SQL���ʱ���ִ���");
							e.printStackTrace();
					}finally{
						dataAccess.closeconn(conn, null, prep, null);	
					}
			       return flag;
			    }
			//�޸�����
			 public boolean Updateticket(int price,String ticketID){
			        boolean flag = false;
			        Connection conn = null;
			     	PreparedStatement prep = null;
			        try{
			       // ������ݿ�����
			     	conn = dataAccess.getConnection();
			        prep = conn.prepareStatement
			        		("update ticket set price = ? where ticketID= ? and state=1");
			        prep.setInt(1,price);
					prep.setString(2,ticketID );
			 		prep.execute();
			 		flag = true;
			 		System.out.println("�޸ĳɹ���");
			 		} catch (SQLException e) {
			 			System.out.println("����SQL���ʱ���ִ���");
			 				e.printStackTrace();
			 		}finally{
			 			dataAccess.closeconn(conn,null, prep, null);	
			 		}
			        return flag;
			     }
			//��ѯ���м�¼
			    public Vector<TicketDTO> findAllTicket()  {
				Vector<TicketDTO> v = new Vector<TicketDTO>();
				Connection conn = null;
				Statement stat = null;
				ResultSet rs = null;
				try {
					conn = dataAccess.getConnection();
					stat = conn.createStatement(); //����sql������ִ��
					String sql = "select * from ticket";
					rs = stat.executeQuery(sql);
					while(rs.next()){//��������
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
					System.out.println("����SQL���ʱ���ִ���");
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
				      // ������ݿ�����
				    	conn = dataAccess.getConnection();
				    	stat = conn.createStatement(); //����sql������ִ��
						stat.executeUpdate(sql);
						flag = true;
						System.out.println("�޸ĳɹ���");
						   
						} catch (SQLException e) {
							System.out.println("����SQL���ʱ���ִ���");
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
				      // ������ݿ�����
				    	conn = dataAccess.getConnection();
				    	stat = conn.createStatement(); //����sql������ִ��
						stat.executeUpdate(sql);
						flag = true;
						System.out.println("��ӳɹ���");
						   
						} catch (SQLException e) {
							System.out.println("����SQL���ʱ���ִ���");
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
						while(rs.next()){//��������
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
						System.out.println("����SQL���ʱ���ִ���");
							e.printStackTrace();
					}finally{
						dataAccess.closeconn(conn, stat, prpstmt, rs);		
			     	}
					return v;
			    }
				   	    
			    
			    
}
