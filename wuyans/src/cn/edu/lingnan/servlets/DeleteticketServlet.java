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

public class DeleteticketServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String ticketID = req.getParameter("ticketID");
		TicketDAO t = new TicketDAO();
		boolean flag = t.deleteticketBuId(ticketID);	
		Vector<TicketDTO> v = new Vector<TicketDTO>();
		v = t.findAllTicket();	
		HttpSession s = req.getSession();
		s.setAttribute("allticket", v);
		resp.sendRedirect("showAllticket.jsp");
	}
}
