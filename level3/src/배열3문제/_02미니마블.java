package 배열3문제;

import java.util.Scanner;

public class _02미니마블 {

	public static void main(String[] args) {

		/*
		 	번갈아가며 1~3 사이 숫자 입력 이동
		 	이동하다 같은 위치에 놓이면 잡음(상대 원점으로)
		 	3바퀴 돌면 이김
		 */
		
		Scanner sc = new Scanner(System.in);
		int[] game = { 1, 2, 3, 4, 5, 6, 7, 8 };
		int[] p1 = { 1, 0, 0, 0, 0, 0, 0, 0 };
		int[] p2 = { 1, 0, 0, 0, 0, 0, 0, 0 };
		int size = game.length;
		int turn = 1;
		int cnt1 = 0;
		int cnt2 = 0;
		int idx1 = 0;
		int idx2 = 0;
		while (true) {
			System.out.println("┌───────────────┬───────────────┐");
			System.out.println("│   p1 : " + cnt1 + "바퀴  	│   p2 : " + cnt2 + "바퀴  	│");
			System.out.println("├───┬───┬───┬───┼───┬───┬───┬───┤");
			for(int i = 0;i<size;i++) {
				System.out.print(i==0? "│ "+(i+1) :" │ "+ (i+1));
			}
			System.out.println(" │");
			System.out.println("├───┼───┼───┼───┼───┼───┼───┼───┤");
			for (int i = 0; i < size; i++) {
				System.out.print(p1[i] != 0 ? "│ ⛵" : "│   ");
			}
			System.out.print("│");
			System.out.println();
			System.out.println("│   │   │   │   │   │   │   │   │");
			for (int i = 0; i < size; i++) {
				System.out.print(p2[i] != 0 ? "│ 🛸" : "│   ");
			}
			System.out.println("│");
			System.out.println("├───┴───┴───┴───┴───┴───┴───┴───┤");
			int cnt = cnt1 > cnt2 ? cnt1 : cnt2;
			if (cnt == 3) {
				turn = turn == 2 ? 1 : 2;
				System.out.println("│             p" + turn + " 승리 		│");
				System.out.println("├───────────────────────────────┤");
				break;
			}
			if(cnt!=3) {
				System.out.println("│     	    player " + turn + "턴  		│");
			}
			System.out.println("└───────────────────────────────┘");
			System.out.print("(1~3) >> ");
			int move = sc.nextInt();
			System.out.println("└───────────────────────────────┘");
			if (move < 1 || move > 3) {
				System.out.println("이동 불가 거리");
				continue;
			}
			if (turn == 1) {
				p1[idx1] = 0;
				idx1 += move;
				if (idx1 >= size) {
					idx1 = 0;
					cnt1++;
				}
				p1[idx1] = 1;
				if (p1[0] == 0 && p2[0] == 0 && idx1 == idx2) {
					System.out.println("p1이 p2를 잡았다!");
					p2[idx2] = 0;
					p2[0] = 1;
					idx2 = 0;
				}
			} else {
				p2[idx2] = 0;
				idx2 += move;
				if (idx2 >= size) {
					idx2 = 0;
					cnt2++;
				}
				p2[idx2] = 1;
				if (p1[0] == 0 && p2[0] == 0 && idx1 == idx2) {
					System.out.println("p2가 p1을 잡았다!");
					p1[idx1] = 0;
					p1[0] = 1;
					idx1 = 0;
				}
			}
			turn = turn == 2 ? 1 : 2;
		}
		System.out.println("│            게임 종료		│");
		System.out.println("└───────────────────────────────┘");
		sc.close();
	}

}
