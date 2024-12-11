package 배열1문제;

public class _02연습문제02 {

	public static void main(String[] args) {

		/*
		 	[문제]
		 		100,200,300,400,500 저장 후
		 		4의 배수와 갯수 출력
		 */
		int[] array = new int[5];
		int cnt = 0;
		System.out.print("4의 배수는 >> ");
		for (int i = 0; i < 5; i += 1) {
			array[i] = (i + 1) * 100;
			if (array[i] % 4 == 0) {
				System.out.print(array[i] + " ");
				cnt += 1;
			}
		}
		System.out.println();
		System.out.println("4의 배수 갯수는 = " + cnt);
	}

}
