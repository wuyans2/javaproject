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

public class UpdateorderformServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String clientID = req.getParameter("clientID");
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
		boolean flag = o.updateorderform(odto);
		Vector<orderformDTO> v = new Vector<orderformDTO>();
		v = o.findAllorderform();	
		HttpSession s = req.getSession();
		s.setAttribute("allorderform", v);
		resp.sendRedirect("showAllorderform.jsp");			
	}
}
