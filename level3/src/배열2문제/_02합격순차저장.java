package 배열2문제;

import java.util.Arrays;

public class _02합격순차저장 {

	public static void main(String[] args) {

		/*
		 	[문제]
		 		1. 배열 a, b를 비교해 둘의 합을 배열 c에 저장
		 		2. 배열 c의 값 중 짝수만 d에 저장
		 		3. d에 저장할 때 앞에서부터 순차적으로
		 */
		
		int[] a = { 10, 20, 30, 40, 50 };
		int[] b = { 13, 54, 17, 42, 1 };
		int[] c = new int[5];
		int[] d = new int[5];
		int idx = 0;
		for (int i = 0; i < a.length; i++) {
			c[i] = a[i] + b[i];
			if (c[i] % 2 == 0) {
				d[idx++] = c[i];
			}
		}
		System.out.println("int[] c = " + Arrays.toString(c));
		System.out.println("int[] d = " + Arrays.toString(d));
	}
}
