package 반복문문제02;

import java.util.Scanner;

public class _10영수증3단계 {

	public static void main(String[] args) {

		/*
		 	5번 주문을 받는다
		 	주문이 끝난 후, 돈을 입력받는다.
		 	각 메뉴별 주문 수량과 총 금액을 출력한다
		 	주문이 성공할때까지 돈 입력받는다.
		 	주문 성공후 영수증 출력한다.
		 */
		Scanner sc = new Scanner(System.in);

		int price1 = 8700;
		int price2 = 6200;
		int price3 = 1500;
		int priceTotal = 0;

		System.out.println("======= 롯데리아 =======");
		System.out.println("1. 불고기 버거 : " + price1 + "원");
		System.out.println("2. 새우   버거 : " + price2 + "원");
		System.out.println("3. 콜      라 : " + price3 + "원\n");

		int i = 1;
		int cnt1 = 0;
		int cnt2 = 0;
		int cnt3 = 0;
		int inputCash = 0;
		int change = 0;

		while (i <= 5) {
			System.out.print("[ " + i + " ] 메뉴 입력 : ");
			int sel = sc.nextInt();
			if (sel > 3 || sel < 1) {
				System.out.println("메뉴 번호 선택 오류");
				continue;
			} else if (sel == 1) {
				System.out.println("불고기버거 선택");
				cnt1 += 1;
			} else if (sel == 2) {
				System.out.println("새우버거 선택");
				cnt2 += 1;
			} else if (sel == 3) {
				System.out.println("콜라 선택");
				cnt3 += 1;
			}
			i += 1;
		}
		priceTotal = price1 * cnt1 + price2 * cnt2 + price3 * cnt3;
		System.out.println("\n총 금액 = " + priceTotal);
		while (true) {
			System.out.print("현금 입력 >> ");
			inputCash = sc.nextInt();
			if (inputCash < 0) {
				System.out.println("양수의 값을 입력해주세요");
				continue;
			}
			if (inputCash < priceTotal) {
				System.out.println("현금이 부족합니다");
				continue;
			}
			break;
		}
		change = inputCash - priceTotal;
		System.out.println("\n======= 영수증 =======");
		i = 1;
		if (cnt1 != 0) {
			System.out.println(i + ". 불고기 버거 : " + cnt1 + "개");
			i += 1;
		}
		if (cnt2 != 0) {
			System.out.println(i + ". 새우   버거 : " + cnt2 + "개");
			i += 1;
		}
		if (cnt3 != 0) {
			System.out.println(i + ". 콜      라 : " + cnt3 + "개");
			i += 1;
		}
		if (priceTotal != 0) {
			System.out.println(i + ". 총  금  액 : " + priceTotal + "원");
			i += 1;
		}
		if (change != 0) {
			System.out.println(i + ". 잔      돈 : " + change + "원");
		}
		System.out.println("=====================");
		sc.close();
	}
}
