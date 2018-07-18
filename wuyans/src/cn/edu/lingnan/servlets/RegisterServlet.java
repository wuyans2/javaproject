package cn.edu.lingnan.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.lingnan.dao.clientDAO;
import cn.edu.lingnan.dto.clientDTO;

public class RegisterServlet extends HttpServlet {
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
		//1����ҳ���ȡ������Ҫ������
	    String clientID=null;
		String name =null;
		String tel=null;
		String password = null;
		int superuser=0;
		int state=0;
		clientID = req.getParameter("clientID");
		name = new String(req.getParameter("username").getBytes("ISO-8859-1"),"GB2312");
		//name = req.getParameter("username");
		tel = req.getParameter("tel");
		password = req.getParameter("password");
		superuser = Integer.parseInt(req.getParameter("superuser"));
		state = Integer.parseInt(req.getParameter("state"));
		System.out.println("1:"+clientID+"  "+name+"  "+tel+"  "+password+"   "+superuser);
	
		//2�����ú�̨��ҵ���߼�ȥ�ж�����û����������Ƿ��������ȷ
		clientDAO sd = new clientDAO();
		clientDTO sdto = new clientDTO();
		sdto.setClientID(clientID);
		sdto.setName(name);
		sdto.setTel(tel);
		sdto.setPassword(password);
		sdto.setSuperuser(superuser);
		sdto.setState(state);
	    boolean flag = sd.registerIntoclient(sdto);
		//3�����ݽ��ȥ����Ӧ��ҳ��
		if(flag)
			resp.sendRedirect(req.getContextPath()+"/index.html");
		else 
			resp.sendRedirect(req.getContextPath()+"/error.html");
	}

}

