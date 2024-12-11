package level4시험;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class _09 {

	public static void main(String[] args) {
		/*
		 	1. com에 1~9 사이 숫자 3개 저장 (중복 없이)
		 	2. me에 1~9 사이 숫자 3개 입력 (중복 없이)
		 	3. com과 me 비교해 맞출때 까지 반복
		 	4. 숫자와 자리가 같으면 strike ++, 숫자같은데 자리 다르면 ball++
		 */
		Scanner sc = new Scanner(System.in);
		Random rd = new Random();
		int size = 3;
		int[] com = new int[3];
		int[] me = new int[3];
		boolean isEqual = false;
		for (int i = 0; i < size; i++) {
			com[i] = rd.nextInt(9) + 1;
			for (int k = 0; k < i; k++) {
				if (com[i] == com[k]) {
					isEqual = true;
					break;
				}
			}
			if (isEqual) {
				i--;
				continue;
			}
		}
		System.out.println("com = " + Arrays.toString(com));
		while (true) {
			int strike = 0;
			int ball = 0;
			for (int i = 0; i < size; i++) {
				isEqual = false;
				System.out.print("숫자" + (i + 1) + " 입력 >> ");
				me[i] = sc.nextInt();
				for (int k = 0; k < size; k++) {
					if (k < i && me[i] == me[k]) {
						System.out.println("중복 숫자 입력 불가");
						isEqual = true;
						break;
					}
					if (i != k && me[i] == com[k]) {
						ball++;
					} else if (i == k && me[i] == com[k]) {
						strike++;
					}
				}
				if (isEqual) {
					i--;
					continue;
				}
			}
			System.out.println("me = " + Arrays.toString(me));
			System.out.printf("%ds %db\n", strike, ball);
			if (strike == 3) {
				break;
			}
		}
		System.out.println("다 맞춤!");
		sc.close();
		// 소요 시간 : 13분 27초
	}

}
