package 배열2문제;

import java.util.Arrays;

public class _06학생검색 {

	public static void main(String[] args) {

		/*
		 	[문제]
		 		아래 배열은 3명의 학생 데이터이다
		 		각 학생은 3개씩 데이터로 표현한다.
		 		맨앞은 번호, 그다음 국어점수, 그다음 수학점수
		 		아래 3 학생 중 국어점수가 수학점수보다 높은 학생 번호를 answer배열에 저장 출력
		 */
		int[] arr = { 1001, 20, 30, 1002, 43, 23, 1003, 45, 1 };
		int[] answer = new int[arr.length];
		int idx = 0;
		for (int i = 0; i < arr.length; i++) {
			if (i % 3 == 1 && arr[i] > arr[i + 1]) {
				answer[idx++] = arr[i - 1];
			}
		}
		System.out.println("int[] answer = "+Arrays.toString(answer));
		
		
		
//		int[] arr = { 1001, 20, 30, 1002, 43, 23, 1003, 45, 1 };
//		//int[] arr = {hakbuns[0], korean[0], math[0],
//		//				hakbuns[1], korean[1], math[1]
//		//				,hakbuns[2], korean[2], math[2]}
//		int[] answer = new int[arr.length];
//		
//		//
//		
//		int idx = 0;
//		for (int i = 0; i < arr.length; i++) {
//			if (i % 3 == 1 && arr[i] > arr[i + 1]) {
//				answer[idx] = arr[i - 1];
//				idx += 1;
//			}
//		}
//		System.out.println("int[] answer = "+Arrays.toString(answer));
//		
	}

}
