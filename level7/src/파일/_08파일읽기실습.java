package 파일;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;

public class _08파일읽기실습 {

	public static void main(String[] args) {

		String[] ids = null;
		String[] pws = null;
		int[] moneys = null;

		final String CUR_PATH = System.getProperty("user.dir") + "\\src\\파일\\";
		String fileName = "file06.txt";

		String filePath = CUR_PATH + fileName;

		try (FileReader fr = new FileReader(filePath); 
				BufferedReader br = new BufferedReader(fr)) {
			String temp = "";
			while (true) {
				String getLine = br.readLine();
				if (getLine == null)
					break;
				temp += getLine + ",";
			}

			String[] datas = temp.split(",");
			int size = datas.length;
			ids = new String[size];
			pws = new String[size];
			moneys = new int[size];

			for (int i = 0; i < size; i++) {
				String[] data = datas[i].split("/");
				ids[i] = data[0];
				pws[i] = data[1];
				moneys[i] = Integer.parseInt(data[2]);
			}
			System.out.println(filePath + " 불러오기 성공");
			System.out.println(Arrays.toString(ids));
			System.out.println(Arrays.toString(pws));
			System.out.println(Arrays.toString(moneys));
		} catch (Exception e) {
			System.out.println(filePath + " 불러오기 실패");
			e.printStackTrace();
		}
	}

}
