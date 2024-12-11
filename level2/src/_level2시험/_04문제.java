package _level2시험;

import java.util.Scanner;

public class _04문제 {

	public static void main(String[] args) {

		/*
		   [문제]
		  		1~10000사이의 숫자를 입력받고
		  		자리별 홀수의 개수를 출력하시오
		 */
		Scanner sc = new Scanner(System.in);
		int input = 0;
		while (true) {
			System.out.print("1~10000 사이 숫자 입력 >> ");
			input = sc.nextInt();
			if (input < 1 || input > 10000) {
				System.out.println("입력오류");
				continue;
			}
			break;
		}
		int pos = input;
		int cnt = 0;
		while (true) {
			if (pos % 10 % 2 == 1) {
				cnt += 1;
			}
			pos /= 10;
			if (pos == 0) {
				break;
			}
		}
		System.out.printf("%d : %d개",input,cnt);
		sc.close();

		// 소요 시간 : 5분 35초
	}

}
