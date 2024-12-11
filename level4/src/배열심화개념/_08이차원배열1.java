package 배열심화개념;

import java.util.Arrays;

public class _08이차원배열1 {

	public static void main(String[] args) {

		int[] arr = {1,2,3,4,5,6};
		
		for(int i = 0;i<arr.length;i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		System.out.println(Arrays.toString(arr));
		
		int[][] darr = new int[2][3]; // 2개의 주소값 저장 => 주소값 당 3개의 변수방 (heap에 2,3,3 총 3개 그룹 생성)
		
		for(int i = 0;i<darr.length;i++) { // darr.length => 2
			for(int k = 0; k<darr[i].length;k++) { // darr[i].length => 3
				System.out.print(darr[i][k] + " ");
			}
			System.out.println();
		}
		darr[0] = arr; // => 배열 참조 값 변경 (기존 배열은 미참조 시 삭제)
		System.out.println();
		System.out.println(Arrays.toString(darr));
		System.out.println(Arrays.deepToString(darr));
		
		
	}

}
