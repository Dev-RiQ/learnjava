package _level2시험;

public class _03문제 {

	public static void main(String[] args) {

		/*
		   [문제]
		  		1980의 약수 중 순서대로 약수 출력했을 떄,
		  		백의 자리가 3인 두 번쨰 약수를 출력하시오.
		 */
		int num = 1980;
		int i = 1;
		int cnt = 0;
		int num2 = 0;
		while (i <= num) {
			if (num % i == 0 && i / 100 % 10 == 3) {
				cnt += 1;
				if (cnt == 2) {
					num2 = i;
				}
			}
			i += 1;
		}
		System.out.println("백의 자리가 3인 두 번째 약수 : " + num2);

		
		
		// 소요 시간 :2분 45초
	}

}
