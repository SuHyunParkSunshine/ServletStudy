package common;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletContext;

public class JDBCConnectVerPF {

	private String driver;
	private String url;
	private String id;
	private String pwd;

	public JDBCConnectVerPF() {
		driver = "com.mysql.cj.jdbc.Driver";
		url = "jdbc:mysql://localhost:3306/musthave";
		id = "musthave";
		pwd = "1234";
	}

	public JDBCConnectVerPF(String driver, String url, String id, String pwd) {
		this.driver = driver;
		this.url = url;
		this.id = id;
		this.pwd = pwd;
	}

	public JDBCConnectVerPF(ServletContext application) {
		driver = application.getInitParameter("MySQLDriver");
		url = application.getInitParameter("MySQLURL");
		id = application.getInitParameter("MySQLId");
		pwd = application.getInitParameter("MySQLPwd");
	}

	public Connection getConnection() {
		try {
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url, id, pwd);
			return con;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	public void closeConnection(Connection con) {
		try {
			if(con != null) con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
