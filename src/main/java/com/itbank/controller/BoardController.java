package com.itbank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.service.BoardService;
import com.itbank.service.ReplyService;
import com.itbank.vo.BoardVO;
import com.itbank.vo.ReplyVO;

@Controller
@RequestMapping("/board")	// /board 아래로 들어오는 모든 요청을 처리
public class BoardController {
	
	@Autowired		// spring bean으로 등록된 객체를 하나 생성 받는 구문 (DI 의존성 주입)
	private BoardService bs;
	
	@Autowired
	private ReplyService rs;

	// 게시글 전체 가져오기
	@GetMapping( { "", "/{idx}" } )
	public ModelAndView list(@PathVariable(required = false) Integer idx) {
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("ver", bs.getTest());		// view에서 출력할 데이터를 Attribute에 담는다
		mav.addObject("map", bs.getBoards(idx));
		mav.setViewName("board/list");		// 출력할 view name을 지정
		
		return mav;
	}
	
	// 게시글 작성 폼
	@GetMapping("/write")
	public void write() {}
	
	// 게시글 작성 수행
	@PostMapping("/write")
	public String write(BoardVO input) {

		bs.addBoard(input);
		
		return "redirect:/board";
	}
	
	// 지정 게시글 가져오기
	@GetMapping("/view/{idx}")
	public ModelAndView view(@PathVariable int idx) {
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("row", bs.getBoardOne(idx));
		mav.addObject("replys", rs.getReplys(idx));
		mav.setViewName("board/view");
		
		return mav;
	}
	
	// 댓글 작성
	@PostMapping("/view/{b_idx}")
	public String writeReply(ReplyVO input) {
		rs.addReply(input);
		
		return "redirect:/board/view/" + input.getB_idx();
	}
	
	// 게시글 삭제
	@GetMapping("/delete/{idx}")
	public String delete(@PathVariable int idx) {
		
		bs.delete(idx);
		
		return "redirect:/board";
	}
	
	// 게시글 수정
	@GetMapping("/update/{idx}")
	public ModelAndView update(@PathVariable int idx) {
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("row", bs.getBoardOne(idx));
		mav.setViewName("board/update");
		// "board/write"로 보내서 write폼을 재사용해도 된다
		
		return mav;
	}
	
	@PostMapping("/update/{idx}")
	public String update(BoardVO input) {
		
		bs.update(input);
		
		return "redirect:/board";
	}
	
}
