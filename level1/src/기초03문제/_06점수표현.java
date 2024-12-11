package 기초03문제;



public class _06점수표현 {

	public static void main(String[] args) {

		/*
		 * [문제]
		 * 		점수1이 60 이상이고 100 이하이면 true를 출력하시오.
		 * [문제]
		 * 		점수2가 0보다 작거나 100보다 크면 true를 출력하시오.
		 */
		
		int score1 = 78;
		
		System.out.println(score1 >= 60 && score1 <= 100);
		
		int score2 = -1;
		
		System.out.println(score2 < 0 || score2 >100);
		
		
		
		
	}

}
