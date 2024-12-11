package 배열심화개념;

import java.util.Arrays;

public class _02최대값순정렬 {

	public static void main(String[] args) {

		int[] score = { 10, 50, 30, 40, 80, 19 };
		for (int i = 0; i < score.length; i++) {
			for (int k = i + 1; k < score.length; k++) {
				if (score[i] < score[k]) {
					int temp = score[i];
					score[i] = score[k];
					score[k] = temp;
				}
			}
		}
		System.out.println(Arrays.toString(score));
		
		
		
//		int[] score = { 10, 50, 30, 40, 80, 19 };
//		for (int i = 0; i < score.length; i++) {
//			int max = 0;
//			int idx = 0;
//			for (int k = i; k < score.length; k++) {
//				if (max < score[k]) {
//					max = score[k];
//					idx = k;
//				}
//			}
//			int temp = score[i];
//			score[i] = max;
//			score[idx] = temp;
//		}
//		System.out.println(Arrays.toString(score));
		
		
		
		
	}

}
