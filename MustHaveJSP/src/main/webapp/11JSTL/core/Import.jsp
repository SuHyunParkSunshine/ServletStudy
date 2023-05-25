<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL - import</title>
</head>
<body>
	<c:set var="requestVar" value="MustHave" scope="request" />
	<c:import url="/11JSTL/inc/OtherPage.jsp" var="contents">
		<c:param name="user_param1" value="JSP" />
		<c:param name="user_param2" value="기본서" />
	</c:import>

	<h4>다른 문서 삽입하기</h4>
	<!-- 요 시점에 호출해서 찍어주는데 otherpage에서 디스플레이 목적이 있기 때문에  -->
	${ contents } 

	<h4>외부 자원 삽입하기</h4>
	<!-- 프레임을 하나 만들어가지고 브라우저를 지정된 사이즈로 정해가지고 다른 브라우저창을 열수 있는 것처럼 사용 -->
	<iframe src="../inc/GoldPage.jsp" style="width:100%;height:600px;"></iframe>
</body>
</html>