package 문자열기본문제;

import java.util.Random;
import java.util.Scanner;

public class _12영어단어 {

	public static void main(String[] args) {

		/*
		 	처음 영어단어는 전부 *로 표시되어 출력
		 	입력받아 틀릴 때 마다 랜덤 한글자 공개
		 	단, 점수 5점씩 감점
		 	같은 글자는 한번에 공개
		 	다 벗겨지거나 맞추면 종료
		 */
		Scanner sc = new Scanner(System.in);
		Random rd = new Random();
		int score = 100;
		String quest = "performance";
		boolean[] isStar = new boolean[quest.length()];
		int cnt = 0;
		while (true) {
			String temp = "";
			if (cnt != 0) {
				int rdNum = rd.nextInt(quest.length());// 0~10
				if (isStar[rdNum]) {
					continue;
				}
				isStar[rdNum] = true;
				for (int i = 0; i < quest.length(); i++) {
					if (i != rdNum && quest.charAt(i) == quest.charAt(rdNum)) {
						isStar[i] = true;
					}
				}
			}
			System.out.print("문제 : ");
			for (int i = 0; i < quest.length(); i++) {
				if (!isStar[i]) {
					temp += "*";
				} else {
					temp += quest.charAt(i);
				}
			}
			System.out.println(temp);
			if (temp.equals(quest)) {
				System.out.println("탈락");
				break;
			}
			System.out.print("정답 : ");
			String input = sc.next();
			if (input.equals(quest)) {
				System.out.println("맞춤");
				System.out.println("점수 : "+score);
				break;
			}
			score -= 5;
			cnt++;

		}
		sc.close();
		
		
	}

}
