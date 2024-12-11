package 반복문문제03;

import java.util.Scanner;

public class _07ATM4단계 {

	public static void main(String[] args) {
		
		/*
		 	1.로그인
		 	-로그인 후 재 로그인 불가
		 	-로그아웃 상태에서만 이용 가능
		 	2. 로그아웃
		 	-로그인 후 이용가능
		 	3. 입금
		 	-로그인 후 이용가능
		 	4. 출금
		 	-로그인 후 이용가능
		 	5. 이체
		 	6.조회
		 	7.종료
		 */
		
		Scanner sc = new Scanner(System.in); 
		int dbAcc1 = 1111;
		int dbPw1 = 1234;
		int dbMoney1 = 50000;

		int dbAcc2 = 2222;
		int dbPw2 = 2345;
		int dbMoney2 = 70000;
		int money = 0;

		int log = -1; // -1(로그아웃) 1(dbAcc1로그인) 2(dbAcc2로그인)

		while (true) {
			System.out.println("========= 더조은 ATM =========");
			switch (log) { // 상태 표시
			case -1:
				System.out.println("현재 로그아웃 상태");
				System.out.println("1. 로그인");
				break;
			case 1:
				System.out.println("현재 ACC1님 로그인 [ " + dbMoney1 + "원 ]");
			case 2:
				if (log == 2) {
					System.out.println("현재 ACC2 님 로그인[ " + dbMoney2 + "원 ]");
				}
				System.out.println("2. 로그아웃");
				System.out.println("3. 입금");
				System.out.println("4. 출금");
				System.out.println("5. 이체");
				System.out.println("6. 조회");
				break;
			}
			System.out.println("0. 종료");
			System.out.print("메뉴 선택 : ");
			int menu = sc.nextInt();

			if (log == -1 && menu > 1 && menu < 7) {
				System.out.println("[ 접근 오류 ]");
				System.out.println("로그인 후 이용가능");
				continue;
			}
			if (log != -1 && menu == 1) {
				System.out.println("[ 접근 오류 ]");
				System.out.println("이미 로그인 상태입니다");
				continue;
			}

			switch (menu) {
			case 1:
				System.out.print("id >> ");
				int id = sc.nextInt();
				System.out.print("pw >> ");
				int pw = sc.nextInt();
				if (id == dbAcc1 && pw == dbPw1) {
					log = 1;
				} else if (id == dbAcc2 && pw == dbPw2) {
					log = 2;
				} else {
					System.out.println("로그인 실패");
				}
				continue;
			case 2:
				System.out.println("로그아웃 되었습니다.");
				log = -1;
				continue;
			case 5:
				while (true) {
					System.out.print("계좌번호 >> ");
					int acc = sc.nextInt();
					if ((acc == dbAcc1 && log == 1) || (acc == dbAcc2 && log == 2)) {
						System.out.println("본인 계좌 이체 불가");
					} else if (acc != dbAcc1 && acc != dbAcc2) {
						System.out.println("계좌 입력 오류");
					} else {
						break;
					}
				}
			case 3, 4:
				while (true) {
					System.out.print("금액 >> ");
					money = sc.nextInt();
					if (money <= 0) {
						System.out.println("1원 이상 입력");
					} else if ((menu == 4 || menu == 5)
							&& ((log == 1 && money > dbMoney1) || (log == 2 && money > dbMoney2))) {
						System.out.println("잔액 부족");
					} else {
						break;
					}
				}
				System.out.println("처리 완료");
			case 6:
				if (menu == 6) {
					if (log == 1) {
						System.out.println("내 계좌 잔액 : " + dbMoney1);
						System.out.println("상대 계좌 잔액 : " + dbMoney2);
					} else {
						System.out.println("내 계좌 잔액 : " + dbMoney2);
						System.out.println("상대 계좌 잔액 : " + dbMoney1);
					}
				} else {
					if (menu == 4 || menu == 5) {
						money *= -1;
					}
					if (menu == 5) {
						dbMoney2 = log == 1 ? dbMoney2 - money : dbMoney2;
						dbMoney1 = log == 2 ? dbMoney1 - money : dbMoney1;
					}
					if (log == 1) {
						dbMoney1 += money;
						System.out.println("계좌 잔액 : " + dbMoney1);
					} else {
						dbMoney2 += money;
						System.out.println("계좌 잔액 : " + dbMoney2);
					}
				}
				continue;
			case 0:
				System.out.println("프로그램 종료");
				break;
			default:
				System.out.println("메뉴 입력 오류");
				continue;
			}
			break;
		}
		sc.close();
	}

}
