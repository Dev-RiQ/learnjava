package level4시험;

public class _05 {

	public static void main(String[] args) {

		/*
		 	아래와 같은 데이터일때 도서 연체 여부 출력(윤년 계산 X)
		 */
		int rentalPeriod = 10;
		int[] rentalDay = { 2024, 10, 25 };
		int[] today = { 2024, 11, 06 };
		int[] monthList = { 31, 28, 31, 30, 31, 31, 30, 31, 30, 31, 30, 31 };
		int day = 0;
		while (true) {
			rentalDay[2]++;
			day++;
			if (rentalDay[2] > monthList[rentalDay[1] - 1]) {
				rentalDay[2] = 1;
				rentalDay[1]++;
			}
			if (rentalDay[1] > 12) {
				rentalDay[1] = 1;
				rentalDay[0]++;
			}
			int cnt = 0;
			for (int i = 0; i < rentalDay.length; i++) {
				if (rentalDay[i] == today[i]) {
					cnt++;
				}
			}
			if (cnt == 3) {
				break;
			}

		}
		int dayDelay = day - rentalPeriod;
		System.out.printf("빌린지 %d일 연체일이 %d일 경과 되었습니다.", day, dayDelay);
		// 소요 시간 : 34분 11초
	}

}
