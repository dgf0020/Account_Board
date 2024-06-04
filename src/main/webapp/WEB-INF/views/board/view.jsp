<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

	<table>
		<tr>
			<td>${row.idx } ${row.title }</td>
		</tr>
		<tr>
			<td>
				${row.nick } | 
				${row.v_count } | 
				${row.w_date }
			</td>
		</tr>
		<tr>
			<td><pre>${row.contents }</pre></td>
		</tr>
	</table>
	
	<br>
	
	<c:if test="${user.nick == row.nick }">
			<button>수정</button>
			<button>삭제</button>
	</c:if>
	
	<form method="POST">
		<p><textarea name="contents" placeholder="댓글을 입력해주세요" cols="50" rows="3"></textarea></p>
		<p><input name="a_idx" type="hidden" value="${user.idx }"></p>
		
		<button>작성</button>
	</form>
	
	<br>
	
	<c:forEach var="row" items="${replys }">
		<fieldset class="reply">
			<h5>${row.nick } | ${row.w_date }</h5>
			
			<pre>${row.contents }</pre>
		</fieldset>
	</c:forEach>
	
	<script>
		let btns = document.querySelectorAll('button');
		
		btns[0].onclick = () => {
			location.href = '${cpath }/board/update/${row.idx}';
		}
		
		btns[1].onclick = () => {
			location.href = '${cpath }/board/delete/${row.idx}';
		}
	
	</script>

</body>
</html>