package 객체지향문제;

public class Money {
	private int custno; //회원번호
	private int saleno; //판매번호
	private int pcost; // 단가
	private int amount; //수량
	private int price; // 가격(매출)
	private String pcode; // 상품코드
	private String sdate; // 판매일자
	public Money(int custno, int saleno, int pcost, int amount, int price, String pcode, String sdate) {
		this.custno = custno;
		this.saleno = saleno;
		this.pcost = pcost;
		this.amount = amount;
		this.price = price;
		this.pcode = pcode;
		this.sdate = sdate;
	}
	int getCustno() {
		return custno;
	}
	int getAmount() {
		return amount;
	}
	int getPrice() {
		return price;
	}
}
