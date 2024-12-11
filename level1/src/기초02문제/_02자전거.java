package 기초02문제;

public class _02자전거 {

	public static void main(String[] args) {

		/*
		 * [문제]
		 * 		철수는 자전거를 타고 일정한 빠르기로 7분 동안 23/30km를 갔다.
		 * 		철수가 자전거를 타고 1분 동안 간 거리가 몇 km인지 구하시오.
		 * 		단, 소수점 두 자리까지 출력하시오.
		 * [정답]
		 * 		0.11km
		 */
		
		int min = 7;
		double move = 23.0 / 30;
		double movePerMin = move / min;
		
		System.out.println(String.format("%.2f",movePerMin) + " km");
		System.out.println(String.format("%.2f km",movePerMin));
		System.out.println(Math.round(movePerMin*100)/100.0 + " km");
		System.out.printf("%.2f km \n",(movePerMin*100)/100.0 );
		
				
		
	}

}
