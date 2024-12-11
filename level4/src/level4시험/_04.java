package level4시험;

import java.util.Arrays;

public class _04 {

	public static void main(String[] args) {
		/*
		 	1. 모든 점수 총합 출력
		 	2. 수학 1등 번호 출력
		 	3. 전체 1등 번호 출력
		 	4. 수학 점수가 국어 점수보다 높은 번호 출력
		 	5. 총 점수가 높은 순서대로 번호 출력
		 */
		int[][] arr = {
			//	번호   국 수 영
				{1001,100,20,32}, // 152
				{1002, 40,43,12}, // 95
				{1003, 60,21,42}, // 123
				{1004, 76,54,55}, // 185
				{1005, 23,11,76}, // 110
				
		};
		int sum = 0;
		int maxMath = 0;
		int idxMath = -1;
		int idxMK = -1;
		int[] totalScore = new int[5];
		int[] num = new int[5];
		for (int i = 0; i < arr.length; i++) {
			if (arr[i][2] > maxMath) {
				maxMath = arr[i][2];
				idxMath = i;
			}
			if (arr[i][2] > arr[i][1]) {
				idxMK = i;
			}
			for (int k = 0; k < arr[i].length; k++) {
				if (k != 0) {
					totalScore[i] += arr[i][k];
				}
			}
			num[i] = arr[i][0];
		}
		for(int i = 0;i<totalScore.length;i++) {
			for(int k = i+1;k<totalScore.length;k++) {
				if(totalScore[i]<totalScore[k]) {
					int temp = totalScore[i];
					totalScore[i] = totalScore[k];
					totalScore[k] = temp;
					temp = num[i];
					num[i] = num[k];
					num[k] = temp;
				}
			}
			sum += totalScore[i];
		}
		// 1
		System.out.println("모든 점수 합 = " + sum);
		// 2
		System.out.println("수학 1등 = " + arr[idxMath][0]);
		// 3
		System.out.println("전체 1등 = " + num[0]);
		// 4
		System.out.println("수학점수 > 국어점수 = " + arr[idxMK][0]);
		// 5
		System.out.println("높은 순 : " + Arrays.toString(num));
		// 소요 시간 : 8분 27초
	}

}
