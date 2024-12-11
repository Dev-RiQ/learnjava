package 배열심화2;

public class _03순위구하기 {

	public static void main(String[] args) {

		//학번의 석차 출력
		String nums[] = { "1001", "1002", "1003", "1004", "1005" };
		int[] score = { 100, 54, 21, 54, 10 };
		for (int i = 0; i < score.length; i++) {
			int winCnt = 1;
			for (int k = 0; k < score.length; k++) {
				if (score[i] < score[k]) {
					winCnt++;
				}
			}
			System.out.println(nums[i] + "(" + score[i] + "점) " + winCnt + "등");
		}
	}

}
