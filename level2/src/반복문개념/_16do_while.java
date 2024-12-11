package 반복문개념;

public class _16do_while {

	public static void main(String[] args) {

		/*
		 	do{} => 조건과 상관없이 무조건 1번 실행되는 부분
		 	while(조건); => 조건 true일때만 do{} 다시 실행
		 */
		
		int i = 1;
		while(i<=10) {
			System.out.print(i+" ");
			i+=1;
		}
		System.out.println("\n============");
		
		i = 1;
		do {
			System.out.print(i+" ");
			i+=1;
		}while(i<=10);
		System.out.println("\n============");
		
	}

}
