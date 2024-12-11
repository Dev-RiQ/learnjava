package 배열1문제;

import java.util.Arrays;
import java.util.Random;

public class _12홀수만저장 {

	public static void main(String[] args) {

		/*
		 	[문제]
		 		아래 배열에 랜덤값 -100~100을 4개 저장한 후
		 		그 값 중 홀수만 temp에 저장 후 arr과 temp 배열을 출력하시오
		 */
		int[] arr = new int[4];
		int[] temp1 = new int[4];
		int[] temp2 = new int[4];
		Random rd = new Random();
		for (int i = 0; i < arr.length; i += 1) {
			arr[i] = rd.nextInt(201) - 100;
		}
		int idx = 0;
		for (int i = 0; i < arr.length; i += 1) {
			if (arr[i] % 2 != 0) {
				temp1[i] = arr[i];
				temp2[idx] = temp1[i];
				idx += 1;
			}
		}
		System.out.println(Arrays.toString(arr));
		System.out.println(Arrays.toString(temp1));
		System.out.println(Arrays.toString(temp2));
	}

}
