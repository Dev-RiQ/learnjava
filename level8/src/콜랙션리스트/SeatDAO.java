package 콜랙션리스트;

import java.util.ArrayList;
import java.util.Scanner;

public class SeatDAO {

	private ArrayList<Seat> list;
	final private int SIZE = 10;
	
	SeatDAO() {
		list = new ArrayList<Seat>();
		for(int i = 0 ; i < SIZE; i++) {
			list.add(new Seat(i+1));
		}
	}
	
	private void showMenu() {
		System.out.println("[1] 예매");
		System.out.println("[0] 종료");
	}
	
	private void showSeat() {
		for(int i = 0 ; i < SIZE ; i++)
			System.out.print(list.get(i).getNum() + " ");
		System.out.println();
		for(int i = 0 ; i < SIZE ; i++)
			System.out.print(list.get(i).isTaken()? "■ " : "□ ");
		System.out.println();
	}
	
	private int getValue(Scanner sc,String msg,int min, int max) {
		System.out.printf("%s (%d~%d) >> \n",msg,min,max);
		while(true)
			try {
				int sel = sc.nextInt();
				if(sel < min || sel > max)
					throw new Exception();
				return sel;
			} catch (Exception e) {
				System.out.println(msg+" 오류");
			}
	}
	
	private void checkVaildSeat(int value) {
		if(list.get(value - 1).isTaken())
			System.out.println("이미 예매된 좌석");
		else {
			list.get(value - 1).setTaken(true);
			System.out.println("예매 완료");
		}
	}
	
	private void showMoney() {
		int cnt = 0;
		for(int i = 0 ; i <SIZE ; i++)
			if(list.get(i).isTaken())
				cnt++;
		int price = cnt * 12000;
		System.out.println("총 예매 수 : "+cnt);
		System.out.println("매출액 : "+price+"원");
	}

	public void run() {
		Scanner sc = new Scanner(System.in);
		while(true) {
			showMenu();
			int sel = getValue(sc,"메뉴 선택",0,1);
			if(sel == 0)
				break;
			showSeat();
			int value = getValue(sc,"좌석 번호 선택",1,10);
			checkVaildSeat(value);
		}
		showMoney();
		sc.close();
	}
}
