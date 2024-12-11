package 배열심화2;

import java.util.Arrays;

public class _14같은수합치기 {

	public static void main(String[] args) {

		/*
		 	input 배열의 데이터를 순차적으로 arr에 저장하는데
		 	만약 저장하려는 수와 그 앞의 수가 서로 같으면 합친다 (중첩가능)
		 	마지막 arr 값은?
		 */
		int[] input = { 8, 4, 2, 2, 4, 4, 8 };
		int[] arr = new int[input.length];
		int idx = -1;
		for (int i = 0; i < arr.length; i++) {
			arr[++idx] = input[i];
			while (true) {
				System.out.println(Arrays.toString(arr));
				if (idx > 0 && arr[idx - 1] == arr[idx]) {
					arr[idx - 1] += arr[idx];
					arr[idx--] = 0;
					continue;
				}
				break;
			}
		}
		System.out.println("arr = " + Arrays.toString(arr));
	}

}
