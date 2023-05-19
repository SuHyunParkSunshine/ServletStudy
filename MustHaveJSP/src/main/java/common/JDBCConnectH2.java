package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.jsp.JspWriter;

public class JDBCConnectH2 {

	private String driver = "org.h2.Driver";
	private String url = "jdbc:h2:tcp://localhost/~/musthave";
	private String id = "musthave";
	private String pwd = "1234";
	
	public JDBCConnectH2 () {};
	
	public JDBCConnectH2 (String driver, String url, String id, String pwd) {
		this.driver = driver;
		this.url = url;
		this.id = id;
		this.pwd = pwd;
	}

	public Connection getConnection() throws Exception {
		Class.forName(driver);
		return DriverManager.getConnection(url, id, pwd);
	}
	
	public void writeMemberToTable(Connection con, JspWriter out) {
		Statement st = null;
		ResultSet rs = null;
		
		try {
			out.write("<table border =\"1\">");
			out.write("<tr>");
			out.write("<td>id</td><td>pass</td><td>name</td><td>regidate</td>");			
			
			st = con.createStatement();
			rs = st.executeQuery("select * from member");
			while(rs.next()) {
				out.write("<tr>");		
				out.write("<td>");	out.write(rs.getString("id"));	out.write("</td>");
				out.write("<td>");	out.write(rs.getString("pass"));	out.write("</td>");
				out.write("<td>");	out.write(rs.getString("name"));	out.write("</td>");
				out.write("<td>");	out.write(rs.getString("regidate"));	out.write("</td>");
				out.write("</tr>");
			}
			out.write("</table>");		
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (st != null)
					st.close();				
//				if (con != null)
//					con.close();

				System.out.println("JDBC 자원 해제");

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public void writeBoardToTable(Connection con, JspWriter out) {
		Statement st = null;
		ResultSet rs = null;
		
		try {
			out.write("<table border=\"1\">");
			out.write("<tr>");
			out.write("<td>num</td><td>title</td><td>content</td><td>id</td><td>postdate</td><td>visitcount</td>");			
			
			st = con.createStatement();
			rs = st.executeQuery("select * from board");
			while(rs.next()) {
				out.write("<tr>");		
				out.write("<td>");	out.write(rs.getString("num"));	out.write("</td>");
				out.write("<td>");	out.write(rs.getString("title"));	out.write("</td>");
				out.write("<td>");	out.write(rs.getString("content"));	out.write("</td>");
				out.write("<td>");	out.write(rs.getString("id"));	out.write("</td>");
				out.write("<td>");	out.write(rs.getString("postdate"));	out.write("</td>");
				out.write("<td>");	out.write(rs.getString("visitcount"));	out.write("</td>");
				out.write("</tr>");
			}
			out.write("</table>");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (st != null)
					st.close();				
				if (con != null)
					con.close();

				System.out.println("JDBC 자원 해제");

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}

	public static void main(String[] args) throws Exception {

//		JDBCConnectVer2 jdbcCon2 = new JDBCConnectVer2();
//		Connection con = jdbcCon2.getConnection();								


//		Statement st = con.createStatement();
//		ResultSet rs = st.executeQuery("Select id, pass, name from member");
//
//		while (rs.next()) {
//			System.out.println(String.format("%s. %s, %s",
//
//					rs.getString("id"), rs.getString("pass"), rs.getString("name")));
//
//		}
//
//		con.close();
	}
}
