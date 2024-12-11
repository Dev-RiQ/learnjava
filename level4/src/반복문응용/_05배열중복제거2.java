package 반복문응용;

import java.util.Arrays;
import java.util.Scanner;

public class _05배열중복제거2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int[] data = { 5, 2, 2, 8, 5, 6 };
		System.out.print("입력 : ");
		int input = sc.nextInt();
		int cnt = data.length;
		for (int i = 0; i < cnt; i++) {
			if (data[i] == input) {
				for (int k = i--; k < cnt-1; k++) {
					data[k] = data[k + 1];
				}
				data[--cnt] = 0;
			}
		}
		System.out.println(Arrays.toString(data));
		sc.close();
		
	}

}
