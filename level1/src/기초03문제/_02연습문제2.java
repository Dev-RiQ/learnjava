package 기초03문제;

public class _02연습문제2 {

	public static void main(String[] args) {

		/*
		 * [문제]
		 * 		2에 어떤수 a를 곱한 수가 3에서 a를 뺀 수보다 크다.
		 * 		위 문제를 비교연산자를 사용해 표현하시오.
		 * 		그리고 풀이를 주석으로 표현하시오.
		 * 		단, 답의 기준은 정수로 한다. (소수점이면 올림이나 내림)
		 * 
		 * [정답]
		 * 		a = 2
		 */
		
		// 2 * a > 3 - a
		// 2a + a > 3
		// 3a > 3
		// a > 1
		int a = 2;
		boolean b = 2 * a > 3 - a;
		
		System.out.println(b);
		
		
		
	}

}
