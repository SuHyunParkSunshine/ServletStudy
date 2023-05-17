<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String popupMode = "on";

Cookie [] cookies = request.getCookies();

if (cookies != null) {
	for (Cookie c : cookies) {
		String cookieName = c.getName();
		String cookieValue = c.getValue();
		if (cookieName.equals("PopupClose")) {
			popupMode = cookieValue;
		}
	}
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿠키를 이용한 팝업 관리</title>
<style>
	div#popup {
	position: absolute; top: 100px; left:100px; color:yellow;
	width:300px; height:100px; background-color:gray;	
	}
	
	div#popup > div {
	position: relative; background-color:#ffffff; top: 0px;
	border:1px solid gray; padding:100px; color:black; 	
	}
</style>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>

</body>
</html>