package 객체지향문제;

public class Member {
	private int custno; //회원번호
	private String custname; // 회원성명
	private String phone; //회원전화
	int getCustno() {
		return custno;
	}
	String getCustname() {
		return custname;
	}

	private String address;//통신사
	private String joindate; //가입일자
	private String grade; // 고객등급
	private String city; // 거주도시
	public Member(int custno, String custname, String phone, String address, String joindate, String grade,
			String city) {
		this.custno = custno;
		this.custname = custname;
		this.phone = phone;
		this.address = address;
		this.joindate = joindate;
		this.grade = grade;
		this.city = city;
	}
	@Override
	public String toString() {
		return "Member [custno=" + custno + ", custname=" + custname + ", phone=" + phone + ", address=" + address
				+ ", joindate=" + joindate + ", grade=" + grade + ", city=" + city + "]";
	}

}
