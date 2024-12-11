package 배열2문제;

import java.util.Arrays;

public class _04일이삼일이삼 {

	public static void main(String[] args) {

		/*
		 	[문제]
		 		아래 배열에 숫자 1,2,3,1,2,3,1,2를
		 		순차적으로 저장하고 출력하시오
		 */
		int[] arr = new int[8];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = i % 3 + 1;
		}
		System.out.println(Arrays.toString(arr));
		
	}

}
