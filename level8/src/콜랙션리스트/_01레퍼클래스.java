package 콜랙션리스트;

/*
 	Wrapper 클래스 : 감싼 클래스 => 기본 자료형을 클래스로 감싼다.
 	
 	원시타입 : int char double boolean byte short long float
 	참조타입 : 주소값 => 클래스 : 사용자 정의 자료형 => 설계도 : 속성값 , 기능 (행동)
 	
 	
 */
public class _01레퍼클래스 {

	public static void main(String[] args) {

		int num1 = 10;
		Integer num2 = 10; // 레퍼 클래스 (기존 int의 확장팩 같은 느낌 => 메서드 존재)
		
		System.out.println(num1 + 10);
		System.out.println(num2 + 10);
		
//		char char1 = 'a';
//		Character char2 = 'a';
//		
//		double dNum1 = 10;
//		Double dNum2 = 10.0;
//		
//		boolean b1 = true;
//		Boolean b2 = true;
		
		System.out.println(Integer.parseInt("10"));
		System.out.println(Integer.valueOf("10"));
		System.out.println(Integer.MAX_VALUE);
	}

}
