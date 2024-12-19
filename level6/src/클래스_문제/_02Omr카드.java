package 클래스_문제;

import java.util.Arrays;
import java.util.Random;

class Omr {
	int[] answer = { 1, 3, 4, 2, 5 };
	int[] hgd = new int[5];
	int cnt = 0;
	int score = 0;
}

public class _02Omr카드 {

	public static void main(String[] args) {

		Random rd = new Random();
		Omr omr = new Omr();
		for (int i = 0; i < omr.hgd.length; i++) {
			omr.hgd[i] = rd.nextInt(5) + 1;
			if (omr.hgd[i] == omr.answer[i]) {
				omr.cnt++;
			}
		}
		omr.score = 20 * omr.cnt;
		System.out.println("answer  = " + Arrays.toString(omr.answer));
		System.out.println("hgd     = " + Arrays.toString(omr.hgd));
		System.out.println("성적    = " + omr.score);
	}

}
