package membership;

import java.io.Serializable;

//직렬화해가지고 파일에다가 쓰고 읽고 할 수 있는 객체라고 marking을 남기는 것, marking이 있어야지 readobject, writeobject가 가능
public class MemberDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private String id;
	private String pass;
	private String name;
	private String regidate;
	
	public MemberDTO() {
		// TODO Auto-generated constructor stub
	}	

	public MemberDTO(String id, String pass, String name, String regidate) {
		super();
		this.id = id;
		this.pass = pass;
		this.name = name;
		this.regidate = regidate;
	}

	// 멤버 변수별 게터와 세터
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRegidate() {
		return regidate;
	}

	public void setRegidate(String regidate) {
		this.regidate = regidate;
	}

	@Override
	public String toString() {
		return "MemberDTO [id=" + id + ", pass=" + pass + ", name=" + name + ", regidate=" + regidate + "]";
	}	

}
