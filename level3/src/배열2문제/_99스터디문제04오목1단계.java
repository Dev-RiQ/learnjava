package 배열2문제;

import java.util.Random;
import java.util.Scanner;

public class _99스터디문제04오목1단계 {

	public static void main(String[] args) {

		/*
		 	[문제] 오목1단계
		 		세로 16칸 크기의 바둑판에서 com과 me가 번갈아 돌을 놓는다.
		 		좌표는 최대 15 까지 가능하며, com은 좌표값을 랜덤으로 받고, 
		 		이미 랜덤으로 받거나, me가 입력한 값은 중복으로 입력 불가능하다.
		 		마찬가지로 me도 com이 사용하거나 내가 입력한 값은 중복으로 입력 불가능하다.
		 		아직 놓지 않은 칸은 " ·", com이 놓은 칸은 " ○", me가 놓은 칸은 " ●"로 출력한다.
		 		게임은 me가 먼저 시작한다. (turn = 1(me), turn = 0(com))
		 		모든 판에 돌이 가득찬 것이 표시되면 게임을 종료하고 결과를 발표한다.
		 		결과는 me와 com 각자 연이어 놓아진 돌의 최대 갯수를 각각 출력하고, me가 com보다
		 		더 많으면 "승리" 출력
		 		갯수가 같다면 "비김" 출력
		 		적다면 "패배" 출력
		 	[예시]
		 		 0  ●  => me
				 1  ● 
				 2  ●
				 3  ●
				 4  ○  => com
				 5  ·  => 빈칸
				 6  ○
				 7  ●
				 8  ○
				 9  ·
				10  ●
				11  ○
				12  ○
				13  ○
				14  ·
				15  ·
		 */
		boolean[] com = new boolean[16];
		boolean[] me = new boolean[16];
		boolean[] total = new boolean[16];
		Scanner sc = new Scanner(System.in);
		Random rd = new Random();
		int turn = 1;
		int setCom = com.length;
		int setMe = me.length;
		int set = total.length;
		int cnt = 0;
		while (true) {
			// 판 셋팅
			for (int i = 0; i < total.length; i++) {
				if (i < 10) {
					System.out.print(" " + i + " ");
				} else {
					System.out.print(i + " ");
				}
				if (total[i] == false) {
					System.out.println(" ·");
				}
				if (total[i] == true && com[i] == true) {
					System.out.println(" ○");
				}
				if (total[i] == true && me[i] == true) {
					System.out.println(" ●");
				}
			}
			System.out.println();
			//판 출력 직후 종료 조건
			if (cnt == 16) {
				break;
			}
			//me, com 입력 셋팅
			while (true) {
				if (turn == 1) {
					System.out.print("me turn ! >> ");
					setMe = sc.nextInt();
					set = setMe;
				} else {
					setCom = rd.nextInt(16);
					set = setCom;
				}
				if (set < 0 || set > 15) {
					System.out.println("0~15 사이 값 입력");
					continue;
				}
				if (total[set] == true) {
					if (turn == 1) {
						System.out.println("이미 놓여있는 자리입니다.");
					}
					continue;
				}
				if (turn == 0) {
					System.out.println("com turn ! >> " + setCom);
				}
				total[set] = true;
				cnt++;
				if (turn == 1) {
					me[set] = true;
					turn = 0;
				} else {
					com[set] = true;
					turn = 1;
				}
				break;
			}
		}
		//게임 종료 및 결과도출 ( com, me 연속 갯수 카운팅)
		System.out.println("게임 종료");
		cnt = 0;
		int cntCom = 1;
		for (int i = 0; i < com.length; i++) {
			if (com[i] == true) {
				cnt++;
			} else {
				cnt = 0;
			}
			if (cnt > cntCom) {
				cntCom = cnt;
			}
		}
		cnt = 0;
		int cntMe = 1;
		for (int i = 0; i < me.length; i++) {
			if (me[i] == true) {
				cnt++;
			} else {
				cnt = 0;
			}
			if (cnt > cntMe) {
				cntMe = cnt;
			}
		}
		System.out.printf("Me : 최대 %d번, Com : 최대 %d번 \n", cntMe, cntCom);
		if (cntMe > cntCom) {
			System.out.println("승리");
		} else if (cntMe < cntCom) {
			System.out.println("패배");
		} else {
			System.out.println("비김");
		}
		sc.close();
		
	}

}
