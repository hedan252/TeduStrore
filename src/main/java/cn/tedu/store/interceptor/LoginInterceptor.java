package cn.tedu.store.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor  implements HandlerInterceptor{

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)throws Exception {
		HttpSession session=request.getSession();
		//日志
		System.out.println("LoginInterceptor");
		System.out.println("\t"+request.getServletPath());
		if(session.getAttribute("uid")!=null) {
			//session中有uid则是登陆的，则放行
			//日志
			System.out.println("\n已经登录，放行");
			return true;
		}else {
			//session中没有uid,表示没有登录，或登录已经过期，则重定向
			String url=request.getContextPath()+"/user/login.do";
			//日志
			System.out.println("\t没登录 已拦截，重定向"+url);
			
			response.sendRedirect(url);
			
			return false;
		}
		
	}

	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		
	}

	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

}
