<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>액션 태그 - forward</title>
</head>
<body>
	<h2>포워드 결과</h2>
	<ul>
<!-- 		page가 변경 된 후라서 포함이 되지 않음 -->
		<li>page 영역 : <%=pageContext.getAttribute("pAttr")%></li>  
		<li>request 영역 : <%=request.getAttribute("rAttr")%></li>	</ul>

</body>
</html>