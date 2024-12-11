package 조건문문제;

import java.util.Random;

public class _11주사위게임 {

	public static void main(String[] args) {

		/*
		 	[문제]
		 		철수는 주사위 2개를 가지고 있다.
		 		주사위는 눈금이 1~6까지 있다.
		 		철수가 주사위 2개를 던졌을 떄 그 합을 출력하시오.
		 		단, 주사위 눈금이 서로 같으면 6을 추가로 더하시오.
		 */
		
		Random rd = new Random();
                    
		int dice1 = rd.nextInt(6) + 1;
		int dice2 = rd.nextInt(6) + 1;
		int sum = dice1 + dice2;

		System.out.println("1번 주사위 = " + dice1);
		System.out.println("2번 주사위 = " + dice2);

		if (dice1 == dice2) {
			sum += 6;
			System.out.println("더블 보너스 주사위 합은" + sum  + " 입니다.");
		}
		if (dice1 != dice2) {
			System.out.println("주사위 합은 " + sum + " 입니다.");
		}
		
		
		
	}

}
