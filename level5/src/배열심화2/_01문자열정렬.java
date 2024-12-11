package 배열심화2;

import java.util.Arrays;

public class _01문자열정렬 {

	public static void main(String[] args) {

		String[] names = { "홍길동", "김유신", "마동석", "자바킹", "서동요" };
		for (int i = 0; i < names.length; i++) {
			for (int k = i+1; k < names.length; k++) {
				if (names[i].compareTo(names[k]) > 0) {
					String temp = names[i];
					names[i] = names[k];
					names[k] = temp;
				}
			}
		}
		System.out.println(Arrays.toString(names));
	}

}
