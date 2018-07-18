package cn.edu.lingnan.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AuthorityFilter implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub
		
	}
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		//�жϵ�¼�û���Ȩ����ʲô������ǳ����û�����ô����ȥ��adminĿ¼�µĽ��棬����ȥ��Ȩ�޴���Ľ���
		HttpServletRequest request = (HttpServletRequest)arg0;
		HttpServletResponse response = (HttpServletResponse) arg1;
		HttpSession s = request.getSession();
		//String superValue = (String )s.getAttribute("superValue");
		Integer superValue = (Integer)s.getAttribute("superValue");
		System.out.println("--3--"+superValue); //���ڹ����������Ƿ����Value���ֵ
		if(superValue!=null){
//			if(superValue.equals("0"+superValue))
			if(superValue==0){
				System.out.println("--4--");
				response.sendRedirect(request.getContextPath()+"/index.html");
			}
			else 
//				if(superValue.equals("1"))
				if(superValue==1)
					arg2.doFilter(arg0, arg1);
				else
					response.sendRedirect(request.getContextPath()+"/authority.html");		  
		}
		else
		response.sendRedirect(request.getContextPath()+"/index.html");
	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
