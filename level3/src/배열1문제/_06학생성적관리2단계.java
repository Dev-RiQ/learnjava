package 배열1문제;

import java.util.Scanner;

public class _06학생성적관리2단계 {

	public static void main(String[] args) {

		/*
		 	[문제]
		 		1. 인덱스 입력받아 성적 출력
		 		2.성적 입력받아 인덱스 출력
		 		3. 학번 입력받아 성적 출력
		 */
		int[] arr = { 87, 11, 45, 98, 23 };
		int[] hakbuns = { 1001, 1002, 1003, 1004, 1005 };
		int[] scores = { 87, 11, 45, 98, 23 };

		Scanner sc = new Scanner(System.in);

		// 1
		while (true) {
			System.out.print("인덱스 : ");
			int index = sc.nextInt();
			if (index < 0 || index >= arr.length) {
				System.out.println("인덱스 입력 오류");
			} else {
				System.out.println("성적 : " + arr[index]);
				break;
			}
		}
		System.out.println();
		// 2
		int score = 0;
		int cnt = 0;
		while (true) {
			System.out.print("성적 : ");
			score = sc.nextInt();
			for (int i = 0; i < arr.length; i += 1) {
				if (score != arr[i]) {
					cnt += 1;
				}
			}
			if (cnt == arr.length) {
				System.out.println("해당 성적 없음");
				cnt = 0;
				continue;
			}
			break;
		}
		System.out.print("인덱스 : ");
		for (int i = 0; i < arr.length; i += 1) {
			if (score == arr[i]) {
				System.out.println(i);
			}
		}
		System.out.println();
		// 3
		int hakbun = 0;
		cnt = 0;
		while (true) {
			System.out.print("학번 : ");
			hakbun = sc.nextInt();
			for (int i = 0; i < hakbuns.length; i += 1) {
				if (hakbun != hakbuns[i]) {
					cnt += 1;
				}
			}
			if (cnt == hakbuns.length) {
				System.out.println("해당 학번 없음");
				cnt = 0;
				continue;
			}
			break;
		}
		System.out.print("성적 : ");
		for (int i = 0; i < hakbuns.length; i += 1) {
			if (hakbun == hakbuns[i]) {
				System.out.println(scores[i]);
			}
		}
		sc.close();
	}

}
