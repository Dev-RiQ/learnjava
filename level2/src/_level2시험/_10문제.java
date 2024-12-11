package _level2시험;

import java.util.Scanner;

public class _10문제 {

	public static void main(String[] args) {

		/*
		   [문제]
		  		[ATM로그인 실패]
		  		1. [1.로그인] 이후
		  		새로운 메뉴 출력 : [1.잔액확인] [2.로그아웃] [0.종료]
		  		2. 로그인을 3번 실패기 강제종료
		  		3. 로그인 성공 후 로그인 메뉴 실행 안함
		 */
		
		Scanner sc = new Scanner(System.in);
		int log = -1;
		int dbId = 1111;
		int dbPw = 1234;
		int cntLogFail = 0;
		while (true) {
			if (log == -1) {
				System.out.println("[1.로그인]");
			} else {
				System.out.println("[1.잔액확인]");
				System.out.println("[2.로그아웃]");
			}
			System.out.println("[0.종료]");
			System.out.print("메뉴 입력 >> ");
			int sel = sc.nextInt();
			if (log == -1 && sel == 2) {
				System.out.println("서비스 오류");
				continue;
			}
			if (log == -1 && (sel < 0 || sel > 1) || log == 1 && (sel < 0 || sel > 2)) {
				System.out.println("메뉴 번호 입력 오류");
				continue;
			}
			if (log == -1) {
				if (sel == 1) {
					System.out.print("id >> ");
					int inputId = sc.nextInt();
					System.out.print("pw >> ");
					int inputPw = sc.nextInt();
					if (inputId != dbId || inputPw != dbPw) {
						System.out.println("로그인 실패");
						cntLogFail += 1;
						if (cntLogFail == 3) {
							System.out.println("로그인 3번 실패로 프로그램 강제종료");
							sel = 0;
						}
					} else {
						System.out.println("로그인 성공");
						log = 1;
						cntLogFail = 0;
					}
				}
			} else {
				if (sel == 1) {
					System.out.println("잔액 조회");
				} else if (sel == 2) {
					System.out.println("로그아웃");
					log = -1;
				}
			}

			if (sel == 0) {
				System.out.println("프로그램 종료");
				break;
			}

		}
		sc.close();
		
		//소요 시간 : 분 초
	}

}
