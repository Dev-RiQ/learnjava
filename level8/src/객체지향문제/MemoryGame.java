package 객체지향문제;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class MemoryGame {
	
	ArrayList<Node1> list;
	final private int SIZE = 10;

	private void init() {
		list = new ArrayList<Node1>();
		String[] gameSet = { "♥", "■", "◆", "♣", "●" };
		for (int i = 0; i < SIZE; i++)
			list.add(new Node1(gameSet[i/2]));
		suffleCard();
	}

	private void suffleCard() {
		Random rd = new Random();
		for (int i = 0; i < 100; i++) {
			int idx = rd.nextInt(SIZE);
			Node1 temp = list.get(0);
			list.set(0,list.get(idx));
			list.set(idx, temp);
		}
	}

	private void showCard() {
		for (int i = 0; i < SIZE; i++)
			System.out.print(list.get(i));
		System.out.println();
	}

	private void selectCard() {
		int idx1 = getIndex(1);
		String card1 = getCard(idx1);
		showCard();
		int idx2 = getIndex(2);
		String card2 = getCard(idx2);
		showCard();
		matchCard(idx1, card1, idx2, card2);
	}
	
	private String getCard(int idx) {
		String card = list.get(idx).getFront();
		list.get(idx).setBack(card);
		return card;
	}
	
	private void matchCard(int idx1,String card1,int idx2,String card2) {
		if (!card1.equals(card2)) {
			list.get(idx1).setBack(null);
			list.get(idx2).setBack(null);
			System.out.println("오답");
		} else {
			list.get(idx1).setOpen(true);
			list.get(idx2).setOpen(true);
			System.out.println("정답");
		}
	}

	private int getIndex(int num) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("카드" + num + " 선택 (1-10) >>");
			try {
				int value = sc.nextInt() - 1;
				if(isVaildValue(value))
					return value;
			} catch (Exception e) {
				System.err.println("1~10 범위의 숫자 선택");
			}finally {
				sc.nextLine();
			}
		}
	}
	
	private boolean isVaildValue(int value) throws Exception {
		if (value < 0 || value > 9)
			throw new Exception();
		if (list.get(value).isOpen())
			System.out.println("이미 맞춘 카드");
		else if (list.get(value).getBack() != null)
			System.out.println("같은 카드 선택 불가");
		else
			return true;
		return false;
	}

	private boolean isEnd() {
		for (int i = 0; i < SIZE; i++)
			if (!list.get(i).isOpen())
				return false;
		return true;
	}

	private void showAnswer() {
		for (int i = 0; i < SIZE; i++)
			System.out.print("["+list.get(i).getFront()+"]");
		System.out.println();
	}
	
	private void playGame() {
		while (true) {
			showCard();
			if (isEnd())
				break;
			selectCard();
		}
		System.out.println("게임 종료");
		Scanner sc = new Scanner(System.in);
		sc.close();
	}
	
	public void run() {
		init();
		showAnswer();
		playGame();
	}
}
