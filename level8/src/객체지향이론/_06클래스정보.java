package 객체지향이론;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

class Test05{
	private int a;
	private int b;
	private String c;
	int getA() {
		return a;
	}
	int getB() {
		return b;
	}
	String getC() {
		return c;
	}
	void setA(int a) {
		this.a = a;
	}
	void setB(int b) {
		this.b = b;
	}
	void setC(String c) {
		this.c = c;
	}
	@Override
	public String toString() {
		return "Test05 [a=" + a + ", b=" + b + ", c=" + c + "]";
	}
	
}

public class _06클래스정보 {

	public static void main(String[] args) {

		Test05 test = new Test05();
		System.out.println(test.getClass().getName());
		System.out.println(test.getClass().getSimpleName());
		System.out.println(test.getClass().getPackageName());
		
		// ? 컴파일에서 타입이 결정되는게 아니라 런타임에서 타입이 결정된다.
		Class<?> myClass;
		
		try {
			myClass = Class.forName(test.getClass().getName());
			for(Method method : myClass.getDeclaredMethods()) // 선언된 메서드 정보들 가져옴
				System.out.println(method.getName());
			
			for(Field field : myClass.getDeclaredFields()) // 선언된 멤버변수 정보들 가져옴
				System.out.println(field.getName());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
