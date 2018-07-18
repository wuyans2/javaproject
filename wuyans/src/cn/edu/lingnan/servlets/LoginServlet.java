package cn.edu.lingnan.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.lingnan.dao.clientDAO;

public class LoginServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//1����ҳ���ȡ������Ҫ������
		String name =null;
		String password = null;
		//name = req.getParameter("username");
		 name = new String(req.getParameter("username").getBytes("ISO-8859-1"),"GB2312");
		password = req.getParameter("password");
		System.out.println("1:"+name+"  "+password);

		//2�����ú�̨��ҵ���߼�ȥ�ж�����û����������Ƿ��������ȷ
		clientDAO sd = new clientDAO();
//		Boolean flag = sd.findclientByNameAndPassword(name, password);
		int superValue= sd.findclientByNameAndPassword(name, password);
		String clientID = sd.findclientByNandP(name, password);
		String tel = sd.findclientByNP(name, password);
		Integer b =1;
		System.out.println("--2--:"+superValue);
		HttpSession s = req.getSession();
		s.setAttribute("superValue", superValue);
		//s.setAttribute("clientID", "001");
		s.setAttribute("name",name);
		s.setAttribute("password", password);
		s.setAttribute("clientID", clientID);
		s.setAttribute("tel", tel);
		
		//3�����ݽ��ȥ����Ӧ��ҳ��
		if(superValue==1){
			resp.sendRedirect(req.getContextPath()+"/admin/admin.html");
		}
		else if(superValue!=0)
			resp.sendRedirect(req.getContextPath()+"/OK.html");
		else 
			resp.sendRedirect(req.getContextPath()+"/error.html");
	}

}
