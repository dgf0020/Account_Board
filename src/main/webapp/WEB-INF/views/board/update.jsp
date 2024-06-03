<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

	<form method="POST">
		<table>
			<tr>
				<td><input name="title" placeholder="제목" value="${row.title }" required></td>
			</tr>
			<tr>
				<td>
					${row.nick } | 
					${row.v_count } | 
					${row.w_date }
				</td>
			</tr>
			<tr>
				<td><textarea name="contents">${row.contents }</textarea></td>
			</tr>
		</table>
		
		<br>
		
		<button>수정</button>
	</form>

</body>
</html>