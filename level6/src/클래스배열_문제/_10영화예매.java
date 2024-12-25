package 클래스배열_문제;

import java.util.Scanner;

class Seat {
	int y;
	int x;
	String userId;
	boolean isTaken;
	int price;
}

public class _10영화예매 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int seatPrice = 12000;

		String[] userIdList = { "aaa", "bbb", "ccc" };
		String[][] seatUserIdList = { { null, "aaa", "aaa", null }, { null, null, "bbb", null },
				{ "ccc", "bbb", null, "bbb" } };

		Seat[] sList = new Seat[seatUserIdList.length * seatUserIdList[0].length];

		int idx = 0;
		for (int i = 0; i < seatUserIdList.length; i++) {
			for (int k = 0; k < seatUserIdList[i].length; k++) {
				Seat s = new Seat();
				s.y = i;
				s.x = k;
				if (seatUserIdList[i][k] != null) {
					s.userId = seatUserIdList[i][k];
					s.isTaken = true;
					s.price = seatPrice;
				}
				sList[idx++] = s;
			}
		}

		while (true) {
			System.out.println("==========================");
			System.out.println("[0] 종료");
			System.out.println("[1] 전체출력");
			System.out.println("[2] 회원 aaa가 예약한 자리와 요금출력");
			System.out.println("[3] 예약가능한자리 위치출력");
			System.out.println("[4] 예약을 가장 많이한 회원출력");
			System.out.print("메뉴 선택 >> ");
			int sel = sc.nextInt();
			if (sel == 0) {
				System.out.println("프로그램 종료");
				break;
			} else if (sel < 1 || sel > 4) {
				System.out.println("입력 오류");
			} else if (sel == 1) {
				System.out.println("===== 전체 출력 =====");
				for (Seat s : sList) {
					System.out.printf("[%4s ]", (s.userId == null ? "" : s.userId));
					if (s.x == seatUserIdList[0].length - 1)
						System.out.println();
				}

			} else if (sel == 2) {
				String id = "aaa";
				int priceTotal = 0;
				System.out.printf("===== 회원 %s 예약 조회 =====\n", id);

				for (Seat s : sList) {
					if (id.equals(s.userId)) {
						System.out.printf("[%4s ]", s.userId);
						priceTotal += s.price;
					} else
						System.out.printf("[%4s ]", s.userId == null ? "" : "X ");
					if (s.x == seatUserIdList[0].length - 1)
						System.out.println();
				}

				if (priceTotal == 0)
					System.out.println("예약된 내역이 없습니다.");
				else
					System.out.println("총 금액 : " + priceTotal);

			} else if (sel == 3) {
				System.out.println("===== 예약 가능 자리 조회 =====");
				System.out.println("O(예매가능), X(예매불가)");

				for (Seat s : sList) {
					System.out.printf("[%4s ]", s.userId == null ? "O " : "X ");
					if (s.x == seatUserIdList[0].length - 1)
						System.out.println();
				}

			} else if (sel == 4) {
				System.out.println("===== 최다 예매 회원 =====");

				int max = 0;
				String maxUserName = null;
				for (String u : userIdList) {
					int cnt = 0;
					for (Seat s : sList) {
						if (u.equals(s.userId))
							cnt++;
					}
					if (max < cnt) {
						max = cnt;
						maxUserName = u;
					}
				}
				System.out.println(maxUserName + " 회원");
			}
		}
		sc.close();
	}
}
