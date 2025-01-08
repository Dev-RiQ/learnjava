package 객체지향문제;

public class Total {
	private int custNo; // 회원번호
	private String custname; //회원성명
	private int sum; // 총합
	int getCustNo() {
		return custNo;
	}
	void setCustNo(int custNo) {
		this.custNo = custNo;
	}
	String getCustname() {
		return custname;
	}
	void setCustname(String custname) {
		this.custname = custname;
	}
	int getSum() {
		return sum;
	}
	void setSum(int sum) {
		this.sum = sum;
	}
	@Override
	public String toString() {
		return custNo + " " + custname + " " + sum;
	}

}
