package _level2시험;

import java.util.Scanner;

public class _08문제 {

	public static void main(String[] args) {

		/*
		   [문제]
		  		1. p1과 p2는 번갈아 1~3 입력
		  		2. br은 p1과p2의 입력값을 누적해서 저장
		  		3. br이 31 넘으면 게임 종료
		  		4. 승리자 출력
		 */
		
		Scanner sc = new Scanner(System.in);

		int br = 0;
		int turn = 1;
		while (br < 31) {
			System.out.println("p" + turn + "의 차례");
			System.out.print("1~3 입력 >> ");
			int input = sc.nextInt();
			if (input < 1 || input > 3) { // 1, 2, 3
				System.out.println("입력 오류");
				continue;
			}
			br += input; // 1,2,3
			System.out.println("현재 숫자 : " + br);
			turn = turn == 1 ? turn + 1 : turn - 1;
			System.out.println();
		}
		System.out.println("게임 종료");
		System.out.println("p" + turn + " 승리");
		sc.close();

		// 소요 시간 : 4분 35초
	}

}
