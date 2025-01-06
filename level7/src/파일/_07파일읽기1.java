package 파일;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class _07파일읽기1 {

	public static void main(String[] args) {

		String filePath = System.getProperty("user.dir") + "\\src\\파일\\";
		String fileName = "file06.txt";
		
		String data = "";
		
		try (FileReader fr = new FileReader(filePath + fileName); // fr.read()는 char[]라 불편
				BufferedReader br = new BufferedReader(fr);){ // char[]를 String으로 가져와줌
			data += br.readLine()+"\n"; // \n 기준으로 한줄씩 읽어옴 (\n 사라짐)
//			while(true) {
//				int read = fr.read();
//				if(read == -1)
//					break;
//				System.out.println((char)read);
//			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		System.out.println(data);
	}

}
