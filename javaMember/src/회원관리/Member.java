package 회원관리;

public class Member {

	private String id;
	private String pw;
	private String name;

	Member(String id, String pw, String name) {
		this.id = id;
		this.pw = pw;
		this.name = name;
	}

	String getId() {
		return id;
	}

	String getPw() {
		return pw;
	}

	String getName() {
		return name;
	}

	void setId(String id) {
		this.id = id;
	}

	void setPw(String pw) {
		this.pw = pw;
	}

	void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return id+ " : "+pw+ " : "+name;
	}
}
