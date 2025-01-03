package 파일;

import java.io.FileWriter;
import java.io.IOException;

// 세이브 파일 만들기
// 1) 변수 생성 => FileWriter fw = null;
// 2) 파일 생성 => fw = new FileWriter("파일이름");
// 3) 파일에 내용 저장 => fw.write("저장 내용");
// 4) 파일 쓰기 객체 닫기 => fw.close();

public class _01파일저장1 {

	public static void main(String[] args) {

		String fileName = "file01.txt";

		FileWriter fw = null;
		try {
			fw = new FileWriter(fileName); // 같으면 계속 덮어쓰기
			fw.write("안녕하세요\n");
			fw.write("반갑습니다");
			System.out.println("파일 " + fileName+" 생성 완료");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fw != null) {
				try {
					fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
