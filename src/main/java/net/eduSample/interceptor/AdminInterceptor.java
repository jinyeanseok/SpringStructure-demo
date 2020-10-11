package net.eduSample.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import net.eduSample.common.vo.UserVO;

public class AdminInterceptor extends HandlerInterceptorAdapter {

	 @Override
	 public boolean preHandle(HttpServletRequest req,
	    HttpServletResponse res, Object obj) throws Exception {
	  
	  HttpSession session = req.getSession();
	  UserVO user = (UserVO)session.getAttribute("user");
	  
	  if(user == null || user.getVerify() != 9) {
//	  if(user.getVerify() != 9) {
	   res.sendRedirect("/login/form");
	   return false;
	  }
	  
	  return true;
	 }
}
