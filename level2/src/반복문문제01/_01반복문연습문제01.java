package 반복문문제01;

public class _01반복문연습문제01 {

	public static void main(String[] args) {

		/*
		 	[문제1]
		 		1~4까지 출력
		 		
		 	[문제2]
		 		4~1까지 거꾸로 출력
		 		
		 	[문제3]
		 		1~4까지 짝수만 출력
		 */
		
		int i = 1;

		while (i <= 3) {
			System.out.print(i + ", ");
			i += 1;
		}
		System.out.println(i);

		System.out.println("============");

		i = 4;

		while (i >= 1) {
			if (i > 1) {
				System.out.print(i + ", ");
			} else {
				System.out.println(i);
			}
			i -= 1;
		}

		System.out.println("============");
		
		i = 4;
		
		while (i >= 1) {
			System.out.print(i);
			if (i != 1) {
				System.out.print(", ");
			}
			i -= 1;
		}
		
		System.out.println("============");

		i = 2;

		while (i <= 4) {
			System.out.print(i + ", ");
			i += 2;
		}
		
		System.out.println("============");

		i = 1;

		while (i <= 4) {
			if (i % 2 == 0) {
				System.out.print(i + ", ");
			}
			i += 1;
		}
	}

}
