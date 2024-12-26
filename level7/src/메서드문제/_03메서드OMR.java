package 메서드문제;

import java.util.Arrays;
import java.util.Random;

class ScoreMng {
	Random rd = new Random();
	int[] answer = { 1, 3, 4, 2, 5 };
	int[] hgd;
	String[] checkList;
	int score;

	void makeAnswer() {
		hgd = new int[answer.length];
		for (int i = 0; i < hgd.length; i++)
			hgd[i] = rd.nextInt(5) + 1;
	}

	void showAnswer() {
		System.out.println("정답 = " + Arrays.toString(answer));
		System.out.println("내답 = " + Arrays.toString(hgd));
	}

	void checkAnswer() {
		checkList = new String[hgd.length];
		for (int i = 0; i < hgd.length; i++) {
			if (hgd[i] == answer[i]) {
				checkList[i] = "O";
				score += 20;
			} else
				checkList[i] = "X";
		}
		System.out.println("결과 = " + Arrays.toString(checkList));
		System.out.println("성적 = " + score);
	}

}

public class _03메서드OMR {

	public static void main(String[] args) {

		ScoreMng sm = new ScoreMng();

		sm.makeAnswer();
		sm.showAnswer();
		sm.checkAnswer();
	}

}
