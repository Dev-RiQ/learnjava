package 메서드문제;

import java.util.Scanner;

class Bank {

	Scanner sc = new Scanner(System.in);

	String name = "";

	String[] arAcc = { "1111", "2222", "3333", "", "" };
	String[] arPw = { "1234", "2345", "3456", "", "" };
	int[] arMoney = { 87000, 34000, 17500, 0, 0 };
	String[] menu = { "회원가입", "회원탈퇴", "로그인", "로그아웃", "입금하기", "이체하기", "종료" };

	int count = 3;
	int log = -1;

	void init() {
		name = "더조은은행";
	}

	void showMenu() {
		System.out.printf("로그인 상태 [%s] \n", log == -1 ? "로그아웃" : arAcc[log] + "님 로그인 중");
		System.out.printf("=== %s === \n", name);
		for (int i = 0; i < menu.length; i++) {
			System.out.printf("%d. %s \n", i + 1, menu[i]);
		}
	}
	
	int getNumber(String name, int start, int end) {
		while (true) {
			System.out.printf("%s 입력 >> ", name);
			int select = 0;
			try {
				select = sc.nextInt();
			} catch (Exception e) {
				sc = new Scanner(System.in);
				System.out.println("-2,147,483,648 ~ 2,147,483,647 사이의 정수만 입력하세요.");
				continue;
			}
			if (select < start || select > end) {
				System.out.printf("범위 에러 : %d ~ %d 사이 입력 \n", start, end);
				continue;
			}
			return select;
		}
	}

	String getInputString(String name) {
		while (true) {
			System.out.printf("%s 입력 >> ", name);
			String input = sc.next();
			if (input.equals("null")) {
				System.out.println("null 입력 불가");
				continue;
			}
			return input;
		}
	}

	void joinNewMember() {
		while (true) {
			String id = getInputString("ID");
			if (isMatchAcc(id))
				System.out.println("중복된 ID");
			else {
				arAcc[count] = id;
				arPw[count++] = getInputString("PW");
				break;
			}
		}
	}

	void deleteMemberInfo() {
		while (true) {
			if (getInputString("PW").equals(arPw[log])) {
				int index = count - 1;
				for (int i = log; i < count - 1; i++) {
					if (arAcc[i].isBlank()) {
						index = i;
						break;
					}
					arAcc[i] = arAcc[i + 1];
					arPw[i] = arPw[i + 1];
					arMoney[i] = arMoney[i + 1];
				}
				arAcc[index] = "";
				arPw[index] = "";
				arMoney[index] = 0;
				count--;
				log = -1;
				break;
			}
			System.out.println("비밀번호 불일치");
		}
	}

	void logIn() {
		while (true) {
			int index = getMatchAccIndex(getInputString("ID"));
			if (index != -1) {
				if (getInputString("PW").equals(arPw[index])) {
					log = index;
					break;
				} else
					System.out.println("비밀번호가 일치하지 않습니다.");
			} else
				System.out.println("존재하지 않는 ID 입니다.");
		}
	}
	
	void logOut() {
		log = -1;
	}

	void depositMoney() {
		arMoney[log] += getNumber("입금금액", 1, 100000000);
		accountBalance("입금 후");
	}

	void sendMoney() {
		while (true) {
			int index = getMatchAccIndex(getInputString("이체할 ID"));

			if (index == log)
				System.out.println("본인 계좌 이체 불가");
			else if (index != -1) {
				int money = getNumber("이체할 금액", 1, arMoney[log]);
				arMoney[index] += money;
				arMoney[log] -= money;
				accountBalance("이체 후");
				break;
			} else
				System.out.println("존재하지 않는 계좌번호");
		}
	}

	void accountBalance(String name) {
		System.out.println(name + " 계좌 잔액 : " + arMoney[log]);
	}

	int getMatchAccIndex(String acc) {
		int index = -1;
		for (String a : arAcc) {
			index++;
			if (a.equals(acc))
				return index;
		}
		return -1;
	}

	boolean isMatchAcc(String acc) {
		for (String a : arAcc)
			if (a.equals(acc))
				return true;
		return false;
	}

	boolean isMatchPw(String pw) {
		for (String a : arPw)
			if (a.equals(pw))
				return true;
		return false;
	}

	boolean isSelectError(int log, int select) {
		if (log == -1 && (select == 2 || select == 4 || select == 5 || select == 6)) {
			System.out.println("로그인 후 이용 가능");
		} else if (log != -1 && (select == 1 || select == 3)) {
			System.out.println("로그인 상태에서 이용 불가능");
		} else if (select == 1 && count == arAcc.length) {
			System.out.println("더 이상 가입할 수 없습니다.");
		} else if (select == 5 && arMoney[log] == 0) {
			System.out.println("통장 잔고가 0원이라 이체가 불가능합니다.");
		} else {
			return false;
		}
		return true;

	}

	void run() {
		init();
		while (true) {
			showMenu();
			int select = getNumber("메뉴", 1, 7);
			if (isSelectError(log, select))
				continue;

			System.out.printf("=== %s === \n", menu[select - 1]);
			if (select == 1)
				joinNewMember();
			else if (select == 2)
				deleteMemberInfo();
			else if (select == 3)
				logIn();
			else if (select == 4)
				logOut();
			else if (select == 5)
				depositMoney();
			else if (select == 6)
				sendMoney();
			else if (select == 7) {
				System.out.println("프로그램 종료");
				break;
			}
			System.out.printf("=== %s 완료 === \n", menu[select - 1]);
		}
		sc.close();
	}
}

public class _09메서드ATM {

	public static void main(String[] args) {

		Bank bank = new Bank();
		bank.run();
	}

}
