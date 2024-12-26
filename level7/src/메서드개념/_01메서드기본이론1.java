package 메서드개념;

/*
 	지역변수 - 클래스 or 메서드 영역 안에서 선언된 변수 => 자료형 변수이름 = 초기값; => Stack 영역 안에 생성
 	전역(멤버변수) - 클래스 or 메서드 영역 밖에서 선언된 변수 => 자동 초기값을 가지고 있다 => Heap 영역 안에서 new 키워드로 선언
 		=> 인스턴스 변수, 클래스 변수
 	
 	메서드의 기본 구조
 	1. 유산 키워드   2. 메서드이름    3. 외부값    4. {메서드 영역}
 	
 	1. 유산 => 유산이 없으면 void, 유산이 있으면 해당 유산의 자료형 타입
 	2. 메서드 이름 => 소문자로 띄워쓰기는 카멜표기법, 동사키워드
 	3. 외부값 = > () 메서드를 실행할때 외부에서 가져오는 값 : 외부에 값이 없으면  () 빈괄호 표시, 값이 있으면 자료형 변수이름
 	4. 메서드 실행역역{} : body
 */

class Test01 {
	int xMain; // Heap에 생성

	void type01(String a, int b) {
		System.out.println(a+" 유산도 없고 외부값도 없는 메서드 타입"+b);
	}

	void printHello10Times() {
		for (int i = 0; i < 10; i++)
			System.out.println("Hello");
	}
	
	void printX() {
		int x = 10; // Stack에 생성
		System.out.println("v프린트 했다");
		System.out.println(x+xMain);
	}
	
}

public class _01메서드기본이론1 {

	public static void main(String[] args) {

		Test01 t01 = new Test01(); // 인스턴스 객체변수 생성
		int age = 10;
		String name = "나";
//		t01.type01(); // 메서드 호출
//		name.substring();
		name = "너";
		t01.type01(name,age); // 메서드 호출
//		t01.x = 20;
		t01.printX();
		Test01 t2 = new Test01();
//		t2.x = 30;
		t2.printX();
//		System.out.println(t01.printX());
		t01.printHello10Times();
	}

}
