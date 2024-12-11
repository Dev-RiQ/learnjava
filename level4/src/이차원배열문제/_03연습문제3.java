package 이차원배열문제;

import java.util.Arrays;

public class _03연습문제3 {

	public static void main(String[] args) {

		int[][] arr = {
				{101,102,103,104},
				{201,202,203,204},
				{301,302,303,304}
		};
		int[] garo = new int[3];
		int[] sero = new int[4];
		for (int i = 0; i < arr.length; i++) {
			for (int k = 0; k < arr[i].length; k++) {
				garo[i] += arr[i][k];
				sero[k] += arr[i][k];
			}
		}
		System.out.println(Arrays.toString(garo));
		System.out.println(Arrays.toString(sero));
		
	}

}
