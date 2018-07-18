package cn.edu.lingnan.servlets;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.lingnan.dao.TicketDAO;
import cn.edu.lingnan.dao.orderformDAO;
import cn.edu.lingnan.dto.TicketDTO;
import cn.edu.lingnan.dto.orderformDTO;

public class FindAllorderform extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		orderformDAO o = new orderformDAO();
		Vector<orderformDTO> v = new Vector<orderformDTO>();
		v =o.findAllorderform();	
		HttpSession s = req.getSession();
		s.setAttribute("allorderform", v);
		resp.sendRedirect("showAllorderform.jsp");
	}
}
