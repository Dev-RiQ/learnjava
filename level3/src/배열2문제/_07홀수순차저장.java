package 배열2문제;

import java.util.Arrays;

public class _07홀수순차저장 {

	public static void main(String[] args) {

		/*
		 	[문제]
		 		arr배열 값 중 홀수만 배열 c에 저장하시오
		 		위치는 뒤에서부터 저장
		 */
		int[] arr = { 10, 49, 51, 36, 17 };
		int[] c = new int[5];
		int idx = c.length;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] % 2 != 0) {
				c[--idx] = arr[i];
			}
		}
		System.out.println("c = "+Arrays.toString(c));
		
	}

}
