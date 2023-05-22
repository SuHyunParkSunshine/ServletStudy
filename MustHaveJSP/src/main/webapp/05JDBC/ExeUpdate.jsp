<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
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
	<h2>회원 추가 테스트(executeUpdate() 사용)</h2>
	<%
	// DB에 연결	
	JDBCConnectVerPF jdbc = new JDBCConnectVerPF();
	Connection con = jdbc.getConnection();
	
	if (con == null) {
		out.print("<h2>Fail to Connect DB</h2>");
		return;
	}
	
	// 테스트용 입력 값 준비
// 	String id = "test1";
// 	String pass = "1111";
// 	String name = "테스트1회원";
	
	String id =request.getParameter("id");
	String pass =request.getParameter("pass");
	String name =request.getParameter("name");
	
	if(id == null) {
		out.println("<h2>input data is invaild</h2>");
		return;
	}
	
	//쿼리문 생성
	String sql = "insert into member(id, pass, name) values (?, ?, ?)";
	PreparedStatement psmt = con.prepareStatement(sql);
	psmt.setString(1, id);
	psmt.setString(2, pass);
	psmt.setString(3, name);
	
	//쿼리 수행
	int inResult = psmt.executeUpdate();
	out.println(inResult + "행이 입력되었습니다.");
	
	psmt.close();
	
	//연결 닫기
	jdbc.closeConnection(con);
	%>

</body>
</html>