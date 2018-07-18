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
		//判断登录用户的权限是什么，如果是超级用户，那么可以去到admin目录下的界面，否则去到权限错误的界面
		HttpServletRequest request = (HttpServletRequest)arg0;
		HttpServletResponse response = (HttpServletResponse) arg1;
		HttpSession s = request.getSession();
		//String superValue = (String )s.getAttribute("superValue");
		Integer superValue = (Integer)s.getAttribute("superValue");
		System.out.println("--3--"+superValue); //我在过滤器里面是否读到Value这个值
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
