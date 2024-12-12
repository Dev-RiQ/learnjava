package 배열심화3;

import java.util.Scanner;

public class _12회전 {

	public static void main(String[] args) {

		int[][] block = {
				{ 1, 2, 3, 4 },     // 00 01 02 03
				{ 5, 6, 7, 8 },		// 10 11 12 13
				{ 9, 10, 11, 12 },	// 20 21 22 23
				{ 13, 14, 15, 16 }	// 30 31 32 33
		};
		Scanner sc = new Scanner(System.in);
		int size = block.length;
		while (true) {
			System.out.println("[    current block    ]");
			for (int[] col : block) {
				for (int row : col) {
					System.out.printf(" [%2d] ", row);
				}
				System.out.println();
			}
			System.out.println("=======================");
			System.out.println("[    0. test exit     ]");
			System.out.println("[    1. turn left     ]");
			System.out.println("[    2. turn right    ]");
			System.out.print("## select number >> ");
			int sel = sc.nextInt();
			if (sel == 0) {
				System.out.println("test over.");
				break;
			}
			if (sel < 1 || sel > 2) {
				System.out.println("error : non-existent function.");
				continue;
			}
			int[][] temp = block;
			block = new int[size][size];
			for (int i = 0; i < size; i++) {
				int row = sel == 1 ? size - 1 - i : i;
				for (int k = 0; k < size; k++) {
					int col = sel == 1 ? k : size - 1 - k;
					block[i][k] = temp[col][row];
				}
			}
			System.out.print(".\n.\n.\n[ turn ");
			System.out.print(sel == 1 ? "left" : "right");
			System.out.println(" complete ]\n");
		}
		sc.close();
	}

}
