package level5시험;

import java.util.Random;
import java.util.Scanner;

public class _09 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Random rd = new Random();

		int size = 10;
		int[][] map = new int[size][size];

		int snakeSize = 4;
		int[] y = new int[snakeSize];
		int[] x = new int[snakeSize];
		for (int i = 0; i < snakeSize; i++) {
			map[0][i] = i + 1;
			y[i] = 0;
			x[i] = i;
		}

		int maxTale = 8;
		int itemCnt = rd.nextInt(5) + 4;
		int setItemCnt = 0;
		while (setItemCnt != itemCnt) {
			int rdY = rd.nextInt(size);
			int rdX = rd.nextInt(size);
			if (map[rdY][rdX] != 0) {
				continue;
			}
			map[rdY][rdX] = -1;
			setItemCnt++;
		}
		boolean isTouch = false;

		while (true) {
			System.out.println("        [남은 아이템 갯수 : " + itemCnt + "]");
			for (int[] col : map) {
				for (int row : col) {
					System.out.print("[" + (row == -1 ? "◆" : row == 0 ? " " : row) + "]");
				}
				System.out.println();
			}
			if (itemCnt == 0) {
				System.out.println("Round Complete !");
				break;
			}
			if (isTouch) {
				System.out.println("Dead...");
				break;
			}
			System.out.print("w.상 s.하 a.좌 d.우 > ");
			String move = sc.next();
			boolean nonMove = false;
			int py = y[0];
			int px = x[0];
			switch (move) {
			case "w":
				py--;
				break;
			case "s":
				py++;
				break;
			case "a":
				px--;
				break;
			case "d":
				px++;
				break;
			default:
				nonMove = true;
				break;
			}
			if (nonMove) {
				System.out.println("입력오류");
				continue;
			}
			if(py < 0 || px < 0 || py > size - 1 || px > size - 1) {
				System.out.println("이동 불가");
				continue;
			}
			if (map[py][px] > 0 && !(py == y[snakeSize - 1] && px == x[snakeSize - 1])) {
				isTouch = true;
				continue;
			}
			if (map[py][px] == -1) {
				itemCnt--;
				if (snakeSize < maxTale) {
					snakeSize++;
					int[] tempY = y;
					int[] tempX = x;
					y = new int[snakeSize];
					x = new int[snakeSize];
					for (int i = 0; i < snakeSize - 1; i++) {
						y[i] = tempY[i];
						x[i] = tempX[i];
					}
				}
			}
			for (int i = 0; i < snakeSize; i++) {
				map[y[i]][x[i]] = 0;
			}
			for (int i = snakeSize - 1; i > 0; i--) {
				y[i] = y[i - 1];
				x[i] = x[i - 1];
			}
			y[0] = py;
			x[0] = px;
			int num = 1;
			for (int i = 0; i < snakeSize; i++) {
				map[y[i]][x[i]] = num++;
			}
		}
		sc.close();
		// 소요 시간 : 20분 29초
	}

}
