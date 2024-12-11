package 배열심화2;

import java.util.Arrays;

public class _20인형뽑기2 {

	public static void main(String[] args) {

		int[][] machine = {
				{ 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 3 },
				{ 0, 2, 0, 0, 3 },
				{ 3, 1, 3, 0, 1 },
				{ 1, 4, 2, 0, 2 },
				{ 4, 1, 4, 0, 4 },
				{ 2, 1, 4, 3, 3 }
		};
		String[] nameList = { "호랑이", "곰", "사자", "기린" };
		int[] input = { 1, 0, 0, 3, 3, 4, 4 };
		for (int move : input) {
			for (int[] col : machine) {
				System.out.println(Arrays.toString(col));
			}
			System.out.println("input = " + move);
			int get = machine[machine.length - 1][move];
			System.out.println("*******"+(get == 0 ? "꽝" : nameList[get - 1])+"*******");
			if(get==0) { continue; }
			for (int i = machine.length - 1; i > 0; i--) {
				machine[i][move] = machine[i - 1][move];
			}
			System.out.println();
		}
		for (int[] col : machine) {
			System.out.println(Arrays.toString(col));
		}
		
	}

}
