package 조건문문제;

import java.util.Scanner;

public class _08점수유효성검사1단계 {

	public static void main(String[] args) {

		/*
		 	[문제]
		 		1.점수를 입력받는다.
		 		2. 점수가 60점 이상이면 합격, 미만이면 불합격
		 		3. 단, 입력받은 정수가
		 			음수이거나 100점을 초과하면, "점수를 잘못 입력했습니다."
		 */
		
		Scanner sc = new Scanner(System.in);

		System.out.print("점수를 입력하세요 >>");
		int input = sc.nextInt();

		boolean err = input > 100 || input < 0;

		if (!err) {
			if (input >= 60) {
				System.out.println("\n합격");
			}
			if (input < 60) {
				System.out.println("\n불합격");
			}
		}
		if (err) {
			System.out.println("\n점수를 잘못 입력했습니다.");
		}

		sc.close();
	}

}
