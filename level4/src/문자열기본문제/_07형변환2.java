package 문자열기본문제;

import java.util.Arrays;

public class _07형변환2 {

	public static void main(String[] args) {

		//이름은 name, 성적은 score배열에 각각 저장 및 출력
		
		String str = "김철수/87,이만수/42,이영희/95";

		String[] name = new String[3];
		int[] score = new int[3];

		String[] temp = str.split(",");
		for (int i = 0; i < temp.length; i++) {
			name[i] = temp[i].substring(0, 3);
			score[i] = Integer.parseInt(temp[i].substring(4));
		}
		System.out.println(Arrays.toString(name));
		System.out.println(Arrays.toString(score));
		
	}

}
