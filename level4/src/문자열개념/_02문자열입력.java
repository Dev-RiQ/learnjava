package 문자열개념;

import java.util.Scanner;

public class _02문자열입력 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.print("값 입력 >> ");
		int num =sc.nextInt();
		System.out.println(num);
		sc.nextLine(); // 버퍼 초기화 
		System.out.print("이름 입력 >> ");
		String name = sc.nextLine(); // 엔터 전까지 다 출력(띄어쓰기도)
		System.out.println(name);
		System.out.print("이름2 입력 >> ");
		String name2 = sc.next();
		System.out.println(name2);
		sc.close();
	}

}
