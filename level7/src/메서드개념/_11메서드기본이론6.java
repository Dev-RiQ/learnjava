package 메서드개념;

import java.util.Arrays;

class Test08 {

	int cntMultiple4(int[] arr) {
		int cntMultiple4 = 0;
		for (int a : arr)
			if (a % 4 == 0)
				cntMultiple4++;
		return cntMultiple4;
	}

	int[] makeMultiple4Arr(int[] arr) {
		int cntMultiple4 = cntMultiple4(arr);
		int[] multiple4Arr = new int[cntMultiple4];
		int idx = 0;
		for (int a : arr)
			if (a % 4 == 0)
				multiple4Arr[idx++] = a;

		return multiple4Arr;
	}
}

class Test09 {
	int cnt;
	int arr[];

	void cntMultiple4(int[] arr) {
		for (int a : arr)
			if (a % 4 == 0)
				cnt++;
	}

	void makeMultiple4Arr(int[] arr) {
		if(cnt == 0)
			cntMultiple4(arr);
		this.arr = new int[cnt];
		int idx = 0;
		for (int a : arr)
			if (a % 4 == 0)
				this.arr[idx++] = a;
	}
}

public class _11메서드기본이론6 {

	public static void main(String[] args) {

		Test08 e8 = new Test08();
		Test09 e9 = new Test09();

		int[] arr = { 87, 12, 21, 56, 100 };

		System.out.println("[리턴사용할경우]");

		// 1) 4의 배수 개수를 리턴
		int cnt1 = e8.cntMultiple4(arr);
		System.out.println("cnt1 = " + cnt1);

		// 2) 4의 배수만 배열 타입으로 리턴
		int[] arr1 = e8.makeMultiple4Arr(arr);
		System.out.println("arr1 = " + Arrays.toString(arr1));

		System.out.println("--------------------");
		System.out.println("[리턴사용안할경우]");

		// 1) 4의 배수 개수를 리턴
		e9.cntMultiple4(arr);
		int cnt2 = e9.cnt;
		System.out.println("cnt2 = " + cnt2);

		// 2) 4의 배수만 배열 타입으로 리턴
		e9.makeMultiple4Arr(arr);
		int[] arr2 = e9.arr;
		System.out.println("arr2 = " + Arrays.toString(arr2));
	}

}
