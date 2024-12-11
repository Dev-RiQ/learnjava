package 반복문개념;

public class _15삼항연산자 {

	public static void main(String[] args) {

		//항연산
		
		//단항연산자 ==> num++;
		//이항연산자 ==> num = 10;
		//삼항연산자 ==> 미니if-else문 => 조건? 참값 : 거짓값
		
		int num = 10;
		if (num % 2 == 0) {
			System.out.println("짝수");
		} else {
			System.out.println("홀수");
		}
		System.out.println("===========");
		System.out.println(num % 2 == 0 ? "짝수" : "홀수");

		boolean win = false;
		System.out.println(win ? "이겼다" : "졌다");
		
		int turn = 1;
		turn = turn == 1 ? 2 : 1;
		System.out.println(turn);
	}

}
