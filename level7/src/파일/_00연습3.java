package 파일;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

class StudentInfo {

	String stuNo;
	String stuName;
	String stuBirth;
	String stuSex;
	String stuScore;
	String stuRank;

	String getStuNo() {
		return stuNo;
	}

	String getStuName() {
		return stuName;
	}

	String getStuBirth() {
		return stuBirth;
	}

	String getStuSex() {
		return stuSex;
	}

	String getStuScore() {
		return stuScore;
	}

	String getStuRank() {
		return stuRank;
	}

	StudentInfo(String stuNo, String stuName, String stuBirth, String stuSex, String stuScore, String stuRank) {
		this.stuNo = stuNo;
		this.stuName = stuName;
		this.stuBirth = stuBirth;
		this.stuSex = stuSex;
		this.stuScore = stuScore;
		if (stuRank.equals("수석"))
			this.stuRank = "1";
		else if (stuRank.equals("차석"))
			this.stuRank = "2";
		else
			this.stuRank = stuRank;
	}

	@Override
	public String toString() {

		String stuName = this.stuName;
		if (stuName.length() == 2)
			stuName = stuName.substring(0, 1) + "  " + stuName.substring(1);
		return String.format("[ %s  |  %s  |   %s   |    %s    |  %8s  |  %4s ]\n", stuNo, stuName, stuBirth, stuSex,
				stuScore, stuRank);
	}
}

class StudentInfoDAO {

	StudentInfo[] sList;

	StudentInfo[] getsList() {
		return sList;
	}

	void setStuData(String data) {
		String[] datas = data.split("\n");
		String[] temp = new String[datas.length];
		int size = 0;
		for (int i = 0; i < datas.length; i++) {
			datas[i] = datas[i].replace(" ", "");
			if (datas[i].length() != 0) {
				datas[i] = datas[i].substring(1, datas[i].length() - 1);
				if (datas[i].substring(0, 2).equals("25")) {
					temp[size] = datas[i];
					size++;
				}
			}
		}
		System.out.println("총 학생 수 : " + size);
		setsList(temp, size);
	}

	void setsList(String[] data, int size) {
		sList = new StudentInfo[size];
		for (int i = 0; i < size; i++) {
			String[] temp = data[i].split("\\|");
			sList[i] = new StudentInfo(temp[0], temp[1], temp[2], temp[3], temp[4], temp[5]);
		}

	}
}

class StudentInfoSearch {

	StudentInfoDAO dao;
	String data;
	Scanner sc;

	StudentInfoSearch() {
		dao = new StudentInfoDAO();
	}

	void loadData() {
		String filePath = System.getProperty("user.dir") + "\\src\\파일\\studentInfo.txt";
		File file = new File(filePath);
		try (FileReader fr = new FileReader(file)) {
			data = setData(fr);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	String setData(FileReader fr) throws IOException {
		String data = "";
		try {
			while (true)
				data += Character.toString(fr.read());
		} catch (IllegalArgumentException e) {
			System.out.println("불러오기 완료");
			return data;
		}
	}

	String setGet(String info) {
		while (true) {
			System.out.print(info + " 검색 >> ");
			String get = sc.nextLine();
			if (!(get.isBlank() || get.contains(" ")))
				return get;
			System.err.println("빈칸 입력 불가");
		}
	}

	void search(int sel) {
		String[] info = { "학번", "이름", "생년월일", "성별", "총 점수", "등수" };
		String get = setGet(info[sel - 1]);
		boolean isHave = false;
		String data = "";
		for (StudentInfo s : dao.getsList())
			if (setMatchType(s, sel, get)) {
				data += s;
				isHave = true;
			}
		if (isHave)
			printData(data);
		else
			System.err.println("존재하지 않는 " + info[sel - 1]);
	}

	void printData(String data) {
		System.out.println("===================================================================");
		System.out.println(String.format("[ %s  |  %s  |  %s  |  %s  |  %s  |  %s ]", "학  번", "이  름", "생년월일", "성  별",
				"입학성적", "등수"));
		System.out.println("===================================================================");
		System.out.println(data.substring(0, data.length() - 1));
		System.out.println("===================================================================");
	}

	boolean setMatchType(StudentInfo s, int sel, String get) {
		boolean isMatch = false;

		if (sel == 1)
			isMatch = s.getStuNo().contains(get);
		else if (sel == 2)
			isMatch = s.getStuName().contains(get);
		else if (sel == 3)
			isMatch = s.getStuBirth().contains(get);
		else if (sel == 4)
			isMatch = s.getStuSex().equals(get);
		else if (sel == 5)
			isMatch = s.getStuScore().equals(get);
		else if (sel == 6)
			isMatch = s.getStuRank().equals(get);

		return isMatch;
	}

	void showMenu() {
		System.out.println("====================");
		System.out.println("[  학생 정보 검색  ]");
		System.out.println("====================");
		System.out.println("[1] 학번 검색");
		System.out.println("[2] 이름 검색");
		System.out.println("[3] 생년월일 검색");
		System.out.println("[4] 성별 검색");
		System.out.println("[5] 총 점수 검색");
		System.out.println("[6] 등수 검색");
		System.out.println("[7] 종료");
		System.out.println("====================");
	}

	int setSel() {
		int sel = 0;
		while (true) {
			try {
				System.out.print("메뉴 선택 >> ");
				sel = sc.nextInt();
				if (sel < 1 || sel > 7)
					throw new Exception();
			} catch (Exception e) {
				System.err.println("숫자 1~7만 입력 가능합니다.");
				sc.nextLine();
				continue;
			}
			sc.nextLine();
			System.out.println("====================");
			return sel;
		}
	}

	void run() {
		loadData();
		dao.setStuData(data);
		sc = new Scanner(System.in);
		while (true) {
			showMenu();
			int sel = setSel();
			if (sel == 7) {
				System.out.println("프로그램 종료");
				break;
			} else
				search(sel);
		}
		sc.close();
	}
}

public class _00연습3 {

	public static void main(String[] args) {

		// 학생 정보 시스템 검색창
		// 연습2 에서 만든 studentInfo.txt를 불러와 해당 데이터를 기반으로 검색
		// 학번, 이름, 생년월일은 입력 데이터를 포함한 값 모두 출력
		// 성별, 점수, 등수는 입력 데이터와 일치하는 값 모두 출력

		// scanner로 받아오는 입력 값들을 try catch를 이용하여 오류 처리
		// nextInt => "숫자 1~7만 입력 가능합니다"
		// nextLine => "존재하지 않는 학번" (이름 검색하면 "존재하지 않는 이름") 과 같이 출력
		// 1~6번 메뉴 선택 후 검색은 모두 한 메서드에서 진행 (1 선택 시 학번 검색, 3 선택 시 생년월일 검색 자동 전환)

		StudentInfoSearch s = new StudentInfoSearch();
		s.run();
	}

}
