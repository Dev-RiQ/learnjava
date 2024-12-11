package 배열2문제;

import java.util.Arrays;
import java.util.Scanner;

public class _09전파 {

	public static void main(String[] args) {

		/*
		 	[문제]
		 		인덱스를 입력받고 해당 인덱스의 값을 0으로 변경하시오
		 		해당 값 양 옆의 값들도 0으로 변경하시오
		 		단, 인덱스 값이 0 또는 4일 경우 양옆 중 한 곳만 0으로 변경하시오
		 */
		Scanner sc = new Scanner(System.in);
		int[] arr = {9,9,9,9,9,9};
		int index;
		while(true) {
			System.out.print("인덱스 입력 >> ");
			index = sc.nextInt();
			if(index<0||index>arr.length-1) {
				System.out.println("입력 오류");
				continue;
			}
			break;
		}
		arr[index] = 0;
		if(index>0) {
			arr[index-1] = 0;
		}
		if(index<5) {
			arr[index+1] = 0;
		}
		System.out.println(Arrays.toString(arr));
		sc.close();
		
	}

}
