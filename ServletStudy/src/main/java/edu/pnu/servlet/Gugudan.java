package edu.pnu.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/gugudan")

public class Gugudan extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("text/html; charset=utf-8");

		String type = req.getParameter("type");
		String snum = req.getParameter("num");

		int num = 2;		
		if (snum != null) {
			num = Integer.parseInt(snum);
		}

		try (PrintWriter out = resp.getWriter();) {

			if (type == null || type.equals("table")) {

				out.println("<h2>구구단입니다잉</h2>");

				out.println(String.format("<h3>%d단 입니다.</h3>", num));

				int result = 0;

				out.println("<table border=\"1\">");

				for (int i = 1; i <= 9; i++) {

					result = num * i;					

					out.print(String.format("<tr><td>%d * %d = %d</td></tr>", num, i, result));

				}

			} else if (type != null || type.equals("list")) {

				out.println("<h2>구구단입니다잉</h2>");

				out.println(String.format("<h3>%d단 입니다.</h3>", num));

				int result = 0;

				for (int i = 1; i <= 9; i++) {

					result = num * i;

					out.print(String.format("<li>%d * %d = %d</li>", num, i, result));

				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
