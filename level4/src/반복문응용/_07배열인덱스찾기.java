package 반복문응용;

public class _07배열인덱스찾기 {

	public static void main(String[] args) {

		/*
		 	[문제]
		 		배열 b의 값들은 arr의 인덱스이다.
		 		arr배열에서 b의 값들이 가르키는 인덱스의 값을 출력하시오
		 */
		int[] arr = { 10, 20, 30, 40, 50 };
		int[] b = { 1, 4, 0 };
		for (int i = 0; i < b.length; i++) {
			System.out.print(i == 0 ? arr[b[i]] : ", " + arr[b[i]]);
		}
		
	}

}
