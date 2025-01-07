package level7시험;

import java.util.Random;
import java.util.Scanner;

class Word {
	String word;
	int ranPos;

	Word(String word, int ranPos) {
		this.word = word;
		this.ranPos = ranPos;
	}

	String getWord() {
		return word;
	}

	String printWord() {
		String text = "";
		for (int i = 0; i < word.length(); i++)
			text += i == ranPos ? "*" : word.charAt(i);
		return text;
	}

	@Override
	public String toString() {
		return printWord();
	}

}

class WordDAO {
	Random ran;
	boolean[] checkList;
	Word[] list;

	void init() {
		String[] simple = { "java", "jsp", "python", "android", "spring" };
		list = new Word[simple.length];
		checkList = new boolean[simple.length];
		ran = new Random();
		for (int i = 0; i < list.length; i++)
			list[i] = new Word(simple[i], ran.nextInt(simple[i].length()));
	}

	String getValue(Scanner sc) {
		while (true) {
			System.out.print(" >> ");
			String value = sc.nextLine();
			if (!(value.isBlank() || value.contains(" ")))
				return value;
			System.out.println("빈칸 입력 불가");
		}
	}

	void matchValue(String value, int idx) {
		System.out.println();
		if (!list[idx].getWord().equals(value)) {
			System.out.println("[ 오답.. ]");
			return;
		}
		checkList[idx] = true;
		System.out.println("[ 정답 ! ]");
	}

	void printScore() {
		int score = 0;
		for (boolean cList : checkList)
			if (cList)
				score += 20;
		System.out.printf("총 점수 = %d점", score);
	}

	void printWord(int idx) {
		System.out.printf("\n문제 %d : %s\n", (idx + 1), list[idx]);
	}

	void run() {
		init();
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < list.length; i++) {
			printWord(i);
			String value = getValue(sc);
			matchValue(value, i);
		}
		printScore();
		sc.close();
	}
}

public class _03 {

	public static void main(String[] args) {

		WordDAO dao = new WordDAO();
		dao.run();
	}
	// 소요 시간 : 20분 46초
}
