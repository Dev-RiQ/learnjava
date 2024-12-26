package 메서드개념;

class Test04{
	void type01() {
//		return;
	}
	
	void type02(int age, String name) {
//		return;
	}
	
	int type03() {
		System.out.println("type03실행했다");
		return 1000;
	}
}
public class _08매서드기본이론4 {

	public static void main(String[] args) {

		Test04 t4 = new Test04();
		
		t4.type01();
		t4.type02(10,"test");
		t4.type03(); // 에러는 안뜨지만 반환 받을 변수 없어서 증발 (리턴 이전의 실행은 진행)
		System.out.println(t4.type03());
		
		int result = t4.type03();
		System.out.println(result);
	}

}
