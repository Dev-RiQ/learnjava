package 반복문문제01;

public class _09배수2 {

	public static void main(String[] args) {

		/*
		 	[문제]
		 		7의 배수 중 작은 수부터 3개만 출력하시오.
		 */

		int i = 1;
		int num = 0;
		while(i<=3) {
			num+=7;
			System.out.print(num + " ");
			i+=1;
		}
		
		System.out.println("\n==============================");
		
		 i = 1;
		int end = 7*3;
		while (i <= end) {
			if (i % 7 == 0 && i!=21) {
				System.out.print(i + ", ");
			}else if(i % 7 == 0 && i ==21) {
				System.out.println(i);
			}
			i += 1;
		}

		System.out.println("\n==============================");

		i = 0;
		end = 7*3;
		while (i + 7 <= end) {
			i += 7;
			System.out.print(i + " ");
		}

		System.out.println("\n==============================");

		i = 1;
		int cnt = 0;
		boolean run = true;
		while (run) {
			if (i % 7 == 0 && cnt != 2) {
				cnt += 1;
				System.out.print(i + " ");
			}else if (i % 7 == 0 && cnt == 2) {
				cnt += 1;
				System.out.print(i);
			}
			if (cnt == 3) {
				run = false;
			}
			i += 1;
		}
		
	}

}
