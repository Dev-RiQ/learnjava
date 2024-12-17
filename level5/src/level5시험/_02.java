package level5시험;

import java.util.Scanner;

public class _02 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int[][] block = {
				{ 1, 2, 3, 4 },
				{ 5, 6, 7, 8 },
				{ 9, 10, 11, 12 },
				{ 13, 14, 15, 16 }
		};
		int size = block.length;
		while (true) {
			for (int[] col : block) {
				for (int row : col) {
					System.out.printf("[%2d]", row);
				}
				System.out.println();
			}
			System.out.println("[1.left_turn] [2.right_turn]");
			System.out.print("입력 (0. 종료) >> ");
			int sel = sc.nextInt();
			if (sel == 0) {
				System.out.println("종료");
				break;
			}
			if (sel < 1 || sel > 2) {
				System.out.println("입력오류");
				continue;
			}
			if (sel == 1) {
				int[][] temp = block;
				block = new int[size][size];
				for (int i = 0; i < size; i++) {
					for (int k = 0; k < size; k++) {
						block[i][k] = temp[k][size - 1 - i];
					}
				}
			} else {
				int[][] temp = block;
				block = new int[size][size];
				for (int i = 0; i < size; i++) {
					for (int k = 0; k < size; k++) {
						block[i][k] = temp[size - 1 - k][i];
					}
				}
			}
		}
		sc.close();
		
		// 소요 시간 : 4분 37초
	}

}
