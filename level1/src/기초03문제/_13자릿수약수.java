package 기초03문제;

import java.util.Scanner;

public class _13자릿수약수 {

	public static void main(String[] args) {

		/*
		 * [문제]
		 * 		사용자에게 4자리 숫자를 입력받고 그중
		 * 		1000의 자리가 5의 배수 이거나 1의 자리가 25의 약수이면,
		 * 		true 출력하시오
		 */

		Scanner scan = new Scanner(System.in);

		System.out.print("4자리 숫자를 입력하세요 >> "); // ln안하면 엔터안하니까 옆에 작성됨.

		int input = scan.nextInt();
		int input1000 = input / 1000;
		int input1 = input % 10;
		boolean res = input1000 == 5 || input1 == 1 || input1 == 5;

		System.out.println("\n입력한 숫자 " + input + "는 조건에 만족한다.\n" + res);

		scan.close();
		
	}

}
