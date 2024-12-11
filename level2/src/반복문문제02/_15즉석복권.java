package 반복문문제02;

import java.util.Random;

public class _15즉석복권 {

	public static void main(String[] args) {

		/*
		 	1~9사이의 랜덤 값을 4개 출력한다.
		 	랜덤 값이 모두 짝수이면 "당첨"을 출력,
		 	하나라도 짝수가 아니면 "꽝"을 출력한다.
		 */
		
		Random rd = new Random();
		int i = 1;
		int cnt = 0;
		while (i <= 4) {
			int rdNum = rd.nextInt(9) + 1;
			System.out.print(rdNum + " ");
			if (rdNum % 2 == 0) {
				cnt += 1;
			}
			i += 1;
		}
		System.out.print(": ");
		if (cnt == 4) {
			System.out.println("당첨");
		} else {
			System.out.println("꽝");
		}
		
		
	}

}
