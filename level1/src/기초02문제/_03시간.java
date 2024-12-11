package 기초02문제;

public class _03시간 {

	public static void main(String[] args) {

		/*
		 * [문제1]
		 * 		4000초를 시간만 출력하시오.
		 * 		4000초를 시간을 제외하고 분만 출력하시오.
		 * 		4000초를 시간과 분을 제외하고 초만 출력하시오.
		 */
		
		int time = 4000;
		int hour = time/3600;
		int min = time%3600/60;
		int sec = time%60;
		
		System.out.println(hour + "시간");
		System.out.println(min + "분");
		System.out.println(sec + "초");
		
		
	}

}
