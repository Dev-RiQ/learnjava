package 반복문문제02;

import java.util.Random;

public class _99스터디제작문제_3중간값 {

	public static void main(String[] args) {

		/*
		 	[문제]
		 		1. 1000~9999 사이의 랜덤 값을 3개 출력한다.
		 		2. 해당 값들을 작은 숫자부터 순서대로 출력한다.
		 		3. 가장 작은 수를 제외한 두 숫자의 100의 자릿수를 비교하여,
		 			더 큰 값을 가진 숫자를 최종 출력한다.
		 			(자릿수의 값이 같다면 제일 처음부터 다시 지정한다)
		 	[출력예시]
		 		랜덤 값 >> 7717, 8985, 8974 
				랜덤 값 정렬 >> 7717, 8974, 8985 
				남은 두 수 : 8974, 8985
				100의 자리 >> 9, 9

				[ 다시 설정 ]

				랜덤 값 >> 6547, 1844, 3735 
				랜덤 값 정렬 >> 1844, 3735, 6547 
				남은 두 수 : 3735, 6547
				100의 자리 >> 7, 5
				[ 100의 자리가 더 큰 값 = 3735 ]
		 */
		
		Random rd = new Random();
		int output = 0;
		while (true) {
			int num1 = rd.nextInt(9000) + 1000;
			int num2 = rd.nextInt(9000) + 1000;
			int num3 = rd.nextInt(9000) + 1000;
			System.out.printf("랜덤 값 >> %d, %d, %d \n", num1, num2, num3);
			int min = num1;
			if (min > num2) {
				min = num2;
			}
			if (min > num3) {
				min = num3;
			}
			int max = num1;
			if (max < num2) {
				max = num2;
			}
			if (max < num3) {
				max = num3;
			}
			int mid = num1;
			if (min != num2 && max != num2) {
				mid = num2;
			}
			if (min != num3 && max != num3) {
				mid = num3;
			}
			System.out.printf("랜덤 값 정렬 >> %d, %d, %d \n", min, mid, max);
			System.out.println("남은 두 수 : " + mid + ", " + max);
			System.out.print("100의 자리 >> " + (mid / 100 % 10) + ", " + (max / 100 % 10) + "\n");
			if (mid / 100 % 10 < max / 100 % 10) {
				output = max;
			} else if (mid / 100 % 10 > max / 100 % 10) {
				output = mid;
			} else {
				System.out.println("\n[ 다시 설정 ]\n");
				continue;
			}
			break;
		}
		System.out.println("[ 100의 자리가 더 큰 값 = " + output + " ]");
	}

}
