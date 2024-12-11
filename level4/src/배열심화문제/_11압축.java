package 배열심화문제;

import java.util.Arrays;

public class _11압축 {

	public static void main(String[] args) {

		/*
		 	arr배열에 이어진 같은 숫자 1개로 압축해서 b 배열에 저장
		 */
//		int[] arr = { 1, 1, 1, 3, 3, 3, 3, 2, 2, 3, 3, 3, 4, 5 };
//		int idx = 1;
//		int cnt = 1;
//		for (int i = 0; i < arr.length - 1; i++) {
//			if (arr[i] != arr[i + 1]) {
//				cnt++;
//			}
//		}
//		int temp[] = arr;
//		arr = new int[cnt];
//		arr[0] = temp[0];
//		for (int i = 0; i < temp.length - 1; i++) {
//			if (temp[i] != temp[i + 1]) {
//				arr[idx++] = temp[i + 1];
//			}
//		}
//		temp = null;
//		System.out.println(Arrays.toString(arr));
		int[] arr = { 1, 1, 1, 3, 3, 3, 3, 2, 2, 3, 3, 3, 4, 5 };
		int[] b = null;
		int idx = 1;
		int cnt = 1;
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] != arr[i + 1]) {
				cnt++;
			}
		}
		b = new int[cnt];
		b[0] = arr[0];
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] != arr[i + 1]) {
				b[idx++] = arr[i + 1];
			}
		}
		System.out.println(Arrays.toString(b));
		
		//중복 모두 제거
		
		b = null;
		cnt = 0;
		idx = 0;
		for(int i = 0;i<arr.length;i++) {
			for(int k = i+1; k<arr.length;k++) {
				if(arr[i] == arr[k]) {
					cnt--;
					break;
				}
			}
			cnt++;
		}
		b = new int[cnt];
		for(int i =0;i<arr.length;i++) {
			boolean check = false;
			for(int k = 0;k<b.length;k++) {
				if(arr[i]==b[k]) {
					check = true;
					break;
				}
			}
			if(!check) {
				b[idx++] = arr[i];
			}
		}
		System.out.println(Arrays.toString(b));
	}

}
