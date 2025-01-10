package 스태틱카드;

public class Player {

	private String name;
//	private Card card1;
//	private Card card2;
	private static int cardSize;
	private final Card[] cards = new Card[cardSize];
	private boolean win;
	
	static int getCardSize() {
		return cardSize;
	}
	
	static void setCardSize(int size) {
		Player.cardSize = size;
	}

	Player(String name, Card[] cards) {
		this.name = name;
		for (int i = 0; i < this.cards.length; i++)
			this.cards[i] = cards[i];
	}

	String getName() {
		return name;
	}

	Card[] getCards() {
		return cards;
	}

	boolean isWin() {
		return win;
	}

	void setWin(boolean win) {
		this.win = win;
	}

	void setName(String name) {
		this.name = name;
	}
	
	int getSum() {
		int sum = 0;
		for(Card c : cards)
			sum += c.getNum();
		return sum;
	}
	
	int getTopNum() {
		int num = 0;
		for(Card c : cards)
			if(num < c.getNum())
				num = c.getNum();
		return num;
	}
	
	int getTopShape() {
		int shape = 0;
		for(Card c : cards)
			for(int i = 0 ; i < 4; i++)
				if(c.getShape().equals(Card.getShapes()[i]) && c.getNum() == getTopNum())
					shape = i;
		return shape;
	}

	private String setToString() {
		String msg = name + " : ";
		int sum = 0;
		for (Card card : cards) {
			msg += card.toString() + ", ";
			sum += card.getNum();
		}
		return msg.substring(0, msg.length() - 2) + " : " + sum;
	}

	@Override
	public String toString() {
		return setToString();
	}

}
