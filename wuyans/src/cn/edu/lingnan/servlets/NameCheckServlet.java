package cn.edu.lingnan.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.lingnan.dao.clientDAO;

public class NameCheckServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
    		throws ServletException, IOException {
        String username = req.getParameter("username");
        clientDAO c = new clientDAO();
        boolean flag = c.findclientByName(username);
        if(flag)
        	resp.getWriter().print(true);
        
    }

}
