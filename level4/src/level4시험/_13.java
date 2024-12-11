package level4시험;

import java.util.Arrays;

public class _13 {

	public static void main(String[] args) {
		/*
		 	아래 배열에서 혼자 있는 숫자를 제거한 후 나머지만 출력
		 */
		int[] arr1 = { 1, 2, 3, 2, 1 };
		int[] arr2 = { 1, 3, 4, 4, 2 };
		int[] arr3 = { 1, 1, 1, 1, 1 };
		int[][] arr = { arr1, arr2, arr3 };
		for (int i = 0; i < arr.length; i++) {
			for (int k = 0; k < arr[i].length; k++) {
				boolean isAlone = true;
				for (int j = 0; j < arr[i].length; j++) {
					if (k != j && arr[i][k] == arr[i][j]) {
						isAlone = false;
						break;
					}
				}
				if (isAlone) {
					int[] temp = arr[i];
					arr[i] = new int[temp.length - 1];
					int idx = 0;
					for (int j = 0; j < temp.length; j++) {
						if (temp[j] != temp[k]) {
							arr[i][idx++] = temp[j];
						}
					}
					temp = null;
					k--;
				}
			}
			System.out.println(Arrays.toString(arr[i]));
		}
		// 소요 시간 : 18분 17초
	}

}
