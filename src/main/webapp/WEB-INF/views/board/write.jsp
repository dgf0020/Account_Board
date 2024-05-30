<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

	<form method="POST">
		<table>
			<tr>
				<td><input name="title" placeholder="제목" required></td>
			</tr>
			<tr>
				<td><textarea name="contents" placeholder="내용"></textarea></td>
			</tr>
		</table>
		
		<br>
		
		<input name="a_idx" type="hidden" value="${user.idx }">
										<%-- AccountVO에는 a_idx가 아니라 idx이다 --%>
										<%-- 로그인이 되어있지 않으면 value에 아무런 값도 들어가있지 않다 --%>
		
		<button>작성</button>
	</form>
	
</body>
</html>