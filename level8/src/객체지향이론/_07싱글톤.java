package 객체지향이론;

//자바 디자인 패턴 gof 중에 하나
//싱글톤 패턴 (singleton pattern)

//단 하나의 유일한 객체를 만들어주는 것!

//1. 생성자를 private 로 막아준다.
//2. 클래스 내부에 자기자신의 객체의 인스턴스를 만든다 -> static으로 만든다
//3. 내부 자기자신의 객체를 private 만들고 -> getter 만들어준다


class Singleton{

	private Singleton() {};
	private static Singleton instance; // main 시작할 때 자동으로 만든다
	
	public static Singleton getInstance() {
		if(instance == null) instance = new Singleton();
		return instance;
	}
	
	void printTest() {
		System.out.println("test!!!");
	}
	
}

public class _07싱글톤 {
	public static void main(String[] args) {
		// 객체를 생성 단 한개
		
		// 객체 생성 == > new 클래스이름() => new 생성자 호출
//		Singleton singleton = new Singleton();
//		Singleton.instance.printTest();
//		Singleton.instance = null;
		
		Singleton.getInstance().printTest();
		System.out.println();
	}

}