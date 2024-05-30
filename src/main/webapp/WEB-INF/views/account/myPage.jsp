<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

	<h4>마이페이지</h4>

	<table>
		<tr>
			<th>회원번호</th>
			<td>${user.idx }</td>
		</tr>
		<tr>
			<th>아이디</th>
			<td>${user.userid }</td>
		</tr>
		<tr>
			<th>닉네임</th>
			<td>${user.nick }</td>
		</tr>
		<tr>
			<th>이메일</th>
			<td>${user.email }</td>
		</tr>
		<tr>
			<th>가입일</th>
			<td>${user.join_date }</td>
		</tr>
	</table>
	
	<br>
	
	<a href="${cpath }/account/update/${user.idx}">
		<button>수정</button>
	</a>
	
	<a href="${cpath }/account/delete/${user.idx}">
		<button>탈퇴</button>
	</a>

</body>
</html>