package 예외처리;

class Ex01{
	// 직접 에러 처리
	int sample1(int num, int divider) {
		int result = 0;
		
		try {
			System.out.printf("%d / %d = ",num,divider);
			result = num / divider;
		} catch (ArithmeticException e) {
//			System.out.println("0으로 나눌 수 없습니다.");
		}
		return result;
	}
	
	// throws => 예외를 던진다 (호출한 놈에게 떠넘기기)
	int sample2(int num, int divider) throws ArithmeticException{
		int result = 0;
		
		System.out.printf("%d / %d = ",num,divider);
		result = num / divider;
		return result;
	}
}

public class _05예외떠넘기기 {

	public static void main(String[] args) {

		Ex01 e1 = new Ex01();
		System.out.println(e1.sample1(10, 0));
		try {
			System.out.println(e1.sample2(10, 0));
		} catch (ArithmeticException e) {
			System.out.println(0);
		}
		
	}

}
