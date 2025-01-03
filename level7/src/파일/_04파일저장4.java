package 파일;

import java.io.File;
import java.io.FileWriter;

public class _04파일저장4 {

	public static void main(String[] args) {

		String dir = System.getProperty("user.home");
		System.out.println(dir);
		dir += File.separator + "desktop";
		System.out.println(dir);
		
		String data = "ABC";
		File file = new File(dir,"file04.txt");
		System.out.println(file.getPath());
		
		try (FileWriter fw = new FileWriter(file)){
			fw.write(data);
			
			System.out.println(file.getPath()+" 저장 완료");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("저장 실패");
		}
	}

}
