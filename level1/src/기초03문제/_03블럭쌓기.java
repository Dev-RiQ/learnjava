package 기초03문제;

public class _03블럭쌓기 {

	public static void main(String[] args) {

		/*
		 * [문제]
		 * 		철수는 2시간 동안 블럭은 231개 쌓았다.
		 * 		민수는 1시간 반 동안 블럭을 177개 쌓았다.
		 * 		철수가 민수보다 블럭을 쌓는 속도가 더 빠른지 여부를
		 * 		true 또는 false로 표현하시오.
		 * [정답]
		 * 		false
		 */
		int timeChulsoo = 2;
		int buildChulsoo = 231;
		double buildPerHourChulsoo = (double)buildChulsoo / timeChulsoo;
		
		double timeMinsoo = 1.5;
		int buildMinsoo = 177;
		double buildPerHourMinsoo = (double)buildMinsoo / timeMinsoo;
		
		System.out.println(buildPerHourChulsoo > buildPerHourMinsoo);
		
		boolean result = buildPerHourChulsoo > buildPerHourMinsoo;
		
		System.out.println(result);
		
		System.out.println(buildPerHourChulsoo);
		System.out.println(buildPerHourMinsoo);
		
	}

}
