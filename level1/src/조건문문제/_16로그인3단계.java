package 조건문문제;

import java.util.Scanner;

public class _16로그인3단계 {

	public static void main(String[] args) {

		/*
			[문제]
				중첩 조건문으로 표현
				
				1. id입력받아 joinId와 일치하면 pw입력 가능
				2. id 틀리면 "ID를 확인해주세요." 출력
				3. pw 틀리면 "PW를 확인해주세요." 출력
				4. id와 pw 모두 일치 시 "로그인 성공입니다." 출력
		 */
		
		int joinId = 1234;
		int joinPw = 1111;
		int pw = 0;
		
		Scanner sc = new Scanner(System.in);
		System.out.print("ID : ");
		int id = sc.nextInt();
				
		if (id == joinId) {
			System.out.print("PW : ");
			pw = sc.nextInt();
			
			if (pw == joinPw) {
				System.out.println("로그인 성공입니다.");
			}
			if (pw != joinPw) {
				System.out.println("PW를 확인해주세요.");
			}
		}
		if (id != joinId) {
			System.out.println("ID를 확인해주세요.");
		}
		if (id != joinId || pw != joinPw) {
			System.out.println("로그인 실패");
		}
		sc.close();
		
		
		
	}

}
