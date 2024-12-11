package 이차원배열문제;

import java.util.Random;
import java.util.Scanner;

public class _04사다리게임 {

	public static final String RESET = "\u001B[0m"; 
	public static final String FONT_YELLOW = "\u001B[33m";
	
	public static void main(String[] args) throws InterruptedException {
		/*
		 	인덱스 0~4 선택
		 	0만나면 아래
		 	1은 오른쪽가서 아래
		 	2는 왼쪽가서 아래
		 */
		Scanner sc = new Scanner(System.in);
		Random rd = new Random();
		
		String menu[] = {"떡라면","햄버거","치킨","쫄면","된장찌개","피자","토스트","김밥","돈가스","소고기"};
		
		int ladder[][]= {
				{0,0,0,0,0},
				{1,2,0,1,2},
				{0,1,2,0,0},
				{0,0,1,2,0},
				{1,2,0,0,0},
				{0,1,2,0,0},
				{1,2,0,0,0},
				{0,0,0,1,2},
				{0,0,0,0,0},
		};
		for(int i = 0;i<300;i++) {
			int rdNum = rd.nextInt(menu.length);
			String temp = menu[0];
			menu[0] = menu[rdNum];
			menu[rdNum] = temp;
		}
		int cnt = 0;
		int col = menu.length;
		ladder = new int[9][col];
		for (int i = 0; i < ladder.length; i++) {
			for (int k = 0; k < ladder[i].length; k++) {
				ladder[i][k] = cnt < col*5 ? rd.nextInt(2) : 0;
				if (k == ladder[i].length-1 && ladder[i][k] == 1) {
					k--;
					continue;
				}
				if (ladder[i][k] == 1) {
					ladder[i][++k] = 2;
					cnt++;
				}
			}
		}
		for (int i = 0; i < ladder[0].length; i++) {
			System.out.print("(" + i + ")");
		}
		System.out.println();
		for (int i = 0; i < ladder.length; i++) {
			for (int k = 0; k < ladder[i].length; k++) {
				if (ladder[i][k] == 0) {
					System.out.print(" │ ");
				} else if (ladder[i][k] == 1) {
					System.out.print(" ├─");
				} else if (ladder[i][k] == 2) {
					System.out.print("─┤ ");
				}
			}
			System.out.println();
		}
		for (int i = 0; i < menu.length; i++) {
			System.out.printf(i == 0 ? " %.1s" : " %.1s", menu[i]);
		}
		System.out.println();
		int output = -1;
		while (true) {
			System.out.print("시작할 번호 선택 >> ");
			int sel = sc.nextInt();
			if (sel < 0 || sel >= col) {
				System.out.println("없는 번호입니다");
				continue;
			}
			int temp = sel;
			int cntTurn = 0;
			while (true) {
				for (int i = 0; i < ladder[0].length; i++) {
					if (i == temp) {
						System.out.print(FONT_YELLOW + "(" + i + ")" + RESET);
					} else {
						System.out.print("(" + i + ")");
					}
				}
				System.out.println();
				cntTurn++;
				sel = temp;
				for (int i = 0; i < ladder.length; i++) {
					boolean isChange = false;
					if (ladder[i][sel] == 2) {
						sel--;
						isChange = true;
					}
					for (int k = 0; k < ladder[i].length; k++) {
						if (ladder[i][k] == 0) {
							System.out.print(k == sel && cntTurn > i ? FONT_YELLOW + " ┃ " + RESET : " │ ");
						} else if (ladder[i][k] == 1) {
							System.out.print(k == sel && cntTurn > i
									? isChange ? FONT_YELLOW + " ┏━" + RESET : FONT_YELLOW + " ┗━" + RESET
									: " ├─");
						} else if (ladder[i][k] == 2) {
							System.out.print(k == sel && cntTurn > i
									? isChange ? FONT_YELLOW + "━┛ " + RESET : FONT_YELLOW + "━┓ " + RESET
									: "─┤ ");
						}
						if (k == sel && ladder[i][sel] == 1) {
							sel++;
						}
						if (k == sel && isChange) {
							sel--;
						}
						if (cntTurn == ladder.length && k == ladder[i].length - 1) {
							if (i == 4) {
								System.out.print("     오늘의 점심은~");
							} else if (i == 5) {
								System.out.print("     " + menu[output]);
							}
						} else if (cntTurn % 2 == 0 && k == ladder[i].length - 1) {
							if (i == 2) {
								System.out.print("     ┏━━━");
							} else if (i == 3) {
								System.out.print("     ┗━━━   ━━━┓");
							} else if (i == 4) {
								System.out.print("    ━━━┳━━━    ┃");
							} else if (i == 5) {
								System.out.print("       ┃   ━━━┳━━━");
							} else if (i == 6) {
								System.out.print("              ┃");
							}
						} else if (cntTurn % 2 == 1 && k == ladder[i].length - 1) {
							if (i == 2) {
								System.out.print("            ━━━┓");
							} else if (i == 3) {
								System.out.print("     ┏━━━      ┃");
							} else if (i == 4) {
								System.out.print("     ┗━━━  ━━━┳━━━");
							} else if (i == 5) {
								System.out.print("    ━━━┳━━━   ┃");
							} else if (i == 6) {
								System.out.print("       ┃");
							}
						}
					}
					System.out.println();
				}
				if (cntTurn == 1) {
					output = sel;
				}
				for (int i = 0; i < menu.length; i++) {
					if (i == sel && cntTurn == ladder.length) {
						System.out.printf(i == 0 ? FONT_YELLOW + " %.1s" + RESET : FONT_YELLOW + " %.1s" + RESET,
								menu[i]);
					} else {
						System.out.printf(i == 0 ? " %.1s" : " %.1s", menu[i]);
					}
				}
				System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
				Thread.sleep(300);
				if(cntTurn==ladder.length) {
					break;
				}
			}
			break;
		}
		sc.close();
	}

}
