package 반복문응용;

public class _01인풋더하기 {

	public static void main(String[] args) {

		/*
		 	[문제]
		 		민수는 학교에서 산수시험을 봤다
		 		arr1의 숫자와 arr2의 숫자의 합을 구하는 시험이다
		 		
		 		input 배열은 민수가 작성한 답이다.
		 		민수는 답을 순차적으로 적지 않고 뒤섞여서 적었따
		 		위 더하기 문제의 답을 답안지에서 찾아 민수는 몇 문제 맞췄는지 출력
		 */
		int[] arr1 = { 4, 65, 23, 1, 45, 7 };
		int[] arr2 = { 61, 2, 54, 3, 5, 6 };
		int[] input = { 67, 13, 2, 22, 65, 4 };
		int cnt = 0;
		for (int i = 0; i < arr1.length; i++) {
			for (int k = 0; k < input.length; k++) {
				if (input[k] == arr1[i] + arr2[i]) {
					System.out.print(cnt == 0 ? input[k] : ", " + input[k]);
					cnt++;
				}
			}
		}
		System.out.println();
		System.out.println("정답 : " + cnt + "개");
		
	}

}
