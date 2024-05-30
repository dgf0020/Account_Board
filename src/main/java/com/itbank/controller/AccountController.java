package com.itbank.controller;

import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.exception.LoginException;
import com.itbank.service.AccountService;
import com.itbank.vo.AccountVO;

@Controller
@RequestMapping("/account")
public class AccountController {

	@Autowired
	private AccountService as;
	
	// 모든 Account 테이블을 가져온다
	@GetMapping
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("list", as.getAccounts());
		mav.setViewName("account/list");
		
		return mav;
	}
	
	// 로그인 폼
	@GetMapping("/login")
	public void login() {}
	
	// 로그인 수행 - 실패시 예외 발생
	@PostMapping("/login")
	public String login(AccountVO input, HttpSession session) throws LoginException, NoSuchAlgorithmException {
		// session : 웹브라우저 종료시까지 유지되는 객체. 주로 로그인 유지에 사용
		
		session.setAttribute("user", as.login(input));
									// null이되면 Attribute가 만들어지지 않는다
		
		return "redirect:/";
	}
	
	// 로그아웃 수행
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("user");
		
		return "redirect:/";
	}
	
	// 회원가입 폼
	@GetMapping("/signUp")
	public void signUp() {}
	
	// 회원가입 수행
	@PostMapping("/signUp")
	public String signUp(AccountVO input) 
			throws NoSuchAlgorithmException {
		as.addAccount(input);
		
		return "redirect:/";
	}
	
	// 마이페이지
	@GetMapping("/myPage")
	public String myPage(HttpSession session) {
		AccountVO user = (AccountVO) session.getAttribute("user");
						// Object로 반환되므로 다운캐스팅해준다
		
		if (user == null) {
			return "redirect:/account/login";
		}
		
		return "account/myPage";
	}
	
	@GetMapping("/update/{idx}")
	public ModelAndView view(@PathVariable int idx) {
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("row", as.getAccountOne(idx));
		mav.setViewName("account/update");
		
		return mav;
	}
	
	@PostMapping("/update/{idx}")
	public String update(AccountVO input) throws NoSuchAlgorithmException {
		as.update(input);
		
		return "account/myPage";
	}
	
	@GetMapping("/delete/{idx}")
	public String delete(@PathVariable int idx, HttpSession session) {
		as.delete(idx);
		
		session.removeAttribute("user");
		
		return "redirect:/";
	}
}
