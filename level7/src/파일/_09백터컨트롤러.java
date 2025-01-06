package 파일;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

class FileEx {
	String fileName = "vector.txt";
	final String CUR_PATH = System.getProperty("user.dir") + "\\src\\파일\\";
	String filePath = CUR_PATH + fileName;
	int[] arr;

	FileEx() {
	}

	void printMenu() {
		System.out.println("\n[벡터 컨트롤러]");
		System.out.println("[1]추가하기");
		System.out.println("[2]삭제하기(인덱스)");
		System.out.println("[3]저장하기");
		System.out.println("[4]로드하기");
		System.out.println("[5]종료하기");
	}

	int getNum(String msg, int min, int max) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.printf("%s [%d~%d] >> ", msg, min, max);
			try {
				int sel = sc.nextInt();
				if (sel < min || sel > max)
					throw new Exception();
				return sel;
			} catch (Exception e) {
				System.err.printf("%d~%d 범위의 숫자를 입력하세요.\n", min, max);
			} finally {
				sc.nextLine();
			}
		}
	}

	void addData() {
		int num = getNum("추가할 값", -1000, 1000);
		if (arr == null)
			arr = new int[1];
		else {
			int[] temp = arr;
			arr = new int[temp.length + 1];
			for (int i = 0; i < temp.length; i++)
				arr[i] = temp[i];
		}
		arr[arr.length - 1] = num;
		System.out.println(num + " 추가 완료");
	}

	void delData() {
		int idx = getNum("삭제할 인덱스", 0, arr.length - 1);
		System.out.println(arr[idx] + " 삭제 완료");
		if (arr.length == 1)
			arr = null;
		else {
			int[] temp = arr;
			arr = new int[temp.length - 1];
			int index = 0;
			for (int i = 0; i < temp.length; i++)
				if (i != idx)
					arr[index++] = temp[i];
		}
	}

	void saveData() {
		try (FileWriter fw = new FileWriter(filePath)) {
			fw.write(getData());
			System.out.println(fileName + " 저장 완료");
		} catch (Exception e) {
			System.err.println(fileName + " 저장 실패");
			e.printStackTrace();
		}
	}

	String getData() {
		String data = "";
		for (int i = 0; i < arr.length; i++)
			data += arr[i] + ",";
		return data.substring(0, data.length() - 1);
	}
	
	void loadData() {
		try (FileReader fr = new FileReader(filePath); BufferedReader br = new BufferedReader(fr)) {
			String[] datas = br.readLine().split(",");
			arr = new int[datas.length];

			for (int i = 0; i < arr.length; i++)
				arr[i] = Integer.parseInt(datas[i]);
			System.out.println(fileName + " 로드 성공");
		} catch (Exception e) {
			System.err.println(fileName + " 로드 실패");
			e.printStackTrace();
		}
	}

	boolean isExsist() {
		File file = new File(filePath);
		if (file.exists())
			return true;
		return false;
	}

	boolean isVaild(int sel) {
		System.out.println();
		if (sel == 2 && arr == null)
			System.err.println("삭제할 값이 없습니다.");
		else if (sel == 3 && arr == null)
			System.err.println("저장할 값이 없습니다.");
		else if (sel == 4 && !isExsist())
			System.err.println("저장된 파일이 없습니다.");
		else
			return true;
		return false;
	}

	void run() {
		while (true) {
			printMenu();
			int sel = getNum("메뉴 선택", 1, 5);
			if (!isVaild(sel))
				continue;
			if (sel == 1)
				addData();
			else if (sel == 2)
				delData();
			else if (sel == 3)
				saveData();
			else if (sel == 4)
				loadData();
			else
				break;
		}
		System.out.println("프로그램 종료");
		Scanner sc = new Scanner(System.in);
		sc.close();
	}
}

public class _09백터컨트롤러 {

	public static void main(String[] args) {
		FileEx e = new FileEx();
		e.run();
	}
}
