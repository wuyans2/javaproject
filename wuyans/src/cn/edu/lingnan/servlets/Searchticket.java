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


public class Searchticket extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		TicketDAO t=new TicketDAO();
		  Vector<TicketDTO> v=new Vector<TicketDTO>();
		 //String address = req.getParameter("address");
		  String address = new String(req.getParameter("address").getBytes("ISO-8859-1"),"GB2312");
			System.out.println(address);
	      v =t.findAllTicketbyaddress(address);
	    HttpSession s = req.getSession(); //在前端可用这个session,session是对每个用户而言
	    s.setAttribute("search1", v); //东西都放到这里，前面就可以用了	    	
	    resp.sendRedirect("searchticket.jsp");//查找完了之后，把页面切过去，去jsp页面
	}

}
