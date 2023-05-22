package membership;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import common.JDBCConnectVerPF;

public class MemberDAO extends JDBCConnectVerPF {

	// default 생성자는 ctrl+space하면 바로 생김
	public MemberDAO() {
	}

	// 명시한 데이터베이스로의 연결이 완료된 MemberDAO 객체를 생성합니다.
	public MemberDAO(String drv, String url, String id, String pw) {
		super(drv, url, id, pw);
	}

	// executeQuery
	// ---------------------------------------------------------------------------
	// 명시한 아이디/패스워드와 일치하는 회원 정보를 반환합니다.
	public MemberDTO getMemberDTO(String uid, String upass) {
		MemberDTO dto = new MemberDTO(); // 회원 정보 DTO 객체 생성
		String query = "select * from member where id=? and pass=?"; // 쿼리문 템플릿

		Connection con = getConnection();
		if (con == null)
			return null;
		PreparedStatement psmt = null;
		ResultSet rs = null;

		try {
			// 쿼리 실행
			psmt = con.prepareStatement(query);
			psmt.setString(1, uid);
			psmt.setString(2, upass);
			rs = psmt.executeQuery();

			if (rs.next()) {
				dto.setId(rs.getString("id"));
				dto.setPass(rs.getString("pass"));
				dto.setName(rs.getString(3));
				dto.setRegidate(rs.getString(4));

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (rs != null)
					psmt.close();
				if (rs != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return dto;
	}

	public ArrayList<MemberDTO> getAllMemberDTO() {

		String query = "select * from member"; // 쿼리문 템플릿

		Connection con = getConnection();
		if (con == null)
			return null;
		Statement st = null;
		ResultSet rs = null;

		ArrayList<MemberDTO> list = null;

		try {
			// 쿼리 실행
			st = con.createStatement();
			rs = st.executeQuery(query);

			list = new ArrayList<>();

			while (rs.next()) {
				MemberDTO dto = new MemberDTO();

				dto.setId(rs.getString("id"));
				dto.setPass(rs.getString("pass"));
				dto.setName(rs.getString(3));
				dto.setRegidate(rs.getString(4));

				list.add(dto);

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (rs != null)
					st.close();
				if (rs != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	// executeUpdate
	// ---------------------------------------------------------------------------
	public int insertMemberDTO(MemberDTO member) {

		String query = "insert into member(id, pass, name) values (?, ?, ?)"; // 쿼리문 템플릿

		Connection con = getConnection();
		if (con == null)
			return 0;
		PreparedStatement psmt = null;
		int ret = 0;

		String id = member.getId();
		String pass = member.getPass();
		String name = member.getName();

		try {
			// 쿼리 실행
			psmt = con.prepareStatement(query);
			psmt.setString(1, id);
			psmt.setString(2, pass);
			psmt.setString(3, name);
			ret = psmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (psmt != null)
					psmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return ret;
	}

	public int updateMemberDTO(MemberDTO member) {

		String query = "update member set pass =?, name =? where id =?"; // 쿼리문 템플릿

		Connection con = getConnection();
		if (con == null)
			return 0;
		PreparedStatement psmt = null;
		int ret = 0;

		String id = member.getId();
		String pass = member.getPass();
		String name = member.getName();

		try {
			// 쿼리 실행
			psmt = con.prepareStatement(query);
			psmt.setString(1, pass);
			psmt.setString(2, name);
			psmt.setString(3, id);
			ret = psmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (psmt != null)
					psmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return ret;	
	}

	public int deleteMemberDTO(String uid) {
		
		String query = "delete from member where id =?"; // 쿼리문 템플릿

		Connection con = getConnection();
		if (con == null)
			return 0;
		PreparedStatement psmt = null;
		int ret = 0;

		try {
			// 쿼리 실행
			psmt = con.prepareStatement(query);
			psmt.setString(1, uid);			
			ret = psmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (psmt != null)
					psmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return ret;	
	}
}
