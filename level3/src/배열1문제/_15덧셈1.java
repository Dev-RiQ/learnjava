package 배열1문제;

import java.util.Random;

public class _15덧셈1 {

	public static void main(String[] args) {

		/*
		 	[문제]
		 		아래 배열에서 랜덤 값 -100~100을 4개 저장 후
		 		홀수만 출력 후 합 출력
		 */
		Random rd = new Random();
		int[] arr = new int[4];
		System.out.print("int[] arr = ");
		for (int i = 0; i < arr.length; i += 1) {
			arr[i] = rd.nextInt(201) - 100;
			System.out.print(i == 0 ? "{" + arr[i] : ", " + arr[i]);
			System.out.print(i == arr.length - 1 ? "};\n" : "");
		}
		int cnt = 0;
		int sum = 0;
		System.out.print("결과 : ");
		for (int i = 0; i < arr.length; i += 1) {
			if (arr[i] % 2 != 0) {
				cnt += 1;
				sum += arr[i];
				System.out.print(cnt == 1 ? arr[i] : " + " + arr[i]);
			}
		}
		System.out.print(cnt != 0 ? " = " + sum : "홀수 없음");
		
		
	}

}
