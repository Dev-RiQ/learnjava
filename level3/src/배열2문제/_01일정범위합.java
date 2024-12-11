package 배열2문제;

import java.util.Arrays;
import java.util.Scanner;

public class _01일정범위합 {

	public static void main(String[] args) {

		/*
		 	[문제]
		 		인덱스 2개를 입력받고
		 		작은 인덱스에서부터 큰 인덱스까지의 값들의 합을 출력하시오
		 		단, index1이 index2보다 더 크더라도
		 		작은 인덱스부터 큰 인덱스까지의 합을 출력하시오
		 */
		Scanner sc = new Scanner(System.in);
		int[] array = { 10, 43, 25, 76, 3, 100, 56 };
		System.out.println(Arrays.toString(array));
		System.out.println("인덱스 입력 (0~" + (array.length - 1) + ")");
		int index1 = 0;
		int index2 = 0;
		while(true) {
			System.out.print("인덱스1 입력 : ");
			index1 = sc.nextInt();
			System.out.print("인덱스2 입력 : ");
			index2 = sc.nextInt();
			if ((index1 >= array.length || index2 >= array.length) || (index1 < 0 || index2 < 0)) {
				System.out.println("범위 초과");
				continue;
			}
			break;
		}
		if (index1 > index2) {
			int index = index1;
			index1 = index2;
			index2 = index;
		}
		int sum = 0;
		for (int i = index1; i <= index2; i++) {
			System.out.print(i == index1 ? "출력 : " + array[i] : " + " + array[i]);
			sum += array[i];
		}
		System.out.println(index1 == index2 ? "" : " = " + sum);
		sc.close();
		
		
		
		
	}

}
