package 파일;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class _03파일저장3 {

	public static void main(String[] args) {

		String paths = System.getProperty("user.dir"); // 현재 프로젝트 경로
		System.out.println(paths);
		//또는
		Path path = Paths.get("");
		// 절대경로 (프로젝트 위치) : C:\~~\level7
		System.out.println(path.toAbsolutePath());
		// 상대경로 (프로젝트 안의 파일 위치) : \src\파일
		String packagePath = path.toAbsolutePath() + "\\src\\파일\\";
		System.out.println(packagePath);
		
		String fileName = "file03.txt";
		String filePath = packagePath + fileName;
		// 원하는 경로에 fileName저장
		System.out.println(filePath);
		File file = new File(filePath);
		System.out.println(file.exists()? "파일 존재":"파일 없음"); // 있는지 없는지? -> boolean
		
		try {
			boolean isFileCreated = file.createNewFile(); // 없으면 새로 파일 생성
			System.out.println(file.getPath()); // 파일 경로 확인
			System.out.println(isFileCreated? "파일 생성":"이미 존재");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
