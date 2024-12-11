package 이차원반복문;

import java.util.Scanner;

public class _04소수찾기 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 한 개 입력 >> ");
		int num = sc.nextInt();
		if (num < 2) {
			System.out.println("2 이상의 값을 입력하세요");
		}
		for (int i = 2; i <= num; i++) {
			int cnt = 0;
			for (int k = 2; k <= i; k++) {
				if (i % k == 0) {
					cnt++;
				}
				if (cnt > 1) {
					break;
				}
			}
			if (cnt == 1) {
				System.out.print(i == 2 ? i : ", " + i);
			}
		}
		sc.close();
	}

}
