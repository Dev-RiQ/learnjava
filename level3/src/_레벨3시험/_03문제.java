package _레벨3시험;

import java.util.Arrays;

public class _03문제 {

	public static void main(String[] args) {

		/*
		 	[문제1]
		 		arr1 배열의 값들을 앞으로 한칸씩 당기고 맨뒤에 a의 값을 저장
		 	[문제2]
		 		arr2 배열을 뒤로 하나씩 밀어낸 후 맨 앞에 b의 값을 저장
		 */
		//1
		int[] arr1 = { 10, 20, 30, 40, 50 };
		int a = 90;
		for (int i = 0; i < arr1.length - 1; i++) {
			arr1[i] = arr1[i + 1];
		}
		arr1[arr1.length - 1] = a;
		System.out.println("arr1 = " + Arrays.toString(arr1));
		//2
		int[] arr2 = { 10, 20, 30, 40, 50 };
		int b = 60;
		for (int i = arr2.length - 1; i > 0; i--) {
			arr2[i] = arr2[i - 1];
		}
		arr2[0] = b;
		System.out.println("arr2 = " + Arrays.toString(arr2));
		// 소요 시간 : 2분 35초
	}

}
