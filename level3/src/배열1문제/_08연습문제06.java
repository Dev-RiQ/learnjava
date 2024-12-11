package 배열1문제;

public class _08연습문제06 {

	public static void main(String[] args) {

		/*
		 	[문제]
		 		arr와 answer을 각 자리별로 비교 후
		 		값이 같으면 temp에 1을 저장
		 		값이 다르면 temp에 -1을 저장후
		 		temp배열의 모든 값을 출력하시오
		 */
		
		int[] arr = { 10, 43, 22, 14 };
		int[] answer = { 10, 42, 21, 14 };

		int[] temp = new int[4];

		for (int i = 0; i < temp.length; i += 1) {
			temp[i] = arr[i] == answer[i] ? 1 : -1;
			System.out.print(i == 0 ? temp[i] : ", " + temp[i]);
		}
		
		
		
	}

}
