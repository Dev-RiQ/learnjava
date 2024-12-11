package 반복문문제01;

public class _04반복문연습문제04 {

	public static void main(String[] args) {

		/*
		 	[문제]
		 		아래조건을 충족하는 식을 작성하시오
		 		1) 10~1까지 거꾸로 반복
		 		2) 3의 배수일때  "안녕"출력
		 		3) 3의 배수 아닐떄는 숫자 출력
		 */
		
		int i = 10;

		while (i >= 1) {
			if (i % 3 == 0) {
				System.out.println("안녕");
			} else {
				System.out.println(i);
			}
			i -= 1;
		}

	}

}
