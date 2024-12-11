package _01;

import java.util.Arrays;

public class _012같은수문제변형 {

	public static void main(String[] args) {

		/*
		 * input 데이터 a에 순차적으로 저장한다.
		 * 만약, 
		 * 저장하려는 숫자와 현재 숫자가 같다면 둘의 합을 현재 숫자에 저장한다
		 * 저장하려는 숫자가 현재 숫자의 2배이면 저장하지 않고,
		 * 저장하려는 숫자가 현재 숫자의 3배이면 둘다 삭제한다.
		 * 조건에 맞는 데이터를 저장한 후 이전의 것과도 비교한다.
		 */
//		int[] input = { 1, 1, 3, 6, 1, 2, 2, 4, 12, 7};
		//[2, 3, 1, 7, 0, 0, 0, 0, 0, 0]
		int[] input = { 4, 2, 4, 1, 1, 2, 6, 4, 12, 7};
		//[8, 7, 0, 0, 0, 0, 0, 0, 0, 0]
//		int[] input = { 1, 3, 3, 2, 1, 2, 2, 4, 12, 24};
		//[3, 2, 1, 24, 0, 0, 0, 0, 0, 0]
//		int[] input = { 1, 3, 3, 2, 1, 2, 2, 4, 12, 3};
		//[3, 2, 0, 0, 0, 0, 0, 0, 0, 0]
//		int[] input = { 1, 3, 3, 2, 1, 2, 2, 4, 12, 2};
		//[3, 2, 1, 0, 0, 0, 0, 0, 0, 0]

		int[] a = new int[input.length];
		int idx = 0;
		for (int i = 0; i < a.length; i++) {
			a[idx] = input[i];
			while(true) {
				if(idx>0) {
					if(a[idx] == a[idx-1]) {
						a[idx-1] += a[idx];
						a[idx--] = 0;
						continue;
					}else if(a[idx]%a[idx-1]==0 && a[idx]/a[idx-1] == 2){
						a[idx] = 0;
						idx--;
						continue;
					}else if(a[idx]%a[idx-1]==0 && a[idx]/a[idx-1] == 3){
						a[idx] = 0;
						a[idx-1] = 0;
						idx -=2;
						continue;
					}
					
				}
				break;
			}
			idx++;
		}
		System.out.println(Arrays.toString(a));
		
	}

}
