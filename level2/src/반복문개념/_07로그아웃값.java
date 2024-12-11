package 반복문개념;

import java.util.Scanner;

public class _07로그아웃값 {

	public static void main(String[] args) {

		/*
		 	[문제]
		 		1. 로그인
		 			- 로그인 후, 재로그인 불가함
		 			- 로그아웃 상태에서만 이용 가능
		 		2. 로그아웃
		 			- 로그인 후 이용가능
		 		3. 로그인, 로그아웃 관리는 log변수를 이용한다.
		 			예) -1(로그아웃), 1111(id1), 2222(id2)
		 */
		
		Scanner sc = new Scanner(System.in);

		int id = 0;
		int pw = 0;
		
		int id1 = 1111;
		int pw1 = 1234;

		int id2 = 2222;
		int pw2 = 2345;
		int log = -1; // -1:로그아웃 1111(id1) 2222(id2)
		boolean rs = true;
		
		while (rs) {
			if (log == -1) {
				System.out.println("로그아웃 상태");
			} else if (log == 1111) {
				System.out.println("1111님 로그인상태");
			} else if (log == 2222) {
				System.out.println("2222님 로그인상태");
			}
			
			System.out.println("1. 로그인");
			System.out.println("2. 로그아웃");
			System.out.println("0. 종료");
			System.out.print("메뉴 선택 : ");
			int input = sc.nextInt();
			if (input != 0 && input != 1 && input != 2) {
				System.out.println("번호 입력오류");
			}
			
			if (input == 0) {
				System.out.println("프로그램 종료");
				log = -1;
				rs = false;
			}else if (input == 2) {
				if(log == -1) {
					System.out.println("로그인 후 이용해주세요.");
				} else {
					System.out.println("로그아웃 성공");
					log = -1;
				}
			}else if (input == 1) {
				if(log == 1111 || log == 2222) {
					System.out.println("로그아웃 후 이용해주세요");
				} else {
					System.out.print("id >> ");
					id = sc.nextInt();
					System.out.print("pw >> ");
					pw = sc.nextInt();
					if (id == id1 && pw == pw1) {
						System.out.println("1111님 로그인 성공");
						log = 1111;
					} else if (id == id2 && pw == pw2) {
						System.out.println("2222님 로그인 성공");
						log = 2222;
					} else {
						System.out.println("로그인 실패");
					}
				}
			}
			System.out.println("================");
		}
		
		
		id = 0;
		pw = 0;
		
		id1 = 1111;
		pw1 = 1234;
		
		id2 = 2222;
		pw2 = 2345;
		log = -1; // -1:로그아웃 1111(id1) 2222(id2)
		rs = true;
		
		while (rs) {
			//상태창
			if (log == -1) {
				System.out.println("로그아웃 상태");
			} else if (log == id1) {
				System.out.println("1111님 로그인상태");
			} else if (log == id2) {
				System.out.println("2222님 로그인상태");
			}
			//기본 출력문 : 메뉴 선택
			System.out.println("1. 로그인");
			System.out.println("2. 로그아웃");
			System.out.println("0. 종료");
			System.out.print("메뉴 선택 : ");
			int input = sc.nextInt();
			if (input < 0 || input > 2) {
				System.out.println("번호 입력오류");
			}
			//0번 프로그램 종료
			if (input == 0) {
				System.out.println("프로그램 종료");
				log = -1;
				rs = false;
			}
			//2번 로그아웃
			if (input == 2 && log == -1) {
				System.out.println("로그인 후 이용해주세요.");
			} else if (input == 2) {
				System.out.println("로그아웃 성공");
				log = -1;
			}
			//1번 로그인
			if (input == 1 && log != -1) {
				System.out.println("로그아웃 후 이용해주세요");
			} else if (input == 1) {
				System.out.print("id >> ");
				id = sc.nextInt();
				System.out.print("pw >> ");
				pw = sc.nextInt();
				if (id == id1 && pw == pw1) {
					System.out.println("1111님 로그인 성공");
					log = id1;
				} else if (id == id2 && pw == pw2) {
					System.out.println("2222님 로그인 성공");
					log = id2;
				} else {
					System.out.println("로그인 실패");
				}
			}
			System.out.println("================");
		}
		sc.close();

		
		
	}

}
