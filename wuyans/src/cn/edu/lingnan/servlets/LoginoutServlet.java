package cn.edu.lingnan.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.lingnan.dao.clientDAO;

public class LoginoutServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//1�����ݽ��ȥ����Ӧ��ҳ��
		System.out.println("�Ѿ�ע���ˡ�������");
		HttpSession s = req.getSession();
		s.invalidate();
			resp.sendRedirect(req.getContextPath()+"/index.html");
	}

}
