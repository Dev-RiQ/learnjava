package 객체지향문제;

import java.util.ArrayList;
import java.util.Random;

public class MemoryGame {
	Random rd = new Random();
	ArrayList <Node1> list;
	final private int SIZE=10;
	private void init() {
		list = new ArrayList<Node1>();
		String [] gameSet = {"♥","■","◆","♣","●"};
		int [] gameSetNum = {1,1,2,2,3,3,4,4,5,5};
		for(int i = 0; i < SIZE; i++) {
			int idx = rd.nextInt(SIZE);
			int temp = gameSetNum[idx];
			gameSetNum[idx] = gameSetNum[i];
			gameSetNum[i] = temp;
		}
		String []game = new String[SIZE];
		for(int i = 0; i < game.length; i++) {
			game[i] = gameSet[gameSetNum[i]-1];
		}
		setFront(game);
	}
	void setFront(String[] gameSet) {
		for(int i = 0; i < SIZE; i++) {
			list.add(new Node1());
			list.get(i).setFront(gameSet[i]);
			list.get(i).setBack(null);
			list.get(i).setOpen(false);
			
		}
	}
	public void run() {
		init();
	}
}
