package _레벨1시험;

import java.util.Random;
import java.util.Scanner;

public class _06문제 {

	public static void main(String[] args) {
		/*
	 	[문제]
	 		1. 0 또는 1의 랜덤 숫자를 저장한다.
	 		2. 0은 동전 앞면, 1은 동전의 뒷면이다.
	 		3. 동전의 앞뒷면을 맞추는 게임이다.
	 			사용자에게 0.앞면 1.뒷면 입력받아서 정답, 오답 출력
	 */

		Scanner sc = new Scanner(System.in);
		Random rd = new Random();

		int com = rd.nextInt(2);

		System.out.println("===앞 뒷면 맞추기 게임===");
		System.out.println("동전의 앞면 : 0 , 뒷면 : 1 을 입력하세요.");

		int me = sc.nextInt();

		if (me != 0 && me != 1) {
			System.out.println("0또는1만 입력하세요.");
		} else {
			System.out.printf("이번 동전은 : %d \n나의 선택은 : %d\n", com, me);
			if (com == me) {
				System.out.println("정답");
			} else {
				System.out.println("오답");
			}
		}
		sc.close();

		// 시간 : 2분 33초
	}

}
