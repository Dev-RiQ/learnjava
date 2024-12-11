package 반복문문제01;

public class _10배수십의자리 {

	public static void main(String[] args) {

		/*
		 	[문제]
		 		숫자 100이상 900이하인 9의 배수 중에서
		 		10의 자리가 6인 첫 번째 배수를 출력하시오.
		 */
		int min = 100;
		int max = 900;
		int i = min;

		while (i <= max) {
			if (i % 9 == 0 && i / 10 % 10 == 6) {
				System.out.println(i);
				i = max + 1;
			}
			i += 1;
		}
		//=============
		i = min;
		int cnt = 1;

		while (cnt == 1) {
			if (i % 9 == 0 && i / 10 % 10 == 6) {
				System.out.println(i);
				cnt += 1;
			}
			i += 1;
		}
		//=============
		
		i = 100; // 3번째 출력
		cnt = 1;

		while (cnt <= 3) {
			if (i % 9 == 0 && i / 10 % 10 == 6) {
				if (cnt == 3) {
					System.out.println(i);
				}
				cnt += 1;
			}
			i += 1;
		}
	
		//=============
			
		i = min;
		boolean run = true;
		while (run) {
			if (i % 9 == 0 && i / 10 % 10 == 6) {
				System.out.println(i);
				run = false;
			}
			i += 1;
		}

	}

}
