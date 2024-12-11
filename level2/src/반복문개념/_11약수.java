package 반복문개념;

public class _11약수 {

	public static void main(String[] args) {

		/*
		 	48의 약수를 아래와 같이 전부 출력하시오.
		 	예) 8의 약수 => 1, 2, 4, 8
		 	
		 	그리고 48의 약수 갯수를 출력하세요
		 */
		
		int i = 1;
		int num = 48;
		int cnt = 0;
		System.out.print(num + "의 약수 => ");
		while (i <= num) {
			if (num % i == 0) {
				cnt += 1;
				System.out.print(i);
				if (i != num) {
					System.out.print(", ");
				}
			}
			i += 1;
		}
		System.out.println("\n" + num + "의 약수 갯수 " + cnt + "개");
	}

}
