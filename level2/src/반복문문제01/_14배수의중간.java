package 반복문문제01;

public class _14배수의중간 {

	public static void main(String[] args) {

		/*
		 	[문제]
		 		1~1000사이의 숫자 중 다음 조건에 맞는 숫자를 출력하시오.
		 		조건) 28의 배수를 출력하는 배수 갯수를 구하고 그 개수 중 중간번쨰
		 			 28의 배수를 구하시오.
		 */

		int i = 1;
		int multi = 28;
		int cnt = 0;
		int max = 1000;
		int centerNum = 0;

		while (i <= max) {
			if (i % multi == 0) {
				cnt += 1;
			}
			i += 1;
		}

		System.out.println("배수의 갯수는 : " + cnt);
		int centerCnt = cnt / 2 + 1;
		System.out.println(centerCnt * multi); //이렇게 바로도 냄

		i = 1;
		cnt = 0;

		while (i <= max) {
			if (i % multi == 0) {
				cnt += 1;
				if (cnt == centerCnt) {
					centerNum = i;
				}
			}
			i += 1;
		}
		System.out.println(centerNum);

		System.out.println("===============");

		multi = 28;
		max = 1000;
		i = multi;
		cnt = 0;
		centerNum = 0;
		int cntMax = max / multi;
		centerCnt = cntMax / 2 + 1;
		
		while (i <= max) {
			cnt += 1;
			if (cnt == centerCnt) {
				centerNum = i;
			}
			i += multi;
		}
		System.out.println("배수의 갯수는 : " + cnt);
		System.out.println(centerNum);
	}

}
