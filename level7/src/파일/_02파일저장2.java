package 파일;

import java.io.FileWriter;
import java.io.IOException;

public class _02파일저장2 {

	public static void main(String[] args) {

		String fileName = "file02.txt";
		//try - with - resource
		try (FileWriter fw = new FileWriter(fileName)){ // 자동 fw.close();
			for(int i = 1 ; i <= 10 ; i++)
				fw.write("안녕 "+i+"\n");
			System.out.println(fileName+"저장 완료");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
