package 배열심화3;

import java.util.Scanner;

public class _09페이징 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.print("1~1000 사이의 숫자 입력 (0.종료) >> ");
			int number = sc.nextInt();
			if (number == 0) {
				System.out.println("종료");
				break;
			}
			if (number < 1 || number > 1000) {
				System.out.println("입력 오류");
				continue;
			}
			int num = number % 10 == 0 ? number - 9 : number - number % 10 + 1;
			System.out.printf("%d ==> %d\n", number, num);
		}
		sc.close();
	}

}
