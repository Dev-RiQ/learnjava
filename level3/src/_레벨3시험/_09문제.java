package _레벨3시험;

public class _09문제 {

	public static void main(String[] args) {

		/*
		 	[문제]
		 		1. seatList는 영화관 7자리를 의미한다
		 		2. seatList의 값들은 예매한 회원번호를 나타낸다
		 		3. find의 값들은 검색하고자하는 회원번호들이다
		 		4. find의 값을 영화관에서 찾아 자리를 출력해주자
		 			단, 없는 번호는 X 출력
		 */
		int[] seatList = { 1003, 1003, 0, 0, 1002, 0, 1001 };
		int[] find = { 1004, 1003, 1001, 1005 };
		for (int i = 0; i < find.length; i++) {
			int cnt = 0;
			System.out.print(find[i] + " : ");
			for (int k = 0; k < seatList.length; k++) {
				if (find[i] == seatList[k]) {
					System.out.print(k + " ");
					cnt++;
				}
			}
			if (cnt == 0) {
				System.out.print("X");
			}
			System.out.println();
		}
		// 소요 시간 : 7분 10초
	}

}
