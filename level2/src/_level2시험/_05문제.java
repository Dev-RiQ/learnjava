package _level2시험;

import java.util.Random;
import java.util.Scanner;

public class _05문제 {

	public static void main(String[] args) {

		/*
		   [문제]
		  		1. com은 랜덤 1~100사이 저장
		  		2. me는 1~100사이 입력
		  		3. com 과 me 를 비교해 com이 크면 "크다", 작으면 "작다" 힌트제공
		  		4. 정답 시 게임 종료
		  		5. 오답시 -20점, 0점되면 게임 오버 게임종료
		  		6. 게임 종료 후 성적 출력. 처음에 바로 맞추면 100점
		 */

		Scanner sc = new Scanner(System.in);
		Random rd = new Random();

		int score = 100;
		int com = rd.nextInt(100) + 1;
		System.out.println(com);
		while (true) {
			System.out.println("1~100 사이 입력");
			int me = sc.nextInt();
			if (me < 1 || me > 100) {
				System.out.println("입력 오류");
				continue;
			}
			if (com != me) {
				System.out.println(com > me ? "크다" : "작다");
				score -= 20;
				if (score == 0) {
					System.out.println("게임 오버");
					break;
				}
				continue;
			}
			if (com == me && score == 100) {
				System.out.println("한 번에 정답");
			}
			if (com == me && score != 100) {
				System.out.println("정답");
			}
			break;
		}
		System.out.println("정답 : " + com);
		System.out.println("최종 점수 : " + score);
		sc.close();

		// 소요 시간 : 17분 4초
	}

}
