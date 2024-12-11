package 배열1개념;

import java.util.Arrays;
import java.util.Scanner;

public class _08추가원리 {

	public static void main(String[] args) {

		/*
		 	[문제]
		 		arr 배열에 값을 1개씩 입력받아 저장한다.
		 		단, 5개 이상 추가할 수 없다. (저장공간 초과 오류)
		 */
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[5];

		int input = 0;
		int i = 0;
		while (input != -100) {
			System.out.print("값 입력 (-100 종료) >> ");
			input = sc.nextInt();
			if (i == 5) {
				System.out.println("저장공간 초과");
				break;
			}
			if (input != -100) {
				arr[i++] = input;
			}
			for (int j = 0; j < i + 1; j++) {
				if (arr[j] != 0 && input != -100) {
					System.out.print(j == 0 ? "[" + arr[j] : ", " + arr[j]);
					if(j==i) {
						System.out.println("]");
					}
				}
			}
		}
		System.out.println(Arrays.toString(arr));
		System.out.println("종료");
		sc.close();
	}

}
