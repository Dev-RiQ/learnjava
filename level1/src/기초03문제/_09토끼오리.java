package 기초03문제;

public class _09토끼오리 {

	public static void main(String[] args) {

		/*
		 * [문제]
		 * 		어느 농장에는 토끼와 오리가 모두 35마리가 있다.
		 * 		토끼와 오리의 다리의 수의 합이 96개일 때,
		 * 		토끼와 오리는 각각 몇 마리 인지 주석으로 표현하시오.
		 * [정답]
		 * 		토끼 = 13
		 * 		오리 = 22
		 */
		
		// 토끼 a마리
		// 오리 b마리
		// a+b = 35
		// 4a+2b = 96
		// b = 35-a
		// 4a +70 - 2a = 96
		// 2a = 26
		// a = 13
		// b = 35 -13 = 22

		int rabbitCnt = 13;
		int duckCnt = 22;
		int rabbitLeg = 4;
		int duckLeg = 2;
		
		int totalCnt = rabbitCnt + duckCnt;
		int totalLeg = rabbitLeg*rabbitCnt + duckLeg*duckCnt;
		
		boolean res = totalCnt == 35 && totalLeg == 96;
		
		System.out.println(res);
		
	}

}
