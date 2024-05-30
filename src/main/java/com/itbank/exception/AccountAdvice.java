package com.itbank.exception;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

// servlet-context.xml에 component-scan해줘야한다

@ControllerAdvice		// 예외를 받아 처리할 스프링 객체
public class AccountAdvice {

	@ExceptionHandler(LoginException.class)		// 처리할 예외 클래스를 명시
	public ModelAndView failLogin(LoginException e) {
		// 1. 예외 정보를 활용하려면 매개변수에 변수를 작성하면 되고
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("row", 0);
		mav.addObject("data", e.getMessage());
		mav.setViewName("message");

		
		return mav;
	}
				// DB구문을 실행할 때 예외발생 : DAO -> service -> controller 순으로 예외 전가됨
				// 					advice가 없으면 -> 에러페이지를 띄움
				//					advice가 있으면 -> advice가 예외를 받아서 처리한다
	@ExceptionHandler(DuplicateKeyException.class)
	public ModelAndView failSignUp() {
		// 2. 딱히 필요 없으면 생략 가능
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("row", 0);
		mav.addObject("data", "이미 가입된 정보입니다");
		mav.setViewName("message");
		
		return mav;
	}

}
