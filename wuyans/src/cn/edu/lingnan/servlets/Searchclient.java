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
	    HttpSession s = req.getSession(); //在前端可用这个session,session是对每个用户而言
	    s.setAttribute("search", v); //东西都放到这里，前面就可以用了	    	
	    resp.sendRedirect("searchclient.jsp");//查找完了之后，把页面切过去，去jsp页面

	}

}
