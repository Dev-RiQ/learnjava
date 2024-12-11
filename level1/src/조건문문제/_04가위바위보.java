package 조건문문제;

import java.util.Scanner;

public class _04가위바위보 {

	public static void main(String[] args) {

		/*
		 * 가위(0), 바위(1), 보(2) 게임 [1단계]
		 * 1. com은 바위(1)만 낼 수 있다.
		 * 2. me는 0~2 사이의 숫자를 입력받는다.
		 * 3. com과 me를 비교해,
		 * 		1) 비겼다.
		 * 		2) 내가 이겼다.
		 *		3) 내가 졌다.		를 출력한다. 
		 *
		 */
		
		Scanner sc = new Scanner(System.in);

		System.out.println("가위(0) / 바위(1) / 보(2) 중 원하는 숫자 하나를 입력하세요.");
		int com = 1;
		int me = sc.nextInt();

		//오류 설정
		boolean err = me < 0 || me > 2;
		if (err) {
			System.out.println("\n입력 오류");
		}
		
		if (!err && com > me) {
			System.out.println("\n내가 졌다.");
		}
		if (!err && com == me) {
			System.out.println("\n비겼다.");
		}
		if (!err && com < me) {
			System.out.println("\n내가 이겼다.");
		}

		sc.close();
		
		
		
		
		
		
	}

}
