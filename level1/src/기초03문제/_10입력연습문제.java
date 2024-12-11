package 기초03문제;

import java.util.Scanner;

public class _10입력연습문제 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		
		System.out.println("정수입력 \n");
		
		//문제 1) 숫자 2개를 입력받아, 합 출력
		
		System.out.println("원하는 숫자 2개를 입력하세요.");
		int num1 = scan.nextInt(); 
		int num2 = scan.nextInt();
		int sum = num1 + num2;
		
		System.out.println("입력한 두 수의 합은 "+ sum + " 입니다.\n");
		
		//문제 2) 숫자 1개를 입력받아, 홀수이면 true 출력
		
		System.out.println("원하는 숫자 1개를 입력하세요.");
		int num3 = scan.nextInt();
		boolean res1 = num3%2 == 1;
		
		System.out.println("입력한 값은 홀수인가? \n" + res1 + "\n");
		
		//문제 3) 숫자 1개를 입력받아 3의 배수이거나 45의 약수이면 true 출력
		
		System.out.println("원하는 숫자 1개를 입력하세요.");
		int num4 = scan.nextInt();
		boolean res2 = num4%3 == 0 || 45%num4 == 0;
		
		System.out.println("입력한 값은 3의 배수 또는 45의 약수인가? \n" + res2);
		
		scan.close();
		
	}

}
