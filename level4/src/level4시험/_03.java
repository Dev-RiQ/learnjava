package level4시험;

import java.util.Scanner;

public class _03 {

	public static void main(String[] args) {
		/*
		 	단어 교체
		 	text 변수 문장 속 지정 단어 교체
		 */
		Scanner sc = new Scanner(System.in);
		String text = "Life is too short.";
		while (true) {
			System.out.println(text);
			System.out.print("변경당할 단어 (exit : 종료) >> ");
			String word = sc.nextLine();
			if (word.equals("exit")) {
				System.out.println("종료");
				break;
			}
			if (word.isBlank()) {
				System.out.println("빈칸만 입력 불가");
				continue;
			}
			boolean isHave = false;
			int idx = -1;
			for (int i = 0; i <= text.length() - word.length(); i++) {
				if (text.substring(i, i + word.length()).equals(word)) {
					isHave = true;
					idx = i;
					break;
				}
			}
			if (!isHave) {
				System.out.println("존재하지 않는 단어");
				continue;
			}
			System.out.print("변경 적용할 단어 >> ");
			String change = sc.nextLine();
			text = text.substring(0, idx) + change + text.substring(idx + word.length());
		}
		sc.close();
		// 소요 시간 : 8분 44초
	}

}
