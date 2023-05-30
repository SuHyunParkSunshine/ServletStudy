package fileupload;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Vector;

import common.JDBCConnectVerPF;

public class MyfileDAO extends JDBCConnectVerPF {

	public int insertFile(MyfileDTO dto) {
		int applyResult = 0;
		Connection con = getConnection();
		try {
			String query = "insert into myfile(name, title, cate, ofile, sfile) values(?, ?, ?, ?, ?)";

			PreparedStatement psmt = con.prepareStatement(query);
			psmt.setString(1, dto.getName());
			psmt.setString(2, dto.getTitle());
			psmt.setString(3, dto.getCate());
			psmt.setString(4, dto.getOfile());
			psmt.setString(5, dto.getSfile());
			applyResult = psmt.executeUpdate();

		} catch (Exception e) {
			System.out.println("INSERT 중 예외 발생");
			e.printStackTrace();
		}
		return applyResult;
	}

	public List<MyfileDTO> myFileList() {
		List<MyfileDTO> fileList = new Vector<MyfileDTO>();

		Connection con = getConnection();

		String query = "select * from myfile order by idx desc";
		try {
			PreparedStatement psmt = con.prepareStatement(query);
			ResultSet rs = psmt.executeQuery();

			while (rs.next()) {
				MyfileDTO dto = new MyfileDTO();
				dto.setIdx(rs.getString(1));
				dto.setName(rs.getString(2));
				dto.setTitle(rs.getString(3));
				dto.setCate(rs.getString(4));
				dto.setOfile(rs.getString(5));
				dto.setSfile(rs.getString(6));
				dto.setPostdat(rs.getString(7));
				fileList.add(dto);
			}
		} catch (Exception e) {
			System.out.println("SELECT 시 예외 발생");
			e.printStackTrace();
		}
		return fileList;
	}
	
	public static void main(String[] args) {
		//1. 데이터 입력 객체를 만들고
		MyfileDAO dao = new MyfileDAO();
		//2-1. 입력할 DTO객체를 만들고
		MyfileDTO dto = new MyfileDTO();
		
		//2-2. DTO객체를 생성해서 입력한다.
		// MyfileDTO dto = new MyfileDTO("a2","b2","c2","d2","e2");

		// 3-1. 입력할 내용을 DTO객체에 설정하고
//		dto.setName("a");
//		dto.setTitle("b");
//		dto.setCate("c");
//		dto.setOfile("d");
//		dto.setSfile("e");
		
		// 4-1. 데이터를 입력한다.
		//dao.insertFile(dto);

//		int res = dao.insertFile(dto);
		List<MyfileDTO> arr = dao.myFileList();
		
		for (int i = 0; i < arr.size(); i++) {
			
			System.out.println(arr.get(i));
		}
		 //System.out.println("list" + dao.myFileList());
	}
		
}
