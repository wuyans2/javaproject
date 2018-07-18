package cn.edu.lingnan.servlets;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.lingnan.dao.TicketDAO;
import cn.edu.lingnan.dto.TicketDTO;



public class UpdateticketServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String ticketID = req.getParameter("ticketID");
		String offtime = req.getParameter("offtime");
		String falltime = req.getParameter("falltime");
		//String address = req.getParameter("address");
		String address = new String(req.getParameter("address").getBytes("ISO-8859-1"),"GB2312");
		String price = req.getParameter("price");
		String surplus = req.getParameter("surplus");
		String state =req.getParameter("state");
		System.out.println(ticketID+"  "+offtime+"  "+falltime+"  "+address);
		TicketDAO t = new TicketDAO();
		TicketDTO tdto = new TicketDTO();
		tdto.setTicketID(ticketID);
		tdto.setOfftime(offtime);
		tdto.setFalltime(falltime);
		tdto.setAddress(address);
		tdto.setPrice(price);
		tdto.setSurplus(surplus);
		tdto.setState(state);
		boolean flag = t.updateticket(tdto);
		Vector<TicketDTO> v = new Vector<TicketDTO>();
		v = t.findAllTicket();	
		HttpSession s = req.getSession();
		s.setAttribute("allticket", v);
		resp.sendRedirect("showAllticket.jsp");			
	}
}

