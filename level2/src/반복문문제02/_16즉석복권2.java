package 반복문문제02;

import java.util.Random;

public class _16즉석복권2 {

	public static void main(String[] args) {

		/*
		 	1또는7 랜덤으로 10번출력.
		 	7 연속 3번 이상이면 "당첨", 아니면 "꽝" 출력
		 */
		Random rd = new Random();

		int i = 1;
		int beforeNum = 0;
		int x2 = 0;
		int x3 = 0;

		while (i <= 10) {
			int lotto = rd.nextInt(7) + 1;
			if (lotto != 1 && lotto != 7) {
				continue;
			}
			System.out.print(lotto + " ");
			if (x2 == 1 && beforeNum == 7 && lotto == 7) {
				x3 = 1;
			} else if (beforeNum == 7 && lotto == 7) {
				x2 = 1;
			} else {
				x2 = 0;
			}
			beforeNum = lotto;
			i += 1;
		}
		System.out.println();
		if (x3 == 1) {
			System.out.println("당첨");
		} else {
			System.out.println("꽝");
		}
		
		//
		
		i = 1;
		int cnt = 0;
		int cnt3 = 0;
		
		while (i <= 10) {
			int lotto = rd.nextInt(7) + 1;
			if (lotto != 1 && lotto != 7) {
				continue;
			}
			System.out.print(lotto + " ");
			if (lotto == 7) {
				cnt += 1;
			} else {
				cnt = 0;
			}
			if (cnt >= 3) {
				cnt3 = 1;
			}
			i += 1;
		}
		System.out.println();
		if (cnt3 == 1) {
			System.out.println("당첨");
		} else {
			System.out.println("꽝");
		}
		
		//
		
		i = 1;
		cnt = 0;
		cnt3 = 0;
		
		while (i <= 10) {
			int lotto = rd.nextInt(2);
			if(lotto == 0) {
				lotto = 7;
			}
			System.out.print(lotto + " ");
			if (lotto == 7) {
				cnt += 1;
			} else {
				cnt = 0;
			}
			if (cnt >= 3) {
				cnt3 = 1;
			}
			i += 1;
		}
		System.out.println();
		if (cnt3 == 1) {
			System.out.println("당첨");
		} else {
			System.out.println("꽝");
		}
	}

}
