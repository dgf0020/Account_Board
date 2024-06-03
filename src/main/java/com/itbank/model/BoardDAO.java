package com.itbank.model;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.itbank.component.Paging;
import com.itbank.vo.BoardVO;

// import org.springframework.stereotype.Repository;

// @Repository -> 인터페이스에서는 안써도된다
public interface BoardDAO {

	@Select("select banner from v$version")
	String test();

	List<BoardVO> selectAll(Paging pg);

	int insert(BoardVO input);

	BoardVO selectOne(int idx);

	int delete(int idx);

	int update(BoardVO input);

	int totalBoard();

}
