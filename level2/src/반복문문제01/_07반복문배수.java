package 반복문문제01;

public class _07반복문배수 {

	public static void main(String[] args) {

		/*
		 	[문제]
		 		7의 배수 중 1보다 크고 150보다 작은 수 중
		 		가장 큰 수를 출력하시오.
		 */
		
		
		int i = 1;
		int max = 0;

		while (i < 150) {
			if (i % 7 == 0) {
				max = i;
			}

			i += 1;
		}
		System.out.println(max);
		
		
		i = 150;
		max = 0;
		while (i >= 1) {
			if (i % 7 == 0) {
				max = i;
				i = 0;
			}
			i -= 1;
		}
		System.out.println(max);
		
		i = 0;
		while (i + 7 < 150) {
			i += 7;
		}
		System.out.println(i);
	}

}
