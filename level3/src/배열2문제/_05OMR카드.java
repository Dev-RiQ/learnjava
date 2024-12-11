package 배열2문제;

import java.util.Arrays;
import java.util.Random;

public class _05OMR카드 {

	public static void main(String[] args) {

		/*
		 	[문제]
		 		1. test배열은 시험 문제의 정답지
		 		2. student배열에 1~5점 사이의 랜덤 숫자 5개를 저장
		 		3. 각 자리 수를 비교 점수를 result배열에 기록
		 			(맞으면 true, 틀리면 false저장)
		 		4. 점수는 한 문제당 20점
		 		5. 성적도 함께 출력
		 */
		Random rd = new Random();
		int[] test = new int[5];
		int[] student = new int[5];
		boolean[] result = new boolean[5];
		int score = 0;
		for (int i = 0; i < test.length; i++) {
			test[i] = rd.nextInt(5) + 1;
			student[i] = rd.nextInt(5) + 1;
//			boolean rs = test[i] == student[i];
//			result[i] = rs == true ? true : false;
//			score = rs == true ? score + 20 : score;
			if(test[i] == student[i]) {
				result[i] = true;
				score +=20;
			}

		}
		System.out.println("test    : " + Arrays.toString(test));
		System.out.println("student : " + Arrays.toString(student));
		System.out.println("result  : " + Arrays.toString(result));
		System.out.println("성적     : " + score + "점");

		
	}

}
