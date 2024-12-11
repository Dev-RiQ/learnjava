package 반복문문제03;

public class _05규칙찾기5 {

	public static void main(String[] args) {

		/*
		 	[문제]
		 		0 1 
				1 2 
				2 3 
				3 1 
				4 2 
				5 3 
				6 1 
				7 2 
				8 3 
				9 1 
		 */
		for (int i = 0; i < 10; i++) {
			System.out.printf("%d %d \n", i, i % 3 + 1);
		}
		
	}

}
