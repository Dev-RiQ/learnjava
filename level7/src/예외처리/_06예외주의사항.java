package 예외처리;

public class _06예외주의사항 {

	public static void main(String[] args) {

		try {
			Exception e = new Exception("에러발생~~~");
			throw e; // 강제로 에러 발생
//			System.out.println("안녕~"); // 컴파일 에러 우선 알려줌
		} catch (Exception e) {
			System.out.println("예외발생!!");
			e.printStackTrace();
		}
		System.out.println("프로그램 종료");
		System.out.println("===================");
		try {
			throw new Exception("에러발생~~!!!"); // catch로 강제 소환
		} catch (Exception e) {
			System.out.println(e.getMessage()); // 내가 입력한거 나옴
//			System.out.println("예외발생!!");
//			e.printStackTrace();
		}
		System.out.println("프로그램 종료");
	}

}
