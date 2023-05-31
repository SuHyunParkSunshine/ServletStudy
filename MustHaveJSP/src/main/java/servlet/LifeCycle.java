package servlet;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/13Servelt/LifeCycle.do")
public class LifeCycle extends HttpServlet {

	//servlet 생성자가 시작하자마자 처음 한번 실행되는 것
	@PostConstruct
	public void myPostConstruct() {
		System.out.println("myPostConstruct() 호출");
	}

	//servlet 생성자가 시작하자마자 처음 한번 실행되는 것, 최초 실행 메소드
	@Override
	public void init() throws ServletException {
		System.out.println("init() 호출");
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("service() 호출");
		//하기의 코드가 없으면 doGet이나 doPost로 넘어가지를 않아서 실행이 되지가 않음
		super.service(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doGet() 호출");
		//req.getRequestDispatcher("/13Servlet/LifeCycle.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doPost() 호출");
		//req.getRequestDispatcher("/13Servlet/LifeCycle.jsp").forward(req, resp);
	}
	
	@Override
	public void destroy() {
		System.out.println("destroy() 호출");
	}
	@PreDestroy
	public void myPreDestroy() {
		System.out.println("myPreDestroy() 호출");
	}
}
