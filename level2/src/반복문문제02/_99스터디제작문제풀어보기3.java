package 반복문문제02;

import java.util.Random;

public class _99스터디제작문제풀어보기3 {

	public static void main(String[] args) {

		/*
	 	[문제]
	 		1. 1000~9999 사이의 랜덤 값을 2개 출력한다.
	 		2. 해당 값들을 작은 숫자부터 순서대로 출력한다.
	 		3. 두 숫자의 100의 자릿수를 비교하여,
	 			더 큰 값을 가진 숫자를 최종 출력한다.
	 			(자릿수의 값이 같다면 제일 처음부터 다시 지정한다)
		 */
		
		Random rd = new Random();
		int max = 0;
		int min = 0;
		while (true) {
			int num1 = rd.nextInt(9000) + 1000;
			int num2 = rd.nextInt(9000) + 1000;
			System.out.printf("랜덤 값 >> %d, %d", num1, num2);
			max = num1;
			if (max < num2) {
				max = num2;
			} else {
				min = num2;
			}
			System.out.printf("\n랜덤 값 정렬 >> %d, %d", min, max);
			System.out.printf("\n100의 자리 >> %d, %d\n", min / 100 % 10, max / 100 % 10);
			if (min / 100 % 10 > max / 100 % 10) {
				max = min;
			} else if (min / 100 % 10 == max / 100 % 10) {
				System.out.println("\n[ 다시 설정 ]\n");
				continue;
			}
			System.out.println("\n[ 100의 자리가 더 큰 값 = " + max + " ]");
			break;
		}
	}

}
