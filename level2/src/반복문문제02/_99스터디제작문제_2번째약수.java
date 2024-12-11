package 반복문문제02;

import java.util.Random;

public class _99스터디제작문제_2번째약수 {

	public static void main(String[] args) {

		/*
		 	[문제]
		 		1. 1~30까지의 숫자 중 3의배수 또는 4의 배수가 아닌 숫자만 랜덤으로 5개를 출력한다.
		 		2. 그 5개의 숫자의 합을 출력한다.
		 		3. 숫자의 합의 약수와 약수의 갯수를 구하고
		 		4. 약수의 갯수가 3개 이하면 처음부터 다시 시작
		 		5. 약수의 갯수가 8개 미만이면 4번째로 작은 약수 출력
		 		6. 만약 약수의 갯수가 8개 이상이면 (약수의 갯수 / 2 + 1)번째로 작은 약수 출력
		 	[출력예시]
		 		랜덤숫자 : 22 5 22 23 11 
				숫자의 합 : 83
				83의 약수 : 1 83 
				[ 약수의 갯수 : 2 ]
				다시 시작

				랜덤숫자 : 10 29 19 17 5 
				숫자의 합 : 80
				80의 약수 : 1 2 4 5 8 10 16 20 40 80 
				[ 약수의 갯수 : 10 ]
				6번째 약수 : 10
		 */
		
		Random rd = new Random();
		while (true) {
			int i = 1;
			int sum = 0;
			int cnt = 0;
			System.out.print("랜덤숫자 : ");
			while (i <= 5) {
				int rdNum = rd.nextInt(30) + 1;
				if (rdNum % 3 == 0 || rdNum % 4 == 0) {
					continue;
				}
				System.out.print(rdNum + " ");
				sum += rdNum;
				i += 1;
			}
			System.out.println("\n숫자의 합 : " + sum);
			System.out.print(sum + "의 약수 : ");
			i = 1;
			while (i <= sum) {
				if (sum % i == 0) {
					cnt += 1;
					System.out.print(i + " ");
				}
				i += 1;
			}
			i = 1;
			System.out.println("\n[ 약수의 갯수 : " + cnt + " ]");
			if (cnt <= 3) {
				System.out.println("다시 시작\n");
				continue;
			} else if (cnt < 8) {
				cnt = 0;
				while (i <= sum) {
					if (sum % i == 0) {
						cnt += 1;
					}
					if (cnt == 4) {
						break;
					}
					i += 1;
				}
				System.out.println(cnt + "번째 약수 : " + i);
			} else {
				int cnt8 = cnt / 2 + 1;
				cnt = 0;
				while (i <= sum) {
					if (sum % i == 0) {
						cnt += 1;
					}
					if (cnt == cnt8) {
						break;
					}
					i += 1;
				}
				System.out.println(cnt8 + "번째 약수 : " + i);
			}
			break;
		}
		
		
	}

}
