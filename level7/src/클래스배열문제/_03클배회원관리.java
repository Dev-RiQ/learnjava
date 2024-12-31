package 클래스배열문제;

import java.util.Scanner;

class Client {
	String id;
	String name;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	void printInfo() {
		System.out.println(id + "\t" + name);
	}
}

class ClientDAO {
	final int SIZE = 10;
	Client[] cList;
	Scanner sc;
	int cnt;

	void testMax() {
		sc = new Scanner(System.in);
		cList = new Client[SIZE];
		cnt = SIZE;
		for (int i = 0; i < SIZE; i++) {
			cList[i] = new Client();
			String str = "test" + (i + 1);
			cList[i].setId(str);
			cList[i].setName(str);
		}
	}

	void init() {
		cList = new Client[SIZE];
		for (int i = 0; i < SIZE; i++)
			cList[i] = new Client();
		sc = new Scanner(System.in);
	}

	int getInputInteger(String msg, int start, int end) {
		while (true) {
			System.out.print(msg);
			int input = sc.nextInt();
			sc.nextLine();
			if (!(input < start || input > end))
				return input;
			System.out.printf("%d~%d 사이 값을 입력해주세요. \n", start, end);
		}
	}

	String getInputString(String msg) {
		while (true) {
			System.out.print(msg);
			String input = sc.nextLine();
			if (isValid(input))
				return input;
		}
	}

	boolean isValid(String input) {
		if (input.isBlank())
			System.out.println("텍스트를 입력해주세요.");
		else if (input.contains(" "))
			System.out.println("공백은 포함될 수 없습니다.");
		else
			return true;
		return false;
	}

	void printMenu() {
		System.out.println("[1]추가 [2]삭제 [3]출력 [4]종료");
	}

	String checkId(String toDo) {
		boolean isCreate = toDo.equals("create") ? true : false;
		while (true) {
			String id = getInputString("아이디 >> ");
			if (checkDupl(id, isCreate))
				return id;
			if (isCreate)
				System.out.println("이미 존재하는 아이디입니다.");
			else
				System.out.println("존재하지 않는 아이디입니다.");
		}
	}

	boolean checkDupl(String input, boolean isCreate) {
		for (int i = 0; i < cnt; i++)
			if (input.equals(cList[i].getId()))
				return isCreate ? false : true;
		return isCreate ? true : false;
	}

	void createClient() {
		String id = checkId("create");
		String name = getInputString("이름 >> ");
		cList[cnt].setId(id);
		cList[cnt++].setName(name);
		System.out.println("회원가입이 완료되었습니다.");
	}

	void deleteClient() {
		String id = checkId("delete");
		for (int i = indexDeleteId(id); i < SIZE - 1; i++)
			cList[i] = cList[i + 1];
		if (cnt == 10)
			cList[SIZE - 1] = new Client();
		cnt--;
	}

	int indexDeleteId(String id) {
		for (int i = 0; i < cnt; i++)
			if (id.equals(cList[i].getId()))
				return i;
		return SIZE;
	}

	void printClient() {
		System.out.println("전체 회원 목록을 출력합니다.");
		System.out.println("아이디 \t 이름");
		for (Client info : cList)
			if (info.id != null)
				info.printInfo();
	}

	boolean isError(int input) {
		if (cnt == SIZE && input == 1)
			System.out.println("더 이상 가입할 수 없습니다.");
		else if (cnt == 0 && input == 2)
			System.out.println("삭제할 데이터가 없습니다.");
		else if (cnt == 0 && input == 3)
			System.out.println("출력할 데이터가 없습니다.");
		else
			return false;
		return true;
	}

	void run() {
//		testMax();
		init();
		while (true) {
			printMenu();
			int input = getInputInteger("메뉴 선택 >> ", 1, 4);
			if (isError(input))
				continue;
			else if (input == 1)
				createClient();
			else if (input == 2)
				deleteClient();
			else if (input == 3)
				printClient();
			else if (input == 4)
				break;
		}
		System.out.println("프로그램 종료");
	}
}

public class _03클배회원관리 {

	public static void main(String[] args) {

		ClientDAO dao = new ClientDAO();
		dao.run();
	}

}
