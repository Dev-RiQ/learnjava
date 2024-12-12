package 배열심화3;

import java.util.Scanner;

public class _13식권자판기 {

	public static void main(String[] args) {
		// 1) 관리자 2)사용자
		// 관리자 -> 식권충전, 잔돈충전, 뒤로가기
		// 사용자 -> 구입-금액입력-매수입력-잔돈, 뒤로가기
		Scanner sc = new Scanner(System.in);
		int[] money = { 50000, 10000, 5000, 1000, 500, 100 }; // 잔돈 단위
		int[] charges = { 1, 1, 1, 1, 5, 10 }; // 잔돈 개수
		int tickets = 5; // 식권 개수
		int price = 3200; // 식권 가격
		while (true) {
			System.out.println("[1]관리자 메뉴");
			System.out.println("[2]사용자 메뉴");
			System.out.print("메뉴 선택 (0. 종료) >> ");
			int menu = sc.nextInt();
			if (menu == 0) {
				System.out.println("자판기 종료");
				break;
			}
			if (menu < 1 || menu > 2) {
				System.out.println("입력 오류");
				continue;
			}
			if (menu == 1) {
				while (true) {
					System.out.println();
					System.out.println("[ 자판기 관리메뉴 ]");
					System.out.println("[잔여 식권 : " + tickets + "]");
					System.out.println("[잔돈 단위 / 개수]");
					for (int i = 0; i < money.length; i++) {
						System.out.printf("[%6d 원 / %3d 개]\n", money[i], charges[i]);
					}
					System.out.println("1) 식권 충전");
					System.out.println("2) 잔돈 충전");
					System.out.println("3) 뒤로 가기");
					System.out.print("메뉴 선택 >> ");
					int menuAdmin = sc.nextInt();
					if (menuAdmin == 3) {
						System.out.println("메인 메뉴로 돌아갑니다.");
						break;
					}
					if (menuAdmin < 1 || menuAdmin > 2) {
						System.out.println("입력 오류");
						continue;
					}
					if (menuAdmin == 1) {
						System.out.println();
						while (true) {
							System.out.print("충전 매수 >> ");
							int addTicket = sc.nextInt();
							if (addTicket < 1) {
								System.out.println("1 이상의 값을 입력해주세요.");
								continue;
							}
							tickets += addTicket;
							System.out.printf("식권 %d장 충전 완료 !\n", addTicket);
							break;
						}
					} else {
						System.out.println();
						while (true) {
							for (int i = 0; i < money.length; i++) {
								System.out.printf("[%d] %d원\n", i + 1, money[i]);
							}
							System.out.print("충전 금액 단위 >> ");
							int addMoney = sc.nextInt() - 1;
							if (addMoney < 0 || addMoney > money.length - 1) {
								System.out.println("입력 오류");
								continue;
							}
							System.out.print("충전 개수 >> ");
							int addMoneyCnt = sc.nextInt();
							if (addMoneyCnt < 1) {
								System.out.println("1 이상의 값을 입력해주세요.");
								continue;
							}
							charges[addMoney] += addMoneyCnt;
							System.out.printf("%d원 %d개 충전 완료 !\n", money[addMoney], addMoneyCnt);
							break;
						}
					}
				}
			} else {
				while (true) {
					boolean isExit = false;
					System.out.println("[ 현재 잔여 식권 수 : " + tickets + "]");
					System.out.println("1) 구입");
					System.out.println("2) 뒤로가기");
					System.out.print("메뉴 선택 >> ");
					int menuUser = sc.nextInt();
					if (menuUser == 2) {
						System.out.println("메인 메뉴로 돌아갑니다.");
						break;
					}
					if (tickets == 0) {
						System.out.println("현재 식권이 매진되어 구매가 불가능합니다.");
						break;
					}
					if (menuUser != 1) {
						System.out.println("입력 오류");
						continue;
					}
					int buyTickets, inputMoney;
					while (true) {
						System.out.print("구입 매수 (0.취소) >> ");
						buyTickets = sc.nextInt();
						if (buyTickets == 0) {
							System.out.println("구매 취소");
							isExit = true;
							break;
						}
						if (buyTickets < 1) {
							System.out.println("1 이상의 값을 입력해주세요.");
							continue;
						}
						if (buyTickets > tickets) {
							System.out.println("식권 수가 부족합니다.");
							System.out.println("잔여 식권 수 초과 구매는");
							System.out.println("관리자에게 문의하세요.");
							continue;
						}
						break;
					}
					if (isExit) {
						continue;
					}
					while (true) {
						int needMoney = price * buyTickets;
						System.out.println("지불 금액 : " + needMoney + "원");
						System.out.print("투입 금액 (0. 취소) >> ");
						inputMoney = sc.nextInt();
						if (inputMoney == 0) {
							System.out.println("구매 취소");
							break;
						}
						if (inputMoney < needMoney) {
							System.out.println("지불 금액 이상의 값을 입력해주세요.");
							continue;
						}
						if (inputMoney % 100 != 0) {
							System.out.println("100원 이상의 단위로만 입력하세요.");
							continue;
						}
						int change = inputMoney - needMoney;
						int tempInputMoney = inputMoney;
						int tempChange = change;
						int[] tempMoney = new int[money.length];
						for (int i = 0; i < money.length; i++) {
							tempMoney[i] = charges[i];
						}
						for (int i = 0; i < money.length; i++) {
							if (tempInputMoney - money[i] >= 0) {
								tempInputMoney -= money[i];
								tempMoney[i]++;
								i--;
							}
						}
						for (int i = 0; i < money.length; i++) {
							if (tempChange - money[i] >= 0 && tempMoney[i] > 0) {
								tempChange -= money[i];
								tempMoney[i]--;
								i--;
							}
						}
						if (tempChange != 0) {
							System.out.println("잔돈이 " + tempChange + "원 부족하여 투입 금액이 반환됩니다.");
							continue;
						}
						System.out.println("거스름돈 : " + change + "원");
						System.out.println();
						charges = tempMoney;
						tickets -= buyTickets;
//						테스트
//						for (int i = 0; i < money.length; i++) {
//							System.out.printf("[%6d 원 / %3d 개]\n", money[i], charges[i]);
//						}
						break;
					}
				}
			}
		}
		sc.close();
	}

}
