package level4시험;

import java.util.Arrays;
import java.util.Random;

public class _14 {

	public static void main(String[] args) {
		/*
		 	랜덤 숫자 5개 저장(1~9사이)
		 	홀수이면 맨앞에 저장(밀어내기)
		 	짝수면 맨뒤에 저장(밀어내기)
		 */
		Random rd = new Random();
		int[] arr = new int[5];
		int front = 0;
		int back = arr.length - 1;
		for (int i = 0; i < arr.length; i++) {
			int rdNum = rd.nextInt(9) + 1;
			if (rdNum % 2 == 0) {
				for (int k = back; k < arr.length - 1; k++) {
					arr[k] = arr[k + 1];
				}
				arr[arr.length - 1] = rdNum;
				back--;
			} else {
				for (int k = front; k > 0; k--) {
					arr[k] = arr[k - 1];
				}
				arr[0] = rdNum;
				front++;
			}
			System.out.println(Arrays.toString(arr));
		}
		// 소요 시간 : 21분 22초
	}

}
