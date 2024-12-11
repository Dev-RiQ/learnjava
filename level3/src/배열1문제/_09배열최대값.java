package 배열1문제;

import java.util.Random;

public class _09배열최대값 {

	public static void main(String[] args) {

		/*
		 	[문제]
		 		array배열에 -100~100사이의 랜덤 숫자를 저장하고,
		 		가장 큰 값의 인덱스와 값을 출력하시오 (5개)
		 */
		
		Random rd = new Random();
		int[] array = new int[5];
		int max = -100;
		int idx = -1;
		for (int i = 0; i < array.length; i += 1) {
			array[i] = rd.nextInt(201) - 100;
			System.out.print(array[i] + " ");
			if (array[i] > max) {
				max = array[i];
				idx = i;
			}
		}
		System.out.println("\n==============");
		System.out.println("가장 큰 값 : " + max + "  인덱스 : " + idx);
		
		
	}

}
