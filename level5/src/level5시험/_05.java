package level5시험;

import java.util.Scanner;

public class _05 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int[] money = { 50000, 10000, 5000, 1000, 500, 100 };
		int[] charges = { 1, 1, 1, 1, 5, 10 };

		int tickets = 5;
		int price = 3200;

		while (true) {
			System.out.println("[1]관리자");
			System.out.println("[2]사용자");
			System.out.print("메뉴 선택 (0. 종료) : ");
			int sel = sc.nextInt();
			if (sel == 0) {
				System.out.println("프로그램 종료");
				break;
			}
			if (sel < 1 || sel > 2) {
				System.err.println("입력 오류");
				continue;
			}
			if (sel == 1) {
				while (true) {
					System.out.println("[잔여 티켓 : " + tickets + "]");
					System.out.println("[잔여 현금]");
					for (int i = 0; i < money.length; i++) {
						System.out.printf("[ %5d : %d ]\n", money[i], charges[i]);
					}
					System.out.println("1)식권충전");
					System.out.println("2)잔동충전");
					System.out.println("3)뒤로가기");
					System.out.print("메뉴 선택 : ");
					int choice = sc.nextInt();
					if (choice == 3) {
						System.out.println("메인 메뉴로 돌아갑니다.");
						break;
					}
					switch (choice) {
					case 1:
						while (true) {
							System.out.println("[식권충전]");
							System.out.print("충전할 식권 갯수 : ");
							int addTickets = sc.nextInt();
							if (addTickets < 1) {
								System.err.println("1이상의 값을 입력하세요.");
								continue;
							}
							tickets += addTickets;
							System.out.println("식권" + addTickets + "장이 충전되었습니다.");
							break;
						}
						break;
					case 2:
						while (true) {
							System.out.println("[잔돈충전]");
							for (int i = 0; i < money.length; i++) {
								System.out.printf("%d) %d\n", i + 1, money[i]);
							}
							System.out.print("충전할 단위 선택 : ");
							int selUnit = sc.nextInt() - 1;
							if (selUnit < 0 || selUnit > money.length - 1) {
								System.err.println("단위 선택 오류");
								continue;
							}
							while (true) {
								System.out.println("[잔돈충전]");
								System.out.println("[선택한 단위 : " + money[selUnit] + "]");
								System.out.print("충전 수량 : ");
								int addCharges = sc.nextInt();
								if (addCharges < 1) {
									System.err.println("1이상의 값을 입력하세요.");
									continue;
								}
								charges[selUnit] += addCharges;
								System.out.printf("%d원 단위 %d개가 충전되었습니다.\n", money[selUnit], addCharges);
								break;
							}
							break;
						}
						break;
					default:
						System.err.println("입력오류");
						break;
					}
				}
			} else {
				while(true) {
					System.out.println("[잔여 티켓 : " + tickets + "]");
					System.out.println("1)구매");
					System.out.println("2)뒤로가기");
					System.out.print("메뉴 선택 : ");
					int choice = sc.nextInt();
					if(choice == 2) {
						System.out.println("메인 메뉴로 돌아갑니다.");
						break;
					}
					switch (choice) {
					case 1:
						while (true) {
							System.out.print("현금을 넣어주세요 >> ");
							int inputCash = sc.nextInt();
							if (inputCash < 100) {
								System.err.println("100원 이상을 입력하세요.");
								continue;
							}
							if (inputCash % 100 != 0) {
								System.err.println("100원 단위로 입력하세요.");
								continue;
							}
							System.out.println(inputCash + "원이 입력되었습니다.");
							while (true) {
								System.out.print("구매할 식권 매수 >> ");
								int buyTickets = sc.nextInt();
								if (buyTickets < 1) {
									System.err.println("1매 이상을 입력하세요.");
									continue;
								}
								if (buyTickets > tickets) {
									System.err.println("현재 티켓 재고가 부족합니다.");
									System.err.println("현재 티켓 재고 : " + tickets);
									continue;
								}
								if (buyTickets * price > inputCash) {
									System.err.println("현재 투입 금액으로 구매 불가능한 수량입니다.");
									System.err.println("현재 최대 구매 가능 매수 : " + inputCash / price);
									continue;
								}
								int change = inputCash - buyTickets * price;
								int tempChange = change;
								int tempInputCash = inputCash;
								int[] tempCharges = new int[charges.length];
								for (int i = 0; i < money.length; i++) {
									tempCharges[i] = charges[i];
									
								}
								for (int i = 0; i < money.length; i++) {
									if (tempInputCash >= money[i]) {
										tempInputCash -= money[i];
										tempCharges[i]++;
										i--;
									}
								}
								for (int i = 0; i < money.length; i++) {
									if (tempChange >= money[i] && tempCharges[i] != 0) {
										tempChange -= money[i];
										tempCharges[i]--;
										i--;
									}
								}
								if (tempChange != 0) {
									System.err.println("기계 내 거스름 돈이 부족합니다.");
									System.err.println("투입 금액 " + inputCash + "원을 반환합니다.");
									System.err.println("투입 금액을 변경하거나 관리자를 호출해 주시길 바랍니다.");
								} else {
									System.out.println("티켓" + buyTickets + "장이 구매 완료되었습니다.");
									System.out.println("거스름돈 " + change + "원이 정상 반환 되었습니다.");
									charges = tempCharges;
									tickets -= buyTickets;
								}
								break;
							}
							break;
						}
						break;
					default:
						System.err.println("입력오류");
						break;
					}
					
				}
			}
		}
		sc.close();
		// 소요 시간 : 34분 25초
	}

}
