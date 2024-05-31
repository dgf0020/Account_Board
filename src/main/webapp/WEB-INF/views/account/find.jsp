<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

	<h4>ID 찾기</h4>
	
	<form action="findId" method="POST">
		<p><input name="email" type="email" placeholder="가입시 이메일" required></p>
		
		<button>find</button>
	</form>
	
	<h4>PW 찾기</h4>
	
	<%--
		패스워드 찾기
		
		인증 성공 후 
		1. 랜덤 pw를 생성해서 제공한다
		2. 직접 새 패스워드를 입력하게 한다
	 --%>
	
	<form action="findPw" method="POST">
		<p><input name="userid" placeholder="가입시 아이디" required></p>
		<p><input name="email" type="email" placeholder="가입시 이메일" required></p>
		
		<button>find</button>
	</form>

</body>
</html>