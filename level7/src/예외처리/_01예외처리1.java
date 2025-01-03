package 예외처리;

// 예외 : 컴파일러에서 발생하는 우리가 처리할 수 있는 것들 => 발생 시 JVM 종료
// 컴파일 예외 => 실행 전 미리 알 수 있는 에러 => 문법적 예외 시 (실행 전에 알려줌)
// 런타임 예외 => 문법적으로 예외는 없지만 논리적으로 예외인 것들 => 실행중 발생

public class _01예외처리1 {

	public static void main(String[] args) {

		int num = 10;
		int diveder = 0;
		
		if(diveder == 0)
			System.out.println("0으로 나눌 수 없음"); // 예외 처리
		else
			System.out.println(num / diveder); // 런타임 예외
		
		System.out.println("=============");
		num = 10;
		diveder = 0;
		try {
			// 혹시 예외가 발생할 수 있는 코드 블럭
			System.out.println(num / diveder);
			// 예외 발생 시 catch 구문으로 넘어가서 아래 실행 X
			System.out.println("프로그램 종료");
		}catch(Exception e) {
			// 런타임 예외 발생하면 실행
			System.out.println("0으로 나눌 수 없음");
		}
		
		System.out.println("=============");
	}

}
