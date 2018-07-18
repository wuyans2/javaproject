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

public class Order extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		HttpSession s = req.getSession();
		String clientID = (String)s.getAttribute("clientID");
//		String clientID = req.getParameter("clientID");
		String ticketID = req.getParameter("ticketID");
		String number = req.getParameter("number");
		String state = req.getParameter("state");
		System.out.println(ticketID+"  "+clientID+"  "+number+"  "+state);
		orderformDAO o = new orderformDAO();
		orderformDTO odto = new orderformDTO();
		odto.setClientID(clientID);
		odto.setTicketID(ticketID);
		odto.setNumber(number);
		odto.setState(state);
		boolean flag = o.Insertorderform1(odto);
		Vector<orderformDTO> v = new Vector<orderformDTO>();
		v = o.findmyorderform1(clientID);
//		HttpSession s = req.getSession();
		s.setAttribute("order", v);
		resp.sendRedirect("myorderform.jsp");			
	}


}
