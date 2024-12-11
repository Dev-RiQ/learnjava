package 조건문문제;

import java.util.Scanner;

public class _15영수증 {

	public static void main(String[] args) {

		/*
		 	[문제]
		 		1. 메뉴판 출력
		 		2. 메뉴 번호 입력
		 		3. 현금 입력
		 		4. 현금, 메뉴가격 확인해 영수증 출력
		 		5. 현금 부족 시 "현금이 부족합니다." 출력
		 */
		
		Scanner sc = new Scanner(System.in);
		
		int price1 = 8700;
		int price2 = 6200;
		
		System.out.println("=== 롯데리아 ===");
		System.out.println("1. 새우버거 : " + price1 + "원");
		System.out.println("2. 치즈버거 : " + price2 + "원");
		System.out.print("메뉴를 선택하세요 : ");
		int menu = sc.nextInt();
		System.out.print("현금을 입력하세요 : ");
		int cash = sc.nextInt();
		
		boolean order1 = cash >= price1;
		boolean order2 = cash >= price2;
		boolean menu1 = menu == 1;
		boolean menu2 = menu == 2;
		boolean error = !order1 && menu1 || !order2 && menu2;
		
		int price = 0;
		
		if (order1 && menu1) {
			price = price1;
			System.out.println("새우버거를 구매합니다.");
					
		}
		if (order2 && menu2) {
			price = price2;
			System.out.println("치즈버거를 구매합니다.");
		}
		if (cash > price1 && menu1 || cash > price2 && menu2) {
			System.out.println("거름돈은 "+ (cash - price) + "원 입니다.");
		}
		
		if (error) {
			System.out.println("오류 : 현금이 부족합니다.");
			
		}
		if (!menu1 && !menu2) {
			System.out.println("오류 : 메뉴를 다시 입력하세요.");
		}
		
		sc.close();
		
	}

}
