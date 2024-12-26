package 메서드개념;

class Test03 {
	String name;
	int age;
	
	void printInfo1() {
		String name = "둘리";
		int age = 1000;
		System.out.printf("이름 : %s, 나이 : %d살 \n",name, age);
	}
	
	void printInfo2() {
		System.out.printf("이름 : %s, 나이 : %d살 \n",name, age);
	}
	
	void printThis() {
		System.out.println("this = "+this);
	}
}

public class _03메서드기본이론3_this {

	public static void main(String[] args) {

//		String name = "홍길동";
//		int age = 10;
		
		Test03 t03 = new Test03();
		
		t03.name = "스폰지밥";
		t03.age = 3;
		
		Test03 t04 = new Test03();
		t04.name = "둘리";
		
		System.out.println(t03);
		System.out.println(t04);
		t03.printThis();
		t04.printThis();
		
		t03.printInfo1();
		t03.printInfo2();
		t04.printInfo2();
	}

}
