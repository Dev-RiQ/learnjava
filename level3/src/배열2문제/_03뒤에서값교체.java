package 배열2문제;

import java.util.Arrays;

public class _03뒤에서값교체 {

	public static void main(String[] args) {

		/*
		 	[문제]
		 		arr배열에서 반복을 순차적으로 진행하되
		 		3번째마다 바로 뒤의 값과 위치를 교환후 출력하시오
		 */
		int[] arr = { 10, 20, 30, 40, 50, 60, 70, 80 };
		System.out.println(Arrays.toString(arr));
		for (int i = 0; i < arr.length; i++) {
			if (i % 3 == 2) {
				int temp = arr[i];
				arr[i] = arr[i+1];
				arr[i+1] = temp;
			}
		}
		System.out.println(Arrays.toString(arr));
	}

}
