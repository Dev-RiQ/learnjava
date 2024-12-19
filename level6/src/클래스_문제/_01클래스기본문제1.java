package 클래스_문제;

class Test01{
	int[] arr = {87,100,11,72,92};
}

public class _01클래스기본문제1 {

	public static void main(String[] args) {
		
		Test01 t1 = new Test01();

		// 전체 합 출력
		int sum = 0;
		for (int i = 0; i < t1.arr.length; i++) {
			sum += t1.arr[i];
		}
		System.out.println(sum);

		// 4의 배수 합 출력
		sum = 0;
		int cnt = 0;
		for (int i = 0; i < t1.arr.length; i++) {
			if (t1.arr[i] % 4 == 0) {
				sum += t1.arr[i];
				cnt++;
			}
		}
		System.out.println(sum);

		// 4의 배수 개수 출력
		System.out.println(cnt);
	}

}
