package 배열심화문제;

import java.util.Arrays;

public class _04석차출력 {

	public static void main(String[] args) {

		/*
		 	성적 순으로 번호 출력
		 */
		
		int[] numList = {1001,1002,1003,1004};
		int[] scoreList = {42,11,98,87};
		for(int i = 0;i<numList.length;i++) {
			for(int k = i;k<numList.length;k++) {
				if(scoreList[i]<scoreList[k]) {
					int tempNum = numList[k];
					numList[k] = numList[i];
					numList[i] = tempNum;
					int tempScore = scoreList[k];
					scoreList[k] = scoreList[i];
					scoreList[i] = tempScore;
				}
			}
			
		}
		System.out.println(Arrays.toString(numList));
		System.out.println(Arrays.toString(scoreList));
	}

}
