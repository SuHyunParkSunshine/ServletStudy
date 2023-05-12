<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%!public int add(int num1, int num2) {
		return num1 + num2;
	}%>

<html>
<head>
<meta charset="UTF-8">
<title>스크립트 요소</title>
</head>
<body>

	<%
	String a = request.getParameter("n1");
	String b = request.getParameter("n2");

// 		String a = "11";
// 		String b = "12";

	int num1 = 2;
	int num2 = 2;
	int result = add(num1, num2);
	int res = 0;

	if (a != null && b != null) {

		int n1 = Integer.parseInt(a);
		int n2 = Integer.parseInt(b);

		res = n1 + n2;
	} else {
		res = 0;
	}
	// 	int res = 0;
	// 	String sa = request.getParameter("a");
	// 	String sb = request.getParameter("b");

	// 	if (sa != null && sb != null) {
	// 		int a = Integer.parseInt(sa);
	// 		int b = Integer.parseInt(sb);
	// 		res = a + b;
	// 	}
	%>



	덧셈 결과 1 :
	<%=result%>
	<br /> 덧셈 결과 2 :
	<%=add(30, 40)%><br /> 덧셈 결과 3:
	<%=res%>

</body>
</html>