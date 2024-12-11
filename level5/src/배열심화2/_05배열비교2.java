package 배열심화2;

import java.util.Arrays;

public class _05배열비교2 {

	public static void main(String[] args) {

		/*
		 	arr배열과 result배열을 비교해서 겹치는 값이 있으면 두 배열의 값을 0으로 변경
		 	겹치면 전부다
		 */
		int[][] array = {
				{ 1, 3, 4 },
				{ 5, 6, 3 },
				{ 6, 8, 9 }
		};
		int[] result = { 1, 5, 6, 3, 7 };
		int temp = 0;
		boolean isEqual = false;
		for (int i = 0; i < array.length; i++) {
			for (int k = 0; k < array.length; k++) {
				if (!isEqual) {
					for (int j = 0; j < result.length; j++) {
						if (array[i][k] != 0 && array[i][k] == result[j]) {
							temp = result[j];
							result[j] = 0;
							isEqual = true;
						}
					}
				}
				if (isEqual) {
					if (array[i][k] == temp) {
						array[i][k] = 0;
					}
				}
			}
			if (isEqual && i == 2) {
				isEqual = false;
				i = -1;
			}
		}
		System.out.println(Arrays.deepToString(array));
		System.out.println(Arrays.toString(result));

	}
}
