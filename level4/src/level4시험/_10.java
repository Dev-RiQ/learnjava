package level4시험;

import java.util.Arrays;

public class _10 {

	public static void main(String[] args) {

		/*
		 	두 배열을 하나로 합치고 오름차순 정렬
		 */
		int[] arr1 = { 9, 10, 3, 2, 20, 19 };
		int[] arr2 = { 15, 12, 1, 5, 7, 8 };
		int[] arrS = new int[arr1.length + arr2.length];
		for (int i = 0; i < arrS.length; i++) {
			if (i < arr1.length) {
				arrS[i] = arr1[i];
			} else {
				arrS[i] = arr2[i - arr1.length];
			}
		}
		for (int i = 0; i < arrS.length; i++) {
			for (int k = i + 1; k < arrS.length; k++) {
				if (arrS[i] > arrS[k]) {
					int temp = arrS[i];
					arrS[i] = arrS[k];
					arrS[k] = temp;
				}
			}
		}
		System.out.println(Arrays.toString(arrS));
		// 소요 시간 : 8분 16초
	}

}
