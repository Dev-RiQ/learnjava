package 반복문문제01;

import java.util.Scanner;

public class _11영수증2단계 {

	public static void main(String[] args) {

		/*
		 	[문제]
		 		1. 5번 주문을 받는다.
		 		2. 주문이 끝난 후, 돈을 입력받는다.
		 		3. 각 메뉴별 주문 수량과 총 금액을 출력한다.
		 */

		Scanner sc = new Scanner(System.in);

		int price1 = 8700;
		int price2 = 6200;
		int price3 = 1500;
		System.out.println("=== 롯데리아 ===");
		System.out.println("1. 불 고 기    버 거 : " + price1 + "원");
		System.out.println("2. 새 우      버 거 : " + price2 + "원");
		System.out.println("3. 콜           라 : " + price3 + "원");

		int i = 1;
		int cnt1 = 0;
		int cnt2 = 0;
		int cnt3 = 0;
		
		while (i <= 5) {
			System.out.printf("[ %d번 ] 메뉴 선택 : ", i);
			int input = sc.nextInt();
			if (input == 1) {
				cnt1 += 1;
			} else if (input == 2) {
				cnt2 += 1;
			} else if (input == 3) {
				cnt3 += 1;
			} else {
				System.out.println("오류 : 메뉴를 다시 선택하세요.");
				i -= 1;
			}
			i += 1;
		}
		int totalPrice = price1 * cnt1 + price2 * cnt2 + price3 * cnt3;
		System.out.println("총 금액 = " + totalPrice);

		System.out.print("현금 입력 : ");
		int cash = sc.nextInt();
		int change = cash - totalPrice;
		if (cash < totalPrice) {
			System.out.println("오류 : 현금이 부족합니다.");
			i = 0;
		} else {
			System.out.println("=== 롯데리아 영수증 ===");
			System.out.printf("1. 불 고 기    버 거 : %d개", cnt1);
			System.out.printf("\n2. 새 우      버 거 : %d개", cnt2);
			System.out.printf("\n3. 콜           라 : %d개", cnt3);
			System.out.printf("\n4. 총     금     액 : %d원", totalPrice);
			System.out.printf("\n5. 잔           돈 : %d원", change);
		}
		sc.close();
	}

}
