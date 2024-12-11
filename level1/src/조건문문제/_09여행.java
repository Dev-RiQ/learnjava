package 조건문문제;

public class _09여행 {

	public static void main(String[] args) {

		/*
		 	[문제]
		 		고속버스를 타고 여행을 떠나려한다.
		 		출발시간까지 1시간 여유가 있다.
		 		고속버스역과 상점을 시속 3km로 걸어서 왕복을 하고
		 		10분 동안 물건을 산다고 하면
		 		역에서 1.3km 떨어진 상점을 다녀올 수 있는지 여부를 판단해서
		 		
		 		물건 살 수 있음
		 		물건 살 수 없음
		 		을 출력하시오
		 		
		 */

		int kmPer1hour = 3;
		int timeLeft = 1;
		int timeBuy = 10;
		double kmToShop = 1.3;

		double kmPer1min = kmPer1hour * 1.0 / 60;
		int minLeft = timeLeft * 60;
		double timeNeed = 2 * kmToShop / kmPer1min + timeBuy;

		boolean able = timeNeed <= minLeft && timeNeed > 0;

		System.out.println("소요 시간 : " + timeNeed + "분");

		if (able) {
			System.out.println("물건 살 수 있음");
		}
		if (!able) {
			System.out.println("물건 살 수 없음");
		}
		
		
		
		
	}

}
