package 배열1개념;

import java.util.Arrays;
import java.util.Random;

public class _06중복숫자금지2_암기 {

	public static void main(String[] args) {

		/*
			0~4 사이 숫자 arr에 저장
			중복은 없이
			
		 */
		
		Random rd = new Random();
		boolean[] check = new boolean[5];
		int[] arr = new int[5];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = rd.nextInt(5);
			if (check[arr[i]]) {
				System.out.println("중복"+arr[i]);
				i--;
			}else {
				System.out.println("저장"+arr[i]);
				check[arr[i]] = true;
			}
			System.out.println(Arrays.toString(arr));
			System.out.println(Arrays.toString(check));
		}
	}

}
