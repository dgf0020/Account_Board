<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

	<h4>${ver }</h4>
	
	<table>
		<thead>
			<tr>
				<th>글번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>조회수</th>
				<th>작성일</th>
			</tr>
		</thead>
		
		<tbody>
			<c:forEach var="row" items="${list }">
				<tr>
					<td>${row.idx }</td>
					<td>${row.title }</td>
					<td>${row.nick }</td>
					<td>${row.v_count }</td>
					<td>${row.w_date }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<br>
	
	<a href="${cpath }/board/write">
		<button>write</button>
	</a>
	
	<%--
		1. write 버튼을 누르면
		GET /board/write로 요청을 보낸다
		해당 요청의 결과로 게시글 입력 폼을 출력한다
		입력은 제목과 내용, 현재 로그인한 계정의 번호(a_idx)를 전송한다
		전송은 POST /board/write에 한다
		
		2. /POST /board/write로 요청이 들어오면
		board 테이블에 글을 insert한다
	 --%>

</body>
</html>