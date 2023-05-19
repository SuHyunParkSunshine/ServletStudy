package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCConnect {

	public Connection con;
	public Statement stmt;
	public PreparedStatement psmt;
	public ResultSet rs;

	public JDBCConnect() {
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			String url = "jdbc:mysql://localhost:3306/musthave";
			String id = "musthave";
			String pwd = "1234";
			con = DriverManager.getConnection(url, id, pwd);

			System.out.println("DB 연결 성공(기본 생성자)");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void showMem() {
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery("Select id, pass, name from member");
																						
			while (rs.next()) {
				System.out.println(String.format("%s. %s, %s", 
																	
						rs.getString("id"), rs.getString("pass"), rs.getString("name")));
			}
		} catch (Exception e) {
			
		}

	}
	
	public void showBor() {
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery("Select num, title, content, id from board");
																						
			while (rs.next()) {
				System.out.println(String.format("%d, %s. %s, %s", 
																	
						rs.getInt("num"), rs.getString("title"), rs.getString("content"), rs.getString("id")));
			}
		} catch (Exception e) {
			
		}

	}

	public void close() {
		try {
			if (rs != null)
				rs.close();
			if (stmt != null)
				stmt.close();
			if (psmt != null)
				psmt.close();
			if (con != null)
				con.close();

			System.out.println("JDBC 자원 해제");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		JDBCConnect jdbcCon = new JDBCConnect();

		jdbcCon.showMem();
		
		System.out.println("=".repeat(50));
		
		jdbcCon.showBor();
		
		jdbcCon.close();
	}

}
