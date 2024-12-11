package 반복문문제02;

import java.util.Random;

public class _08최대값갯수 {

	public static void main(String[] args) {

		/*
		 	랜덤으로 1~10을 10번 출력하고
		 	가장 큰 수를 출력하시오.
		 	단, 가장 큰 수가 여러번 나온 경우
		 	출력된 횟수도 함께 출력하시오.
		 */
		
		Random rd = new Random();
		int i = 1;
		int cnt = 0;
		int max = 0;

		while (i <= 10) {
			int rdNum = rd.nextInt(10) + 1;
			if (max < rdNum) {
				max = rdNum;
				cnt = 0;
			}
			if(max == rdNum) {
				cnt += 1;
			}
			System.out.println("i = " + i + ", rdNum = " + rdNum + ", max = " + max + ", cnt = " + cnt);
			i += 1;
		}
		System.out.println("10개 중 최대 : " +max);
		System.out.println("최대 값은 "+cnt+"번");
	}

}
