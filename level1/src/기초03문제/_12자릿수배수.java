package 기초03문제;

import java.util.Scanner;

public class _12자릿수배수 {

	public static void main(String[] args) {

		/*
		 * [문제]
		 * 		사용자에게 4자리 숫자를 입력받고 그중
		 * 		100의 자리가 3이고 10의 자리가 4이면,
		 * 		true 출력하시오.
		 */
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("4자리 숫자를 입력하시오 >> ");
		
		int num = scan.nextInt();
		boolean res = num/100%10 == 3 && num/10%10 == 4;
		
		System.out.println("\n입력한 숫자 " + num + "는 X34X 이다.\n" + res);
		
		scan.close();
		
		
	}

}
