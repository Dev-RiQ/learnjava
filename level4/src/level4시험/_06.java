package level4시험;

import java.util.Random;
import java.util.Scanner;

public class _06 {

	public static void main(String[] args) {

		/*
		 	타자연습 2단계
		 	1. 문제 섞는다
		 	2. 순서대로 문제 출제하고, 다맞추면 종료
		 	3. 문제 출제 시 단어 랜덤 한곳 * 출력
		 */
		Scanner sc = new Scanner(System.in);
		Random rd = new Random();
		String[] words = { "java", "mysql", "jsp", "spring" };
		for (int i = 0; i < 100; i++) {
			int rdNum = rd.nextInt(words.length - 1) + 1;
			String temp = words[0];
			words[0] = words[rdNum];
			words[rdNum] = temp;
		}
		for (int i = 0; i < words.length; i++) {
			int rdNum = rd.nextInt(words[i].length());
			while (true) {
				System.out.println("[ ROUND " + (i + 1) + " ]");
				System.out.print("문제 : ");
				System.out.println(words[i].substring(0, rdNum) + "*" + words[i].substring(rdNum + 1));
				System.out.print("정답 : ");
				String input = sc.next();
				if (words[i].equals(input)) {
					System.out.println("정답입니다.");
					System.out.println();
					break;
				}
				System.out.println("오답입니다.");
				System.out.println();
			}
		}
		System.out.println("게임 종료");
		sc.close();
		// 소요 시간 : 6분 57초
	}

}
