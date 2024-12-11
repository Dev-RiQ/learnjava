package 반복문개념;

public class _10공배수 {

	public static void main(String[] args) {
		
		/*
		 	12와 15의 공배수를 구하세요.
		 	작은것부터 순서대로 5개만 출력하시오.
		 	
		 */
		int i = 1;
		int num1 = 12;
		int num2 = 15;
		int cnt = 0;
		
		while(true) {
			if (i % num1 == 0 && i % num2 == 0) {
				cnt += 1;
				System.out.print(i);
				if (cnt == 5) {
					break;
				}
				System.out.print(", ");
			}
			i += 1;
		}
	}

}
