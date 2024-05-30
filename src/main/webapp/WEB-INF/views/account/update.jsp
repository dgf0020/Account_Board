<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

	<h4>회원정보 수정</h4>
	
	<form method="POST">
		<table>
			<tr>
				<th>회원번호</th>
				<td>${row.idx }</td>
			</tr>
			<tr>
				<th>아이디</th>
				<td>${row.userid }</td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input name="userpw" placeholder="비밀번호" required></td>
			</tr>
			<tr>
				<th>닉네임</th>
				<td><input name="nick" value="${row.nick }" placeholder="닉네임" required></td>
			</tr>
			<tr>
				<th>이메일</th>
				<td><input name="email" type="email" value="${row.email }" placeholder="이메일" required></td>
			</tr>
		</table>
		
		<br>
		
		<input name="idx" type="hidden" value="${row.idx }">
		
		<button>수정</button>
	</form>

</body>
</html>