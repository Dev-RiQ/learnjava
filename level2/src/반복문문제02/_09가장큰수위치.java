package 반복문문제02;

import java.util.Random;

public class _09가장큰수위치 {

	public static void main(String[] args) {

		/*
		 	1. 1~9 / 5번 반복
		 	2. 가장 큰 수와 번호를 출력
		 	3. 가장 큰 수가 여러개면 첫 번째 번호를 출력
		 */

		Random rd = new Random();
		//가장 큰 수 처음 번호
		int i = 1;
		int max = 0;
		int cnt = 0;
		
		while (i <= 5) {
			int rdNum = rd.nextInt(9) + 1;
			if (max < rdNum) {
				max = rdNum;
				cnt = i;
			}
			System.out.println(i + "   " + rdNum);
			i += 1;
		}
		System.out.println("가장 큰 수 : " + max);
		System.out.println("가장 큰 수 번호 : " + cnt);
		
		// 가장 큰 수 마지막 번호
		i = 1;
		max = 0;
		cnt = 0;
		
		while (i <= 5) {
			int rdNum = rd.nextInt(9) + 1;
			if (max < rdNum) {
				max = rdNum;
				cnt = i;
			}else if (max == rdNum) {
				cnt = i;
			}
			System.out.println(i + "   " + rdNum);
			i += 1;
		}
		System.out.println("가장 큰 수 : " + max);
		System.out.println("가장 큰 수 번호 : " + cnt);
		 
		
		//가장 큰 수 n번째 번호
		i = 1;
		max = 0;
		cnt = 0;
		int cntN = 0;
		int cntNum = 0;
		
		while (i <= 5) {
			int rdNum = rd.nextInt(9) + 1;
			if (max < rdNum) {
				max = rdNum;
				cnt = i;
				cntN = 1;
			}else if (max == rdNum) {
				cntN += 1;
				if(cntN == 2) {
					cntNum = i;
				}
			}
			System.out.println(i + "   " + rdNum);
			i += 1;
		}
		System.out.println("가장 큰 수 : " + max);
		System.out.println("가장 큰 수 갯수 : " + cntN);
		if(cntN == 1) {
			System.out.println("가장 큰 수 번호 : " + cnt);
		}else {
			System.out.println("가장 큰 수 두 번째 번호 : " + cntNum);
		}
	}

}
