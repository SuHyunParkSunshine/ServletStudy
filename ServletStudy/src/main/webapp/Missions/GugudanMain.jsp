<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>GugudanMain(JSP)</title>
</head>
<body>

<%
	String sel = request.getParameter("sel");
	String val = request.getParameter("val");
	
 	if (sel.equals("GugudanType1")) {
 		//Redirect방식
 		//response.sendRedirect("GugudanType1.jsp?num=" + val);
 		
 		//forward방식
 		request.getRequestDispatcher("GugudanType1.jsp?num=" + val).forward(request, response);
 	}
 	
 	else {
 		//Redirect방식
 		//response.sendRedirect("GugudanType2.jsp?col=" + val);
 		
 		//forward방식
 		request.getRequestDispatcher("GugudanType2.jsp?num=" + val).forward(request, response);
 	}

%>

</body>
</html>