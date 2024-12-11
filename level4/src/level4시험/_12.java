package level4시험;

public class _12 {

	public static void main(String[] args) {
		/*
		 	구구단 옆으로 출력
		 */
		for (int i = 1; i < 10; i++) {
			for (int k = 2; k < 10; k++) {
				System.out.printf("%d * %d = %d\t", k, i, i * k);
			}
			System.out.println();
		}
		// 소요 시간 : 1분 36초
	}

}
