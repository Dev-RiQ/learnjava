package 배열심화2;

import java.util.Arrays;

public class _11같은수삭제 {

	public static void main(String[] args) {
		/*
		 * input 데이터 a에 순차저장 
		 * 단, 저장하려는 숫자가 현재 숫자와 같으면 둘 다 삭제
		 */
		int[] input = { 1, 1, 3, 2, 1, 1, 4, 4 };
		int[] a = new int[input.length];
		int idx = 0;
		for (int i = 0; i < a.length; i++) {
			if (i != a.length - 1 && input[i] == input[i + 1]) {
				i++;
			} else {
				a[idx++] = input[i];
			}
		}
		System.out.println(Arrays.toString(a));
	}

}
