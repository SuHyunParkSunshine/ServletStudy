<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- 문자열을 단위로 자르는 것 token, 자르는 행위 tokeniser -->
<title>JSTL - forTokens</title>
</head>
<body>
	<%
	String rgba = "Red,Green,Blue,Black";
	%>
	<h4>JSTL의 forTokens 태그 사용</h4>
	<!-- delims를 기준으로 자르겠다. -->
	<c:forTokens items="<%=rgba%>" delims="," var="color">
		<span style="color:${ color };">${ color }</span>
		<br />
	</c:forTokens>
</body>
</html>