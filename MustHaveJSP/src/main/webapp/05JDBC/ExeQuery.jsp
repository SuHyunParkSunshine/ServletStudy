<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="common.JDBCConnectVerPF"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JDBC</title>
</head>
<body>
	<h2>회원 목록 조회 테스트(exeQuery() 사용)</h2>
	<%
	// DB에 연결
	JDBCConnectVerPF jdbc = new JDBCConnectVerPF();
	Connection con = jdbc.getConnection();
	
	if (con == null) {
		out.println("!!Fail to Connect DB!!");
		return;
	}
	
	// 쿼리문 생성
	String sql = "select id, pass, name, regidate from member";
	Statement stmt = con.createStatement();
	
	//쿼리 수행
	ResultSet rs = stmt.executeQuery(sql);
	
	//결과 확인(웹 페이지에 출력)
	while(rs.next()) {
		String id = rs.getString(1);
		String pw = rs.getString(2);
		String name = rs.getString("name");
		java.sql.Date regidate = rs.getDate("regidate");
		
		out.println(String.format("%s, %s, %s, %s", id, pw, name, regidate) + "<br/>");
	}
	
	rs.close();
	stmt.close();
	
	//연결 닫기
	jdbc.closeConnection(con);
	%>

</body>
</html>