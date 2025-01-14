package utills;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Utils {

	private Utils() {
	}

	private static Utils instance;

	public static Utils getInstance() {
		if (instance == null)
			instance = new Utils();
		return instance;
	}

	private Scanner sc = new Scanner(System.in);
	private final String CUR_PATH = System.getProperty("user.dir") + "\\src\\" + Utils.class.getPackageName() + "\\";

	public int getValue(String msg, int start, int end) {
		int value = 0;
		while (true) {
			try {
				value = getInteger(msg, start, end);
				break;
			} catch (InputMismatchException e) {
				System.err.println("int 타입이 아닌 값이 입력되었습니다.");
			} catch (Exception e) {
				System.err.printf("%d~%d 사이의 정수 값을 입력해주세요. \n", start, end);
			} finally {
				sc.nextLine();
			}
		}
		return value;
	}

	private int getInteger(String msg, int start, int end) throws Exception {
		System.out.println(msg);
		int value = sc.nextInt();
		if (value < start || value > end)
			throw new Exception();
		return value;
	}

	public String getValue(String msg) {
		String value = null;
		while (true) {
			try {
				value = getString(msg);
				break;
			} catch (NullPointerException e) {
				System.err.println("빈칸은 입력 불가능합니다.");
			} catch (ArrayIndexOutOfBoundsException e) {
				System.err.println("띄어쓰기는 입력 불가능합니다.");
			} catch (Exception e) {
				System.err.println("잘못된 입력입니다.");
			}
		}
		return value;
	}

	private String getString(String msg) throws Exception {
		System.out.println(msg);
		String value = sc.nextLine();
		if (value.contains(" "))
			throw new ArrayIndexOutOfBoundsException();
		else if (value.isBlank())
			throw new NullPointerException();
		return value;
	}

	public void savaDataToFile(String fileName, String allListToData) {
		if (allListToData == null) {
			System.out.println("[ 데이터가 존재하지 안습니다. ]");
			return;
		}
		try (FileWriter fw = new FileWriter(CUR_PATH + fileName)) {
			fw.write(allListToData);
			System.out.println(CUR_PATH + fileName + "저장 성공");
		} catch (Exception e) {
			System.err.println(CUR_PATH + fileName + "저장 실패");
		}
	}

	public String loadDataToFile(String fileName) {
		if (!new File(CUR_PATH + fileName).exists()) {
			System.err.println("저장된 파일이 없습니다.");
			return null;
		}
		String data = "";
		try (FileReader fr = new FileReader(CUR_PATH + fileName); BufferedReader br = new BufferedReader(fr)) {
			while (true) {
				String temp = br.readLine();
				if (temp == null)
					break;
				data += temp + "\n";
			}
			System.out.println(CUR_PATH + fileName + "불러오기 성공");
		} catch (Exception e) {
			System.err.println(CUR_PATH + fileName + "불러오기 실패");
		}
		return data;
	}

}
