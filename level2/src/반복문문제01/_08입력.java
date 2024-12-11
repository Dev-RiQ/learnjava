package 반복문문제01;

import java.util.Scanner;

public class _08입력 {

	public static void main(String[] args) {

		/*
		 	1. 무한 반복을 하면서 숫자를 입력받는다.
		 	2. 입력한 숫자가 -100이면, 프로그램 종료
		 */
		
		Scanner sc = new Scanner(System.in);
		
		boolean run = true;
		while (run) {
			System.out.print("숫자입력(EXIT:-100) : ");
			int i = sc.nextInt();
			if (i == -100) {
				run = false;
				System.out.println("\n프로그램 종료");
			}

		}
		sc.close();

	}

}
