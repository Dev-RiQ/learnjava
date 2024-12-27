package 메서드문제;

import java.util.Scanner;

class Theater {

	Scanner sc = new Scanner(System.in);

	int[] seat = new int[10];
	String name = ""; // 영화관 이름
	int cnt; // 예매 수
	int money; // 매출
	int price = 12000;
	boolean isEnd;

	void printMenu() {
		System.out.printf("=== %s === \n",name);
		System.out.println("[1] 예매하기");
		System.out.println("[2] 종료하기");
	}

	int getSelectNum(String name, int start, int end) {
		while (true) {
			System.out.printf("%s 선택 >> ",name);
			int sel = sc.nextInt();
			
			if(sel <start || sel >end) {
				System.out.printf("범위 에러 : %d ~ %d 사이의 값을 입력하세요.\n", start, end);
				continue;
			}
			return sel;
		}
	}
	
	void selectMenu() {
		while (!isEnd) {
			printMenu();
			int sel = getSelectNum("메뉴",1,2);
			if (sel == 1)
				selectSeat();
			else
				printEndMsg();
		}
	}

	void printSeat() {
		for (int i = 1 ; i <= 10 ; i ++ )
			System.out.printf("%2d  ",i);
		System.out.println();

		for (int s : seat)
			System.out.print(s == 0 ? "[O] " : "[X] ");
		System.out.println();
	}

	void selectSeat() {
		while (true) {
			printSeat();
			int sel = getSelectNum("좌석", 1, 10) - 1;
			if (seat[sel] != 0) {
				System.out.println("이미 예매된 좌석입니다.");
				continue;
			}
			seat[sel]++;
			cnt++;
			money += price;
			System.out.println("=== 예매 완료 ===");
			break;
		}
	}
	
	void printEndMsg() {
		System.out.println("영화예매가 종료됩니다.");
		System.out.println("총 매출액 = " + money);
		isEnd = true;
	}

	void run() {
		name = "메가박스";
		selectMenu();
		sc.close();
	}
}

public class _08메서드영화예매 {

	public static void main(String[] args) {

		Theater megabox = new Theater();
		megabox.run();
	}

}
