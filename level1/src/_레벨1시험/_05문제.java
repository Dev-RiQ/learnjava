package _레벨1시험;

import java.util.Scanner;

public class _05문제 {

	public static void main(String[] args) {
		/*
	 	[문제]
	 	 	 		if -else if -else 모두 써서 구현하시오
	 	 	 1. 키를 입력받는다
	 	 	 2.	입력받은 키가 120 이상이면, 놀이기구를 이용할 수 있다.
	 	 	 3.	키가 120 미만이면, 놀이기구 못탐
	 	 	 4. 단, 부모님과 함께오면 가능 (yes = 1 , no = 0)
	 */
	
		Scanner sc = new Scanner(System.in);

		System.out.print("키를 입력하세요 >> ");
		int tall = sc.nextInt();

		if (tall >= 120) {
			System.out.println("탑승 가능");
		} else if (tall < 120 && tall > 0) {
			System.out.print("부모님 동행 여부 (yes : 1 no : 0) >> ");
			int yesNo = sc.nextInt();
			if (yesNo == 1) {
				System.out.println("탑승 가능");
			} else if (yesNo == 0) {
				System.out.println("탑승 불가");
			} else {
				System.out.println("오류 : 1, 0 중 하나를 입력하세요.");
			}
		} else {
			System.out.println("오류 : 양수 값을 입력하세요.");
		}
		sc.close();

		// 시간 : 5분 2초
	}

}
