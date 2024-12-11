package 조건문문제;

public class _02오이가격 {

	public static void main(String[] args) {

		/*
		 * [문제]
		 * 		마트에서 오이를 3개씩 묶어서 1500원에 판매한다.
		 * 		오이가 14개 필요하다면,
		 * 		필요한 금액을 출력하시오.
		 * 		단, 오이는 묶음으로만 판매한다.
		 * [정답]
		 * 		7500
		 */

		int price = 1500;
		int buy = 14;
		int set = 3;

		int setNeed = buy / set;

		if (buy % set != 0) {
			setNeed += 1;
		}
		int cost = price * setNeed;
		
		
		System.out.println("총 가격 " + cost + " 원");
		
	}

}
