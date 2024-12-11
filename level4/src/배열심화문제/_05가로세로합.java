package 배열심화문제;

import java.util.Arrays;

public class _05가로세로합 {

	public static void main(String[] args) {

		/*
		 	1~9 사이의 숫자가 섞여서 저장되어있는 길이 9 배열
		 	사각형으로 출력후
		 	가로합, 세로합 저장 및 출력
		 */
		int[] arr = { 2, 4, 6, 8, 1, 5, 9, 7, 3 };
		int[] garo = { 0, 0, 0 };
		int[] sero = { 0, 0, 0 };
		for (int i = 0; i < arr.length; i++) {
			System.out.print(i == arr.length - 1 ? arr[i] : arr[i] + ", ");
			garo[i/3] += arr[i];
			sero[i%3] += arr[i];
			if (i % 3 == 2) {
				System.out.println();
			}
		}
		System.out.println(Arrays.toString(garo));
		System.out.println(Arrays.toString(sero));
	}

}
