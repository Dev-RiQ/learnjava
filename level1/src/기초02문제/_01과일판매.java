package 기초02문제;

public class _01과일판매 {

	public static void main(String[] args) {

		/*
		 * [문제]
		 * 		가게에 과일 250개가 있다.
		 * 		그중에 오전에 120개가 팔렸고, 오후에는 80개가 팔렸다.
		 * 		남은 과일은 전체 과일의 몇 % 인지 구하시오.
		 * [정답]
		 * 		20%
		 */
		
		int fruitCnt = 250;
		int fruitSellCnt1 = 120;
		int fruitSellCnt2 = 80;
		int fruitRemain = fruitCnt - fruitSellCnt1 - fruitSellCnt2;
		double fruitRemainRatio = fruitRemain * 100.0 / fruitCnt; // 정수/정수하면 정수나오니까 실수로 만들기.
		
		System.out.println((int)fruitRemainRatio + " %");
			
		
		
	}

}
