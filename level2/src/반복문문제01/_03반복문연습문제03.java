package 반복문문제01;

public class _03반복문연습문제03 {

	public static void main(String[] args) {

		/*
	 	[문제]
	 		아래 조건을 만족하는 식을 작성하시오.
	 			조건 1) 10~1 까지 거꾸로 반복문 실행
	 			조건 2) 3~6까지는 숫자대신 "안녕" 출력
	 			조건 3) 3~6까지 아닐때는 숫자를 출력한다.
		 */
	
		int i = 10;

		while (i >= 1) {
			if (i >= 3 && i <= 6) {
				System.out.println("안녕");
			} else {
				System.out.println(i);
			}
			i -= 1;
		}

	}

}
