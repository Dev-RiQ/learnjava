package 문자열개념;

import java.util.Scanner;

public class _09단어검색 {

	public static final String BACKGROUND_CYAN = "\u001B[46m"; 
	public static final String RESET = "\u001B[0m";  
	
	public static void main(String[] args) {

		/*
		 	단어 입력받아 TEXT 배열에 해당 단어가 존재하면 출력
		 	(부분 검색도 가능)
		 */
		Scanner sc = new Scanner(System.in);
		String text = "Life is too short."; // 
		System.out.print("검색할 단어를 입력하세요 : ");
		String word = sc.nextLine();
		boolean isEqual = false;
		if (word.length() <= text.length()) {
			for (int i = 0; i < text.length() - word.length() + 1; i++) {
				if (text.charAt(i) == word.charAt(0) && text.substring(i, i + word.length()).equals(word)) {
					isEqual = true;
					System.out.println(text.substring(0,i)+BACKGROUND_CYAN+text.substring(i,i+word.length())+RESET+text.substring(i+word.length(),text.length()));
				}
			}
		}
		System.out.println(isEqual);
		sc.close();
	}

}
