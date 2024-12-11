package 배열심화개념;

import java.util.Arrays;

public class _05깊은복사얕은복사 {

	public static void main(String[] args) {

		//shallow copy => 주소값만 복사 => 한 쪽에서 값을 수정하면 달느 쪽에도 영향을 미친다
		int[] arr = {10,20,30,40,50};// new int[5];
		int[] temp = arr; //얕은복사 => heap data 공유
		temp[2] =100;
		System.out.println(Arrays.toString(arr));
		System.out.println(Arrays.toString(temp));
		
		//deep copy => 새로운 주소에 값을 복사 => 서로 다른 주소 값을 가지고 있다
		int[] copy = new int[5];// heap에 새로운 주소 창출
		for(int i =0;i<copy.length;i++) { // 후 복사
			copy[i] = arr[i];
		}
		copy[2] = 3000;
		System.out.println(Arrays.toString(arr));
		System.out.println(Arrays.toString(copy));
		
		
		
	}

}
