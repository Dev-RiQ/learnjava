package 메서드문제;

class Test02 {
	void printSum(int[] a) {
		int sum = 0;
		for (int num : a)
			sum += num;
		System.out.println("arr 전체 합 = " + sum);
	}

	void printSumMultiple4(int[] a) {
		int sum4 = 0;
		for (int num : a)
			if (num % 4 == 0)
				sum4 += num;
		System.out.println("arr 4의 배수 합 = " + sum4);
	}

	void printCountMultiple4(int[] a) {
		int cnt4 = 0;
		for (int num : a)
			if (num % 4 == 0)
				cnt4++;
		System.out.println("arr 4의 배수 개수 = " + cnt4);
	}

	void printCountEven(int[] a) {
		int cntEven = 0;
		for (int num : a)
			if (num % 2 == 0)
				cntEven++;
		System.out.println("arr 짝수 개수 = " + cntEven);
	}
}

public class _02메서드기본문제2 {

	public static void main(String[] args) {

		Test02 t = new Test02();
		int[] arr = { 87, 100, 11, 72, 92 };

		// 1) 전체 합
		t.printSum(arr);

		// 2) 4의 배수의 합
		t.printSumMultiple4(arr);

		// 3) 4의 배수의 개수
		t.printCountMultiple4(arr);

		// 4) 짝수의 개수
		t.printCountEven(arr);
	}

}
