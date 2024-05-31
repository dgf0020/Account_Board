package com.itbank.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.itbank.vo.AccountVO;

/*
	Interceptor
	 - 요청을 가로채서 필요한 처리를 하기 위한 Spring 객체 (bean)
	 - Controller로 넘어가기 전, Controller 수행 후, 클라이언트에 전달된 후 -> 3가지를 처리 가능
	
	작동 시점)
	1. preHandle		요청이 Controller로 넘어가기 전에 가로챈다	(가장 많이 쓴다)
	2. postHandle		Controller 메서드가 수행된 후 가로챈다	(주로 디버깅용으로 쓴다)
	3. afterCompletion	응답이 클라이언트에 전달된 후 수행			(주로 디버깅용으로 쓴다)
	
	요청을 가로챔 -> servlet-context에 적어준다
 */

public class LoginInterceptor extends HandlerInterceptorAdapter {

	// preHandle
	// - true를 반환하면 요청한 Controller로 이어 진행
	// - false를 반환하면 Controller로 전달하지 않고 종료
	// (/write, /myPage가 Controller로 넘어가기 전에 가로채서 로그인이 되어있는지 확인. 로그인이 되어있으면 true, 로그인이 되어있지 않으면 false를 반환)
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//System.out.println("인터셉터 실행!!!");
		
		// 최상위 경로를 가져온다
		String cpath = request.getContextPath();
		
		// 세션을 가져온다
		HttpSession session = request.getSession();
		
		// 세션에서 user(= 로그인된 계정)을 가져온다
		AccountVO user = (AccountVO) session.getAttribute("user");	// getAttribute가 object로 꺼내주니까 다운캐스팅해줘야한다
		
		// 로그인 상태가 아니면
		if (user == null) {
			response.sendRedirect(cpath + "/account/login");
			
			return false;		// false면 원래 진행하려던 Controller를 수행하지 않는다
		}
		
		return true;			// true면 원래 진행하려던 Controller를 수행한다
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		super.afterCompletion(request, response, handler, ex);
	}
	
}
