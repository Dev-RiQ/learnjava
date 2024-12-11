package 반복문개념;

public class _03누적변수 {

	public static void main(String[] args) {

		// 반복변수 => i j k n => 반복문의 횟수에 영향을 미치는 수

		// 누적 변수 => 반복문 안에서 누적하면서 사용하는 변수 => 갯수, 총합 count, cnt, sum, hap ... => 초기값 0으로 시작
		
		//1부터 10까지의 합

		int i = 1;
		int sum = 0;
		System.out.println("i : sum");

		while (i <= 10) {
			sum += i;
			System.out.printf("%d : %d \n", i, sum);
			i += 1;
		}

	}

}
