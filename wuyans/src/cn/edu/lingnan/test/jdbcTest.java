package cn.edu.lingnan.test;

import java.util.Scanner;
import java.util.Vector;

import cn.edu.lingnan.dao.TicketDAO;
import cn.edu.lingnan.dao.clientDAO;
import cn.edu.lingnan.dao.orderformDAO;
import cn.edu.lingnan.dto.TicketDTO;
import cn.edu.lingnan.dto.clientDTO;
import cn.edu.lingnan.dto.orderformDTO;

public class jdbcTest {

	public static void main(String[] args) {	
		
		int m =1;
		while(m<2){
		System.out.println("------------------------------");
		System.out.println("1.查看全部用户表         2.根据ID查找用户        3.插入用户 ");
		System.out.println("4.修改用户名                  5.删除用户                   6.查看全部订单");
		System.out.println("7.根据用户ID查找订单    8.购买机票                 9.修改机票数量");
		System.out.println("10.删除订单                 11.查看机票信息           12.根据用户ID查找机票");
		System.out.println("13.删除机票                  14.增加机票                  15.修改机票价格");
		System.out.println("-------------------------------");
		System.out.println("请选择：");
		Scanner reader=new Scanner(System.in);
		String id,name,tel,password;
	    String tid;
		int superuser,state;
		String clientID,ticketID;
		int number;
		String offtime,falltime,address;
		int price,surplus,addprice;
		Vector<clientDTO> v = new Vector<clientDTO>();
		clientDAO c = new clientDAO();
		Vector<orderformDTO> v1 = new Vector<orderformDTO>();
		orderformDAO o = new orderformDAO();
		Vector<TicketDTO> v2 = new Vector<TicketDTO>();
		TicketDAO t = new TicketDAO();
		orderformDTO oto = new orderformDTO();
		int a;
		a = reader.nextInt();
		switch(a)
		{
		case 1:{
			v = c.findAllclientTnfo();
		    for(clientDTO sd : v)
			     System.out.println("用户Id:"+sd.getClientID()+"  "+"用户名:"+ sd.getName()+"  "+"电话:"+ sd.getTel());
		    break;
		}
		case 2:{
			Scanner reader1=new Scanner(System.in);
			System.out.println("请输入要查找的clientID：");
			id = reader1.nextLine();		
			c.findclientbyID(id);
			break;
		}
		case 3:{
			Scanner reader2=new Scanner(System.in);
			System.out.println("请输入要插入的用户id");
			id = reader2.nextLine();
			System.out.println("请输入要插入的用户名");
			name = reader2.nextLine();
			System.out.println("请输入要插入的用户电话");
			tel = reader2.nextLine();
			System.out.println("请输入要插入的用户密码");
			password = reader2.nextLine();
			System.out.println("请输入要插入的用户权限");
			superuser = reader2.nextInt();
			System.out.println("请输入要插入的用户状态");
			state = reader2.nextInt();
			c.InsertIntoclient(id, name, tel, password, superuser,state);	
		    break;
		}
		case 4:{
			Scanner reader3=new Scanner(System.in);
			System.out.println("请输入要修改用户名的用户id：");
			id = reader3.nextLine();
			System.out.println("请输入新的用户名：");
			name = reader3.nextLine();
			c.Updateclient(id, name);
			break;
		}
		case 5:{
			Scanner reader4=new Scanner(System.in);
			System.out.println("请输入要删除的用户id：");
			id = reader4.nextLine();
			c.deleteclientBuId(id);
			break;
		}
		case 6:{
			v1 = o.findAllorderformTnfo();
			for(orderformDTO sd : v1)
			System.out.println("用户Id:"+sd.getClientID()+"  "+"机票Id:"+ sd.getTicketID()+"  "+"数量:"+sd.getNumber());
			break;
		}
		case 7:{
			Scanner reader5=new Scanner(System.in);
			System.out.println("请输入要查找的clientID：");
			clientID = reader5.nextLine();		
			o.findorderformbyID(clientID);
			break;
		}
		case 8:{
			Scanner reader6=new Scanner(System.in);
			System.out.println("请输入用户ID：");
			clientID = reader6.nextLine();
			System.out.println("请输入要购买的机票ID：");
			ticketID = reader6.nextLine();
			System.out.println("请输入要购买的机票数量：");
			number = reader6.nextInt();
			System.out.println("请输入要购买的状态：");
			state = reader6.nextInt();
			o.InsertIntoorderform(clientID, ticketID, number,state);
			break;
		}
		case 9:{
			Scanner reader7=new Scanner(System.in);
			System.out.println("请输入要修改用户名的用户id：");
			clientID = reader7.nextLine();
			System.out.println("请输入要修改用户名的机票id：");
			ticketID = reader7.nextLine();
			System.out.println("请输入要修改的机票数量：");
			number = reader7.nextInt();
			o.Updateorderform(number, clientID, ticketID);
			break;
		}
		case 10:{
			Scanner reader8=new Scanner(System.in);
			System.out.println("请输入要删除用户id：");
			clientID = reader8.nextLine();
			System.out.println("请输入删除机票id：");
			ticketID = reader8.nextLine();
			o.deleteorderformByIdAndTicketID(clientID, ticketID);
			break;
		}
		case 11:{
			v2 = t.findAllTicketTnfo();
		    for(TicketDTO sd : v2)
			     System.out.println("机票ID:"+sd.getTicketID()+"  "+"起飞时间:"+ sd.getOfftime()+
			    		 "  "+"降落时间:"+ sd.getFalltime()+"  "+"目的地:"+ sd.getAddress()+"  "+"价格:"+ sd.getPrice());
		    break;
		}
		case 12:{
			Scanner reader9=new Scanner(System.in);
			System.out.println("请输入要查找的ticketID：");
			ticketID = reader9.nextLine();		
			t.findticketbyID(ticketID);
			break;
		}
		case 13:{
			Scanner reader10=new Scanner(System.in);
			System.out.println("请输入要删除的机票ID：");
			tid = reader10.nextLine();		
			t.deleteticketBuId(tid);
//			t.deleteticketBuId1(tid);
			break;
		}
		case 14:{
			Scanner reader11=new Scanner(System.in);
			System.out.println("请输入要插入的机票id：");
			ticketID = reader11.nextLine();
			System.out.println("请输入起飞时间：");
			offtime = reader11.nextLine();
			System.out.println("请输入降落时间：");
			falltime = reader11.nextLine();
			System.out.println("请输入目的地：");
			address = reader11.nextLine();
			System.out.println("请输入机票价格：");
			price = reader11.nextInt();
			System.out.println("请输入总数量：");
			surplus = reader11.nextInt();
			System.out.println("请输入要插入的用户状态：");
			state = reader11.nextInt();
			t.InsertIntoticket(ticketID, offtime, falltime, address, price, surplus, state);
		    break;
		}
		case 15:{
			Scanner reader12=new Scanner(System.in);
			System.out.println("请输入要修改价格的机票ID：");
			ticketID = reader12.nextLine();
			System.out.println("请输入新价格：");
			price = reader12.nextInt();
			t.Updateticket(price, ticketID);
			break;
		}
		case 18:{
			Scanner reader13=new Scanner(System.in);
			System.out.println("请输入用户ID：");
			clientID = reader13.nextLine();
			System.out.println("请输入要购买的机票ID：");
			ticketID = reader13.nextLine();
			System.out.println("请输入要购买的机票数量：");
			number = reader13.nextInt();
			//o.Insertorderform(oto);
			break;
		}
		
		case 16:{
			Scanner reader13=new Scanner(System.in);
			System.out.println("请输入用户ID：");
			clientID = reader13.nextLine();
			System.out.println("请输入要购买的机票ID：");
			ticketID = reader13.nextLine();
			System.out.println("请输入要购买的机票数量：");
			number = reader13.nextInt();
			System.out.println("请输入：");
			number = reader13.nextInt();
			o.Insertorderform1(oto);
			break;
		}
		
		default : System.out.println("没有该选项，请重新输入");
		    break;
		}
		
		}			
		
	}

}
