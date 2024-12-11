package 반복문문제01;

public class _02반복문연습문제02 {

	public static void main(String[] args) {

		/*
		 	[문제]
		 		아래 조건을 만족하는 식을 작성하시오.
		 			조건 1) 1~10까지 반복문 실행
		 			조건 2) 1~5까지는 숫자대신 "안녕" 출력
		 			조건 3) 6~10까지는 숫자를 출력한다.
		 */

		int i = 1;

		while (i <= 10) {
			if (i <= 5) {
				System.out.println("안녕");
			} else {
				System.out.println(i);
			}
			i += 1;
		}

	}

}
