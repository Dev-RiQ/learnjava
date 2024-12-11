package 반복문문제02;

import java.util.Random;
import java.util.Scanner;

public class _99스터디제작문제_4블랙잭 {

	public static void main(String[] args) {

		/*
		 	[문제]
		 		블랙잭 게임
		 		사전 조건) 1~13 사이의 숫자를 랜덤으로 출력한다.
		 				(출력되는 11~13은 합을 계산할때 10으로한다.) << 중요
		 		1. me는 랜덤 2장을 받아 출력을 통해 확인한다.
		 		2. me는 카드를 더받기를 원하면 입력을 통하여 카드를 더 받을 수 있다. 
		 			(더받기 1.yes 2.no)
		 		3. me 카드합이 21이 초과되거나 2.no를 선택하면 게임종료.
		 			(me 카드합은 결과 출력 시 공개)
		 		4. 이후 com에게도 랜덤 카드를 계속 출력한다. 
		 		5. com은 카드의 합이 16 이상이면 더이상 카드를 받지 않는다. 
				6. 이때 com의 점수 합과 me의 점수 합을 비교하여 결과를 출력한다. 
		 		7. com < me <= 21 이거나 (com > 21, me<=21) 이면 "승리" 출력, 
		 			me < com <= 21이거나 (me > 21, com<=21) 이면 "패배" 출력, 
		 			me = com 이거나 (com>21, me>21)이면 "무승부" 출력 
		 	[출력예시1]
		 		Me 카드 : 13 1 
				카드를 더 받으시겠습니까? 1.yes 2.no >> 1

				Me 카드 : 7 
				카드를 더 받으시겠습니까? 1.yes 2.no >> 2

				게임 종료

				Com 카드 : 4 11 1 9 
				Com 점수 합 : 24
				Me 점수 합 : 18
 				 승리! 
 				 
 				=========================================
 			[출력예시2]
 				Me 카드 : 3 9 
				카드를 더 받으시겠습니까? 1.yes 2.no >> 1

				Me 카드 : 12 
				21 초과! 결과 발표

				Com 카드 : 13 9 
				Com 점수 합 : 19
				Me 점수 합 : 22
 				패배!  
		 */
		
		Scanner sc = new Scanner(System.in);
		Random rd = new Random();

		int sumCom = 0;
		int sumMe = 0;
		int rdNum = 0;
		int i = 1;
		while (true) {
			System.out.print("Me 카드 : ");
			while (i <= 2) {
				rdNum = rd.nextInt(13) + 1;
				System.out.print(rdNum + " ");
				if (rdNum > 10) {
					rdNum = 10;
				}
				sumMe += rdNum;
				i += 1;
			}
			if (sumMe > 21) {
				System.out.println("\n21 초과! 결과 발표");
				break;
			}
			int sel = 0;
			while (true) {
				System.out.print("\n카드를 더 받으시겠습니까? 1.yes 2.no >> ");
				sel = sc.nextInt();
				System.out.println();
				if (sel != 1 && sel != 2) {
					System.out.println("입력 오류");
					continue;
				}
				break;
			}
			if (sel == 1) {
				i -= 1;
				continue;
			} else {
				System.out.println("게임 종료");
				break;
			}
		}
		System.out.println();
		System.out.print("Com 카드 : ");
		while (true) {
			rdNum = rd.nextInt(13) + 1;
			System.out.print(rdNum + " ");
			if (rdNum > 10) {
				rdNum = 10;
			}
			sumCom += rdNum;
			if (sumCom >= 16) {
				break;
			}
		}
		System.out.println("\nCom 점수 합 : " + sumCom);
		System.out.println("Me 점수 합 : " + sumMe);
		if (sumCom == sumMe || (sumCom > 21 && sumMe > 21)) {
			System.out.println(" 무승부! ");
		} else if ((sumCom < sumMe || sumCom > 21) && sumMe <= 21) {
			System.out.println(" 승리! ");
		} else {
			System.out.println(" 패배! ");
		}
		sc.close();
	}
	
}
