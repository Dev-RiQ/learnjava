package 배열2문제;

import java.util.Arrays;

public class _15한줄저장 {

	public static void main(String[] args) {

		/*
		 	[문제]
		 		arr1배열과 arr2배열을 서로 붙여서 temp배열에 저장하시오
		 */
		int[] arr1 = { 2, 65, 34, 76, 8, 5 };
		int[] arr2 = { 6, 54, 1, 4 };
		int[] temp = null;

		int idx = arr1.length + arr2.length;
		temp = new int[idx];
		for (int i = 0; i < temp.length; i++) {
			if (i < arr1.length) {
				temp[i] = arr1[i];
			} else {
				temp[i] = arr2[i - arr1.length];
			}
		}
		System.out.println(Arrays.toString(temp));
	}

}
