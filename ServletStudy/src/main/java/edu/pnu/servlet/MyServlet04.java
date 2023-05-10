package edu.pnu.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/myservlet04")
public class MyServlet04 extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html; charset=utf-8");
		PrintWriter out = resp.getWriter();
		
		out.println("<table border=\"1\">");
		out.println("<tr>");
		out.println("<td>번호</td><td>나라</td><td>수도</td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<td>1</td><td>대한민국</td><td>서울</td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<td>2</td><td>미국</td><td>워싱턴</td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<td>3</td><td>일본</td><td>도쿄</td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<td>4</td><td>중국</td><td>베이징</td>");
		out.println("</tr>");
	}

}
