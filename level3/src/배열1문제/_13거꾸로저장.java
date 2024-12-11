package 배열1문제;

import java.util.Arrays;

public class _13거꾸로저장 {

	public static void main(String[] args) {

		/*
		 	[문제]
		 		a배열의 값을 b 배열에 하나씩 저장하는데
		 		순서를 거꾸로 저장하시오
		 */
		int[] a = { 1, 2, 3, 4, 5 };
		int[] b = new int[5];
		for (int i = 0; i < a.length; i += 1) {
			b[i] = a[a.length - 1 - i];
		}
		System.out.println(Arrays.toString(b));

		int idx = a.length;
		for (int i = 0; i < a.length; i += 1) {
			idx -= 1;
			b[i] = a[idx];
		}
		System.out.println(Arrays.toString(b));

		idx = a.length - 1;
		for (int i = 0; i < a.length; i += 1) {
			b[i] = a[idx - i];
		}
		System.out.println(Arrays.toString(b));
	}

}
