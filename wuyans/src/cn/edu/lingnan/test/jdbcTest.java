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
		System.out.println("1.�鿴ȫ���û���         2.����ID�����û�        3.�����û� ");
		System.out.println("4.�޸��û���                  5.ɾ���û�                   6.�鿴ȫ������");
		System.out.println("7.�����û�ID���Ҷ���    8.�����Ʊ                 9.�޸Ļ�Ʊ����");
		System.out.println("10.ɾ������                 11.�鿴��Ʊ��Ϣ           12.�����û�ID���һ�Ʊ");
		System.out.println("13.ɾ����Ʊ                  14.���ӻ�Ʊ                  15.�޸Ļ�Ʊ�۸�");
		System.out.println("-------------------------------");
		System.out.println("��ѡ��");
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
			     System.out.println("�û�Id:"+sd.getClientID()+"  "+"�û���:"+ sd.getName()+"  "+"�绰:"+ sd.getTel());
		    break;
		}
		case 2:{
			Scanner reader1=new Scanner(System.in);
			System.out.println("������Ҫ���ҵ�clientID��");
			id = reader1.nextLine();		
			c.findclientbyID(id);
			break;
		}
		case 3:{
			Scanner reader2=new Scanner(System.in);
			System.out.println("������Ҫ������û�id");
			id = reader2.nextLine();
			System.out.println("������Ҫ������û���");
			name = reader2.nextLine();
			System.out.println("������Ҫ������û��绰");
			tel = reader2.nextLine();
			System.out.println("������Ҫ������û�����");
			password = reader2.nextLine();
			System.out.println("������Ҫ������û�Ȩ��");
			superuser = reader2.nextInt();
			System.out.println("������Ҫ������û�״̬");
			state = reader2.nextInt();
			c.InsertIntoclient(id, name, tel, password, superuser,state);	
		    break;
		}
		case 4:{
			Scanner reader3=new Scanner(System.in);
			System.out.println("������Ҫ�޸��û������û�id��");
			id = reader3.nextLine();
			System.out.println("�������µ��û�����");
			name = reader3.nextLine();
			c.Updateclient(id, name);
			break;
		}
		case 5:{
			Scanner reader4=new Scanner(System.in);
			System.out.println("������Ҫɾ�����û�id��");
			id = reader4.nextLine();
			c.deleteclientBuId(id);
			break;
		}
		case 6:{
			v1 = o.findAllorderformTnfo();
			for(orderformDTO sd : v1)
			System.out.println("�û�Id:"+sd.getClientID()+"  "+"��ƱId:"+ sd.getTicketID()+"  "+"����:"+sd.getNumber());
			break;
		}
		case 7:{
			Scanner reader5=new Scanner(System.in);
			System.out.println("������Ҫ���ҵ�clientID��");
			clientID = reader5.nextLine();		
			o.findorderformbyID(clientID);
			break;
		}
		case 8:{
			Scanner reader6=new Scanner(System.in);
			System.out.println("�������û�ID��");
			clientID = reader6.nextLine();
			System.out.println("������Ҫ����Ļ�ƱID��");
			ticketID = reader6.nextLine();
			System.out.println("������Ҫ����Ļ�Ʊ������");
			number = reader6.nextInt();
			System.out.println("������Ҫ�����״̬��");
			state = reader6.nextInt();
			o.InsertIntoorderform(clientID, ticketID, number,state);
			break;
		}
		case 9:{
			Scanner reader7=new Scanner(System.in);
			System.out.println("������Ҫ�޸��û������û�id��");
			clientID = reader7.nextLine();
			System.out.println("������Ҫ�޸��û����Ļ�Ʊid��");
			ticketID = reader7.nextLine();
			System.out.println("������Ҫ�޸ĵĻ�Ʊ������");
			number = reader7.nextInt();
			o.Updateorderform(number, clientID, ticketID);
			break;
		}
		case 10:{
			Scanner reader8=new Scanner(System.in);
			System.out.println("������Ҫɾ���û�id��");
			clientID = reader8.nextLine();
			System.out.println("������ɾ����Ʊid��");
			ticketID = reader8.nextLine();
			o.deleteorderformByIdAndTicketID(clientID, ticketID);
			break;
		}
		case 11:{
			v2 = t.findAllTicketTnfo();
		    for(TicketDTO sd : v2)
			     System.out.println("��ƱID:"+sd.getTicketID()+"  "+"���ʱ��:"+ sd.getOfftime()+
			    		 "  "+"����ʱ��:"+ sd.getFalltime()+"  "+"Ŀ�ĵ�:"+ sd.getAddress()+"  "+"�۸�:"+ sd.getPrice());
		    break;
		}
		case 12:{
			Scanner reader9=new Scanner(System.in);
			System.out.println("������Ҫ���ҵ�ticketID��");
			ticketID = reader9.nextLine();		
			t.findticketbyID(ticketID);
			break;
		}
		case 13:{
			Scanner reader10=new Scanner(System.in);
			System.out.println("������Ҫɾ���Ļ�ƱID��");
			tid = reader10.nextLine();		
			t.deleteticketBuId(tid);
//			t.deleteticketBuId1(tid);
			break;
		}
		case 14:{
			Scanner reader11=new Scanner(System.in);
			System.out.println("������Ҫ����Ļ�Ʊid��");
			ticketID = reader11.nextLine();
			System.out.println("���������ʱ�䣺");
			offtime = reader11.nextLine();
			System.out.println("�����뽵��ʱ�䣺");
			falltime = reader11.nextLine();
			System.out.println("������Ŀ�ĵأ�");
			address = reader11.nextLine();
			System.out.println("�������Ʊ�۸�");
			price = reader11.nextInt();
			System.out.println("��������������");
			surplus = reader11.nextInt();
			System.out.println("������Ҫ������û�״̬��");
			state = reader11.nextInt();
			t.InsertIntoticket(ticketID, offtime, falltime, address, price, surplus, state);
		    break;
		}
		case 15:{
			Scanner reader12=new Scanner(System.in);
			System.out.println("������Ҫ�޸ļ۸�Ļ�ƱID��");
			ticketID = reader12.nextLine();
			System.out.println("�������¼۸�");
			price = reader12.nextInt();
			t.Updateticket(price, ticketID);
			break;
		}
		case 18:{
			Scanner reader13=new Scanner(System.in);
			System.out.println("�������û�ID��");
			clientID = reader13.nextLine();
			System.out.println("������Ҫ����Ļ�ƱID��");
			ticketID = reader13.nextLine();
			System.out.println("������Ҫ����Ļ�Ʊ������");
			number = reader13.nextInt();
			//o.Insertorderform(oto);
			break;
		}
		
		case 16:{
			Scanner reader13=new Scanner(System.in);
			System.out.println("�������û�ID��");
			clientID = reader13.nextLine();
			System.out.println("������Ҫ����Ļ�ƱID��");
			ticketID = reader13.nextLine();
			System.out.println("������Ҫ����Ļ�Ʊ������");
			number = reader13.nextInt();
			System.out.println("�����룺");
			number = reader13.nextInt();
			o.Insertorderform1(oto);
			break;
		}
		
		default : System.out.println("û�и�ѡ�����������");
		    break;
		}
		
		}			
		
	}

}
