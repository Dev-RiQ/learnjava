package 배열심화개념;

import java.util.Arrays;

public class _04메모리구조2 {

	public static void main(String[] args) {

		int[] arr = {10,20,30,40,50};
		int[] arr2 = {10,20,30,40,50};
		arr[1] =200;
		System.out.println(Arrays.toString(arr));
		
		int[] temp = arr;
		System.out.println(Arrays.toString(temp));
		temp[1] = 2000;
		
		System.out.println(Arrays.toString(arr));
		System.out.println(Arrays.toString(temp));
		System.out.println(arr==temp); // 주소 값을 같게했음
		System.out.println(arr==arr2); // 주소 값이 다름
	}

}
