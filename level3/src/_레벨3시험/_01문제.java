package _레벨3시험;

import java.util.Arrays;
import java.util.Scanner;

public class _01문제 {

	public static void main(String[] args) {

		/*
		 	[문제]
		 		인덱스를 입력받고 해당 인덱스의 값을 0으로 변경
		 		추가조건 : 해당 값 양 옆의 값들도 8로 변경
		 		단, 0,4 인덱스일 경우는 양옆 중 한개만 8로 변경
		 */
		Scanner sc = new Scanner(System.in);
		int[] arr = { 9, 9, 9, 9, 9 };
		int idx = arr.length;
		while (true) {
			System.out.print("인덱스 입력 >> ");
			idx = sc.nextInt();
			if (idx < 0 || idx >= arr.length) {
				System.out.println("인덱스 범위 오류");
				continue;
			}
			break;
		}
		arr[idx] = 0;
		if (idx > 0) {
			arr[idx - 1] = 8;
		}
		if (idx < 4) {
			arr[idx + 1] = 8;
		}
		System.out.println(Arrays.toString(arr));
		sc.close();
		// 소요 시간 : 4분 39초
	}

}
