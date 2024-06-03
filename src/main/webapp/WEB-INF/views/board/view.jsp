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