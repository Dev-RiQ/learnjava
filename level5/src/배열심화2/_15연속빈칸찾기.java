package 배열심화2;

import java.util.Arrays;

public class _15연속빈칸찾기 {

	public static void main(String[] args) {

		/*
		 	arr배열은 숫자 1과 0으로 구성되어 있다
		 	숫자 1은 이미 채워진 자리, 0은 빈자리
		 	input변수 값의 의미는 1부터 시작하는 위치를 의미하며,
		 	연속으로 1으로 채울 칸 수를 의미한다
		 	ex. input == 3, 3번째 자리에 3연속 빈자리 있는지?
		 	있으면 1로
		 */
		int[] arr = { 0, 1, 0, 0, 0, 1, 0, 0 };
		int[] temp = new int[arr.length];

		int input = 4;
		boolean isEmpty = true;
		int idx = -1;
		for (int i = input - 1; i < 2 * input - 1; i++) {
			if (isEmpty) {
				if (arr[i] == 1) {
					idx = i;
					isEmpty = false;
					i = input - 2;
					continue;
				}
				arr[i] = 1;
			} else {
				if (i == idx) {
					break;
				}
				arr[i] = temp[i];
			}
		}
		System.out.println(Arrays.toString(arr));
	}

}
