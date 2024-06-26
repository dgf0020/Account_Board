package com.itbank.model;

import java.util.List;

import com.itbank.vo.AccountVO;

public interface AccountDAO {

	List<AccountVO> selectAll();

	AccountVO selectOne(AccountVO input);

	int insert(AccountVO input);

	AccountVO selectAccOne(int idx);

	int update(AccountVO input);

	int delete(int idx);

	String selectEmail(String email);

	AccountVO selectFind(AccountVO input);

	int updateNewPw(AccountVO input);
}
