package 반복문문제02;

import java.util.Random;
import java.util.Scanner;

public class _99스터디제작문제_1약수갯수 {

	public static void main(String[] args) {

		/*
		 	[문제]
		 		1. 1~99 사이의 값을 랜덤으로 2개 저장.
		 		2. 1~5 사이의 값 1개 입력받음 (오류 처리 필수 : 오류 재입력 시 랜덤값 변동X)
		 		3. 랜덤 값들의 약수를 모두 출력하고, 각 약수의 갯수도 출력
		 		4. 약수의 갯수중 작은 값을 출력하고, 해당 값과 입력값을 비교
		 		5. 비교 값이 일치하면 "일치" 출력후 종료
		 				   불일치하면 "불일치" 출력 후 처음부터 다시 시작
		 	[출력예시]
		 		1~5 사이의 값을 입력하세요 >> 3
				87의 약수 : 1 3 29 87 
				[ 갯수 : 4 ]
				21의 약수 : 1 3 7 21 
				[ 갯수 : 4 ]
				약수의 최소 갯수 : 4
				불일치

	 			1~5 사이의 값을 입력하세요 >> 2
				43의 약수 : 1 43 
				[ 갯수 : 2 ]
				75의 약수 : 1 3 5 15 25 75 
				[ 갯수 : 6 ]
				약수의 최소 갯수 : 2
				일치
		 */
		
		Random rd = new Random();
		Scanner sc = new Scanner(System.in);

		int input = 0;
		int cnt1 = 0;
		int cnt2 = 0;
		while (true) {
			int num1 = rd.nextInt(99) + 1;
			int num2 = rd.nextInt(99) + 1;
			while (true) {
				System.out.print("1~5 사이의 값을 입력하세요 >> ");
				input = sc.nextInt();
				if (input < 1 || input > 5) {
					System.out.println("입력오류");
					continue;
				}
				break;
			}
			System.out.print(num1 + "의 약수 : ");
			int i = 1;
			while (i <= num1) {
				if (num1 % i == 0) {
					System.out.print(i + " ");
					cnt1 += 1;
				}
				i += 1;
			}
			System.out.println("\n[ 갯수 : " + cnt1 + " ]");
			System.out.print(+num2 + "의 약수 : ");
			i = 1;
			while (i <= num2) {
				if (num2 % i == 0) {
					System.out.print(i + " ");
					cnt2 += 1;
				}
				i += 1;
			}
			System.out.println("\n[ 갯수 : " + cnt2 + " ]");
			int min = cnt1;
			if (cnt1 > cnt2) {
				min = cnt2;
			}
			System.out.println("약수의 최소 갯수 : " + min);
			if (input != min) {
				System.out.println("불일치\n");
				cnt1 = 0;
				cnt2 = 0;
				continue;
			} else {
				System.out.println("일치");
				break;
			}
		}
		sc.close();
		
		
	}

}
