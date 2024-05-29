<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

	<form method="POST">
		<p><input name="userid" placeholder="ID" required></p>
		<p><input name="userpw" type="password" placeholder="PW" required></p>
		<p><input name="nick" placeholder="NICK" required></p>
		<p><input name="email" type="email" placeholder="EMAIL" required></p>
		
		<button>signUp</button>
	</form>

</body>
</html>