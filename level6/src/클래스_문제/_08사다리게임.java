package 클래스_문제;

import java.util.Scanner;

class LadderGame{
	int ladder[][] = {
			{ 0, 0, 0, 0, 0 },
			{ 1, 1, 0, 1, 1 },
			{ 0, 0, 0, 0, 0 },
			{ 0, 0, 1, 1, 0 },
			{ 1, 1, 0, 1, 1 },
			{ 0, 1, 1, 0, 0 },
			{ 0, 0, 1, 1, 0 },
			{ 0, 0, 0, 1, 1 },
			{ 0, 0, 0, 0, 0 }
	};
	int x = 0;
	int y = 0;
	String[] menu = { "죠스떡볶이", "CU편의점", "마라탕", "김밥천국", "명인만두" };
}

public class _08사다리게임 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		LadderGame lg = new LadderGame();

		for (int i = 0; i < lg.ladder[0].length; i++) {
			System.out.print(" " + (i + 1) + " ");
		}
		System.out.println();
		for (int i = 0; i < lg.ladder.length; i++) {
			for (int k = 0; k < lg.ladder[i].length; k++) {
				if (lg.ladder[i][k] == 0) {
					System.out.print(" ┃ ");
				} else {
					System.out.print(" ┣━");
					System.out.print("━┫ ");
					k++;
				}
			}
			System.out.println();
		}
		int sel = 0;
		while (true) {
			System.out.print("번호 선택 >> ");
			sel = sc.nextInt();
			if (sel < 1 || sel > 5) {
				System.out.println("입력오류");
				continue;
			}
			break;
		}
		lg.y = 0;
		lg.x = sel - 1;
		boolean isRe = false;
		for (int i = 0; i < lg.ladder.length; i++) {
			boolean isGo = false;
			for (int k = 0; k < lg.ladder[i].length; k++) {
				if (i == lg.y && k == lg.x) {
					System.out.print(" * ");
					if (lg.ladder[i][k] == 0) {
						lg.y++;
					} else {
						if (!isGo) {
							lg.x++;
							isGo = true;
						} else {
							lg.y++;
							if (isRe) {
								lg.x--;
								isRe = false;
							}
						}
					}
				} else if (lg.ladder[i][k] == 0) {
					System.out.print(" ┃ ");
				} else {
					System.out.print(" ┣━");
					System.out.print("━┫ ");
					k++;
				}
			}
			if (lg.y != lg.ladder.length && lg.x != 0 && lg.ladder[lg.y][lg.x] == 1 && lg.ladder[lg.y][lg.x - 1] == 1) {
				isRe = true;
				lg.x--;
			}
			System.out.println();
		}
		for (int i = 0; i < lg.ladder[0].length; i++) {
			for (int k = 0; k < lg.menu.length; k++) {
				if (i > lg.menu[k].length() - 1) {
					System.out.print("   ");
				} else {
					if (lg.menu[k].charAt(i) < 255) {
						System.out.printf(" %-2s", lg.menu[k].charAt(i));
					} else {
						System.out.printf(" %s", lg.menu[k].charAt(i));
					}
				}
			}
			System.out.println();
		}
		System.out.println();
		System.out.println("자~ " + lg.menu[lg.x] + " 드가자~");
		sc.close();
	}

}
