package 반복문문제02;

import java.util.Scanner;

public class _12최대값입력 {

	public static void main(String[] args) {

		/*
		 	1. 반복문 안에서 계속 값을 입력받는다 (-999~1000)
		 	2. 입력받은 숫자 중 가장 큰 숫자를 출력한다.
		 	3. -1000을 입력하면 종료한다.
		 	4. 최대값을 몇 번째에 입력했는지 출력한다, 최대값을 중복으로 입력했을 시
		 		첫 번째로 입력한 최대값의 변수를 출력한다.
		 	5. 반복문 시작하자마자 종료하면 not found 출력
		 */
		
		Scanner sc = new Scanner(System.in);
		int max = 0;
		int maxFirst = 0;
		int cnt = 1;
		while (true) {
			System.out.print("[ "+ cnt +" ]수입력 >> ");
			int inputNum = sc.nextInt();
			if (inputNum == -1000) {
				System.out.println("-----");
				System.out.println("반복문종료");
				break;
			}
			if (inputNum < -1000 || inputNum > 1000) {
				System.out.println("입력오류");
				continue;
			}
			if(cnt == 1) {
				max = inputNum;
				maxFirst = cnt;
			}
			if (max < inputNum) {
				max = inputNum;
				maxFirst = cnt;
			}
			cnt += 1;
		}
		if (cnt == 1) {
			System.out.println("not found");
		} else {
			System.out.println("최대값 : " + max);
			System.out.println("입력번째 : " + maxFirst);
		}
		sc.close();
	}

}
