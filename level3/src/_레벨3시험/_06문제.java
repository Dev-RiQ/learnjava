package _레벨3시험;

import java.util.Random;
import java.util.Scanner;

public class _06문제 {

	public static void main(String[] args) {

		/*
		 	[문제]
		 		1. arr배열에 1~100사이 랜덤값 6개 저장
		 		2. 배열 값을 차례로 출력
		 		3. (1)홀 (2)짝 선택
		 		4. 6회 반복해 정답 개수 출력
		 */
		Random rd = new Random();
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[6];
		int cnt = 0;
		for (int i = 0; i < arr.length; i++) {       
			arr[i] = rd.nextInt(100) + 1;
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.println((i + 1) + "번 : " + arr[i]);
			System.out.println("(1)홀  (2)짝");
			int ans = sc.nextInt();
			if (ans < 1 || ans > 2) {
				System.out.println("1, 2 만 입력하세요");
				i--;
				continue;
			}
			System.out.println(arr[i] % 2 == 2 - ans ? "정답" : "오답"); //1입력 -> 나머지1   2입력 -> 나머지0 2-ans
			cnt = arr[i] % 2 == 2 - ans ? ++cnt : cnt;
		}
		System.out.println("정답 맞춘 횟수 : " + cnt + "개");
		sc.close();
		// 소요 시간 : 5분 12초
	}

}
