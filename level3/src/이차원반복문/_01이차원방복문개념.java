package 이차원반복문;

public class _01이차원방복문개념 {

	public static void main(String[] args) {

		for (int i = 1; i <= 12; i++) {
			System.out.print(i + " ");
		}
		System.out.println();

		for (int i = 1; i <= 12; i++) {
			System.out.print(i + " ");
			if (i % 4 == 0) {
				System.out.println();
			}
		}
		System.out.println();

		int num = 1;
		for (int i = 0; i < 4; i++) { // 세로
			for (int j = 0; j < 3; j++) { // 가로
//				System.out.print(i+ " " + j + " ");
				System.out.print(num++ + " ");
			}
			System.out.println();
		}
		System.out.println();
		
		/*
		 	[문제]
		 		아래와 같은 사각형을 ㅣ출력하시오
		 		###
		 		###
		 		###
		 */
		//1. 1차원 반복문으로 풀기
		for (int i = 0; i < 9; i++) {
			System.out.print("#");
			if (i % 3 == 2) {
				System.out.println();
			}
		}
		System.out.println();
		// 2. 2차원 반복문으로 풀기
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print("#");
			}
			System.out.println();
		}
		System.out.println();
	}

}
