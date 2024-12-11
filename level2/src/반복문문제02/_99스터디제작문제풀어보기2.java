package 반복문문제02;

import java.util.Random;

public class _99스터디제작문제풀어보기2 {

	public static void main(String[] args) {

//		[문제]
//		 		1. 1~30까지의 숫자 중 3의배수 또는 4의 배수가 아닌 숫자만 랜덤으로 5개를 출력한다.
//		 		2. 그 5개의 숫자의 합을 출력한다.
//		 		3. 숫자의 합의 약수와 약수의 갯수를 구하고 2번째 약수 출력
//		 */
		
		Random rd = new Random();

		int i = 1;
		int sum = 0;
		int cnt = 0;
		int num2 = 0;
		while (i <= 5) {
			int num = rd.nextInt(30) + 1;
			if (num % 3 != 0 && num % 4 != 0) {
				System.out.print(num + " ");
				i += 1;
				sum += num;
			}
		}
		i = 1;
		System.out.println();
		System.out.print(sum + "의 약수 : ");
		while (i <= sum) {
			if (sum % i == 0) {
				System.out.print(i + " ");
				cnt += 1;
				if (cnt == 2) {
					num2 = i;
				}
			}
			i += 1;
		}
		System.out.println("\n[ 약수의 갯수 : " + cnt + " ]");
		System.out.println("2번째 약수 : " + num2);
	}

}
