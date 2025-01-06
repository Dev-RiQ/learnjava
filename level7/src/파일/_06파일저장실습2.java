package 파일;

import java.io.FileWriter;

public class _06파일저장실습2 {

	public static void main(String[] args) {

		String[] names = { "mom", "megait", "github" };
		String[] pws = { "1111", "2222", "3333" };
		int[] moneys = { 20000, 30000, 40000 };

		final String CUR_PATH = System.getProperty("user.dir") + "\\src\\파일\\";

		String fileName = "file06.txt";
		String data = "";

		for (int i = 0; i < names.length; i++)
			data += String.format("%s/%s/%d\n", names[i], pws[i], moneys[i]);
		data = data.substring(0, data.length() - 1);

		String filePath = CUR_PATH + fileName;

		try (FileWriter fw = new FileWriter(filePath)) {
			fw.write(data);
			System.out.println(filePath + " 저장 성공");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("저장 실패");
		}
	}

}
