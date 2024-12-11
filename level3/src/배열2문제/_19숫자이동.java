package 배열2문제;

import java.util.Arrays;
import java.util.Scanner;

public class _19숫자이동 {

	public static void main(String[] args) {

		/*
		 	[문제]
		 		1. game배열에 숫자 2는 플레이어
		 		2. 플레이어는 좌(1),우(2)로 이동 가능
		 		3. 좌우 끝에 도달하면 반대편으로 이동
		 		4. 0누르면 게임 좋요
		 */
		Scanner sc = new Scanner(System.in);
		int[] game = { 0, 0, 0, 0, 2, 0, 0, 0, 0 };
		int player = 2;
		int road = 0;
		int set = 4;
		while (true) {
			System.out.println(Arrays.toString(game));
			System.out.print("좌(1) 우(2) 이동 선택 (종료(0)) >> ");
			int move = sc.nextInt();
			if (move < 0 || move > 2) {
				System.out.println("입력 오류");
				continue;
			}
			if (move == 0) {
				System.out.println("게임 종료");
				break;
			}
			game[set] = road;
			if (move == 1) {
				if(set>0) {
					set--;
				}else {
					set = game.length-1;
				}
			} else {
				if(set<game.length-1) {
					set++;
				}else {
					set = 0;
				}
			}
			game[set] = player;
		}
		sc.close();
	}

}
