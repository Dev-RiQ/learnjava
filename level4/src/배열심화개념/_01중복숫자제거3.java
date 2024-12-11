package 배열심화개념;

import java.util.Arrays;
import java.util.Random;

public class _01중복숫자제거3 {

	public static void main(String[] args) {

		/*
		 	1. arr배열에 1~10사이의 랜덤 숫자를 5개 저장한다
		 	2. 단, 중복되는 숫자 없어야한다.
		 	3. 이차원 반복문 사용하기
		 */
		Random rd = new Random();
		int[] arr = new int[5];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = rd.nextInt(10) + 1;
			for (int k = 0; k < i; k++) {
				if (arr[i] == arr[k]) {
					i--;
					break;
				}
			}
		}
		System.out.println(Arrays.toString(arr));
	}

}
