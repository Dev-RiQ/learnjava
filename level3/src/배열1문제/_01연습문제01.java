package 배열1문제;

public class _01연습문제01 {

	public static void main(String[] args) {

		// 10~50까지 array 배열에 저장, 저장 값 총합
		
		int[] array = new int[5];
		int sum = 0;
		for (int i = 0; i < 5; i += 1) {
			array[i] = (i + 1) * 10;
			sum += array[i];
			System.out.print(array[i] + " ");
		}
		System.out.println();
		System.out.println(sum);
		
	}

}
