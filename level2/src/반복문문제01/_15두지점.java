package 반복문문제01;

public class _15두지점 {

	public static void main(String[] args) {

		/*
		 	[문제]
		 		철수네 가족은 x와 y 두 지점을 자전거를 타고 왕복하였다.
		 		갈때는 시속 15km, 올때는 시속 12km로 이동하여
		 		총 45분이 걸렸다.
		 		두 지점 x와 y의 각 소요시간과
		 		왕복으로 이동한 총 거리를 구하시오.
		 */
		
		int kmPerHourXY = 15;
		int kmPerHourYX = 12;
		double kmPerMinXY = kmPerHourXY * 1.0 / 60;
		double kmPerMinYX = kmPerHourYX * 1.0 / 60;
		int i = 1;
		int timeTotal = 45;

		while (i <= timeTotal) {
			int timeX = i;
			int timeY = timeTotal - i;
			double XY = kmPerMinXY * timeX;
			double YX = kmPerMinYX * timeY;
			if (XY == YX) {
				System.out.println("X -> Y = " + timeX + "분");
				System.out.println("Y -> X = " + timeY + "분");
				System.out.println("왕복거리 = " + (int)(XY + YX) + "km");
			}
			i += 1;
		}

	}

}
