package 배열2문제;

import java.util.Arrays;

public class _17교차합 {

	public static void main(String[] args) {

		/*
		 	[문제]
		 		arr1은 앞에서부터 뒤로 반복
		 		arr2는 뒤에서부터 앞으로 반복
		 		b에 arr1과 arr2 각각의 값의 합을 저장 후 출력
		 */
		int[] arr1 = { 11, 21, 31, 41, 51 };
		int[] arr2 = { 25, 26, 27, 28, 29 };
		int size = arr1.length;
		int[] b = new int[size];
		for (int i = 0; i < arr1.length; i++) {
			b[i] = arr1[i] + arr2[arr2.length - i - 1];
		}
		System.out.println(Arrays.toString(b));
		
		
	}

}
