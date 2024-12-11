package 조건문문제;

import java.util.Scanner;

public class _22ATM2단계 {

	public static void main(String[] args) {

		//메뉴선택 1. 로그인 성공할때만 -> 1. 입금 2. 출금 3. 조회

		int cash = 20000;
		int balance = 30000;

		int account = 1111;
		int password = 1234;

		Scanner sc = new Scanner(System.in);
		System.out.println("===더조은 ATM===");
		System.out.println("1.로그인 2.종료");
		int sel = sc.nextInt();
		int sel2 = 0;
		int acc = 0;
		int pw = 0;
		int input = 0;

		if (sel != 1 && sel != 2) {
			System.out.println("입력오류");
		}else if(sel == 2) {
			System.out.println("안녕~");
		}else {
			System.out.print("계좌번호 입력 >> ");
			acc = sc.nextInt();
		}
		
		if(sel == 1){
			if (acc != account) {
				System.out.println("오류 : 계좌번호를 확인하세요.");
			} else {
				System.out.print("비밀번호 입력 >> ");
				pw = sc.nextInt();
			}
		}
		
		if(acc == account) {
			if (pw != password) {
				System.out.println("오류 : 비밀번호를 확인하세요.");
			} else {
				System.out.println("1.입금 2.출금 3.조회");
				sel2 = sc.nextInt();
			}
		}
		
		int i = 1;
		int tempMoney = 0;
		if(pw == password) {
			if (sel2 < 1 || sel2 > 3) {
				System.out.println("오류 : 1, 2, 3 중에 하나를 입력하세요.");
			} else if (sel2 == 1) {
				tempMoney = cash;
			} else if (sel2 == 2) {
				tempMoney = balance;
				i *= -1;
			} else {
				System.out.println("현재 계좌 잔액은 " + balance + "원 입니다.");
			}
		}
		
		if (tempMoney != 0) { 			// 입,출금
			System.out.print("금액 입력 >> ");
			input = sc.nextInt();
			if (input <= tempMoney && input > 0) {
				cash -= input*i;
				balance += input*i;
				System.out.println("처리가 완료되었습니다.");
				System.out.printf("보유 현금 잔액 : %d\n보유 계좌 잔액 : %d\n", cash, balance);
			} else if (input > tempMoney) {
				System.out.println("오류 : 계좌 잔액이 부족합니다.");
			} else {
				System.out.println("오류 : 1 이상의 값을 입력하세요.");
			}
		}
		
//		======================================================================================
//		
//		if (sel != 1 && sel != 2) {
//			System.out.println("입력오류");
//		}else if(sel == 2) {
//			System.out.println("안녕~");
//		}else {
//			System.out.print("계좌번호 입력 >> ");
//			acc = sc.nextInt();
//			if (acc != account) {
//				System.out.println("오류 : 계좌번호를 확인하세요.");
//			} else {
//				System.out.print("비밀번호 입력 >> ");
//				pw = sc.nextInt();
//				if (pw != password) {
//					System.out.println("오류 : 비밀번호를 확인하세요.");
//				} else {
//					System.out.println("1.입금 2.출금 3.조회");
//					sel2 = sc.nextInt();
//					if (sel2 < 1 || sel2 > 3) {
//						System.out.println("오류 : 1, 2, 3 중에 하나를 입력하세요.");
//					} else if (sel2 == 1) {
//						tempMoney = cash;
//					} else if (sel2 == 2) {
//						tempMoney = balance;
//						i *= -1;
//					} else {
//						System.out.println("현재 계좌 잔액은 " + balance + "원 입니다.");
//					}
//					if (tempMoney != 0) { 			// 입,출금
//						System.out.print("금액 입력 >> ");
//						input = sc.nextInt();
//						if (input <= tempMoney && input > 0) {
//							cash -= input*i;
//							balance += input*i;
//							System.out.println("처리가 완료되었습니다.");
//							System.out.printf("보유 현금 잔액 : %d\n보유 계좌 잔액 : %d\n", cash, balance);
//						} else if (input > tempMoney) {
//							System.out.println("오류 : 계좌 잔액이 부족합니다.");
//						} else {
//							System.out.println("오류 : 1 이상의 값을 입력하세요.");
//						}
//					}
//				}
//			}
//		}
//		
//		
//		
//		
//		
//		
////		======================================================================================
//
//		if (sel == 1) { 			// 메뉴 선택 계좌 입력
//			System.out.print("계좌번호 입력 >> ");
//			acc = sc.nextInt();
//		} else if (sel == 2) {
//			System.out.println("종료되었습니다.");
//		} else {
//			System.out.println("오류 : 1, 2 중에 하나를 입력하세요.");
//		}
//
//		if (sel == 1) { 			// 계좌 일치 비번 입력
//			if (acc == account) {
//				System.out.print("비밀번호 입력 >> ");
//				pw = sc.nextInt();
//			} else {
//				System.out.println("오류 : 계좌번호를 확인하세요.");
//			}
//		}
//
//		if (acc == account) { 		// 비번 일치 메뉴 선택
//			if (pw == password) {
//				System.out.println("1.입금 2.출금 3.조회");
//				sel2 = sc.nextInt();
//			} else {
//				System.out.println("오류 : 비밀번호를 확인하세요.");
//			}
//		}
//
//		if (sel2 != 0) {			 // 메뉴 선택 출력문
//			if (sel2 == 1) {
//				System.out.print("입금할 금액 입력 >> ");
//				input = sc.nextInt();
//			} else if (sel2 == 2) {
//				System.out.print("출금할 금액 입력 >> ");
//				get = sc.nextInt();
//			} else if (sel2 == 3) {
//				System.out.println("현재 계좌 잔액은 " + balance + "원 입니다.");
//			} else {
//				System.out.println("오류 : 1, 2, 3 중에 하나를 입력하세요.");
//			}
//		}
//
//		if (sel2 == 1) { 			// 입금
//			if (input <= cash && input > 0) {
//				cash -= input;
//				balance += input;
//				System.out.println("입금이 완료되었습니다.");
//				System.out.printf("보유 현금 잔액 : %d\n보유 계좌 잔액 : %d\n", cash, balance);
//			} else if (input > cash) {
//				System.out.println("오류 : 현금이 부족합니다.");
//			} else {
//				System.out.println("오류 : 1 이상의 값을 입력하세요.");
//			}
//		}
//
//		if (sel2 == 2) { 			// 출금
//			if (get <= balance && get > 0) {
//				balance -= get;
//				cash += get;
//				System.out.println("출금이 완료되었습니다.");
//				System.out.printf("보유 현금 잔액 : %d\n보유 계좌 잔액 : %d\n", cash, balance);
//			} else if (get > balance) {
//				System.out.println("오류 : 계좌 잔액이 부족합니다.");
//			} else {
//				System.out.println("오류 : 1 이상의 값을 입력하세요.");
//			}
//		}
//		
////		======================================================================================
//		
//		if (sel == 1) {
//			System.out.print("계좌번호 입력 >> ");
//			acc = sc.nextInt();
//
//			if (acc == account) {
//				System.out.print("비밀번호 입력 >> ");
//				pw = sc.nextInt();
//
//				if (pw == password) {
//					System.out.println("1.입금 2.출금 3.조회");
//					sel2 = sc.nextInt();
//
//					System.out.print("금액 입력 >> ");
//					input = sc.nextInt();
//					int multi = 1;
//					
//					if (sel2 == 1) {
//						tempMoney = cash;
//					}else if(sel2 ==2) {
//						tempMoney = balance;
//						multi *= -1;
//					}else if (sel2 == 3) {
//						System.out.println("현재 계좌 잔액은 " + balance + "원 입니다.");
//					} else {
//						System.out.println("오류 : 1, 2, 3 중에 하나를 입력하세요.");
//					}
//					
//					if (input <= tempMoney && input > 0) {
//						cash -= input*multi;
//						balance += input*multi;
//						System.out.println("처리가 완료되었습니다.");
//						System.out.printf("보유 현금 잔액 : %d\n보유 계좌 잔액 : %d\n", cash, balance);
//					} else if (input > tempMoney) {
//						System.out.println("오류 : 잔액이 부족합니다.");
//					} else {
//						System.out.println("오류 : 1 이상의 값을 입력하세요.");
//					}
//				} else {
//					System.out.println("오류 : 비밀번호를 확인하세요.");
//				}
//
//			} else {
//				System.out.println("오류 : 계좌번호를 확인하세요.");
//			}
//
//		} else if (sel == 2) {
//			System.out.println("종료되었습니다.");
//		} else {
//			System.out.println("오류 : 1, 2 중에 하나를 입력하세요.");
//		}
//		
////		======================================================================================
//		
//		if (sel == 1) {
//			System.out.print("계좌번호 입력 >> ");
//			acc = sc.nextInt();
//
//			if (acc == account) {
//				System.out.print("비밀번호 입력 >> ");
//				pw = sc.nextInt();
//
//				if (pw == password) {
//					System.out.println("1.입금 2.출금 3.조회");
//					sel2 = sc.nextInt();
//
//					System.out.print("금액 입력 >> ");
//					input = sc.nextInt();
//					
//					if (sel2 == 1) {
//						if (input <= cash && input > 0) {
//							cash -= input;
//							balance += input;
//							System.out.println("입금이 완료되었습니다.");
//							System.out.printf("보유 현금 잔액 : %d\n보유 계좌 잔액 : %d\n", cash, balance);
//						} else if (input > cash) {
//							System.out.println("오류 : 현금이 부족합니다.");
//						} else {
//							System.out.println("오류 : 1 이상의 값을 입력하세요.");
//						}
//
//					} else if (sel2 == 2) {
//						if (get <= balance && get > 0) {
//							balance -= get;
//							cash += get;
//							System.out.println("출금이 완료되었습니다.");
//							System.out.printf("보유 현금 잔액 : %d\n보유 계좌 잔액 : %d\n", cash, balance);
//						} else if (get > balance) {
//							System.out.println("오류 : 계좌 잔액이 부족합니다.");
//						} else {
//							System.out.println("오류 : 1 이상의 값을 입력하세요.");
//						}
//
//					} else if (sel2 == 3) {
//						System.out.println("현재 계좌 잔액은 " + balance + "원 입니다.");
//					} else {
//						System.out.println("오류 : 1, 2, 3 중에 하나를 입력하세요.");
//					}
//
//				} else {
//					System.out.println("오류 : 비밀번호를 확인하세요.");
//				}
//
//			} else {
//				System.out.println("오류 : 계좌번호를 확인하세요.");
//			}
//
//		} else if (sel == 2) {
//			System.out.println("종료되었습니다.");
//		} else {
//			System.out.println("오류 : 1, 2 중에 하나를 입력하세요.");
//		}
		sc.close();
	}

}
