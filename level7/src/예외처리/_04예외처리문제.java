package 예외처리;

import java.util.InputMismatchException;
import java.util.Scanner;

public class _04예외처리문제 {

	public static void main(String[] args) {

		// 나이 입력받고 탄생년도 출력
		// 나이 입력 받았을 때 문자 입력해도 종료X
		// 나이값이 아닙니다 예외처리

		Scanner sc = new Scanner(System.in);
		int yearBirth = 2025;
		while (true) {
			System.out.println();
			System.out.println("나이를 입력해주세요.");
			try {
				int age = sc.nextInt();
				if(age < 0 || age > 200) {
					System.out.println("1~200 사이의 값을 입력하세요.");
					continue;
				}
				System.out.println("탄생년도 = " + (yearBirth - age));
				sc.close();
				break;
			} catch (InputMismatchException e) {
				System.out.println("숫자만 입력하세요");
			} catch (Exception e) {
				System.out.println("예외 발생");
			} finally {
				sc.nextLine();
			}
		}
	}

}
