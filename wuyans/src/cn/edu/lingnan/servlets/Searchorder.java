package cn.edu.lingnan.servlets;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.lingnan.dao.orderformDAO;
import cn.edu.lingnan.dto.orderformDTO;


public class Searchorder extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		orderformDAO sf=new orderformDAO();
		  Vector<orderformDTO> v=new Vector<orderformDTO>();
		  String clientID = req.getParameter("clientID");
			System.out.println(clientID);
	      v = sf.findmyorderformbyid(clientID);
	    HttpSession s = req.getSession(); //��ǰ�˿������session,session�Ƕ�ÿ���û�����
	    s.setAttribute("search2", v); //�������ŵ����ǰ��Ϳ�������	    	
	    resp.sendRedirect("searchorder.jsp");//��������֮�󣬰�ҳ���й�ȥ��ȥjspҳ��

	}

}
