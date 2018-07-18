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
	    HttpSession s = req.getSession(); //在前端可用这个session,session是对每个用户而言
	    s.setAttribute("search2", v); //东西都放到这里，前面就可以用了	    	
	    resp.sendRedirect("searchorder.jsp");//查找完了之后，把页面切过去，去jsp页面

	}

}
