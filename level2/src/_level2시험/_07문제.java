package _level2시험;

import java.util.Random;

public class _07문제 {

	public static void main(String[] args) {

		/*
		   [문제]
		  		철수는 오징어게임에 참가했다.
		  		첫 번째 게임은 "무궁화 꽃이 피었씁니다" 이다.
		  		규칙은 아래와 같다.
		  	[규칙]
		  		1. 전체 거리는 0~25
		  		2. 철수는 현재 0
		  		3. 철수는 매 턴 1~4 랜덤만큼 이동
		  		4. 이동 거리 누적하여, 25이상이면 승리,종료
		  		5. 인형은 매 턴 3~5 랜덤
		  		6. 인형보다 큰 숫자 나오면 움직인것으로 간주 패배, 종료
		  		7. 10턴 안에 도착 못하면 시간초고 ㅏ패배, 종료
		  		8. 철수의 이동경로 전부 출력
		 */
		
		Random rd = new Random();

		int now = 0;
		int cnt = 0;
		
		while (true) {
			int move = rd.nextInt(4) + 1;
			int doll = rd.nextInt(3) + 3;
			now += move;
			cnt += 1;
			System.out.println("철수 : " + move + " 인형 : " + doll);
			if (move > doll) {
				System.out.println("움직여서 패배");
			}else if (now >= 25) {
				System.out.println("승리");
			}else if (cnt >= 10) {
				System.out.println("시간 초과 패배");
			}else {
				continue;
			}
			break;
		}
		System.out.println("게임 종료");

		// 소요 시간 : 6분 44초
	}

}
