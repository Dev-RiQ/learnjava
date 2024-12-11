package 배열2문제;

import java.util.Arrays;
import java.util.Random;

public class _13즉석복권 {

	public static void main(String[] args) {

		/*
		 	[문제]
		 		1. 7개의 배열 방 생성
		 		2. 랜덤으로 1과 7만 저장
		 		3. 당첨 꽝 출력 (7 연속 3번 일떄 당첨)
		 		   심화( 7 나올 확률 40%)
		 */
		Random rd = new Random();
		
		// 1
		int[] lotto = new int[7];
		int cnt = 0;
		boolean win = false;
		for (int i = 0; i < lotto.length; i++) {
			lotto[i] = rd.nextInt(10);
			if (lotto[i] < 6) {
				lotto[i] = 1;
				cnt = 0;
			} else {
				lotto[i] = 7;
				cnt++;
				if (cnt == 3) {
					win = true;
				}
			}
		}
		System.out.println(win ? "당첨" : "꽝");
		System.out.println(Arrays.toString(lotto));

		// 2
		lotto = new int[7];
		win = false;
		for (int i = 0; i < lotto.length; i++) {
			lotto[i] = rd.nextInt(10);
			if (lotto[i] < 6) {
				lotto[i] = 1;
			} else {
				lotto[i] = 7;
				if (i > 1 && lotto[i] == lotto[i - 1] && lotto[i] == lotto[i - 2]) {
					win = true;
				}
			}
		}
		System.out.println(win ? "당첨" : "꽝");
		System.out.println(Arrays.toString(lotto));

		// 3
		lotto = new int[7];
		int idx = lotto.length;
		cnt = 0;
		for (int i = 0; i < lotto.length; i++) {
			lotto[i] = rd.nextInt(10);
			if (lotto[i] < 6) {
				lotto[i] = 1;
			} else {
				lotto[i] = 7;
				if (i - idx == 1) {
					cnt++;
				} else if (cnt < 2) {
					cnt = 0;
				}
				idx = i;
			}
		}
		System.out.println(cnt >= 2 ? "당첨" : "꽝");
		System.out.println(Arrays.toString(lotto));
		
	}

}
