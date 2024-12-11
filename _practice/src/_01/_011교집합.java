package _01;

import java.util.Arrays;

public class _011교집합 {

	public static void main(String[] args) {
		
		/*
		  /*
		 * [문제]
		 * 두 배열의 교집합(같이 중복되는 부분)을 찾고
		 * 찾은 값을 중복없이 저장하고 출력하시오.
		 */
		
		int[] arr1 = { 2, 3, 3, 5, 5, 6, 7, 7, 8, 12 };
		int[] arr2 = { 5, 5, 6, 8, 8, 9, 10, 10 };
		int[] arr = new int[arr1.length];
		int idx = 0;
		for (int i = 0; i < arr1.length; i++) {
			for (int k = i + 1; k < arr1.length; k++) {
				if (arr1[i] == arr1[k]) {
					arr1[k] = 0;
				}
			}
			for (int k = 0; k < arr2.length; k++) {
				if (arr1[i] == arr2[k]) {
					arr[idx++] = arr1[i];
					break;
				}
			}
		}
		System.out.println(Arrays.toString(arr));
	
	}

}
