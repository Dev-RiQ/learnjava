package 배열심화2;

import java.util.Arrays;

public class _04배열비교1 {

	public static void main(String[] args) {

		/*
		 	arr,b,c배열에 공통적으로 존재하는 값을 result배열에 순차적으로 저장
		 */
		int[][] arr = {
				{ 10, 20, 30 },
				{ 40, 50, 60 },
				{ 70, 80, 90 }	
		};
		int[] b = { 23, 40, 20, 50 };
		int[] c = { 4, 34, 40, 50 };
		int[] result = new int[4];
		int idx = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int k = 0; k < arr[i].length; k++) {
				int match = 0;
				for(int j = 0;j<b.length;j++) {
					if(arr[i][k]==b[j]) {
						match++;	
					}
					if(arr[i][k]==c[j]) {
						match++;	
					}
					if(match==2) {
						result[idx++] = arr[i][k];
						break;
					}
				}
			}
		}
		System.out.println(Arrays.toString(result));
	}

}
