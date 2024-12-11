package 배열심화2;

import java.util.Arrays;

public class _12위로복사 {

	public static void main(String[] args) {

		/*
		 	배열 값 한칸씩 위로 올리고 맨 아래칸 ""로 채움
		 */
		String arr[][] = {
				{"○","○","○","○","○"},
				{"▦","▦","▦","▦","▦"},
				{"♬","♬","♬","♬","♬",}
		};
		for (int i = 0; i < arr.length; i++) {
			if (i < arr.length - 1) {
				arr[i] = arr[i + 1];
			} else {
				for (int k = 0; k < arr[i].length; k++) {
					arr[i][k] = "";
				}
			}
			System.out.println(Arrays.toString(arr[i]));
		}
	}

}
