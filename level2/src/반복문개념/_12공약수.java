package 반복문개념;

public class _12공약수 {

	public static void main(String[] args) {

		/*
		 	6과 8의 공약수를 모두 출력하시오.
		 */

		int i = 1;
		int num1 = 1024;
		int num2 = 256;
		int max = 0;
		int cnt = 0;
		int min = num1;
		if(min>num2) {
			min = num2;
		}

		while (i <= min) {
			if (num1 % i == 0 && num2 % i == 0) {
				max = i;
				cnt += 1;
			}
			i += 1;
		}
		System.out.println("num1 = "+num1+" || num2 = "+num2);
		System.out.println("공약수의 개수 >> " + cnt + "개");
		i = 1;
		System.out.print("공약수 >> ");
		
		
		while (i <= max) {
			if (num1 % i == 0 && num2 % i == 0) {
				System.out.print(i);
				if (i != max) {
					System.out.print(", ");
				}
			}
			i += 1;
		}
		
		
		System.out.println();
		System.out.println("최대공약수 >> " + max);
	}

}
