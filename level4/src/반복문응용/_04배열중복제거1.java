package 반복문응용;

import java.util.Arrays;
import java.util.Scanner;

public class _04배열중복제거1 {

	public static void main(String[] args) {

		/*
		 	[문제]
		 		값을 입력받아 data배열에서 해당 값을 제외하고
		 		배열 b에 저장하시오.
		 		단, 같은 값이 여러개 있으면 전부 제외
		 */
		Scanner sc = new Scanner(System.in);
		int[] data = { 5, 2, 6, 8, 5, 6 };
		int[] b = { 0, 0, 0, 0, 0, 0 };
		int input = 0;
		while (true) {
			System.out.print("입력 : ");
			input = sc.nextInt();
			if (input == 0) {
				System.out.println("0 제외 입력");
				continue;
			}
			break;
		}
		int idx = 0;
		for (int i = 0; i < data.length; i++) {
			if (data[i] != input) {
				b[idx++] = data[i];
			}
		}
		System.out.println(Arrays.toString(b));
		sc.close();
		
	}

}
