package FileIO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import membership.MemberDTO;

public class ObjectMain2 {

	public void serialize(MemberDTO obj, String fileName) throws IOException {
		try (FileOutputStream fos = new FileOutputStream(fileName);
				ObjectOutputStream oos = new ObjectOutputStream(fos);) {

			oos.writeObject(obj);
		}
	}

	
	public void serialize(List<MemberDTO> list, String fileName) throws IOException {
		try (FileOutputStream fos = new FileOutputStream(fileName);
				ObjectOutputStream oos = new ObjectOutputStream(fos);) {

			oos.writeObject(list);
		}
	}
	
	public MemberDTO deserialize(String fileName) throws IOException, ClassNotFoundException {
		MemberDTO m = null;
		try (FileInputStream fis = new FileInputStream(fileName);
				ObjectInputStream ois = new ObjectInputStream(fis);) { //자기자신이 독자적으로 stream을 만들수 없고 파라미터로 받아가지고 만들기 가능

			m = (MemberDTO)ois.readObject();
		}		
		return m;
	}	
	
	public List<MemberDTO> deserialize1(String fileName) throws IOException, ClassNotFoundException {
		Object m = null;
		List<MemberDTO> list = new ArrayList<>();
		try (FileInputStream fis = new FileInputStream(fileName);
				ObjectInputStream ois = new ObjectInputStream(fis);) { //자기자신이 독자적으로 stream을 만들수 없고 파라미터로 받아가지고 만들기 가능

//			while((m = ois.readObject()) != null) {
//				list.add((MemberDTO)m);
//			}
			for(int i= 0; i < 2; i++) {
				m = ois.readObject();
				list.add((MemberDTO)m);				
			}
			
		}		
		return list;
	}	
	
	public static void main(String[] args) throws Exception {
		
		ObjectMain2 om = new ObjectMain2();
		
		List<MemberDTO> list = new ArrayList<>();
		
		list.add(new MemberDTO("100", "1234", "홍길동", "2023-01-01"));
		list.add(new MemberDTO("100", "1234", "홍길동", "2023-02-02"));
		list.add(new MemberDTO("100", "1234", "홍길동", "2023-03-03"));
		list.add(new MemberDTO("100", "1234", "홍길동", "2023-04-04"));
		

		om.serialize(list, "testObject.dat");
		
		MemberDTO m = om.deserialize("testObject.dat");
		System.out.println(m);
	}
}
