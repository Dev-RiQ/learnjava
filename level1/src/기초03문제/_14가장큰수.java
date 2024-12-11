package 기초03문제;

import java.util.Scanner;

public class _14가장큰수 {

	public static void main(String[] args) {

		/*
		 * [문제]
		 * 		사용자에게 정수만 3개를 입력받아서 차례로 a, b, c에 저장한다.
		 * 		그리고 그 중에서 a가 가장 큰 수이면 true
		 */
		
		Scanner scan = new Scanner(System.in);

		System.out.println("정수를 입력하세요.\n");
		System.out.print("a = ");
		int a = scan.nextInt();
		System.out.print("b = ");
		int b = scan.nextInt();
		System.out.print("c = ");
		int c = scan.nextInt();

		boolean res = a > b && a > c;
		System.out.println("입력한 세 정수 중 가장 큰 것은 a이다.\n" + res);

		scan.close();
		
		
	}

}
