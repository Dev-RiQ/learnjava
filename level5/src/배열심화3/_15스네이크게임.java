package 배열심화3;

import java.util.Random;
import java.util.Scanner;

public class _15스네이크게임 {
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Random rd = new Random();
		int size = 10;
		int snakeStartNum = 4;
		int snakeTaleMax = 8;
		int itemCntMax = 8;
		int itemCntMin = 4;
		int[][] map = new int[size][size];
		int snakeTaleNow = snakeStartNum;
		int[][] snakeLocation = new int[snakeTaleMax][2];
		for (int i = 0; i < snakeStartNum; i++) {
			snakeLocation[i][0] = 0;
			snakeLocation[i][1] = i;
			map[0][i] = 1;
		}
		int snakeHY = snakeLocation[0][0];
		int snakeHX = snakeLocation[0][1];
		int items = rd.nextInt(itemCntMax - itemCntMin + 1) + itemCntMin;
		for (int i = 0; i < items; i++) {
			int rdIdxY = rd.nextInt(size);
			int rdIdxX = rd.nextInt(size);
			if (map[rdIdxY][rdIdxX] != 0) {
				i--;
				continue;
			}
			map[rdIdxY][rdIdxX] = 2;
		}

		boolean isEnd = false;
		while (true) {
			System.out.println("[남은 아이템 : " + items + "]");
			for (int i = 0; i < size; i++) {
				for (int k = 0; k < size; k++) {
					if(map[i][k]==1) {
						for (int j = 0; j < snakeTaleMax; j++) {
							if (snakeLocation[j][0] == i && snakeLocation[j][1] == k) {
								System.out.printf("[%d]",j+1);
								break;
							}
						}
					}else {
						System.out.print(map[i][k] == 2 ? "[◆]" : "[ ]");
					}
				}
				System.out.println();
			}
			System.out.println("     △");
			System.out.println("     w");
			System.out.println("◁ a  s  d ▷");
			System.out.println("     ▽");
			if (isEnd) {
				System.out.println("뱀에 박음..ㅜㅠ");
				System.out.println("게임 종료.");
				break;
			}
			if (items == 0) {
				System.out.println("미션 성공 !!");
				System.out.println("게임 종료.");
				break;
			}
			String keyH = sc.next();
			int tempY = snakeHY;
			int tempX = snakeHX;
			if (keyH.equals("w")) {
				if (snakeHY == 0) {
					continue;
				}
				if (map[snakeHY - 1][snakeHX] != 1) {
					snakeHY--;
				}
			} else if (keyH.equals("s")) {
				if (snakeHY == size - 1) {
					continue;
				}
				if (map[snakeHY + 1][snakeHX] != 1) {
					snakeHY++;
				}
			} else if (keyH.equals("a")) {
				if (snakeHX == 0) {
					continue;
				}
				if (map[snakeHY][snakeHX - 1] != 1) {
					snakeHX--;
				}
			} else if (keyH.equals("d")) {
				if (snakeHX == size - 1) {
					continue;
				}
				if (map[snakeHY][snakeHX + 1] != 1) {
					snakeHX++;
				}
			} else {
				continue;
			}
			if(tempY == snakeHY && tempX == snakeHX) {
				isEnd = true;
			}else {
				if (map[snakeHY][snakeHX] == 2) {
					items--;
				}
				if (map[snakeHY][snakeHX] == 2 && snakeTaleNow != snakeTaleMax) {
					snakeTaleNow++;
				} else {
					map[snakeLocation[snakeTaleNow - 1][0]][snakeLocation[snakeTaleNow - 1][1]] = 0;
				}
				map[snakeHY][snakeHX] = 1;
				for (int i = snakeTaleNow - 1; i > 0; i--) {
					snakeLocation[i][0] = snakeLocation[i - 1][0];
					snakeLocation[i][1] = snakeLocation[i - 1][1];
				}
				snakeLocation[0][0] = snakeHY;
				snakeLocation[0][1] = snakeHX;
			}
		}
		sc.close();
	}

}
