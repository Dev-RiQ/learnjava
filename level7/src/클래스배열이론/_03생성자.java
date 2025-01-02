package 클래스배열이론;

// 생성자 (constructor) : 객체(인스턴스)를 생성하는 메서드

// 생성자 메서드 공통점
// 1) 이름 불러 호출
// 2) 오버로딩 가능

// 메서드 오버로딩 => 한 클래스 내부에서 여러개의 같은 이름의 메서드 정의
class Ex01{
	int a;
	int b;
	String c;
	
//	Ex01(){} => 없으면 만들어준다
	Ex01() {
		System.out.println("Ex01 생성자를 호출했다");
	}
	Ex01(int a) {
		this.a = a;
		System.out.println("Ex01(int a) 생성자를 호출했다");
	}
	Ex01(int a,int b) {
		this.a = a;
		this.b = b;
		System.out.println("Ex01(int a, int b) 생성자를 호출했다");
	}
	
	void init(int a) {
		this.a = a;
	}
	void init(int a, int b) {
		this.a = a;
		this.b = b;
	}
	void init(int a, int b,String c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}
}

public class _03생성자 {

	public static void main(String[] args) {

		Ex01 e = new Ex01(); // Ex01() => 생성자
		Ex01 e2 = new Ex01(10); // Ex01(10) => 생성자
		Ex01 e3 = new Ex01(10,100); // Ex01(10,100) => 생성자
	}

}
