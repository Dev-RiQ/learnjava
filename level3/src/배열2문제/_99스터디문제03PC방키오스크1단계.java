package 배열2문제;

import java.util.Scanner;

public class _99스터디문제03PC방키오스크1단계 {

	public static void main(String[] args) {

		/*
		 	[문제] PC방 키오스크 1단계
		 		더조은 PC방의 좌석은 총 9석이다.
		 		PC방 키오스크에서 시간 구매 및 사용 종료 가능
		 		메뉴 (1.신규 구매, 2.추가 구매, 0.사용 종료)
		 		신규 구매 시 좌석 선택(빈좌석만 가능) 후 구매 시간 선택
		 		시간 추가 시 좌석 선택(이용중인 좌석만 가능) 후 구매 시간 선택
		 		구매한 시간과 금액은 time,price배열에 누적으로 저장한다. ( 시간 차감은 X)
		 		사용 종료 시 좌석 선택(이용중인 좌석만 가능) 후 
		 		해당 좌석 총 구매 시간, 총 이용 금액 출력 및 시간과 요금 및 좌석 초기화
		 		-999입력 시 프로그램 종료
		 */
		int[] time = new int[9];
		int[] price = new int[9];
		boolean[] seat = new boolean[9];
		int seatNum = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("=== 더조은 PC방 ===");
		while (true) {
			System.out.println("1.신규 구매");
			System.out.println("2.추가 구매");
			System.out.println("0.사용 종료");
			System.out.print("메뉴 선택 >> ");
			int menu = sc.nextInt();
			if (menu == -999) {
				System.out.println("프로그램 종료");
				break;
			}
			if (menu < 0 || menu > 2) {
				System.out.println("입력 오류입니다");
				System.out.println();
				continue;
			}
			while (true) {
				for (int i = 0; i < seat.length; i++) {
					System.out.print(" " + (i + 1) + " ");
				}
				System.out.println();
				for (int i = 0; i < seat.length; i++) {
					System.out.print(seat[i] == false ? "[□]" : "[■]");
				}
				System.out.println();
				System.out.print("좌석 선택  >> ");
				seatNum = sc.nextInt();
				if (seatNum < 1 || seatNum > 20) {
					System.out.println("존재하지 않는 좌석입니다");
					System.out.println();
					continue;
				}
				if (menu == 1 && seat[seatNum - 1] == true) {
					System.out.println("사용 중인 좌석입니다");
					System.out.println();
					continue;
				}
				if (menu != 1 && seat[seatNum - 1] == false) {
					System.out.println("사용 중인 좌석을 선택하세요");
					System.out.println();
					continue;
				}
				break;
			}
			if (menu == 0) {
				System.out.println();
				System.out.printf("%d번 좌석 사용 종료\n", seatNum);
				System.out.printf("총 %d시간 이용, %d원 사용\n", time[seatNum - 1], price[seatNum - 1]);
				seat[seatNum - 1] = false;
				time[seatNum - 1] = 0;
				price[seatNum - 1] = 0;
				continue;
			}
			while (true) {
				System.out.println();
				System.out.println("1. 1시간 (1,000원)");
				System.out.println("2. 2시간 (2,000원)");
				System.out.println("3. 3시간 (3,000원)");
				System.out.print("시간 선택 >> ");
				int timeSet = sc.nextInt();
				if (timeSet < 1 || timeSet > 3) {
					System.out.println("입력 오류입니다");
					continue;
				}
				seat[seatNum - 1] = true;
				time[seatNum - 1] += timeSet;
				price[seatNum - 1] += timeSet * 1000;
				break;
			}
			System.out.println();

		}
		sc.close();
		
		
		
	}

}
