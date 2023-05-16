<%@ page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>session 영역</title>
</head>
<body>

	<%
	ArrayList<?> lists = (ArrayList<?>) session.getAttribute("lists");
	
	//if-else문 사용
	if (lists == null) {
		out.print("<h2>브라우저를 열고 시도하시오</h2>");
	}

	else {
		out.print("<h2>페이지 이동 후 session 영역의 속성 읽기</h2>");
		for (Object str : lists)
			if (str instanceof String)
		out.print(str + "<br />");

	}
	
	//try-catch문 사용
// 	try {
// 		ArrayList<?> lists2 = (ArrayList<?>) session.getAttribute("lists");
// 		for (Object str : lists2)
// 			if (str instanceof String)
// 		out.print(str + "<br />");

// 	} catch (Exception e) {
// 		e.printStackTrace();

// 	}

	// 	ArrayList<String> lists1 = (ArrayList<String>) session.getAttribute("lists");
	// 	for (String str : lists1)
	// 		out.print(str + "<br />");
	%>

</body>
</html>