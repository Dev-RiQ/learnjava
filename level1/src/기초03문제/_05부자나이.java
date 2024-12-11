package 기초03문제;

public class _05부자나이 {

	public static void main(String[] args) {

		/*
		 * [문제]
		 * 		철수는 13살, 철수의 아버지는 45살이다.
		 * 		몇 년 후 철수의 아버지는 철수 나이의 3배가 될지 구하시오.
		 * 		위 식을 표현하고, 풀이 과정을 주석으로 작성하시오.
		 * [정답]
		 * 		3
		 */
		
		int ageSon = 13;
		int ageDad = 45;
				
		int year = 3;		
		boolean result = 3 * (ageSon + year) == ageDad + year;
		
		// 3(13+n) = 45+n
		// 39 +3n = 45 + n
		// 2n = 6
		// n = 3
		
		System.out.println(result);
	
		
		
	}

}
