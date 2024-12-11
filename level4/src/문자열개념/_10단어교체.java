package 문자열개념;

import java.util.Scanner;

public class _10단어교체 {

	public static void main(String[] args) {

		/*
		 	단어를 입력받아 원하는 단어로 교체
		 */
		Scanner sc = new Scanner(System.in);
		String text = "Life is too short.";
		while (true) {
			System.out.println(text);
			System.out.print("단어 선택 (종료 : exit) : ");
			String sel = sc.nextLine();
			if (sel.equals("exit")) {
				System.out.println("종료");
				break;
			}
			if (sel.isBlank()) {
				System.out.println("빈칸 입력 불가");
				continue;
			}
			boolean isEqual = false;
			int idx = 0;
			for (int i = 0; i < text.length() - sel.length() + 1; i++) {
				if (text.charAt(i) == sel.charAt(0) && text.substring(i, i + sel.length()).equals(sel)) {
					isEqual = true;
					idx = i;
					break;
				}
			}
			if (!isEqual) {
				System.out.println("해당 단어가 없습니다.");
				continue;
			}
			System.out.print("단어 변경 :");
			String change = sc.nextLine();
			if (change.isBlank()) {
				System.out.println("빈칸 입력 불가");
				continue;
			}
			text = text.substring(0, idx)+change+text.substring(idx + sel.length(), text.length());
		}
		sc.close();
		
		
	}

}
