package 배열심화3;

import java.util.Random;
import java.util.Scanner;

public class _05모두의마블 {

	public static void main(String[] args) {

		/*
		 	2인 번갈아 주사위 던짐
		 	3바퀴 먼저 돌면 승리
		 */
		Random rd = new Random();
		Scanner sc = new Scanner(System.in);
		int[][] map = {
				{ 1, 2, 3, 4, 5 },
				{ 16, 17, 17, 17, 6 },
				{ 15, 17, 17, 17, 7 },
				{ 14, 17, 17, 17, 8 },
				{ 13, 12, 11, 10, 9 }
		};
		int[] p = { 1, 1 };
		int[] round = { 0, 0 };
		int turn = 1;
		while (true) {
			System.out.println("[p1 : " + round[0] + "/3바퀴]");
			System.out.println("[p2 : " + round[1] + "/3바퀴]");
			for (int[] show1 : map) {
				for (int show2 : show1) {
					if (show2 == p[0] && show2 == p[1]) {
						System.out.print(" * ");
					} else if (show2 == p[0]) {
						System.out.print(" 1 ");
					} else if (show2 == p[1]) {
						System.out.print(" 2 ");
					} else {
						System.out.print(show2 == 17 ? " ■ " : show2 == 1 ? " S " : " □ ");
					}
				}
				System.out.println();
			}
			if (round[0] == 3 || round[1] == 3) {
				turn = turn == 1 ? 2 : 1;
				System.out.println("[ p" + turn + " 승리 ]");
				break;
			}
			System.out.println("[ p" + turn + " 턴 ]");
			while (true) {
				System.out.print("1. 주사위 굴리기 >> ");
				int sel = sc.nextInt();
				if (sel != 1) {
					System.out.println("입력오류");
					continue;
				}
				break;
			}
			int dice = rd.nextInt(6) + 1;
			System.out.println("주사위 : " + dice);
			p[turn - 1] += dice;
			round[turn - 1] += p[turn - 1] > 16 ? 1 : 0;
			p[turn - 1] -= p[turn - 1] > 16 ? 16 : 0;
			p[turn - 1] = round[turn - 1] == 3 ? 1 : p[turn - 1];
			turn = turn == 1 ? 2 : 1;
			System.out.println();
		}
		sc.close();
	}

}
