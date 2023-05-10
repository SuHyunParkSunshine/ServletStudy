package edu.pnu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyServlet01 extends HttpServlet {
	//HttpServlet이라는 부모로부터 상속을 받아야지만 호출이 가능하다

	private static final long serialVersionUID = 1L;
	
	
	//main이 실행이되는 이유는 톰캣이 알아서 찾아서 실행해주기 때문?
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("MyServlet01");
	}

}
