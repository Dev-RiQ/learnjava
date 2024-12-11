package 배열1문제;

import java.util.Scanner;

public class _04연습문제03 {

	public static void main(String[] args) {
		
		/*
		 	[문제]
		 		숫자 한 개를 입력받고,
		 		배열 안에서 그 숫자보다 작은 값만 출력하시오.
		 */
		
		int[] array = { 10, 20, 30, 40, 50 };
		Scanner sc = new Scanner(System.in);
		System.out.print("입력 : ");
		int input = sc.nextInt();
		int cnt = 0;
		System.out.print("결과 : ");
		for (int i = 0; i < array.length; i += 1) {

			if (array[i] < input) {
				if (cnt != 0) {
					System.out.print(", ");
				}
				System.out.print(array[i]);
				cnt += 1;
			}
		}
		sc.close();
	}
	

}
