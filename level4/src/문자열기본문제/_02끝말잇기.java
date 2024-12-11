package 문자열기본문제;

import java.util.Arrays;
import java.util.Scanner;

public class _02끝말잇기 {

	public static void main(String[] args) {

		/*
		 	3글자 단어
		 	끝 단어 입력하면 게임종료
		 	끝말잇기 실패했을때 게임종료
		 	같은 단어 중복 입력 불가능
		 */
		Scanner sc = new Scanner(System.in);
		String str = "자전거";
		int cnt = 0;
		while (true) {
			String[] strs2 = str.split("/");
			System.out.println(Arrays.toString(strs2));
			System.out.println("제시어 : " + str.substring(4 * cnt, 4 * cnt + 3));
			System.out.print("입력 : ");
			String input = sc.next();
			if (input.length() == 1 && input.charAt(0) == str.charAt(str.length() - 1)) {
				break;
			}
			if (input.length() != 3) {
				System.out.println("세 글자 입력");
				continue;
			}
			if (input.charAt(0) != str.charAt(str.length() - 1)) {
				System.out.println("끝말 못 이었음");
				break;
			}
			int cntMatch = 0;
			for (int i = 0; i <= cnt; i++) {
				cntMatch = 0;
				for (int k = 0; k < 3; k++) {
					if (input.charAt(k) == str.substring(4 * i, 4 * i + 3).charAt(k)) {
						cntMatch++;
					}
				}
				if (cntMatch == 3) {
					break;
				}
			}
			if (cntMatch == 3) {
				System.out.println("이미 사용한 단어");
				continue;
			}
			str += "/" + input;
			cnt++;
			System.out.println();
		}
		System.out.println("게임 종료");
		str = "자전거";
		cnt = 1;
		String[] strs = { str };
		while (true) {
			System.out.println("제시어 : " + str);
			System.out.print("입력 : ");
			String input = sc.next();
			if (input.length() == 1 && input.charAt(0) == str.charAt(2)) {
				break;
			}
			if (input.length() != 3) {
				System.out.println("세 글자 입력");
				continue;
			}
			if (input.charAt(0) != str.charAt(2)) {
				System.out.println("끝말 못 이었음");
				break;
			}
			int cntMatch = 0;
			for (int i = 0; i < strs.length; i++) {
				cntMatch = 0;
				for (int k = 0; k < str.length(); k++) {
					if (strs[i].charAt(k) == input.charAt(k)) {
						cntMatch++;
					}
				}
				if (cntMatch == 3) {
					break;
				}
			}
			if (cntMatch == 3) {
				System.out.println("이미 사용한 단어입니다");
				continue;
			}
			String[] temp = strs;
			strs = new String[++cnt];
			for (int i = 0; i < strs.length - 1; i++) {
				strs[i] = temp[i];
			}
			strs[strs.length - 1] = input;
			str = input;
			System.out.println();
		}
		System.out.println("게임 종료");
		sc.close();
	}

}
