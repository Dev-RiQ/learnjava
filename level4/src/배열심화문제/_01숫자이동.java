package 배열심화문제;

import java.util.Arrays;
import java.util.Scanner;

public class _01숫자이동 {

	public static void main(String[] args) {

		/*
		 	[문제]
		 		아래 번호를 입력받고 각 방향으로 0이 아닌 숫자를 모으시오
		 		1)left 2)right
		 */
		Scanner sc = new Scanner(System.in);
		int[] arr = { 0, 2, 0, 4, 3, 0, 0, 5, 6 };
//		int[] arr = { 1, 2, 0, 3, 4, 0, 0, 5, 8 };
//		int[] arr = { 1, 0, 0, 0, 0, 0, 0, 0, 0 };
		sc.close();
//		System.out.println(Arrays.toString(arr));
//		System.out.print("1)left 2)right >> ");
//		int sel = sc.nextInt();
//		int i = sel == 1 ? 0 : arr.length - 1;
//		int range = sel == 1 ? arr.length : -1;
//		int set = sel == 1 ? 1 : -1;
//		for (; i != range; i += set) {
//			for (int k = i; k != range; k += set) {
//				if (arr[i] == 0 && arr[k] != 0) {
//					arr[i] = arr[k];
//					arr[k] = 0;
//					break;
//				}
//			}
//		}
//		System.out.println(Arrays.toString(arr));
		
		
		int i = 0;
		System.out.println(Arrays.toString(arr));
		System.out.print("1)left 2)right >> ");
		int sel = sc.nextInt();
		if (sel == 1) {
			for (i = 0; i < arr.length; i++) {
				for (int k = i; k < arr.length; k++) {
					if (arr[i] == 0 && arr[k] != 0) {
						arr[i] = arr[k];
						arr[k] = 0;
						break;
					}
				}
			}
		} else {
			for (i = arr.length - 1; i >= 0; i--) {
				for (int k = i; k >= 0; k--) {
					if (arr[i] == 0 && arr[k] != 0) {
						arr[i] = arr[k];
						arr[k] = 0;
						break;
					}
				}
			}
			
		}
		System.out.println(Arrays.toString(arr));
		
		
		
		
		System.out.println(Arrays.toString(arr));
		System.out.print("1)left 2)right >> ");
		sel = sc.nextInt();
		if (sel == 1) {
			for (i = 0; i < arr.length; i++) {
				for(int k = i;k<arr.length-1;k++) {
					if(arr[k] == 0) {
						arr[k] = arr[k+1];
						arr[k+1] = 0;
					}
				}
			}
		} else {
			for (i = arr.length-1; i > 0; i--) {
				for(int k = i;k>0;k--) {
					if(arr[k] == 0) {
						arr[k] = arr[k-1];
						arr[k-1] = 0;
					}
				}
			}

		}
		System.out.println(Arrays.toString(arr));
		
		
		
		sc.close();
		
		

	}

}
