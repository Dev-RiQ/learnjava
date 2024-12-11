package 배열심화개념;

import java.util.Arrays;

public class _09이차원배열2 {

	public static void main(String[] args) {

		int[] arr = new int[3]; // null이 아니라면 배열 갯수 지정해야함 => new int 한 순간 주소 생성
		int[][] darr = new int[2][]; // 주소값 갯수 지정 => new int로 생성한 주소 내에 새로운 주소 미생성(null) 
		System.out.println(Arrays.toString(arr));
		System.out.println(Arrays.toString(darr));
		int[][] darr2= {
				{1,2,3},{4,5,6,7},{8,9}
		};
		for(int i = 0;i<darr2.length;i++) {
			for(int k = 0;k<darr2[i].length;k++) {
				System.out.print(darr2[i][k] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

}
