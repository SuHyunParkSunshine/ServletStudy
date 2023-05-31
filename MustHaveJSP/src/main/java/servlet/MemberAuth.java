package servlet;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import membership.MemberDAO;
import membership.MemberDTO;

@WebServlet(urlPatterns = "/13Servlet/MemberAuth.mvc",
			initParams = {@WebInitParam(name="admin_id", value = "suhyun")})

public class MemberAuth extends HttpServlet{
	MemberDAO dao;	
	
	@Override
	public void init() throws ServletException {
		//application 내장 객체 얻기
		ServletContext application = this.getServletContext();
		
		//String driver = "com.mysql.cj.jdbc.Driver";
		//web.xml에서 DB 연결 정보 얻기
		String driver = application.getInitParameter("MySQLDriver");
		String connectUrl = application.getInitParameter("MySQLURL");
		String oId = application.getInitParameter("MySQLId");
		String oPass = application.getInitParameter("MySQLPwd");
		
		dao = new MemberDAO(driver, connectUrl, oId, oPass);
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		String admin_id = this.getInitParameter("admin_id");
		
		String id = req.getParameter("id");
		String pass = req.getParameter("pass");
		
		MemberDTO memberDTO = dao.getMemberDTO(id, pass);
		
		String memberName = memberDTO.getName();
		if(memberName != null) {
			req.setAttribute("authMessage", memberName + "회원님 방가방가*^^*");
		}
		else {
			if(admin_id.equals(id))
				req.setAttribute("authMessage", admin_id + "는 최고 관리자입니다.");
			else
				req.setAttribute("authMessage", "귀하는 회원이 아닙니다.");
		}
//		req.getRequestDispatcher("/13Servlet/MemberAuth.jsp").forward(req, resp);
		//web-inf 외부에서는 접근 할 수 없는 폴더이기 때문에 url 주소를 치면 404에러가 뜬다. 정보들을 내부적으로만 숨겨서 사용 
		req.getRequestDispatcher("/WEB-INF/view/MemberAuthView.jsp").forward(req, resp);
	}
	
	@Override
	public void destroy() {
		Connection con = dao.getConnection();
		dao.closeConnection(con);
	}

}
