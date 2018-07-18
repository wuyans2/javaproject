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



public class DeleteCheckorderformServet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//System.out.println("vvv");
	       String[] arr =  req.getParameterValues("arr");
	      orderformDAO o = new orderformDAO();
	     // System.out.println(arr);
	       for(String a :arr){
	    	   String[] b = a.split(",");
	    	     String m=null;
	    	     String n=null;
	    		   for(int i=0;i<b.length;i=i+2){
	    			   m=b[i];
	    			   n=b[i+1];
	    			   System.out.println(m+"-----"+n);
	    			   o.deleteorderformByIdAndTicketID(m,n);
	    		   } 
	    		 
	       }  
			Vector<orderformDTO> v = new Vector<orderformDTO>();
			v = o.findAllorderform();	
			HttpSession s = req.getSession();
			s.setAttribute("allorderform", v);
			resp.sendRedirect("showAllorderform.jsp");
	}
}

