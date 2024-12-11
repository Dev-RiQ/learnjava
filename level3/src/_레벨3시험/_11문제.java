package _레벨3시험;

public class _11문제 {

	public static void main(String[] args) {
		/*
		 	[문제]
		 		아래 데이터는 학생번호 1개, 점수 2개가 한 셋트이다.
		 		번호는 1001부터 시작이고, 점수는 0~100이다
		 		성적은 두 점수의 합으로 계산하며,
		 		1등 학생의 번호를 출력하시오
		 */
		int[] arr = { 1001, 20, 30, 1002, 43, 100, 1003, 45, 23 };
		int scoreTotal = 0;
		int idx = 0;
		for (int i = 0; i < arr.length; i += 3) {
			if (scoreTotal < arr[i + 1] + arr[i + 2]) {
				scoreTotal += arr[i + 1] + arr[i + 2];
				idx = i;
			}
		}
		System.out.println(arr[idx]);
		// 소요 시간 : 6분 20초
	}
}
