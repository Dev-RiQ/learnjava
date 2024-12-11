package 반복문문제03;

public class _06do_while반복문연습 {

	public static void main(String[] args) {

		/*
		 	1~10까지 반복문 실행하여 숫자 출력
		 	1~5까지는 "안녕" 함께 출력
		 	6~10까지는 "잘가" 함께 출력
		 */
		
		int i = 1;
		do {
			System.out.print(i);
			System.out.println("안녕");
			i += 1;
		} while (i < 6);
		do {
			System.out.print(i);
			System.out.println("잘가");
			i += 1;
		} while (i < 11);
		
		System.out.println("=====");
		
		i = 1;
		do {
			System.out.print(i);
			System.out.println(i < 6 ? "안녕" : "잘가");
			i += 1;
		} while (i < 11);
		
		System.out.println("=====");
		
		for(i=1;i<11;i++) {
			System.out.print(i);
			System.out.println(i < 6 ? "안녕" : "잘가");
		}
		System.out.println("=====");
		
		i = 1;
		while(i<11) {
			System.out.print(i);
			System.out.println(i < 6 ? "안녕" : "잘가");
			i+=1;
		}
	}

}
