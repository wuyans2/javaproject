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

public class InsertclientServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String clientID = req.getParameter("clientID");
		String name = new String(req.getParameter("name").getBytes("ISO-8859-1"),"GB2312");
		//String name = req.getParameter("name");
		String tel = req.getParameter("tel");
		String password = req.getParameter("password");
		int superuser = Integer.parseInt(req.getParameter("superuser"));
		int state = Integer.parseInt(req.getParameter("state"));
		System.out.println(clientID+"  "+name+"  "+tel+"  "+password);
		clientDAO c = new clientDAO();
		clientDTO cdto = new clientDTO();
		cdto.setClientID(clientID);
		cdto.setName(name);
		cdto.setTel(tel);
		cdto.setPassword(password);
		cdto.setSuperuser(superuser);
		cdto.setState(state);
		boolean flag = c.registerIntoclient(cdto);
		Vector<clientDTO> v = new Vector<clientDTO>();
		v = c.findAllclient();	
		HttpSession s = req.getSession();
		s.setAttribute("alluser", v);
		resp.sendRedirect("showAllUser.jsp");
		
	}
}


