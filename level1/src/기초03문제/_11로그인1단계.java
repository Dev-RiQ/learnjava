package 기초03문제;

import java.util.Scanner;

public class _11로그인1단계 {

	public static void main(String[] args) {

		/*
		 * [문제]
		 * 		철수는 로그인을 하려고 한다.
		 * 		아이디와 비밀번호를 입력받는다.
		 * 		아이디와 비밀번호 둘 중 하나만 틀려도 로그인은 실패한다.
		 * 		joinId와 joinPw는 철수가 이미 가입한 아이디와 비밀번호이다.
		 */
		
		Scanner scan = new Scanner(System.in);

		int joinId = 1234;
		int joinPw = 4321;

		System.out.print("ID : ");
		int inputId = scan.nextInt();

		System.out.print("PW : ");
		int inputPw = scan.nextInt();

		boolean login = inputId == joinId && inputPw == joinPw;

		System.out.println("철수는 로그인에 성공하였는가?\n" + login);

		scan.close();
		
	}

}
