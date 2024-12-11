package 반복문문제03;

public class _01규칙찾기1 {

	public static void main(String[] args) {

		/*
		 	[문제]
		 		for문을 사용해서 아래와 같이 출력
		 	[예시]
		 		0 0 1
		 		1 2 3
		 		2 4 5
		 		3 6 7
		 		4 8 9
		 */
		for (int i = 0; i <5; i++) {
			System.out.printf("%d %d %d \n",i,i*2,i*2+1);
		}
		
		
	}

}
