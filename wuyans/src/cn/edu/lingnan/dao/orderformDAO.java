package cn.edu.lingnan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.JOptionPane;

import cn.edu.lingnan.dto.TicketDTO;
import cn.edu.lingnan.dto.clientDTO;
import cn.edu.lingnan.dto.orderformDTO;
import cn.edu.lingnan.util.dataAccess;

public class orderformDAO {
	//�鿴ȫ������
	public Vector<orderformDTO> findAllorderformTnfo()  {
		Vector<orderformDTO> v = new Vector<orderformDTO>();
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		try {
			conn = dataAccess.getConnection();
			stat = conn.createStatement(); //����sql������ִ��
			String sql = "select * from orderform where state=1";
			rs = stat.executeQuery(sql);
			while(rs.next()){//��������
				orderformDTO o = new orderformDTO();
				o.setClientID(rs.getString("clientID"));
				o.setTicketID(rs.getString("ticketID"));
				o.setNumber(rs.getString("number"));
				v.add(o);
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
	public void findorderformbyID(String clientID ){
	    	Connection conn = null;
			Statement stat = null;
			PreparedStatement prep = null;
			ResultSet rs = null;
			try {
				conn = dataAccess.getConnection();
				prep = conn.prepareStatement("select * from orderform where clientID = ? and state=1");
				prep.setString(1, clientID);	
				rs = prep.executeQuery();
				if(rs.next()) {
	                System.out.println("�û�ID : "+rs.getString("clientID")+"   "+"��ƱID:"+rs.getString("ticketID")+"   "
				                       +"����:"+rs.getString("number"));
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
	//�����Ʊ
		 public boolean InsertIntoorderform(String clientID,String ticketID,int number,int state){
		       boolean flag = false;
		       Connection conn = null;
		    	PreparedStatement prep = null;
		       try{
		      // ������ݿ�����
		    	conn = dataAccess.getConnection();
				prep = conn.prepareStatement("insert into orderform values(?,?,?,?)");
				prep.setString(1, clientID);
				prep.setString(2, ticketID);
				prep.setInt(3, number);
				prep.setInt(4, state);
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
		 
		     public boolean Insertorderform(orderformDTO oto){
		       boolean flag = false;
		        String clientID=oto.getClientID();
				String ticketID =oto.getTicketID();
				String number=oto.getNumber();
				String state=oto.getState();
				String sql = "insert into orderform values('"+clientID+"','"+ticketID+"',"+number+ ","+state+")";				
		       Connection conn = null;
		       Statement stat = null;
		       try{
		      // ������ݿ�����
		    	conn = dataAccess.getConnection();
		    	stat = conn.createStatement(); //����sql������ִ��
				stat.executeUpdate(sql);
				flag = true;
				System.out.println("����ɹ���");
				   
				} catch (SQLException e) {
					System.out.println("����SQL���ʱ���ִ���");
						e.printStackTrace();
				}finally{
					dataAccess.closeconn(conn, stat, null, null);	
				}
		       return flag;
		    }
		 
		//�޸Ļ�Ʊ����
		 public boolean Updateorderform (int number,String clientID,String ticketID){
		        boolean flag = false;
		        Connection conn = null;
		     	PreparedStatement prep = null;
		        try{
		       // ������ݿ�����
		     	conn = dataAccess.getConnection();
		        prep = conn.prepareStatement
		        		("update orderform set number =? where clientID=? and ticketID = ? and state=1");
				prep.setInt(1,number);
				prep.setString(2,clientID );
		 		prep.setString(3,ticketID);
		 		
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
		 //ɾ������
		 public boolean deleteorderformByIdAndTicketID(String clientID,String ticketID ){
				boolean flag = false;
				Connection conn = null;
				PreparedStatement prep = null;
				 try{
				       // ������ݿ�����
				     	conn = dataAccess.getConnection();
				        prep = conn.prepareStatement
				        		("update orderform set state=0 where clientID=? and ticketID = ? ");
						prep.setString(1,clientID );
				 		prep.setString(2,ticketID);
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
		 //����ȫ������
		 public Vector<orderformDTO> findAllorderform()  {
				Vector<orderformDTO> v = new Vector<orderformDTO>();
				Connection conn = null;
				Statement stat = null;
				ResultSet rs = null;
				try {
					conn = dataAccess.getConnection();
					stat = conn.createStatement(); //����sql������ִ��
					String sql = "select * from orderform";
					rs = stat.executeQuery(sql);
					while(rs.next()){//��������
						orderformDTO o = new orderformDTO();
						o.setClientID(rs.getString("clientID"));
						o.setTicketID(rs.getString("ticketID"));
						o.setNumber(rs.getString("number"));
						o.setState(rs.getString("state"));
						v.add(o);
					}				
				} catch (SQLException e) {
					System.out.println("����SQL���ʱ���ִ���");
						e.printStackTrace();
				}finally{
					dataAccess.closeconn(conn, stat, null, rs);		
		     	}
				return v;
		    }
		 
		 
		 public boolean updateorderform(orderformDTO odto){
		       boolean flag = false;
		       String clientID=odto.getClientID();
		       String ticketID=odto.getTicketID();
				String number = odto.getNumber();
				String state = odto.getState();
		       Connection conn = null;
		       Statement stat = null;
		       Statement stat1 = null;
		       Statement stat2 = null;
		       Statement stat3 = null;
		       ResultSet rs = null;
		       ResultSet rs1 = null;
		       ResultSet rs2 = null;
		       try{
		      // ������ݿ�����
		    	conn = dataAccess.getConnection();
		    	stat = conn.createStatement(); //����sql������ִ��
		    	stat1 = conn.createStatement();
		    	stat2 = conn.createStatement();
		    	stat3 = conn.createStatement();
		    	String sql2 = "select * from ticket where ticketID = '"+ticketID+"'and state=1";  
				rs = stat.executeQuery(sql2);
				while(rs.next()){
				int surplus=rs.getInt("surplus");
		    	 String sql5 = "select * from  orderform where ticketID = '"+ticketID+"' and clientID = '"+clientID+"'";  
					rs2 = stat2.executeQuery(sql5);	
					while(rs2.next()){
						int number2 = rs2.getInt("number");
						System.out.println("ԭ����������"+number2);
						int s=Integer.parseInt(state);
						if(s==1&&Integer.parseInt(number)<surplus){
							String sql = "update orderform set number="+number+", state="+state+" where ticketID='"+ticketID+"'and clientID='"+clientID+"'";	
							stat3.executeUpdate(sql);
							stat.executeUpdate("update ticket set surplus="+surplus+"+"+number2+"-"+number+" where ticketID = '"+ticketID+"' ") ;
						}else{
							JOptionPane.showMessageDialog(null,"��ⲻ��"); 
						}
						rs.close();	
						rs2.close();
					}
					   
					}			
				
				flag = true;
				System.out.println("�޸ĳɹ���");
				   
				} catch (SQLException e) {
					System.out.println("����SQL���ʱ���ִ���");
						e.printStackTrace();
				}finally{
					dataAccess.closeconn(conn, stat, null,rs);	
				}
		       return flag;
		    }
		 
		//�����Ʊ 
		 public boolean Insertorderform1(orderformDTO oto){
		       boolean flag = false;
		       Statement stat = null;
		       Statement stat1 = null;
		       ResultSet rs = null;
		       ResultSet rs1 = null;
		       ResultSet rs2 = null;
		       Connection conn = null;
		        String clientID=oto.getClientID();
				String ticketID =oto.getTicketID();
				String number=oto.getNumber();
				String state=oto.getState();	
	       try{
		      // ������ݿ�����
		    	conn = dataAccess.getConnection();
		    	stat = conn.createStatement(); //����sql������ִ��
		    	stat1 = conn.createStatement();
		    	int i=Integer.parseInt(number);
		    	System.out.println("����������"+number);
		    	String sql2 = "select * from ticket where ticketID = '"+ticketID+"'and state=1";  
				rs = stat.executeQuery(sql2);
				rs.next();
				int surplus=rs.getInt("surplus");
				System.out.println("����У�"+surplus);
				if(state.equals("1")&&i<surplus&&surplus>0){
		    	String sql = "insert into orderform values('"+clientID+"','"+ticketID+"',"+number+ ","+state+")";	
				stat1.executeUpdate(sql);
				stat.executeUpdate("update ticket set surplus="+surplus+"-"+i+" where ticketID = '"+ticketID+"' ") ;
				}else{
					JOptionPane.showMessageDialog(null,"��ⲻ��"); 
				}
				 rs.close();
				flag = true;
				System.out.println("���гɹ���");
				   
				} catch (SQLException e) {
					System.out.println("����SQL���ʱ���ִ���");
						e.printStackTrace();
				}finally{
					dataAccess.closeconn(conn, stat, null, null);	
				}
		       return flag;
		    }
		 
		 public Vector<orderformDTO> findmyorderform(String clientID,String ticketID)  {
				Vector<orderformDTO> v = new Vector<orderformDTO>();
				Connection conn = null;
				Statement stat = null;
				ResultSet rs = null;
				try {
					conn = dataAccess.getConnection();
					stat = conn.createStatement(); //����sql������ִ��
					String sql = "select * from orderform where clientID='"+clientID+"' and ticketID='"+ticketID+"'";
					rs = stat.executeQuery(sql);
					while(rs.next()){//��������
						orderformDTO o = new orderformDTO();
						o.setClientID(rs.getString("clientID"));
						o.setTicketID(rs.getString("ticketID"));
						o.setNumber(rs.getString("number"));
						o.setState(rs.getString("state"));
						v.add(o);
					}				
				} catch (SQLException e) {
					System.out.println("����SQL���ʱ���ִ���");
						e.printStackTrace();
				}finally{
					dataAccess.closeconn(conn, stat, null, rs);		
		     	}
				return v;
		    }
		 
		 
		 public Vector<orderformDTO> findmyorderform1(String clientID)  {
				Vector<orderformDTO> v = new Vector<orderformDTO>();
				Connection conn = null;
				Statement stat = null;
				ResultSet rs = null;
				try {
					conn = dataAccess.getConnection();
					stat = conn.createStatement(); //����sql������ִ��
					String sql = "select * from orderform where clientID='"+clientID+"'";
					rs = stat.executeQuery(sql);
					while(rs.next()){//��������
						orderformDTO o = new orderformDTO();
						o.setClientID(rs.getString("clientID"));
						o.setTicketID(rs.getString("ticketID"));
						o.setNumber(rs.getString("number"));
						o.setState(rs.getString("state"));
						v.add(o);
					}				
				} catch (SQLException e) {
					System.out.println("����SQL���ʱ���ִ���");
						e.printStackTrace();
				}finally{
					dataAccess.closeconn(conn, stat, null, rs);		
		     	}
				return v;
		    }
		 
		 public Vector<orderformDTO> findmyorderformbyid(String clientID)  {
				Vector<orderformDTO> v = new Vector<orderformDTO>();
				Connection conn = null;
				Statement stat = null;
				ResultSet rs = null;
				PreparedStatement prpstmt = null;	
				try {
					conn = dataAccess.getConnection();
					String sql = "select * from orderform";
					 prpstmt = conn.prepareStatement("select * from orderform where clientID=?");
					 prpstmt.setString(1,clientID);
					rs = prpstmt.executeQuery();
					while(rs.next()){//��������
						orderformDTO o = new orderformDTO();
						o.setClientID(rs.getString("clientID"));
						o.setTicketID(rs.getString("ticketID"));
						o.setNumber(rs.getString("number"));
						o.setState(rs.getString("state"));
						v.add(o);
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
