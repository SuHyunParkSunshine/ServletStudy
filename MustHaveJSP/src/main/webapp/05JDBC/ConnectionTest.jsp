<%@page import="java.sql.Connection"%>
<%@ page import="common.JDBCConnectVer2"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JDBC</title>
</head>
<body>
	<h2>JDBC 테스트 1</h2>
	<%
	JDBCConnectVer2 jdbc2 = new JDBCConnectVer2();
	Connection con = jdbc2.getConnection();
	
	jdbc2.writeMemberToTable(con, out);
	out.write("<br>");
	jdbc2.writeBoardToTable(con, out);
	
	con.close();	
	%>
	
	<h2>JDBC 테스트 2</h2>
	<%
	String driver = application.getInitParameter("MySQLDriver");
	String url = application.getInitParameter("MySQLURL");
	String id = application.getInitParameter("MySQLId");
	String pwd = application.getInitParameter("MySQLPwd");
	
	JDBCConnectVer2 jdbc3 = new JDBCConnectVer2(driver, url, id, pwd);
	Connection con1 = jdbc3.getConnection();
	jdbc3.writeMemberToTable(con1, out);
	out.write("<br>");
	jdbc3.writeBoardToTable(con1, out);
	
	con1.close();
	
	%>

</body>
</html>