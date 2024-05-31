package com.itbank.service;

import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itbank.component.SHA512Hash;
import com.itbank.exception.LoginException;
import com.itbank.model.AccountDAO;
import com.itbank.vo.AccountVO;

@Service
public class AccountService {
	
	@Autowired
	private AccountDAO dao;
	
	@Autowired
	private SHA512Hash hash;

	// 모든 회원정보 가져오기
	public List<AccountVO> getAccounts() {
		return dao.selectAll();
	}

	// 로그인
	public AccountVO login(AccountVO input) throws LoginException, NoSuchAlgorithmException {
											// throws : 예외 전가
		
		// 여기 해시pw를 적용해서 해시 처리된 계정이 로그인 되게 한다
		// 그 후, 일반pw 계정은 로그인 안됨
		String hashpw = hash.getHash(input.getUserpw());
		input.setUserpw(hashpw);
		
		
		input = dao.selectOne(input);
		// 로그인에 실패하면 dao.selectOne(input)은 null이 된다
		
		// 로그인 실패
		if (input == null) {
			String msg = "존재하지 않는 정보입니다";
			
			// throw로 예외를 강제로 발생 시킨다
			throw new LoginException(msg);
		}
		
		return input;
	}

	// 회원가입
	public int addAccount(AccountVO input) 
			throws NoSuchAlgorithmException {
		
		// day55 참고
		// DB에 넘기기 전에 해시 처리. DB에서 비밀번호를 볼 수 없게 만들기 (= 상세 로직)
		String userpw = input.getUserpw();
		String hashpw = hash.getHash(userpw);
			// SHA512Hash로 가서 비밀번호 해시처리
		
		input.setUserpw(hashpw);
			// 해시로 바뀐 pw를 AccountVO에 넣어준다
		
		// 그 후 DAO에 전달
		return dao.insert(input);
	}

	// 회원정보 수정
	public int upAccount(AccountVO input) throws NoSuchAlgorithmException {
		String userpw = input.getUserpw();
		String hashpw = hash.getHash(userpw);
		
		input.setUserpw(hashpw);
		
		return dao.update(input);
	}

	// 회원탈퇴
	public int delAccount(int idx) {
		return dao.delete(idx);
	}

	// id 찾기
	public String FindId(String email) {
		return dao.selectEmail(email);
	}
	
	// pw 찾기
	public int findPw(AccountVO input) throws LoginException {
		// dao에 userid, email을 보내서
		// 일치하는 계정이 있으면 새 패스워드 입력 창
		input = dao.selectFind(input);
		
		// 없으면 예외를 발생
		if (input == null) {
			String msg = "일치하는 정보가 존재하지 않습니다";
;			
			throw new LoginException(msg);
			// throw : 특정 조건일때 예외를 강제로 터뜨림
			// throws : 예외 전가
		}
		
		return input.getIdx();
	}

	// 새 pw 변경
	public int newPassword(AccountVO input) throws NoSuchAlgorithmException {
		String userpw = input.getUserpw();
		String hashpw = hash.getHash(userpw);
		
		input.setUserpw(hashpw);
		
		return dao.updateNewPw(input);
	}

}
