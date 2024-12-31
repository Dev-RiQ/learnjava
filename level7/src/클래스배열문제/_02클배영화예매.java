package 클래스배열문제;

import java.util.Scanner;

class SeatVO {
	int num;
	boolean check;

	void setNum(int num) {
		this.num = num;
	}

	void setCheck(boolean check) {
		this.check = check;
	}
	
	int getNum() {
		return num;
	}

	boolean getCheck() {
		return check;
	}
}

class SeatDAO {

	Scanner sc = new Scanner(System.in);

	final int SIZE = 8;
	SeatVO[] seatList;
	String name;
	int cnt;
	int money;

	void init() {
		seatList = new SeatVO[SIZE];
		for (int i = 0; i < SIZE; i++) {
			seatList[i] = new SeatVO();
			seatList[i].setNum(i+1);
		}
			
	}

	void showMenu() {
		System.out.println("[1] 예매하기");
		System.out.println("[2] 종료");
	}

	int getInput(String msg, int start, int end) {
		while (true) {
			System.out.print(msg + " 선택 >> ");
			int input = sc.nextInt();
			if (input >= start && input <= end)
				return input;
			System.out.println("입력 범위 오류");
		}
	}

	boolean isSoldOut() {
		if (cnt == 8) {
			System.out.println("전 좌석 매진으로 예매 불가");
			return true;
		}
		return false;
	}

	void showSeat() {
		for (SeatVO vo : seatList)
			System.out.printf("%-2d", vo.getNum());
		System.out.println();
		for (SeatVO vo : seatList)
			System.out.print(vo.check == false ? "□ " : "■ ");
		System.out.println();
	}

	void bookSeat(int seatNum) {
		boolean empty = !seatList[seatNum].getCheck();
		if (!empty) {
			System.out.println("이미 예매 완료된 좌석");
			return;
		}
		cnt++;
		money += 12000;
		seatList[seatNum].setCheck(empty);
		System.out.printf("====== %d 번 좌석 예매 완료 ====== \n", seatList[seatNum].getNum());
	}

	void run() {
		init();
		while (true) {
			showMenu();
			int inputMenu = getInput("메뉴", 1, 2);
			if (inputMenu == 1) {
				if (isSoldOut()) continue;
				showSeat();
				int inputSeat = getInput("좌석", 1, SIZE) - 1;
				bookSeat(inputSeat);
			} else
				break;
		}
		System.out.printf("====== 매출액은 %d원 ====== \n", money);
	}
}

public class _02클배영화예매 {

	public static void main(String[] args) {

		SeatDAO dao = new SeatDAO();
		dao.run();
	}

}
