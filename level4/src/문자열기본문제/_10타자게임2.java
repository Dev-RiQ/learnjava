package 문자열기본문제;

import java.util.Random;
import java.util.Scanner;

public class _10타자게임2 {

	public static void main(String[] args) {

		/*
		 	문제 섞어서 순서대로 출제
		 	다맞추면 게임 종료
		 	출제 시 단어 랜덤 한 곳 * 출력 (틀리면 *고정)
		 */

		Scanner sc = new Scanner(System.in);
		Random rd = new Random();

		String[] words = { "java", "mysql", "jsp", "spring" };
		for (int i = 0; i < 100; i++) {
			int idx = rd.nextInt(4);
			String temp = words[0];
			words[0] = words[idx];
			words[idx] = temp;
		}
		String[] temp = new String[words.length];
		for (int i = 0; i < words.length; i++) {
			int rdNum = rd.nextInt(words.length);
			temp[i] = rdNum != 0 ? words[i].substring(0, rdNum - 1) + "*" + words[i].substring(rdNum, words[i].length())
					: "*" + words[i].substring(rdNum + 1, words[i].length());
		}
		for (int i = 0; i < temp.length; i++) {
			System.out.println("문제 : " + temp[i]);
			System.out.print("정답 : ");
			String input = sc.next();
			if (!input.equals(words[i])) {
				i--;
				continue;
			}
		}
		sc.close();
		
	}

}
