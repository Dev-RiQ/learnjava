package 배열1문제;

public class _07연습문제05 {

	public static void main(String[] args) {

		/*
		 	[문제]
		 		1. array의 값을 temp1에 복사 후, 모든 값을 출력
		 		2. array값의 2배를 temp2에 복사 후, 모든 값을 출력
		 */
		int[] array = { 10, 20, 30, 40, 50 };
		int[] temp1 = new int[5];
		int[] temp2 = new int[5];
		for (int i = 0; i < array.length; i += 1) {
			temp1[i] = array[i];
			System.out.print(i == 0 ? temp1[i] : ", " + temp1[i]);
		}
		System.out.println();
		for (int i = 0; i < array.length; i += 1) {
			temp2[i] = array[i] * 2;
			System.out.print(i == 0 ? temp2[i] : ", " + temp2[i]);
		}
		
	}

}
