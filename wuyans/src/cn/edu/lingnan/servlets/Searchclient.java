package cn.edu.lingnan.servlets;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.lingnan.dao.clientDAO;
import cn.edu.lingnan.dto.clientDTO;


public class Searchclient extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		clientDAO sf=new clientDAO();
		  Vector<clientDTO> v=new Vector<clientDTO>();
		  //String name = req.getParameter("name");
		  String name = new String(req.getParameter("name").getBytes("ISO-8859-1"),"GB2312");
			System.out.println(name);
	      v = sf.findAllclienbyName(name);
	    HttpSession s = req.getSession(); //��ǰ�˿������session,session�Ƕ�ÿ���û�����
	    s.setAttribute("search", v); //�������ŵ����ǰ��Ϳ�������	    	
	    resp.sendRedirect("searchclient.jsp");//��������֮�󣬰�ҳ���й�ȥ��ȥjspҳ��

	}

}
