package _레벨3시험;

import java.util.Arrays;
import java.util.Scanner;

public class _02문제 {

	public static void main(String[] args) {

		/*
		 	[문제] 영화관 좌석 예매
		 		1. 좌석번호 입력받음
		 		2. 예매완료 시 좌석 값 1로 변경
		 		3. 이미 예매된 좌석은 재구매 불가
		 		4. 한 좌석당 가격은 12000원
		 		5. 프로그램 종료 후 매출액 출력
		 */
		Scanner sc = new Scanner(System.in);
		int seat[] = new int[7];
		int price = 12000;
		int priceTotal = 0;
		while (true) {
			System.out.println(Arrays.toString(seat));
			System.out.print("좌석 선택 (종료 = -1) >> ");
			int seatNum = sc.nextInt();
			if (seatNum == -1) {
				break;
			}
			if (seatNum < 0 || seatNum > 7) {
				System.out.println("존재하지 않는 좌석입니다");
				continue;
			}
			if (seat[seatNum] != 0) {
				System.out.println("이미 예약이 완료된 좌석입니다");
				continue;
			}
			seat[seatNum] = 1;
			priceTotal += price;
		}
		System.out.println("프로그램 종료");
		System.out.println("총 매출액 = " + priceTotal);
		sc.close();
		// 소요 시간 : 4분 45초
	}

}
