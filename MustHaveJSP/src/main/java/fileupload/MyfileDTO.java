package fileupload;

public class MyfileDTO {

	private String idx;
	private String name;
	private String title;
	private String cate;
	private String ofile;
	private String sfile;
	private String postdat;
	public MyfileDTO() {
		// TODO Auto-generated constructor stub
	}
//	public MyfileDTO(String name, String title, String cate, String ofile, String sfile) {
//		
//		this.name = name;
//		this.title = title;
//		this.cate = cate;
//		this.ofile = ofile;
//		this.sfile = sfile;
//		
//	}
	public String getIdx() {
		return idx;
	}
	public void setIdx(String idx) {
		this.idx = idx;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCate() {
		return cate;
	}
	public void setCate(String cate) {
		this.cate = cate;
	}
	public String getOfile() {
		return ofile;
	}
	public void setOfile(String ofile) {
		this.ofile = ofile;
	}
	public String getSfile() {
		return sfile;
	}
	public void setSfile(String sfile) {
		this.sfile = sfile;
	}
	public String getPostdat() {
		return postdat;
	}
	public void setPostdat(String postdat) {
		this.postdat = postdat;
	}
	@Override
	public String toString() {
		return "MyfileDTO [idx=" + idx + ", name=" + name + ", title=" + title + ", cate=" + cate + ", ofile=" + ofile
				+ ", sfile=" + sfile + ", postdat=" + postdat + "]";
	}
	
}
