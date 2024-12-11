package _레벨1시험;

import java.util.Scanner;

public class _10문제 {

	public static void main(String[] args) {
		/*
	 	[문제]
	 		1. 시험점수 입력
	 		2. 해당 학점 출력
	 		3. 점수표
	 			91~100점 A학점
	 			81~90점 B학점
	 			80이하 재시험
	 		4. 단, 만점이거나 A학점과 B학점의 일의 자리가 7점 이상이면, + 추가
	 											3점 이하면, - 추가
		 */
		
		Scanner sc = new Scanner(System.in);

		System.out.print("점수를 입력 >> ");
		int score = sc.nextInt();

		if (score > 100 || score < 0) {
			System.out.println("오류 : 점수를 확인해주세요.");                                      
		} else   if (score <= 80) {
			System.out.println("재시험");
		} else if (score <= 90) {
			System.out.print("B");
		} else {
			System.out.print("A");
		}

		if (score <= 100 && score > 80) {
			if (score % 10 >= 7 || score % 10 == 0) {
				System.out.println("+");
			} else if (score % 10 <= 3) {
				System.out.println("-");
			}
		}

		sc.close();

		// 시간 : 4분 41초
	}

}
