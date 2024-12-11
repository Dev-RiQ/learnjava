package 기초03문제;

public class _08점수차이 {

	public static void main(String[] args) {

		/*
		 * [문제]
		 * 		철수는 국어 80점, 수학 29점을 받았다.
		 * 		민수는 국어 76점, 수학 40점을 받았다.
		 * 		두 학생의 점수 차이는 7이거나 -7이다.
		 * 
		 * 		위 식을 논리 연산자로 표현하시오.
		 */
		
		int koreanChul = 80;
		int mathChul = 29;
		int koreanMin = 76;
		int mathMin = 40;
		
		int totalScoreChul = koreanChul + mathChul;
		int totalScoreMin = koreanMin + mathMin;
		
		boolean result = totalScoreChul - totalScoreMin == 7 || totalScoreChul - totalScoreMin == -7;
		System.out.println(result);
		
		
		
		
	}

}
