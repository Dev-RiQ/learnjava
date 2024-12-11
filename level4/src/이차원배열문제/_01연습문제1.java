package 이차원배열문제;

import java.util.Arrays;

public class _01연습문제1 {

	public static void main(String[] args) {
		
		//아래 배열 만들기
		//int[][] arr = {{10,20,30},{40,50,60},{70,80,90}};
		//전체 합 출력
		//4의 배수 출력
		//4의 배수 합 출력
		//4의 배수 개수 출력
		int[][] arr = new int[3][3];
		int sum = 0;
		int cnt = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int k = 0; k < arr[i].length; k++) {
				arr[i][k] = i * 30 + (k + 1) * 10;
				sum += arr[i][k];
			}
			System.out.println(Arrays.toString(arr[i]));
		}
		System.out.println("전체 합 = " + sum);
		sum = 0;
		System.out.print("4의 배수 : ");
		for (int i = 0; i < arr.length; i++) {
			for (int k = 0; k < arr[i].length; k++) {
				if (arr[i][k] % 4 == 0) {
					System.out.print(arr[i][k] + " ");
					sum += arr[i][k];
					cnt++;
				}
			}
		}
		System.out.println();
		System.out.println("4의 배수 합 = " + sum);
		System.out.println("4의 배수 개수 = " + cnt);
		
		
		arr = new int[9][1];
		int[] temp = new int[arr.length*arr[0].length];
		sum = 0;
		int sum4 = 0;
		cnt = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int k = 0; k < arr[i].length; k++) {
				sum += arr[i][k] = i * arr[i].length* 10 + (k + 1) * 10;
				if (arr[i][k] % 4 == 0) {
					sum4 += temp[cnt++] = arr[i][k];
				}
			}
			System.out.println(Arrays.toString(arr[i]));
		}
		System.out.println("전체 합 = " + sum);
		System.out.print("4의 배수 = ");
		for(int i = 0;i<temp.length;i++) {
			System.out.print(temp[i]!=0? temp[i] + " ":"");
		}
		temp = null;
		System.out.println();
		System.out.println("4의 배수 합 = " + sum4);
		System.out.println("4의 배수 개수 = " + cnt);
		
	}

}
