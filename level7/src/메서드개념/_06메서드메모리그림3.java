package 메서드개념;

import java.util.Arrays;

class Ex02 {
	void changeValueInArray(int[] arr) {
		arr[1] = 100;
	}
}

public class _06메서드메모리그림3 {

	public static void main(String[] args) {

		int arr[] = { 10, 20, 30, 40, 50 };
		Ex02 e = new Ex02();

		e.changeValueInArray(arr);

		System.out.println(Arrays.toString(arr));

		int testArr[] = { 10, 20, 30, 40 };
		int temp[] = testArr;
		temp[1] = 100;
	}

}
