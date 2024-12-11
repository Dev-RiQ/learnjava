package 배열2문제;

public class _18미니빙고 {

	public static void main(String[] args) {

		/*
		 	[문제]
		 		배열을 3줄씩 출력
		 		가로 3이 연속 3개면 "빙고" 출력
		 */
		int arr[] = { 0, 0, 0, 0, 0, 0, 3, 3, 3 };
		for (int i = 0; i < arr.length; i++) {
			System.out.print(i != arr.length - 1 ? " " + arr[i] + " ," : " " + arr[i]);
			if (i % 3 == 2) {
				System.out.println();
			}
		}
		for (int i = 0; i < arr.length; i++) {
			if (i % 3 == 2 && arr[i - 2] == 3 && arr[i - 1] == 3 && arr[i] == 3) {
				System.out.println("빙고");
			}
		}
		
	}

}
