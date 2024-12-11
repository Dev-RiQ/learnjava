package 조건문문제;

import java.util.Scanner;

public class _19ATM1단계 {

	public static void main(String[] args) {

		/*
		 	[문제]
		 		1. 이체할 계좌번호를 입력받는다
		 		2. 일치하면 금액을 입력받는다
		 		3. 이체할 금액 <= myMoney : 이체가능
		 						myMoney - 이체할 금액
		 						yourMoney + 이체할 금액
		 				이체할 금액 > myMoney : 이체 불가
		 */
		
		Scanner sc = new Scanner(System.in);
		int myAcc = 1234;
		int myMoney = 8700;
		
		int yourAcc = 4321;
		int yourMoney = 12000;
		
//		System.out.print("본인 계좌 확인 >> ");
//		int checkAcc = sc.nextInt();
//		
//		if(checkAcc == myAcc) {
//			System.out.print("이체할 계좌번호를 입력하세요 >> ");
//			int inputAcc = sc.nextInt();
//			
//			if (inputAcc == yourAcc) {
//				System.out.print("이체할 금액을 입력하세요 >> ");
//				int sendMoney = sc.nextInt();
//				
//				if(sendMoney>0) {
//					if (sendMoney <= myMoney) {
//						System.out.println("이체 성공");
//						System.out.println("내 계좌 잔액 : " + (myMoney - sendMoney) + "원");
//						System.out.println("상대 계좌 잔액 : " + (yourMoney + sendMoney) + "원");
//					}else {
//						System.out.println("계좌 잔액이 부족합니다.");
//						System.out.println("현재 잔액 : " + myMoney);
//					}
//				}else {
//					System.out.println("1원 이상을 입력해주세요.");
//				}
//			}else {
//				System.out.println("상대방의 계좌번호를 확인해주세요.");
//			}
//		}else {
//			System.out.println("본인 확인 실패! 계좌번호를 확인해주세요.");
//		}

		System.out.print("이체할 계좌번호를 입력하세요 >> ");
		int inputAcc = sc.nextInt();

		if (inputAcc == yourAcc) {
			System.out.print("이체할 금액을 입력하세요 >> ");
			int sendMoney = sc.nextInt();

			if (sendMoney <= myMoney && sendMoney > 0) {
				myMoney -= sendMoney;
				yourMoney += sendMoney;
				System.out.println("이체 성공");
				System.out.println("내 계좌 잔액 : " + (myMoney) + "원");
				System.out.println("상대 계좌 잔액 : " + (yourMoney) + "원");
			} else if (sendMoney > myMoney) {
				System.out.println("계좌 잔액이 부족합니다.");
				System.out.println("이체 가능 금액 : " + myMoney + "원");
			} else {
				System.out.println("1원 이상을 입력해주세요.");
			}
		} else if (inputAcc == myAcc) {
			System.out.println("본인 계좌로는 이체가 불가능합니다.");
		} else {
			System.out.println("상대방의 계좌번호를 확인해주세요.");
		}

		sc.close();
		
		
	}

}
