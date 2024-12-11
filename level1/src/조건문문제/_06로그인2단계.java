package 조건문문제;

import java.util.Scanner;

public class _06로그인2단계 {

	public static void main(String[] args) {

		/*
		 	로그인 [2단계]
		 	1. Id가 틀린 경우, "Id를 확인해주세요"
		 	2. Pw가 틀린 경우, "Pw를 확인해주세요"
		 	3. Id와 Pw가 모두 일치하는 경우, "로그인 성공"
		 	4. Id와 Pw가 모두 틀리거나 둘중 한개라도 틀린 경우, "로그인 실패"
		 */

		Scanner sc = new Scanner(System.in);

		int dbId = 1234;
		int dbPw = 1111;

		System.out.print("Id를 입력하세요 >>");
		int id = sc.nextInt();
		System.out.print("Pw를 입력하세요 >>");
		int pw = sc.nextInt();
		
		boolean errId = id != dbId;
		boolean errPw = pw != dbPw;
		
		if (!errId && !errPw) {
			System.out.println("로그인 성공");
		}
		if (errId || errPw) {
			if (errId) {
				System.out.println("Id를 확인해주세요");
			}
			if (errPw) {
				System.out.println("Pw를 확인해주세요");
			}
			System.out.println("로그인 실패");
		}

		sc.close();

	}

}
