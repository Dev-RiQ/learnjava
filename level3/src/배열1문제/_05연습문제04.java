package 배열1문제;

import java.util.Scanner;

public class _05연습문제04 {

	public static void main(String[] args) {

		/*
		 	[문제]
		 		인덱스를 입력받고,
		 		그 인덱스보다 작은 인덱스의 값만 출력
		 */
		int[] array = { 10, 20, 30, 40, 50 };
		Scanner sc = new Scanner(System.in);
		System.out.print("입력 : ");
		int input = sc.nextInt();
		int cnt = 0;
		System.out.print("결과 : ");
		for (int i = 0; i < input; i += 1) {
			System.out.print(cnt == 0 ? array[i] : ", " + array[i]);
			cnt += 1;
		}
		sc.close();
		
		
	}

}
