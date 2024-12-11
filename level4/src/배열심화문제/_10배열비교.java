package 배열심화문제;

import java.util.Arrays;

public class _10배열비교 {

	public static void main(String[] args) {

		/*
		 	arr과 b배열의 값이 서로 겹치면
		 	각 배열의 겹치는 값을 모두 0으로 변경
		 */
		int[] arr = { 30, 30, 30, 10 };
		int[] b = { 20, 3, 10, 20 };
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 0) {
				continue;
			}
			int temp = 0;
			for (int k = 0; k < arr.length; k++) {
				if (arr[i] == b[k]) {
					b[k] = 0;
					temp = arr[i];
				}
			}
			for (int k = 0; k < arr.length; k++) {
				if (temp == arr[k]) {
					arr[k] = 0;
				}
			}
		}
		System.out.println(Arrays.toString(arr));
		System.out.println(Arrays.toString(b));
//		for (int i = 0; i < arr.length; i++) {
//			boolean check = false;
//			for(int k = 0;k<arr.length;k++) {
//				if(arr[i] == b[k]) {
//					b[k] = 0;
//					check = true;
//					}		
//				}
//			if(!check) {
//				continue;
//			}
//			for(int k = i;k<arr.length;k++) {
//				if(arr[i] == arr[k]) {
//					arr[k] = 0;
//				}
//			}
//		}
//		System.out.println(Arrays.toString(arr));
//		System.out.println(Arrays.toString(b));
	}

}
