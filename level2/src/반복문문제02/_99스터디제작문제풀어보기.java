package 반복문문제02;

import java.util.Random;

public class _99스터디제작문제풀어보기 {

	public static void main(String[] args) {

		/*
	 	[문제]
	 		1. 1~99 사이의 값을 랜덤으로 2개 저장.
	 		2. 랜덤 값들의 약수를 모두 출력하고, 각 약수의 갯수도 출력
	 		3. 약수의 갯수중 작은 값을 출력하고
	 */
		
		Random rd = new Random();

		int num1 = rd.nextInt(99) + 1;
		int num2 = rd.nextInt(99) + 1;
		int i = 1;
		int cnt1 = 0;
		int cnt2 = 0;
		int min = 0;
		System.out.print(num1 + "의 약수 : ");
		while (i <= num1) {
			if (num1 % i == 0) {
				System.out.print(i + " ");
				cnt1 += 1;
			}
			i += 1;
		}
		System.out.println("\n[ 갯수 : " + cnt1 + " ]");
		System.out.print(num2 + "의 약수 : ");
		i = 1;
		while (i <= num2) {
			if (num2 % i == 0) {
				System.out.print(i + " ");
				cnt2 += 1;
			}
			i += 1;
		}
		System.out.println("\n[ 갯수 : " + cnt2 + " ]");
		min = cnt1;
		if (min > cnt2) {
			min = cnt2;
		}
		System.out.println("약수의 최소 갯수 : " + min);

	}

}
