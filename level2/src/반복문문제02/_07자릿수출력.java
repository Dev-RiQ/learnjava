package 반복문문제02;

import java.util.Random;

public class _07자릿수출력 {

	public static void main(String[] args) {

		/*
		 	1~99,999사이의 랜덤 숫자를 저장하고
		 	자리 수가 몇 자리인지 구하시오.
		 */

		Random rd = new Random();
		
		int num = rd.nextInt(99999) + 1;
		System.out.print(num + " : ");
		int pos = 0;
		while (num > 0) {
			num /= 10;
			pos += 1;
		}
		System.out.println(pos + "자리");
		
		//
		num = rd.nextInt(99999)+1;
		pos = 0;
		while (true) {
			if (num / 10000 != 0) {
				pos = 5;
			} else if (num / 1000 != 0) {
				pos = 4;
			} else if (num / 100 != 0) {
				pos = 3;
			} else if (num / 10 != 0) {
				pos = 2;
			} else if (num != 0) {
				pos = 1;
			}
			break;
		}
		System.out.println(num + " : " + pos + "자리");
	}
}
