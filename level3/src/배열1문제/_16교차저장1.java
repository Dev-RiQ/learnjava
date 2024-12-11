package 배열1문제;

public class _16교차저장1 {

	public static void main(String[] args) {

		/*
		 	[문제]
		 		배열 a의 값과 b의 값을 번갈아가면서
		 		배열 c에 저장한다.
		 */
		
		int[] a = { 10, 20, 30 };
		int[] b = { 40, 50, 60 };
		int[] c = new int[6];

		for (int i = 0; i < c.length; i++) {
			if (i % 2 == 0) {
				c[i] = a[i / 2];
			} else {
				c[i] = b[i / 2];
			}
			System.out.print(i == 0 ? "int[] c = {" + c[i] : ", " + c[i]);
			System.out.print(i == c.length - 1 ? "};" : "");
		}
		
	}

}
