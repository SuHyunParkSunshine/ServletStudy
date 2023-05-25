<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL - forEach 1</title>
</head>
<body>
	<h4>향상된 for문 형태의 forEach 태그</h4>
	<%
	//String 배열 형태를 출력
	String[] rgba = { "Red", "Green", "Blue", "Black" };
	%>
	<!-- value에 들어온 값이 current에 순서대로 들어오게 된다 -->
	<c:forEach items="<%=rgba%>" var="c">
		<span style="color:${ c };">${ c }</span>
	</c:forEach>

	<h4>varStatus 속성 살펴보기</h4>
	<table border="1">
		<c:forEach items="<%=rgba%>" var="c" varStatus="loop">
			<tr>
				<td>count : ${ loop.count }</td>
				<td>index : ${ loop.index }</td>
				<!--current는 현재 index값을 찍어준다 -->
				<td>current : ${ loop.current }</td>
				<td>first : ${ loop.first }</td>
				<td>last : ${ loop.last }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>