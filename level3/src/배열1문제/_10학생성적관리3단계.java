package 배열1문제;

import java.util.Scanner;

public class _10학생성적관리3단계 {

	public static void main(String[] args) {
			
		/*
		   [문제]
		   		1)인덱스 입력 성적출력 (없으면 오류)
		   		2)성적 입력 인덱스출력 (없으면 오류)
		   		3) 학번 입력 성적출력 (없으면 오류)
		 */
		
		int[] arr = { 87, 11, 45, 98, 23 };
		int[] hakbuns = { 1001, 1002, 1003, 1004, 1005 };
		int[] scores = { 87, 11, 45, 98, 23 };

		Scanner sc = new Scanner(System.in);

		// 1
		System.out.print("인덱스 입력 : ");
		int idx = sc.nextInt();
		if (idx < 0 || idx >= arr.length) {
			System.out.println("인덱스 오류");
		} else {
			System.out.println("성적 : " + arr[idx] + "점");
		}

		// 2
		System.out.print("성적 입력 : ");
		int score = sc.nextInt();
		idx = arr.length;
		for (int i = 0; i < arr.length; i += 1) {
			if (score == arr[i]) {
				idx = i;
			}
		}
		System.out.println(idx == arr.length ? "성적이 존재하지 않습니다" : "인덱스 : " + idx);

		// 3
		System.out.print("학번 입력 : ");
		int hakbun = sc.nextInt();
		idx = hakbuns.length;
		for (int i = 0; i < hakbuns.length; i += 1) {
			if (hakbun == hakbuns[i]) {
				idx = i;
			}
		}
		System.out.println(idx == hakbuns.length ? "학번이 존재하지 않습니다" : "성적 : " + scores[idx]);
		sc.close();
	}
}
