package FileIO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import membership.MemberDTO;

public class ObjectMain {

	public void serialize(MemberDTO obj, String fileName) throws IOException {
		try (FileOutputStream fos = new FileOutputStream(fileName);
				ObjectOutputStream oos = new ObjectOutputStream(fos);) {

			oos.writeObject(obj);
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
	
	public static void main(String[] args) throws Exception {
		
		ObjectMain om = new ObjectMain();

		om.serialize(new MemberDTO("100", "1234", "홍길동", "2023-01-01"), "testObject.dat");
		
		MemberDTO m = om.deserialize("testObject.dat");
		System.out.println(m);
	}
}
