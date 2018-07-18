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

public class Findmyself extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String name = req.getParameter("name");
		System.out.println(name);
		System.out.println("11111");
		clientDAO c = new clientDAO();
		Vector<clientDTO> v = new Vector<clientDTO>();
		v = c.findclientbyname(name);	
		HttpSession s = req.getSession();
		s.setAttribute("user", v);
		resp.sendRedirect("showmyself.jsp");
	}

}
