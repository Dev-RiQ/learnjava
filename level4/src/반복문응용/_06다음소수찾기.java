package 반복문응용;

import java.util.Scanner;

public class _06다음소수찾기 {

	public static void main(String[] args) {
		
		/*
		 	[문제]
		 		숫자 한 개를 입력받아 입력받은 숫자보다 큰 첫 번째 소수를 출력한다.
		 */
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Number ? ");
		int input = sc.nextInt();
		int num = input;
		while (true) {
			num++;
			int cnt = 0;
			for (int i = 1; i <= num; i++) {
				if (num % i == 0) {
					cnt++;
				}
			}
			if (cnt == 2) {
				break;
			}
		}
		System.out.println(input + "보다 큰 첫 번째 소수는 " + num);
		sc.close();
	}

}
