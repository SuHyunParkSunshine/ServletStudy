package membership;

import java.util.ArrayList;

public class MemberDAOTest {

	private static MemberDAO memberDAO = new MemberDAO();

	public static void printMemberDTO() {
		// Test getMemberDTO()
		MemberDTO memberDTO = memberDAO.getMemberDTO("test1", "1111");
		System.out.println(memberDTO);

	}

	public static void printAllMemberDTO() {
		// 모든 멤버 데이터 가져와서 출력
		ArrayList<MemberDTO> list = memberDAO.getAllMemberDTO();
		for (MemberDTO m : list) {
			System.out.println(m);
		}

	}

	public static void insertMemberDTO() {
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setId("Hong");
		memberDTO.setPass("1234");
		memberDTO.setName("홍길동이");
		memberDAO.insertMemberDTO(memberDTO);		

	}
	
	public static void updateMemberDTO() {
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setId("Hone");
		memberDTO.setPass("1234");
		memberDTO.setName("캉캉이");
		memberDAO.updateMemberDTO(memberDTO);		

	}
	
	public static void deleteMemberDTO() {
		memberDAO.deleteMemberDTO("Hong");	
	}

	public static void main(String[] args) {

		//printAllMemberDTO();
		System.out.println("-".repeat(80));

		//insertMemberDTO();
		updateMemberDTO();
		//deleteMemberDTO();
		printAllMemberDTO();
		System.out.println("-".repeat(80));

	}
}
