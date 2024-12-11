package 배열1문제;

import java.util.Arrays;

public class _17교차저장2 {

	public static void main(String[] args) {

		/*
		 	[문제]
		 		배열 d의 값을 번갈아가며 e, f에 저장
		 */
		int[] d = { 10, 20, 30, 40, 50, 60 };
		int[] e = new int[3];
		int[] f = new int[3];
		int idx = 0;
		for (int i = 0; i < d.length; i+=2) {
				e[idx] = d[i];
				f[idx++] = d[i+1];
		}
			System.out.println(Arrays.toString(e));
			System.out.println(Arrays.toString(f));
		
	}

}
