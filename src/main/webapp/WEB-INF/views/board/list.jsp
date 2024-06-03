<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

	<c:set var="pg" value="${map['pg'] }" />
	<c:set var="list" value="${map['list'] }" />

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
					<td>
						<a href="${cpath }/board/view/${row.idx}">
							${row.title }
						</a>
					</td>
					<td>${row.nick }</td>
					<td>${row.v_count }</td>
					<td>${row.w_date }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<ul class="menu">
		<c:if test="${pg.prev }">
			<li>
				<a href="${cpath }/board/${pg.begin - 1}">
					이전
				</a>
			</li>
		</c:if>
		
		<c:forEach var="i" begin="${pg.begin }" end="${pg.end }">
			<li>
				<a href="${cpath }/board/${i}">
					${i }
				</a>
			</li>
		</c:forEach>
		
		<c:if test="${pg.next }">
			<li>
				<a href="${cpath }/board/${pg.end + 1}">
					다음
				</a>
			</li>
		</c:if>
	</ul>
	
	<a href="${cpath }/board/write">
		<button>write</button>
	</a>

</body>
</html>