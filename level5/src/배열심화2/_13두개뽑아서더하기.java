package 배열심화2;

import java.util.Arrays;

public class _13두개뽑아서더하기 {

	public static void main(String[] args) {

		/*
		 	arr배열에서 숫자 2개씩 뽑아서 더한 값을
		 	result배열에 저장 후 출력하시오
		 	단, 자기 차례의 인덱스 값은 더하지 않는다
		 	다하고 result배열 중복 값 삭제
		 	++
		 	배열 반응형, 오름차순
		 */
		int[] arr = { 2, 1, 3, 4, 1 , 11, 55, 23,47 };
		int size = 0;
		for(int i = 0;i<arr.length;i++) {
			size+=arr[i]*2;
		}
		int[] result = new int[size];
		boolean[] check = new boolean[size];
		int idx = 0;
		int cnt = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int k = 0; k < arr.length; k++) {
				int sum = arr[i] + arr[k];
				if (!check[sum] && k != i) {
					check[sum] = true;
					result[idx++] = sum;
					cnt++;
				}
			}
		}
		System.out.println(Arrays.toString(result));
		int[] temp = result;
		result = new int[cnt];
		for (int i = 0; i < result.length; i++) {
			int min = size;
			for (int k = 0; k < temp.length; k++) {
				if (temp[k] != 0 && min > temp[k]) {
					if (i == 0) {
						min = temp[k];
					} else if (i != 0 && temp[k] > result[i - 1]) {
						min = temp[k];
					}
				}
			}
			result[i] = min;
		}
		System.out.println(Arrays.toString(result));
	}

}
