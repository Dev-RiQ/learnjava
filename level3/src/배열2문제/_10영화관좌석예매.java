package 배열2문제;

import java.util.Scanner;

public class _10영화관좌석예매 {

	public static void main(String[] args) {

		/*
		 	[문제]
		 		영화관 좌석 예매
		 		1. 좌석번호 입력
		 		2. 완료되면 해당 좌석 값을 1로 변경
		 		3. 이미 예매된 좌석 재구매 불가
		 		4. 한 좌석당 가격 12000원
		 		5. 프로그램 종료 후, 해당 영화관의 총 매출액 출력
		 */
		
		Scanner sc = new Scanner(System.in);
		int[] seat = new int[7];
		int moneyTotal = 0;
		System.out.println("=더조은 영화관=");
		
		while(true) {
			System.out.println("1.좌석예매");
			System.out.println("2.종료");
			System.out.print("메뉴 선택 : ");
			int menu = sc.nextInt();
			if(menu == 1||menu==2) {
				for(int i =0;i<seat.length;i++) {
					System.out.print(" "+(i+1) + " ");
				}
				System.out.println();
				for(int i =0;i<seat.length;i++) {
					System.out.print(seat[i]==0? "[□]":"[■]");
				}
				if(menu==2) {
					break;
				}
				
				System.out.println();
				System.out.print("좌석번호 입력 (1-7) >>");
				int seatNum = sc.nextInt();
				System.out.println();
				if(seatNum<1 || seatNum>7) {
					System.out.println("오류");
					continue;
				}
				if(seat[seatNum-1]!=0) {
					System.out.println("이선좌");
					continue;
				}				
				System.out.println("완료");
				seat[seatNum-1]=1;
				moneyTotal += 12000;
			}
		}
		System.out.println();
		System.out.println("매출액 = "+ moneyTotal);
		System.out.println("프로그램 종료");
		sc.close();
	
		
		
		
		
		
		
		
		
		
		
		
//		Scanner sc = new Scanner(System.in);
//		int[] seat = new int[7];
//		int priceTotal = 0;
//		System.out.println("=== 더조은 영화관 ===");
//		while (true) {
//			int menu = 0;
//			int seatNum = 0;
//			System.out.println("1.좌석예매");
//			System.out.println("2.종료");
//			while (true) {
//				System.out.print("메뉴 선택 : ");
//				menu = sc.nextInt();
//				if (menu == 1 || menu == 2) {
//					break;
//				}
//				System.out.println("없는 메뉴 입니다");
//			}
//			if (menu == 1 || menu==2) {
//				for (int i = 0; i < seat.length; i++) {
//					System.out.print(" " + (i + 1) + " ");
//				}
//				System.out.println();
//				for (int i = 0; i < seat.length; i++) {
//					System.out.print(seat[i] == 0 ? "[□]" : "[■]");
//				}
//				System.out.println();
//			}
//			if(menu==2){
//				break;
//			}
//			while (true) {
//				System.out.print("좌석번호 입력 (1~7) >> ");
//				seatNum = sc.nextInt();
//				if (seatNum < 1 || seatNum > 7) {
//					System.out.println("없는 좌석 번호입니다");
//					continue;
//				}
//				if (seat[seatNum - 1] != 0) {
//					System.out.println("이미 예매 완료된 좌석번호입니다");
//					continue;
//				}
//				System.out.println("== 좌석 예매 완료 ==");
//				seat[seatNum - 1] = 1;
//				priceTotal += 12000;
//				break;
//			}
//
//		}
//		System.out.println("매출액 : " + priceTotal);
//		System.out.println("프로그램 종료");
//		sc.close();
		
		
		
	}

}
