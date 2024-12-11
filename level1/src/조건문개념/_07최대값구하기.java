package 조건문개념;

import java.util.Random;

public class _07최대값구하기 {

	public static void main(String[] args) {

		/*
		 	[최대값]
		 	1) 숫자 3개를 랜덤으로 저장한다. (-1000~1000사이)
		 	2) 3개의 랜덤 숫자 비교
		 	3) 제일 큰 수 (MAX) 출력
		 */

		Random rd = new Random();

		int num1 = rd.nextInt(2001) - 1000;
		int num2 = rd.nextInt(2001) - 1000;
		int num3 = rd.nextInt(2001) - 1000;

		System.out.printf("num1 = %d \nnum2 = %d \nnum3 = %d\n", num1, num2, num3);
		
		if (num1 >= num2 && num1 >= num3) {
			System.out.println("제일 큰 수 : "+num1);
		}else if(num2 >= num1 && num2 >= num3) {
			System.out.println("제일 큰 수 : "+num2);
		}else {
			System.out.println("제일 큰 수 : "+num3);
		}
		
		int max = num1; //최대
		
		if(max < num2) {
			max = num2;
		}
		if(max < num3) {
			max = num3;
		}
		System.out.println(max);
		
		int min = num1; //최소
		
		if(min > num2) {
			min = num2;
		}
		if(min > num3) {
			min = num3;
		}
		System.out.println(min);
	}

}
