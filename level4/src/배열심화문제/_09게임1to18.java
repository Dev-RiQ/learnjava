package 배열심화문제;

import java.util.Random;
import java.util.Scanner;

public class _09게임1to18 {

	public static void main(String[] args) {
		final int SIZE = 9; // 변경불가 변수 지정 (대문자명명)
		Random rd = new Random();
		Scanner sc = new Scanner(System.in);
		int[] front = new int[SIZE];
		int[] back = new int[SIZE];
		for (int i = 0; i < front.length; i++) {
			front[i] = rd.nextInt(9) + 1;
			for (int k = 0; k < i; k++) {
				if (front[i] == front[k]) {
					i--;
					break;
				}
			}
		}
		for (int i = 0; i < back.length; i++) {
			back[i] = rd.nextInt(9) + 10;
			for (int k = 0; k < i; k++) {
				if (back[i] == back[k]) {
					i--;
					break;
				}
			}
		}
		int num = 1;
		while (true) {
			for (int k = 0; k < 3; k++) {
				for (int i = 3 * k; i < 3 + 3 * k; i++) {
					System.out.print("┌───┐ ");
				}
				System.out.println();
				for (int i = 3 * k; i < 3 + 3 * k; i++) {
					if (front[i] != 0) {
						System.out.print(front[i] < 10 ? "│ " + front[i] + " │ " : "│" + front[i] + " │ ");
					} else {
						System.out.print("│   │ ");
					}
				}
				System.out.println();
				for (int i = 3 * k; i < 3 + 3 * k; i++) {
					System.out.print("└───┘ ");
				}
				System.out.println();
			}
			System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
			if (num == 19) {
				break;
			}
			System.out.println();
			System.out.print("칸 입력(1~9) >>");
			int idx = sc.nextInt() - 1;
			if (idx < 0 || idx >= front.length) {
				System.out.println("입력오류");
				continue;
			}
			if (front[idx] != num) {
				System.out.println("순서대로 찾으세요");
				continue;
			}
			front[idx] = num < 10? back[idx] : 0;
			num++;
		}
		System.out.println("게임 종료");
		sc.close();
	}

}
