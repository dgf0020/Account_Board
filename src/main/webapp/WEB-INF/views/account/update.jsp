<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

	<h4>회원정보 수정</h4>
	
	<form method="POST">
		<table>
			<tr>
				<th>비밀번호</th>
				<td><input name="userpw" type="password" placeholder="비밀번호" required></td>
			</tr>
			<tr>
				<th>이메일</th>
				<td><input name="email" type="email" value="${user.email }" placeholder="이메일" required></td>
			</tr>
		</table>
		
		<br>
		
		<button>수정</button>
	</form>

</body>
</html>