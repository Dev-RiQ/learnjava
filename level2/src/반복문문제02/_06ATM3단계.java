package 반복문문제02;

import java.util.Scanner;

public class _06ATM3단계 {

	public static void main(String[] args) {

		/*
		 	1. 입금
		 		입금할 금액을 입력받아, myMoney에 입금 => 천만원 이상 불가능
		 	2. 출금
		 		출금할 금액을 입력받아, myMoney에서 출금
		 	3. 이체
		 		yourAcc 계좌번호를 입력받아, 이체
		 		이체할 금액이 myMoney 잔액을 초과할 경우 이체 불가
		 		이체 후 yourMoney 잔액 증가
		 	4. 조회
		 		myMoney와 yourMoney 잔액 모두 출력
		 */
		
		Scanner sc = new Scanner(System.in);

		int myAcc = 1111;
		int myMoney = 50000;
		int yourAcc = 2222;
		int yourMoney = 70000;

		System.out.println("=====더조은 ATM=====");

//		while (true) {
//			System.out.println("1. 입금\n2. 출금\n3. 이체\n4. 조회\n0. 종료");
//			System.out.print("메뉴 선택 : ");
//			int input = sc.nextInt();
//			if (input > 4 || input < 0) {
//				System.out.println("메뉴 입력 오류");
//				continue;
//			}//입금
//			if (input == 1) {
//				System.out.println("== 입금 ==");
//				System.out.print("금액 >> ");
//				input = sc.nextInt();
//				if (input <= 0) {
//					System.out.println("1 이상 금액을 입력해주세요");
//					continue;
//				}
//				if (input >= 10000000) {
//					System.out.println("1000만원 이상 입금 불가!\n9,999,999이하를 입력해주세요");
//					continue;
//				}
//				myMoney += input;
//				System.out.println("입금완료");
//			}else if (input == 2) {
//				System.out.println("== 출금 ==");
//				System.out.print("금액 >> ");
//				input = sc.nextInt();
//				if (input <= 0) {
//					System.out.println("1 이상 금액을 입력해주세요");
//					continue;
//				}
//				if (input > myMoney) {
//					System.out.println("출금 잔액이 부족합니다");
//					continue;
//				}
//				myMoney -= input;
//				System.out.println("출금완료");
//			}else if (input == 3) {
//				System.out.println("== 이체 ==");
//				System.out.println("이체 계좌번호 입력 >>");
//				input = sc.nextInt();
//				if (input == myAcc) {
//					System.out.println("내 계좌 이체 불가능");
//					continue;
//				}
//				if (input != yourAcc) {
//					System.out.println("계좌 입력 오류");
//					continue;
//				}
//				System.out.println("금액 >>");
//				input = sc.nextInt();
//				if (input <= 0) {
//					System.out.println("1 이상 금액을 입력해주세요");
//					continue;
//				}
//				if (input > myMoney) {
//					System.out.println("이체 잔액이 부족합니다");
//					continue;
//				}
//				myMoney -= input;
//				yourMoney += input;
//				System.out.println("이체완료");
//			}else if (input == 4) {
//				System.out.println("== 조회 ==");
//			}else if (input == 0) {
//				System.out.println("프로그램 종료");
//				break;
//			}
//			System.out.println("myMoney = " + myMoney);
//			System.out.println("yourMoney = " + yourMoney);
//		}
//		
		
		
		while (true) {
			System.out.println("1. 입금\n2. 출금\n3. 이체\n4. 조회\n0. 종료");
			System.out.print("메뉴 선택 : ");
			int sel = sc.nextInt();
			int input = 0;
			if (sel > 4 || sel < 0) {
				System.out.println("메뉴 입력 오류");
				continue;
			}//입금
			if (sel == 1) {
				System.out.println("========입금========");
			}else if (sel == 2) {
				System.out.println("========출금========");
			}else if (sel == 3) {
				System.out.println("========이체========");
				while(true) {
					System.out.println("이체 계좌번호 입력 >>");
					input = sc.nextInt();
					if (input == myAcc) {
						System.out.println("내 계좌 이체 불가능");
						continue;
					}
					if (input != yourAcc) {
						System.out.println("계좌 입력 오류");
						continue;
					}
					break;
				}
			}else if (sel == 4) {
				System.out.println("========조회========");
			}else if (sel == 0) {
				System.out.println("프로그램 종료");
				break;
			}
			if(sel==1||sel==2||sel==3) {
				while(true) {
					System.out.print("금액 >> ");
					input = sc.nextInt();
					if (input < 0) {
						System.out.println("0 이상 금액을 입력해주세요");
						continue;
					}
					if (sel==1&&input >= 10000000) {
						System.out.println("1000만원 이상 입금 불가!\n9,999,999이하를 입력해주세요");
						continue;
					}
					if ((sel==2||sel==3)&&input > myMoney) {
						System.out.println("잔액이 부족합니다");
						System.out.println("현재 잔액 >> "+myMoney);
						continue;
					}
					break;
				}
			}
			if(sel==1) {
				System.out.println("입금 완료");
				myMoney += input;
			}else if(sel == 2) {
				System.out.println("출금 완료");
				myMoney -= input;
			}else if(sel==3) {
				System.out.println("이체 완료");
				myMoney -= input;
				yourMoney += input;
			}
			System.out.println("myMoney = " + myMoney);
			System.out.println("yourMoney = " + yourMoney);
			System.out.println("===================\n");
		}
		sc.close();
	}
}
