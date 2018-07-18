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

public class Myorderform extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		HttpSession s = req.getSession();
		String clientID = (String)s.getAttribute("clientID");
		orderformDAO o = new orderformDAO();
		Vector<orderformDTO> v = new Vector<orderformDTO>();
		v = o.findmyorderform1(clientID);
		s.setAttribute("order", v);
		resp.sendRedirect("myorderform.jsp");	
	}

}
