package 배열1문제;

public class _11학생성적관리4단계 {

	public static void main(String[] args) {
		
		int[] hakbuns = { 1001, 1002, 1003, 1004, 1005 };
		int[] scores = { 87, 11, 45, 98, 23 };
		// 5등 학생의 학번과 성적 출력
		int min = 100;
		int idx = hakbuns.length;
		for (int i = 0; i < hakbuns.length; i += 1) {
			if (min > scores[i]) {
				min = scores[i];
				idx = i;
			}
		}
		System.out.printf("%d번(%d점) \n", hakbuns[idx], scores[idx]);
	}
}
