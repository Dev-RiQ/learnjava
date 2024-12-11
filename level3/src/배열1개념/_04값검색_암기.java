package 배열1개념;

import java.util.Scanner;

public class _04값검색_암기 {

	public static void main(String[] args) {

		/*
		 * [문제] 값을 입력받고 인덱스를 출력하시오. 단, 없는 값이면 -1을 출력하시오
		 */
		Scanner sc = new Scanner(System.in);
		int[] array = { 10, 543, 52, 24, 67 };
		System.out.print("입력 : ");
		int index = sc.nextInt();
		int idx = -1;
		for (int i = 0; i < array.length; i += 1) {
			if (index == array[i]) {
				idx = i;
				break;
			}
		}
		System.out.println("결과 : " + (idx != -1 ? idx : -1));
		sc.close();
	}

}
