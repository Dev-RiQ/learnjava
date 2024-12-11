package 배열2문제;

import java.util.Arrays;

public class _16배수저장 {

	public static void main(String[] args) {

		/*
		 	[문제]
		 		4의 배수만 저장
		 */
		//기본 주어진 배열
		int[] arr = { 44, 11, 29, 24, 76 };
		int[] temp = null;
		//4의 배수 갯수 뽑기
		int cnt = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] % 4 == 0) {
				cnt++;
			}
		}
		//배수 갯수 기반 배열 설정
		temp = new int[cnt];
		//배수 저장
		int idx = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] % 4 == 0) {
				temp[idx++] = arr[i];
			}
		}
		System.out.println(Arrays.toString(temp));
	}

}
