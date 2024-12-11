package 조건문문제;

import java.util.Random;

public class _20게임369 {

	public static void main(String[] args) {

		/*
		 	[문제]
		 		1. 1~50 랜덤 숫자 저장
		 		2. 위 수에 3,6,9 개수가
		 			1) 2개이면, 짝짝 출력
		 			2) 1개이면, 짝 출력
		 			3) 0개이면, 해당 숫자를 출력
		 */
		
		Random rd = new Random();
		
		int num = rd.nextInt(50)+1; 
		System.out.println(num);
		
		int num10 = num/10;
		int num1 = num%10;
				
		boolean checkNum1 = ( num1 != 0 && num1%3 == 0);
		boolean checkNum10 = ( num10 != 0 && num10%3 == 0);
		
		if (checkNum10 && checkNum1) {
			System.out.println("짝짝");
		}else if (checkNum10 || checkNum1) {
			System.out.println("짝");
		}else {
			System.out.println(num);
		}
		
		int cnt = 0;
		if(num10==3||num10==6||num10==9) {
			cnt+=1;
		}
		if(num1%3==0&&num1!=0) {
			cnt+=1;
		}
		if(cnt==2) {
			System.out.println("짝짝");
		}else if(cnt==1) {
			System.out.println("짝");
		}else {
			System.out.println(num);
		}
		
		
	}

}
