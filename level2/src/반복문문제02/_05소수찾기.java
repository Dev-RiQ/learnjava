package 반복문문제02;

import java.util.Scanner;

public class _05소수찾기 {

	public static void main(String[] args) {

		/*
		 	정수 한 개를 입력받아
		 	해당 숫자가 소수인지 아닌지 판별한다.
		 */

		Scanner sc = new Scanner(System.in);

		System.out.print("정수 입력 >> ");
		int input = sc.nextInt();
		if (input <= 0) {
			System.out.println("양의 정수를 입력하세요");
		}

		int i = 1;
		int cnt = 0;
		while (i <= input) {
			if (input % i == 0) {
				cnt += 1;
			}
			if (cnt == 3) {
				break;
			}
			i += 1;
		}
		if (cnt == 2 && input > 0) {
			System.out.println(input + " = 소수이다");
		} else if (input > 0) {
			System.out.println(input + " = 소수가 아니다");
		}
		sc.close();
		
		//소수 나열
		
//		i = 999999999;
//		while(true) {
//			cnt = 0;
//			int j = 1;
//			while(j<=i) {
//				if (i % j == 0) {
//					cnt += 1;
//				}
//				if (cnt == 3) {
//					break;
//				}
//				j +=1;
//			}
//			if (cnt == 2) {
//				System.out.println(i);
//			}
//				
//			i+=1;
//		}
	}

}
