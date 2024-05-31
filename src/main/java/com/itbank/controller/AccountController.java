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
	public void myPage() {}
	
	// 회원정보 수정 폼
	@GetMapping("/update/{idx}")
	public String view(@PathVariable int idx) {
					// 주소창에 있는 값을 받을 떄
		return "account/update";
	}
	
	// 회원정보 수정 수행
	@PostMapping("/update/{idx}")
	public String update(AccountVO input) throws NoSuchAlgorithmException {
					// VO는 @PathVariable적어줄 필요 없음
		as.upAccount(input);
		
		return "redirect:/account/logout";
		// 회원정보 수정 후 다시 로그인하도록 하기위해서 로그아웃시켜줌
	}
	
	// 회원탈퇴
	@GetMapping("/delete/{idx}")
	public String delete(@PathVariable int idx) {
		as.delAccount(idx);
		
		return "redirect:/account/logout";
	}
	
	// id/pw 찾기 폼
	@GetMapping("/find")
	public void find() {}
	
	// id 찾기 수행
	@PostMapping("/findId")
	public ModelAndView findId(String email) {
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("data", as.FindId(email));
		mav.addObject("row", 1);
		mav.setViewName("message");
		
		return mav;
	}
	
	// pw 찾기 수행
	@PostMapping("/findPw")
	public ModelAndView findPw(AccountVO input) throws LoginException {
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("idx", as.findPw(input));
		mav.setViewName("account/newPassword");
		
		return mav;
	}
	
	// 새 pw로 변경
	@PostMapping("/newPassword")
	public ModelAndView newPassword(AccountVO input) throws NoSuchAlgorithmException {
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("row", as.newPassword(input));
		mav.addObject("data", "변경이 완료되었습니다");
		mav.setViewName("message");
		
		return mav;
	}
}
