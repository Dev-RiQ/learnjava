package 메서드문제;

import java.util.Scanner;

class LadderGame {

	Scanner sc = new Scanner(System.in);
	
	int[][] ladder;
	final int SIZE = 5;
	String[] menu;

	void init() {
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
		this.ladder = ladder;
	}
	
	void setMenu() {
		menu = new String[SIZE];
		for (int i = 0; i < SIZE; i++) {
			System.out.printf("%d번 메뉴 >> ", i + 1);
			menu[i] = sc.next();
			for (int k = 0; k < i; k++)
				if(menu[k].equals(menu[i])) {
					System.out.println("중복 메뉴");
					i--;
					break;
				}
		}
	}

	void showLadder() {
		for (int i = 0; i < SIZE; i++)
			System.out.printf(" %d ", i + 1);
		System.out.println();
		
		for (int i = 0; i < ladder.length; i++) {
			for (int k = 0; k < SIZE; k++) {
				if (ladder[i][k] == 0)
					System.out.print(" ┃ ");
				else if (ladder[i][k] == 2)
					System.out.print(" * ");
				else {
					System.out.print(" ┣━━┫ ");
					k++;
				}
			}
			System.out.println();
		}
	}

	int getNumber() {
		while (true) {
			System.out.print("번호 선택 >> ");
			int value = sc.nextInt() - 1;
			if (value < 0 || value >= SIZE)
				System.out.println("입력 오류");
			else
				return value;
		}
	}

	int startLadder(int value) {
		int x = value;
		for (int i = 0; i < ladder.length; i++) {
			if (ladder[i][x] == 1) {
				ladder[i][x] = 2;
				boolean isRight = (x + 1 == SIZE || ladder[i][x + 1] == 0);
				x += isRight ? -1 : 1;
			}
			ladder[i][x] = 2;
		}
		return x;
	}

	int maxMenuLength() {
		int max = 0;
		for (int i = 0; i < SIZE; i++)
			if (max < menu[i].length())
				max = menu[i].length();
		return max;
	}

	void showResult(int x) {
		for (int k = 0; k < maxMenuLength(); k++) {
			for (int i = 0; i < SIZE; i++)
				System.out.printf("%s ", k < menu[i].length() ? menu[i].charAt(k) : "  ");
			System.out.println();
		}
		System.out.printf("\n오늘은 %s 가자~!", menu[x]);
	}

	void test() {
		menu = new String[SIZE];
		menu[0] = "샤브샤브에칼국수와볶음밥";
		menu[1] = "피시방짜계치";
		menu[2] = "죽";
		menu[3] = "마라탕에연태고량주";
		menu[4] = "그냥집에";
	}

	void run() {
//		test();
		init();
		setMenu();
		showLadder();
		int value = getNumber();
		int x = startLadder(value);
		showLadder();
		showResult(x);
		sc.close();
	}
}

public class _13메서드사다리 {

	public static void main(String[] args) {

		LadderGame lg = new LadderGame();

		lg.run();
	}

}
