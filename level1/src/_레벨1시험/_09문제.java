package _레벨1시험;

import java.util.Random;

public class _09문제 {

	public static void main(String[] args) {
		/*
	 	[문제]
	 		1. 숫자 3개를 랜덤 저장하고 출력한다 (-500~500)
	 		2. 3개의 숫자 비교
	 		3. 가장 큰 수 출력
	 	*/

		Random rd = new Random();

		int num1 = rd.nextInt(1001) - 500;
		int num2 = rd.nextInt(1001) - 500;
		int num3 = rd.nextInt(1001) - 500;
		System.out.printf("num1 = %d num2 = %d num3 = %d\n", num1, num2, num3);

		int max = num1;

		if (max < num2) {
			max = num2;
		}
		if (max < num3) {
			max = num3;
		}
		System.out.println(max);

		// 시간 : 4분 34초
	}

}
