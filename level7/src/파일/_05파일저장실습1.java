package 파일;

import java.io.FileWriter;

public class _05파일저장실습1 {

	public static void main(String[] args) {

		String[] names = { "김철수", "이만수", "이영희" };
		int[] ages = { 20, 30, 40 };

		String path = System.getProperty("user.dir");
		final String CUR_PATH = path + "\\src\\파일\\";
		String fileName = "file05.txt";
		String filePath = CUR_PATH + fileName;

		String data = "";
		for (int i = 0; i < names.length; i++) {
			if (i != 0)
				data += ",";
			data+=names[i] + "/" + ages[i];
		}
//		System.out.println(data);
		try (FileWriter fw = new FileWriter(filePath)) { // 자동 new File(filePath)해줌
			fw.write(data);
			System.out.println(filePath + "저장 성공");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("저장 실패");
		}
	}

}
