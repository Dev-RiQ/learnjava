package 메서드개념;

class Test02 {
	
	void type01() {
		System.out.println("type01 : void 유산 X | () 외부값 X");
	}
	
	void type02(int a) { // (int a) : parameter : 매개변수 (외부에서 받아오는 변수)
		System.out.println("type02 : void 유산 X | (int a) 외부값 O");
		System.out.println("외부값 = "+a);
	}
	
	void printSum(int start, int end) {
		int sum = 0;
		for(int i = start ; i <= end; i++)
			sum+=i;
		System.out.printf("%d ~ %d 까지의 총합 = %d \n",start,end,sum);
	}
	
	void printSomething(String msg, int sum) {
		System.out.println(msg);
		System.out.println(sum);
	}
}

public class _02메서드기본이론2 {

	public static void main(String[] args) {

		Test02 t02 = new Test02();
		
		t02.type01();
		int num = 10;
		t02.type02(num); // (num) : argument : 인자값 (외부에서 주는 값)
		
		t02.printSum(1, 10);
		t02.printSum(10, 100);
		
		t02.printSomething("hello", 100);
		
	}

}
