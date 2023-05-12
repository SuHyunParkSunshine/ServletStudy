<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내장 객체 - request</title>
</head>
<body>
<%
	String id = request.getParameter("user_id");
	String pwd = request.getParameter("user_pwd");
	
	if (id.equalsIgnoreCase("must") && pwd.equalsIgnoreCase("1234")) {
		response.sendRedirect("ResponseWelcome.jsp"); //sendRedirect가 클라이언트한테 재요청을 하라고 함
	}
	else {
		request.getRequestDispatcher("ResponseMain.jsp?loginErr=1").forward(request, response);
	}
%>

</body>
</html>