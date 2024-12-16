package 배열심화3;

import java.util.Random;
import java.util.Scanner;

public class _17박스옮기기 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Random rd = new Random();
		int size = 0;
		int end = 9;
		int start = 8;
		int box = 2;
		int wall = 1;
		while (true) {
			System.out.print("맵 크기 설정 (7 이상 입력) >> ");
			size = sc.nextInt();
			if (size < 7) {
				System.out.println("7 이상 입력");
				continue;
			}
			break;
		}
		int[][] map = new int[size][size];
		map[1][2] = box;
		map[1][1] = start;
		map[size - 1][size - 1] = end;
		int wallCnt = 0;
		while (true) {
			System.out.print("벽 개수 설정 (4 이상) >> ");
			wallCnt = sc.nextInt();
			if (wallCnt < 4) {
				System.out.println("4 이상 입력");
				continue;
			}
			if (wallCnt > size + size / 2) {
				System.out.println("너무 많이 입력했음");
				continue;
			}
			break;
		}
		while (wallCnt != 0) {
			int rdNum1 = rd.nextInt(size);
			int rdNum2 = rd.nextInt(size);
			if ((rdNum1 < 3 && rdNum2 < 4) || (rdNum1 > size - 4 && rdNum2 > size - 4)
					|| (rdNum1 != 0 && rdNum2 != 0 && map[rdNum1 - 1][rdNum2 - 1] != 0)
					|| (rdNum1 != 0 && rdNum2 != size - 1 && map[rdNum1 - 1][rdNum2 + 1] != 0)
					|| (rdNum1 != size - 1 && rdNum2 != 0 && map[rdNum1 + 1][rdNum2 - 1] != 0)
					|| (rdNum1 != size - 1 && rdNum2 != size - 1 && map[rdNum1 + 1][rdNum2 + 1] != 0)) {
				continue;
			}
			if (map[rdNum1][rdNum2] == 0) {
				map[rdNum1][rdNum2] = wall;
				wallCnt--;
			}
		}
		int y = 1;
		int x = 1;
		while (true) {
			for (int i = 0; i < size + 2; i++) {
				System.out.print("벽");
			}
			System.out.println();
			for (int[] col : map) {
				System.out.print("벽");
				for (int row : col) {
					if (row == 1) {
						System.out.print("벽");
					} else if (row == 2) {
						System.out.print("＠");
					} else if (row == 8) {
						System.out.print("方");
					} else if (row == 9) {
						System.out.print("골");
					} else {
						System.out.print("  ");
					}
				}
				System.out.println("벽");
			}
			for (int i = 0; i < size + 2; i++) {
				System.out.print("벽");
			}
			System.out.println();
			if (map[size - 1][size - 1] == box) {
				System.out.println("골인~");
				break;
			}
			sc.nextLine();
			System.out.println("       w.상");
			System.out.println("a.좌   s.하   d.우");
			String move = sc.next();
			int py = y;
			int px = x;
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
			}
			if (py < 0 || py > size - 1 || px < 0 || px > size - 1 || map[py][px] == wall) {
				System.out.println("움직일 수 없는 방향");
				continue;
			}
			int pyB = py;
			int pxB = px;
			if (map[pyB][pxB] == box) {
				switch (move) {
				case "w":
					pyB--;
					break;
				case "s":
					pyB++;
					break;
				case "a":
					pxB--;
					break;
				case "d":
					pxB++;
					break;
				}
				if (pyB < 0 || pyB > size - 1 || pxB < 0 || pxB > size - 1 || map[pyB][pxB] == wall) {
					System.out.println("움직일 수 없는 방향");
					continue;
				}
			}
			map[y][x] = 0;
			map[py][px] = start;
			if (y == size - 1 && x == size - 1) {
				map[y][x] = end;
			}
			if (py != pyB || px != pxB) {
				map[pyB][pxB] = box;
			}
			y = py;
			x = px;
		}
		sc.close();
	}

}
