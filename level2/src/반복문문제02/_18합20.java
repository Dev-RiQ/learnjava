package 반복문문제02;

import java.util.Random;

public class _18합20 {

	public static void main(String[] args) {

		/*
		 	[문제]
		 		1~10 사이의 랜덤 숫자 3개 저장
		 		그 숫자의 합이 무조건 20이 되도록 출력
		 		중복 없이 랜덤값 저장
		 */
		
		Random rd = new Random();
		while (true) {
			int num1 = rd.nextInt(10) + 1;
			int num2 = rd.nextInt(10) + 1;
			int num3 = rd.nextInt(10) + 1;
			int sum = num1 + num2 + num3;
			if (sum == 20 && num1 != num2 && num2 != num3 && num3 != num1) {
				System.out.printf("x = %d, y = %d, z = %d\n", num1, num2, num3);
				break;
			}
		}
		
	}

}
