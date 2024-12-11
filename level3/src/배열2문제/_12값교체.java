package 배열2문제;

import java.util.Arrays;
import java.util.Scanner;

public class _12값교체 {

	public static void main(String[] args) {

		/*
		 	[문제]
		 		값 2개를 입력받아 arr배열에서 두 값을 교체하시오
		 		단, 없는 값 입력 시 예외처리
		 */
		Scanner sc = new Scanner(System.in);
		int[] arr = { 10, 20, 30, 40, 50 };
		System.out.print("값1 입력 : ");
		int val1 = sc.nextInt();
		System.out.print("값2 입력 : ");
		int val2 = sc.nextInt();
		System.out.print("결과 : ");
		int idx1 = arr.length;
		int idx2 = arr.length;
		for (int i = 0; i < arr.length; i++) {
			if (val1 == arr[i]) {
				idx1 = i;
			}
			if (val2 == arr[i]) {
				idx2 = i;
			}
		}
		if (idx1 == arr.length || idx2 == arr.length) {
			System.out.println("값을 잘못 입력했습니다.");
		} else {
			arr[idx1] = val2;
			arr[idx2] = val1;
			System.out.println(Arrays.toString(arr));
		}
		sc.close();
	}

}
