package 배열심화문제;

import java.util.Scanner;

public class _03컨트롤러ATM {

	public static void main(String[] args) {

		/*
		 	1. 회원가입
		 		1) id와 pw를 입력받아 가입
		 		2) 가입 시 돈 1,000원이 부여
		 		3) id 중복검사 진행
		 	2. 회원탈퇴
		 		1) 로그인 후에만 이용 가능
		 	3. 로그인
		 		1) 로그아웃 상태에서만 이용
		 		2) id와 pw를 입력받아 로그인
		 	4. 로그아웃
		 	5. 입금 
		 	6. 이체
		 	7. 잔액조회
		 	4~7은 로그인 후 이용 가능
		 */
		Scanner sc = new Scanner(System.in);
		int[] idList = { 1111, 2222, 3333, 0, 0 };
		int[] pwList = { 1111, 2222, 3333, 0, 0 };
		int[] moneyList = { 10000, 20000, 3000, 0, 0 };
		int max = idList.length;
		int log = -1;
		while (true) {
			System.out.println();
			int count = 0;
			int money = 0;
			int acc = 0;
			for (int i = 0; i < idList.length; i++) {
				if (idList[i] != 0) {
					count++;
				}
			}
			boolean checkId = false;
			boolean checkPw = false;
			int id = 0;
			int pw = 0;
			if (log == -1) {
				System.out.println("[로그인 해주세요.]");
				System.out.print("[1]회원가입 [2]로그인 [3]전체회원목록");
			} else {
				System.out.println("[" + idList[log] + "]님이 접속....");
				System.out.print("[4]입금 [5]송금 [6]비밀번호 수정\n[7]회원 탈퇴 [8]로그아웃");
			}
			System.out.println(" [0]종료");
			System.out.print("메뉴 입력 >> ");
			int sel = sc.nextInt();
			if (sel == 0) {
				System.out.println("종료되었습니다.");
				break;
			}
			if (sel < 0 || sel > 8) {
				System.out.println("존재하지 않는 메뉴입니다.");
				continue;
			}
			if (log == -1 && sel > 3) {
				System.out.println("로그인 후 이용가능한 메뉴입니다.");
				continue;
			}
			if (log != -1 && sel < 4) {
				System.out.println("로그인 상태에서 이용 불가능한 메뉴입니다.");
				continue;
			}
			if (sel == 1) {
				if (count == max) {
					System.out.println("정원초과로 인해 더 이상 가입이 불가능합니다.");
					continue;
				}
				System.out.println("====== 회원가입 ======");
				while (true) {
					System.out.print("ID : ");
					id = sc.nextInt();
					if (id < 1000 || id > 9999) {
						System.out.println("4자리 숫자를 입력하세요.");
						continue;
					}
					for (int i = 0; i < idList.length; i++) {
						if (id == idList[i]) {
							checkId = true;
							break;
						}
					}
					if (checkId) {
						System.out.println("이미 사용중인 ID입니다.");
						checkId = false;
						continue;
					}
					break;
				}
				while (true) {
					System.out.print("PW : ");
					pw = sc.nextInt();
					if (id < 1000 || id > 9999) {
						System.out.println("4자리 숫자를 입력하세요.");
						continue;
					}
					break;
				}

				idList[count] = id;
				pwList[count] = pw;
				moneyList[count] = 1000;
				System.out.println(id + "님 환영합니다.");
			} else if (sel == 2) {
				System.out.println("====== 로그인 ======");
				while (true) {
					while (true) {
						System.out.print("ID : ");
						id = sc.nextInt();
						if (id < 1000 || id > 9999) {
							System.out.println("4자리 숫자를 입력하세요.");
							continue;
						}
						for (int i = 0; i < idList.length; i++) {
							if (id == idList[i]) {
								checkId = true;
								log = i;
								break;
							}
						}
						break;
					}
					while (true) {
						System.out.print("PW : ");
						pw = sc.nextInt();
						if (pw < 1000 || pw > 9999) {
							System.out.println("4자리 숫자를 입력하세요.");
							continue;
						}
						if (log != -1 && pw == pwList[log]) {
							checkPw = true;
						}
						break;
					}
					if (!checkId || !checkPw) {
						System.out.println("로그인 정보를 확인하세요");
						log = -1;
						checkId = false;
						checkPw = false;
						continue;
					}
					break;
				}
				System.out.println("로그인에 성공했습니다.");
			} else if (sel == 3) {
				System.out.println("====== 전체회원목록 ======");
				for (int i = 0; i < idList.length; i++) {
					if (idList[i] == 0) {
						break;
					}
					System.out.println("회원 " + (i + 1) + " : " + idList[i]);
				}

			} else if (sel == 4) {
				System.out.println("====== 입금 ======");
				while (true) {
					System.out.print("입금할 금액 >> ");
					money = sc.nextInt();
					if (money < 1) {
						System.out.println("1원 이상 입력해주세요.");
						continue;
					}
					break;
				}
				moneyList[log] += money;
				System.out.println("입금이 완료되었습니다.");
				System.out.println("현재 계좌 잔액 : " + moneyList[log]);
			} else if (sel == 5) {
				System.out.println("====== 송금 ======");
				while (true) {
					System.out.print("송금할 계좌 >> ");
					acc = sc.nextInt();
					if (acc < 1000 || acc > 9999) {
						System.out.println("4자리 숫자를 입력하세요.");
						continue;
					}
					if (acc == idList[log]) {
						System.out.println("본인 계좌로는 송금이 불가능합니다.");
						continue;
					}
					for (int i = 0; i < idList.length; i++) {
						if (acc == idList[i]) {
							checkId = true;
						}
					}
					if (!checkId) {
						System.out.println("존재하지 않는 계좌입니다.");
						continue;
					}
					break;
				}
				while (true) {
					System.out.print("송금할 금액 >> ");
					money = sc.nextInt();
					if (money < 1) {
						System.out.println("1원 이상 입력해주세요.");
						continue;
					}
					if (money > moneyList[log]) {
						System.out.println("잔액이 부족합니다.");
						System.out.println("현재 계좌 잔액 : " + moneyList[log]);
						continue;
					}
					break;
				}
				moneyList[log] -= money;
				System.out.println("송금이 완료되었습니다.");
				System.out.println("현재 계좌 잔액 : " + moneyList[log]);
			} else if (sel == 6) {
				System.out.println("====== 비밀번호 수정 ======");
				while (true) {
					System.out.print("현재 로그인 ID : ");
					id = sc.nextInt();

					if (id != idList[log]) {
						System.out.println("ID가 일치하지 않습니다.");
						continue;
					}
					break;
				}
				while (true) {
					System.out.print("현재 로그인 PW : ");
					pw = sc.nextInt();
					if (pw != pwList[log]) {
						System.out.println("PW가 일치하지 않습니다.");
						continue;
					}
					break;
				}
				while (true) {
					System.out.print("변경할 PW : ");
					pw = sc.nextInt();
					if (pw < 1000 || pw > 9999) {
						System.out.println("4자리 숫자를 입력하세요.");
						continue;
					}
					if (pw == pwList[log]) {
						System.out.println("현재 사용중인 PW입니다.");
						continue;
					}
					break;
				}
				pwList[log] = pw;
				System.out.println("비밀번호 변경을 완료했습니다.");
			} else if (sel == 7) {
				System.out.println("====== 회원탈퇴 ======");
				while (true) {
					System.out.print("현재 로그인 PW : ");
					pw = sc.nextInt();
					if (pw != pwList[log]) {
						System.out.println("PW가 일치하지 않습니다.");
						continue;
					}
					break;
				}
				for (int i = log; i < count - 1; i++) {
					idList[i] = idList[i + 1];
					pwList[i] = pwList[i + 1];
					moneyList[i] = moneyList[i + 1];
				}
				idList[count - 1] = 0;
				pwList[count - 1] = 0;
				moneyList[count - 1] = 0;
				count--;
				System.out.println(idList[log] + "님 탈퇴가 정상 처리되었습니다.");
				log = -1;
			} else {
				System.out.println("====== 로그아웃 ======");
				log = -1;
				System.out.println("로그아웃이 완료되었습니다.");
			}
		}
		sc.close();
	}

}
