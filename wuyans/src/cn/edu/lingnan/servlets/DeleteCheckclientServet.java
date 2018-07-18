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

public class DeleteCheckclientServet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
	       String[] arr =  req.getParameterValues("arr");
	      clientDAO c = new clientDAO();
	      
	       for(String a :arr){
	    	   String[] b = a.split(",");
	    	   for(String d : b)
	    		   c.deleteclientBuId(d);
	       }  
			Vector<clientDTO> v = new Vector<clientDTO>();
			v = c.findAllclient();	
			HttpSession s = req.getSession();
			s.setAttribute("alluser", v);
			resp.sendRedirect("showAllUser.jsp");
	}

}
