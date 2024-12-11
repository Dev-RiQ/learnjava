package level4시험;

import java.util.Arrays;

public class _02 {

	public static void main(String[] args) {

		/*
		 	2차원 반복문
		i0 	 1  2  3  4  5
		i1 	10  9  8  7  6
		i2 	11 12 13 14 15
		i3 	20 19 18 17 16
		i4 	21 22 23 24 25
		 */
		int arr[][] = new int[5][5];
		for (int i = 0; i < arr.length; i++) {
			for (int k = 0; k < arr[i].length; k++) {
				if (i % 2 == 0) {
					arr[i][k] = (i * 5) + (k + 1);
				} else {
					arr[i][k] = ((i + 1) * 5) - k;
				}
			}

		}
		System.out.println(Arrays.toString(arr[0]));
		System.out.println(Arrays.toString(arr[1]));
		System.out.println(Arrays.toString(arr[2]));
		System.out.println(Arrays.toString(arr[3]));
		System.out.println(Arrays.toString(arr[4]));
		// 소요 시간 : 3분 13초
	}

}
