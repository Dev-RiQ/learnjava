package 배열1개념;

import java.util.Arrays;
import java.util.Random;

public class _05중복숫자금지1_암기 {

	public static void main(String[] args) {

		/*
		 	[방법 1] 셔플
		 	1. 먼저 내가 원하는 값을 미리 순서대로 넣는다 (1~4)
		 	2. 랜덤 인덱스 값을 고른다
		 	3. 100번 반복하면서 랜덤 인덱스 값이랑 0번이랑 값 교체
		 */
		Random rd = new Random();
		int[] arr = new int[4];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = i + 1;
		}
		System.out.println("arr = "+Arrays.toString(arr));
		for (int i = 0; i < 100; i++) {
			int idx = rd.nextInt(4);
			int temp = arr[0];
			arr[0] = arr[idx];
			arr[idx] = temp;
		}
		System.out.println("arr rd = "+Arrays.toString(arr));
		
		
		
		
	}

}
