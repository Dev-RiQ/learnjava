package _레벨1시험;

public class _02문제 {

	public static void main(String[] args) {

		/*
		 	[문제]
		 		철수는 일정한 빠르기로 운동장을 5바퀴 도는데 1시간 15분 20초가 걸렸다.
		 		7바퀴 도는데 얼마나 걸릴지 구하시오.
		 		(시간 분 초로 표현)
		 		
		 	[정답]
		 		1시간 45분 28초
		 */
		
		int timeHour = 1;
		int timeMin = 15;
		int timeSec = 20;
		int timeTotalSec = timeHour * 3600 + timeMin * 60 + timeSec;
		int round = 5;

		int time1round = timeTotalSec / round;
		int roundTotal = 7;

		int timeFinalSec = time1round * roundTotal;

		int finalHour = timeFinalSec / 3600;
		int finalMin = timeFinalSec % 3600 / 60;
		int finalSec = timeFinalSec % 60;

		System.out.printf("7바퀴 도는데 걸린 시간은 %d시간 %d분 %d초.", finalHour, finalMin, finalSec);
		
		
		//시간 : 4분 53초
	}

}
