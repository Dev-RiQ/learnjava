package 문자열기본문제;

import java.util.Random;
import java.util.Scanner;

public class _09타자연습1 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Random rd = new Random();

		String[] words = { "java", "mysql", "jsp", "spring" };
		for (int i = 0; i < 100; i++) {
			int idx = rd.nextInt(4);
			String temp = words[0];
			words[0] = words[idx];
			words[idx] = temp;
		}
		for (int i = 0; i < words.length; i++) {
			System.out.println("문제 : " + words[i]);
			System.out.print("입력 : ");
			String input = sc.next();
			if (!input.equals(words[i])) {
				i--;
				continue;
			}
		}
		sc.close();
		
	}

}
