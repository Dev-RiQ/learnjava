package 회원관리;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Utils {

	private static Scanner sc = new Scanner(System.in);
	private static final String CUR_PATH = System.getProperty("user.dir") + "\\src\\" + Utils.class.getPackageName()
			+ "\\";
	private static final String FILE_PATH = CUR_PATH + "member.txt";

	public static void saveFile() {

	}

	public static int getValue(String msg, int start, int end) {
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

	private static int getInteger(String msg, int start, int end) throws Exception {
		System.out.println(msg);
		int value = sc.nextInt();
		if (value < start || value > end)
			throw new Exception();
		return value;
	}

	public static String getValue(String msg) {
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

	private static String getString(String msg) throws Exception {
		System.out.println(msg);
		String value = sc.nextLine();
		if (value.contains(" "))
			throw new ArrayIndexOutOfBoundsException();
		else if (value.isBlank())
			throw new NullPointerException();
		return value;
	}

	public static String loadDataFromFile() {
		String data = "";
		try (FileReader fr = new FileReader(FILE_PATH); BufferedReader br = new BufferedReader(fr)){
			while(true) {
				String temp = br.readLine();
				if(temp == null)
					break;
				data += temp +"\n";
			}
			System.out.println(FILE_PATH + "불러오기 성공");
		} catch (Exception e) {
			System.err.println(FILE_PATH + "불러오기 실패");
		}
		return data;
	}

	public static void saveDataToFile(String memberList) {
		if (memberList.isBlank()) {
			System.out.println("저장할 데이터가 없습니다.");
			return;
		}
		try (FileWriter fw = new FileWriter(FILE_PATH)) {
			fw.write(memberList);
			System.out.println(FILE_PATH + "저장 성공");
		} catch (Exception e) {
			System.err.println(FILE_PATH + "저장 실패");
		}
	}
}
