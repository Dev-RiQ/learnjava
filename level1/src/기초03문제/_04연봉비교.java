package 기초03문제;


public class _04연봉비교 {

	public static void main(String[] args) {

		/*
		 * [문제]
		 * 		작년 내 연봉은 970원이다.
		 * 		올해는 11퍼센트 인상되었다.
		 * 		올해 우리 회사 평균 월급은 91원이다.
		 * 		올해의 내 연봉이 올해의 우리 회사 평균 연봉보다 큰지 확인하시오.
		 * 		위 내용을 비교연산자로 표현하시오.
		 * [정답]
		 * 		false
		 */
		
		int money = 970;
		int increase = 11;
		double moneyYear = money * (1 + (double)increase/100);
		
		int averageMoney = 91;
		int averageMoneyYear = averageMoney * 12;
		
		boolean result = moneyYear > averageMoneyYear;
		
		System.out.println(result);
		System.out.println(moneyYear);
		System.out.println(averageMoneyYear);
		
		
	}

}
