package 이차원반복문;

import java.util.Arrays;
import java.util.Scanner;

public class _05배열응용문제 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int arr[] = { 10, 20, 30, 40, 50 };
		int b[] = new int[5];
		int inputs[] = new int[5];

		for (int i = 0; i < arr.length; i++) {
			System.out.print((i + 1) + "번 숫자 입력 >>");
			int input = sc.nextInt();
			if (input == 0) {
				System.out.println("0을 제외한 숫자를 입력하세요");
				i--;
				continue;
			}
			inputs[i] = input;
			int idx = -1;
			for (int k = 0; k < b.length; k++) {
				if (arr[k] == input) {
					idx = k;
				}
			}
			b[i] = idx;
		}
		System.out.println("b = " + Arrays.toString(b));
		System.out.println("inputs = " + Arrays.toString(inputs));
		sc.close();
		
		
	}

}
