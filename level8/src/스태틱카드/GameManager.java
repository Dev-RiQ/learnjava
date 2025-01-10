package 스태틱카드;

import java.util.ArrayList;
import java.util.Random;

public class GameManager {

	private static int playerSize;
	private final int SIZE = 52;
	private final ArrayList<Card> deck = new ArrayList<>();
	private final Player[] players = new Player[playerSize];
	private Player winner;

	// 참가 인원 수, 인당 카드 장수 설정
	static void init(int playerCnt, int cardCnt) {
		GameManager.setPlayerSize(playerCnt);
		Player.setCardSize(cardCnt);
	}

	// 참가 인원 수 설정
	static void setPlayerSize(int playerSize) {
		GameManager.playerSize = playerSize;
	}

	// 덱 설정 및 셔플
	GameManager() {
		setDeck();
		suffleDeck();
	}

	// 덱 설정
	private void setDeck() {
		for (int i = 0; i < SIZE; i++)
			deck.add(new Card(Card.getShapes()[i / 13], i % 13 + 1));
	}

	// 덱 셔플
	private void suffleDeck() {
		Random rd = new Random();
		for (int i = 0; i < 300; i++) {
			int rdNum = rd.nextInt(SIZE);
			Card temp = deck.get(0);
			deck.set(0, deck.get(rdNum));
			deck.set(rdNum, temp);
		}
	}

	// 참가 인원 생성 및 카드 나눠주기
	private void setPlayers() {
		for (int i = 0; i < players.length; i++)
			players[i] = new Player("p" + (i + 1), shareCard());
	}

	// 카드 나눠주기
	private Card[] shareCard() {
		Card[] cards = new Card[Player.getCardSize()];
		for (int i = 0; i < cards.length; i++) {
			cards[i] = deck.get(0);
			deck.remove(cards[i]);
		}
		return cards;
	}

	// 승리자 찾기
	private void setWinner() {
		setPlayerWin();
		for (int i = 0; i < players.length; i++)
			if (players[i].isWin())
				winner = players[i];
	}

	// 승리자 설정
	private void setPlayerWin() {
		players[winnerIndex()].setWin(true);
	}

	// 승리자 번호 찾기
	private int winnerIndex() {
		String[] type = { "sum", "num", "shape" };
		int[] idxs = getInitIdx();
		for (int i = 0; i < type.length; i++) {
			idxs = getIdxs(getData(type[i]), idxs);
			if (idxs.length == 1)
				return idxs[0];
		}
		return -1;
	}

	// 초기 인덱스 범위 설정
	private int[] getInitIdx() {
		int[] idx = new int[players.length];
		for (int i = 0; i < idx.length; i++)
			idx[i] = i;
		return idx;
	}

	// 중복 조건 만족 인덱스 범위
	private int[] getIdxs(int[] data, int[] idxBefore) {
		int max = getMax(data, idxBefore);
		int size = getSize(data, idxBefore, max);
		return getIdxs(data, idxBefore, size, max);
	}

	// 중복 조건 만족 최대 값
	private int getMax(int[] data, int[] index) {
		int max = 0;
		for (int i = 0; i < index.length; i++)
			if (max < data[index[i]])
				max = data[index[i]];
		return max;
	}

	// 중복 조건 만족 최대 값 갯수
	private int getSize(int[] data, int[] index, int max) {
		int size = 0;
		for (int i = 0; i < index.length; i++)
			if (max == data[index[i]])
				size++;
		return size;
	}

	// 중복 조건 만족 최대 값 인덱스 배열
	private int[] getIdxs(int[] data, int[] idxBefore, int size, int max) {
		int[] idxs = new int[size];
		int index = 0;
		for (int i = 0; i < idxBefore.length; i++)
			if (max == data[idxBefore[i]])
				idxs[index++] = idxBefore[i];
		return idxs;
	}

	// 조건에 따른 데이터 (합, 최대, 모양비교)
	private int[] getData(String type) {
		int[] data = new int[players.length];
		for (int i = 0; i < players.length; i++)
			if (type.equals("sum"))
				data[i] = players[i].getSum();
			else if (type.equals("num"))
				data[i] = players[i].getTopNum();
			else if (type.equals("shape"))
				data[i] = players[i].getTopShape();
		return data;
	}

	// 결과 및 승리자 표시
	private void printResult() {
		for (Player p : players)
			System.out.print(p + (p.equals(winner) ? " ==> 승리\n" : "\n"));
	}

	void run() {
		setPlayers();
		setWinner();
		printResult();
	}
}
