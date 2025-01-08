package 객체지향이론;

import java.util.Scanner;

// heap : 동적메모리 => new 를 할때 메모리방에서 생성 : 갈비지콜렉터가 메모리 공간 관리
// stack : 메서드의 메모리 => 메소드를 호출하면 메모리방 생성, 메서드 호출 끝나면 메모리 공간 삭제
// static : 정적메모리 => static 키워드가 붙은 모든것 
						//프로그램 시작하자마자 생성, 프로그램 끝날 때 메모리방 삭제


//변수
// 자료의 형태 : 원시타입 / 참조타입
// 변수의 위치 : 전역변수 == 멤버변수 / 지역변수
// 멤버변수(field) 종류
// - 인스턴스 변수 (non-static - variable): static 이 안 붙은 변수 : new 할때마다 heap 생성된다 : 객체의 개별공간
// - 클래스 변수 (static - variable): static 붙은 변수 : 객체의 공통공간 : 이탈릭체 (약간 기울어짐)

// 클래스변수 접근하는 2가지 방법
// 1. 인스턴스(객체)이름. 
// 2. 클래스이름.

class Test02{
	static Test01 test01 = new Test01();
	int num1 = 10;
	static int num2 = 20;
	final static int NUM3 = 30;
	
	Test02(int num1, int num2){
		this.num1 = num1;
		this.num2 = num2; // 인스턴스 변수로 접근하는 방법
	}
	
	void printInfo() {
		System.out.println(num1+","+num2);
	}
	//static 메서드는 static 변수만 접근 가능하다
	static void printInfo2() {
//		System.out.println(num1+","+num2); 
//		num1은 객체를 생성할 때 방을 만들기때문에 접근 불가능
		
		System.out.println("========");
		System.out.println(num2);
		System.out.println(NUM3);
		System.out.println("========");
	
	
	
	}
}
public class _03스태틱1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println(Test02.num2); // 클래스 이름으로 접근
		
		Test02.printInfo2();//객체를 만들지 않고 바로 클래스 이름으로 메서드 호출
		
		Test02 t2 = new Test02(10,100);
		t2.printInfo();
		t2.printInfo2();
		Test02 t3 = new Test02(20,200);
		t3.printInfo();
		t3.printInfo2();
		System.out.println("-----------");
		System.out.println(t2.num2);
		
		Test02.test01.getA();
	}

}
