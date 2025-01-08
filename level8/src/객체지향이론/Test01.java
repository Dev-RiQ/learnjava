package 객체지향이론;

public class Test01 {
	private int a;
	private int b;
	int getA() {
		return a;
	}
	private void setA(int a) {
		this.a = a;
	}
	int getB() {
		return b;
	}
	private void setB(int b) {
		this.b = b;
	}

	
	Test01(){}
	Test01(int a , int b){
		setA(a);
		setB(b);
	}
	Test01(String a, String b){
		this.a = Integer.parseInt(a);
		this.b = Integer.parseInt(b);
	}
	private	void printInfo1() {
			System.out.println(a +" : "+ b);
		}
		
		void printInfo2() {
			System.out.println(a +" : "+ b);
		}
		
}