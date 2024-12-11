package 조건문문제;

import java.util.Random;

public class _13더가까운숫자 {

	public static void main(String[] args) {

		/*
		 * [문제] 랜덤으로 35에서 150사이의 값을 변수 a,b,c에 넣고 값을 출력하시오. 그
		 * 리고 a 와 c 중 어떤 숫자가 b와 더 가까운지 출력하시오
		 */

//		Random rd = new Random();
//		int a = rd.nextInt(116) + 35;
//		int b = rd.nextInt(116) + 35;
//		int c = rd.nextInt(116) + 35;
//
//		int bA = (b - a);
//		int bC = (b - c);
//		System.out.printf("a = %d, b = %d, c = %d\n", a, b, c);
//
//		if (bA < 0) {
//			bA = -bA;
//		}
//		if (bC < 0) {
//			bC = -bC;
//		}
//		System.out.println("b와 a의 차이 = " + bA);
//		System.out.println("b와 c의 차이 = " + bC);
//
//		if (bA > bC) {
//			System.out.println("c가 더 가깝다.");
//		}
//		if (bA == bC) {
//			System.out.println("a와 c가 똑같다.");
//		}
//		if (bA < bC) {
//			System.out.println("a가 더 가깝다.");
//		}
		Random rd = new Random();
		int a = rd.nextInt(116) + 35;
		int b = rd.nextInt(116) + 35;
		int c = rd.nextInt(116) + 35;

		int bA = (b-a)*(b-a);
		int bC = (b-c)*(b-c);
		System.out.printf("a = %d, b = %d, c = %d\n", a, b, c);

		System.out.println("b와 a의 차이 = " + bA);
		System.out.println("b와 c의 차이 = " + bC);

		if (bA > bC) {
			System.out.println("c가 더 가깝다.");
		}
		if (bA == bC) {
			System.out.println("a와 c가 똑같다.");
		}
		if (bA < bC) {
			System.out.println("a가 더 가깝다.");
		}

	}

}
