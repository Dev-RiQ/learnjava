package _level2시험;

public class _01문제 {

	public static void main(String[] args) {

		/*
		 	[문제]
		 		철수와 민수는 같은 수영장에 다닌다.
		 		철수는 4일마다 한 번씩 가고 민수는 5일마다 한 번씩 갔다.
		 		
		 		철수와 민수가 2월 3일에 처음 만났다면
		 		다음에 서로 만나는 날은 언제인지 구하시오. (반복문으로)
		 */
		int i = 1;
		int year = 2024;
		int month = 2;
		int day = 3;

		while (true) {
			if (i % 4 == 0 && i % 5 == 0) {
				break;
			}
			i += 1;
		}
		day += i;
		System.out.println(year + "년 " + month + "월 " + day + "일");

		// 소요 시간 : 2분 50초
	}

}
