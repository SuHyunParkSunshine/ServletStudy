<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
String scol = request.getParameter("col");
int col = 3;
if (scol != null) col = Integer.parseInt(scol);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Gugudan type2 (JSP)</title>
</head>
<body>
<h2>구구단 타입 2</h2>
<h3>구구단입니다.</h3>
	
<%
	for (int i = 2; i <=9; i += col) {
		for (int k = 1; k <=9; k++) {
			for(int j = 0; j < col; j++) { 
				if (9 < i + j) break; 
			//out.print((i+j) + " ");
			out.print(String.format("%d*%d=%d  ", i+j, k, (i+j)*k));
		 } 	
		out.print("<br>");
	 } 
	out.print("<br>");
}	 
%>	
</body>
</html>