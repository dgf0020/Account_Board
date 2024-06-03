package com.itbank.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itbank.component.Paging;
import com.itbank.model.BoardDAO;
import com.itbank.vo.BoardVO;

@Service
public class BoardService {
	
	@Autowired
	private BoardDAO dao;

	public String getTest() {
		return dao.test();
	}

	public Map<String, Object> getBoards(Integer idx) {
		// 여기에 페이징 코드
		if (idx == null) { idx = 1; }
		
		Paging pg = (new Paging(idx, dao.totalBoard()));
		List<BoardVO> list = dao.selectAll(pg);
		
		Map<String, Object> map = new HashMap<>();
		
		map.put("pg", pg);
		map.put("list", list);
		
		return map;
	}

	public int addBoard(BoardVO input) {
		return dao.insert(input);
	}

	public BoardVO getBoardOne(int idx) {
		return dao.selectOne(idx);
	}

	public int delete(int idx) {
		return dao.delete(idx);
	}

	public int update(BoardVO input) {
		return dao.update(input);
	}
}
