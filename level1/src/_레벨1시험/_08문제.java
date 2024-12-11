package _레벨1시험;

import java.util.Random;
import java.util.Scanner;

public class _08문제 {

	public static void main(String[] args) {
		/*
	 	[문제]
	 		가위(0) 바위(1) 보(2)
	 		1. com은 랜덤으로 0~2
	 		2. me는 0~2 입력
	 		3. com 과 me 비교
	 		  비겼다
	 		  내가 이겼다
	 		  내가 졌다 		출력
	 */

		Scanner sc = new Scanner(System.in);
		Random rd = new Random();

		int com = rd.nextInt(3);

		System.out.print("가위(0) 바위(1) 보(2) 입력 >> ");
		int me = sc.nextInt();

		if (me < 0 || me > 2) {
			System.out.println("오류 : 0,1,2중 하나를 입력하세요.");
		} else {
			System.out.printf("com : %d me : %d\n", com, me);
			if (me == com) {
				System.out.println("비겼다.");
			} else if (me - com == 1 || com - me == 2) {
				System.out.println("내가 이겼다.");
			} else {
				System.out.println("내가 졌다.");
			}
		}
		sc.close();

		// 시간 : 2분 30초
	}

}
