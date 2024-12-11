package 배열심화3;

import java.util.Scanner;

public class _06숫자이동되감기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int game[][] = {
				{ 1, 2, 3, 4 },
				{ 5, 6, 7, 8 },
				{ 9, 10, 11, 12 },
				{ 13, 14, 15, 0 }
		};
		int move[][] = new int[10000][2];
		int x = 3;
		int y = 3;
		int moveCnt = 0;
		while (true) {
			for (int i = 0; i < game.length; i++) {
				for (int k = 0; k < game[i].length; k++) {
					System.out.printf(" %2d ", game[i][k]);
				}
				System.out.println();
			}
			System.out.println("1)left 2)right 3)up 4)down");
			System.out.println("5)undo 0)out");
			int sel = sc.nextInt();
			if (sel == 0) {
				System.out.println("종료");
				break;
			}
			if (sel < 1 || sel > 5) {
				System.out.println("입력오류");
				continue;
			}
			if ((x == 0 && sel == 1) || (x == 3 && sel == 2) || (y == 0 && sel == 3) || (y == 3 && sel == 4)) {
				System.out.println("이동 불가");
				continue;
			}
			if (sel == 5 && moveCnt == 0) {
				System.out.println("뒤로가기 불가능");
				continue;
			}
			int[] temp = {y,x};
			switch (sel) {
			case 1: x--; break;
			case 2: x++; break;
			case 3: y--; break;
			case 4: y++; break;
			default : y = move[--moveCnt][0]; x = move[moveCnt][1]; break;
			}
			game[temp[0]][temp[1]] = game[y][x];
			game[y][x] = 0;
			move[moveCnt][0] = sel != 5 ? temp[0] : 0;
			move[moveCnt][1] = sel != 5 ? temp[1] : 0;
			if (sel != 5) {
				moveCnt++;
			}
			System.out.println();
		}
		sc.close();
	}

}

