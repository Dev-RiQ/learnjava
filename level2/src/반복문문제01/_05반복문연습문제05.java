package 반복문문제01;

public class _05반복문연습문제05 {

	public static void main(String[] args) {
		
		/*
		 	문제1) 1~5까지의 합 출력
		 	2) 1~10까지 반복해 3미만 7이상만 출력
		 	3) 문제 2의 조건에 맞는 수들의 합 출력
		 	4) 문제 2의 조건에 맞는 수들의 개수 출력
		 */
		
		int i = 1;
		int sum = 0;
		System.out.print("1) 1~5까지의 합 >> ");
		while (i <= 5) {
			sum += i;
			i += 1;
		}
		System.out.println(sum);
		
		System.out.println("==============");
		
		System.out.print("2) 1~10 중 3미만 7이상의 값\n>> ");
		i = 1;
		while (i <= 10) {
			if (i < 3 || i >= 7) {
				System.out.print(i);
				if (i != 10) {
					System.out.print(", ");
				}
			}
			i += 1;
		}

		System.out.println("\n==============");
		
		System.out.print("3) 2번에 해당하는 값의 합 >> ");
		i = 1;
		sum = 0;
		while (i <= 10) {
			if (i < 3 || i >= 7) {
				sum += i;
			}
			i += 1;
		}
		System.out.println(sum);

		System.out.println("==============");

		System.out.print("4) 2번에 해당하는 값의 갯수 >> ");
		i = 1;
		int cnt = 0;
		while (i <= 10) {
			if (i < 3 || i >= 7) {
				cnt += 1;
			}
			i += 1;
		}
		System.out.println(cnt);
	}

}
