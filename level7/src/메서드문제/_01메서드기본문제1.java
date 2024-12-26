package 메서드문제;

class Test01 {
	void printEvenOrOdd(int a) {
		System.out.println("a = " + a);
		System.out.println(a % 2 == 0 ? "짝수" : "홀수");
	}

	void printSum(int x, int y) {
		int sum = 0;
		int start = x < y ? x : y;
		int end = x < y ? y : x;
		for (int i = start; i <= end; i++)
			sum += i;
		System.out.printf("%d ~ %d 총합은 %d \n", x, y, sum);
	}

	void printPrimeNums(int a) {
		if (a < 2)
			System.out.println("2보다 큰 값을 입력해주세요");
		else {
			System.out.println("2부터 " + a + " 까지의 소수를 출력");
			for (int i = 2; i <= a; i++) {
				int cnt = 0;
				for (int k = 1; k < i; k++)
					if (i % k == 0)
						cnt++;
				if (cnt == 1)
					System.out.print(i + " ");
			}
			System.out.println();
		}
	}
}

public class _01메서드기본문제1 {

	public static void main(String[] args) {

		Test01 t = new Test01();

		// 1) test01에서 a가 홀수인지 짝수인지 출력
		int a = 19;
		t.printEvenOrOdd(a);
		t.printEvenOrOdd(a + 1);

		// 2) x부터 y까지 합을 출력
		int x = 1;
		int y = 10;
		t.printSum(x, y);
		t.printSum(y, x);

		// 3) num까지의 소수 모두 출력
		int num = 20;
		t.printPrimeNums(num);
		t.printPrimeNums(-10);

	}

}
