package 예외처리;

public class _02예외처리2 {

	public static void main(String[] args) {

		try {
			int[] arr = new int[3];
			arr[100] = 100;
			System.out.println(arr[0] / 0);
//		} catch (Exception e) { // 종합으로 미리 처리해서 아래에 다른거 처리 불가
//			System.out.println("예외 발생");
		} catch (IndexOutOfBoundsException e) {
			System.out.println(" 배열의 방길이를 초과했습니다.");
			e.printStackTrace(); // 기본적으로 늘 보던 메시지 나옴
			System.out.println(e.getMessage()); // StackTrace에 포함된 오류 항목 출력
		} catch (ArithmeticException e) { // 오류 이름으로 여러개 만들 수 있음
			System.out.println(" 0으로 나눌 수 없습니다.");
		} catch (Exception e) { // 혹시 모르면 마지막에 전체 처리(else같은 느낌)
			System.out.println("예외 발생");
		}
		System.out.println("프로그램종료");
		
		System.out.println("========================");
		String str = "aaa";
		try {
			int num = Integer.parseInt(str);
		} catch (NumberFormatException e) {
			System.out.println("숫자가 아니다");
			System.out.println(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("프로그램종료");
		System.out.println("========================");
		str = null;
		try {
			System.out.println(str.length());
		} catch (NullPointerException e) {
			System.out.println("null임");
			System.out.println(e.getMessage());
		}
		System.out.println("프로그램종료");
	}

}
