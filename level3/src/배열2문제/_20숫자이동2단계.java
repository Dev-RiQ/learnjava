package 배열2문제;

import java.util.Scanner;

public class _20숫자이동2단계 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int[] game = { 0, 0, 1, 0, 2, 0, 1, 0, 1 };
		int pIdx = 4;
		int player = 2;
		int road = 0;
		int wall = 1;
		int move = 0;
		while (true) {
			for (int i = 0; i < game.length; i++) {
				if (game[i] == road) {
					System.out.print("__");
				} else if (game[i] == wall) {
					System.out.print("||");
				} else {
					if (move == 1) {
						System.out.print("👩‍🦽");
					} else {
						System.out.print("🧑‍🦽‍➡️");
					}
				}
			}
			System.out.println();
			System.out.println("1.왼쪽 2.오른쪽");
			move = sc.nextInt();
			if (move == 0) {
				System.out.println("게임 종료");
				break;
			}
			if (move > 2 || move < 1) {
				System.out.println("입력 오류");
				continue;
			}
			int idx = pIdx;
			game[pIdx] = road;
			if (move == 1) {
				if (pIdx > 0) {
					pIdx--;
				} else {
					pIdx = game.length - 1;
				}
			} else {
				if (pIdx < game.length - 1) {
					pIdx++;
				} else {
					pIdx = 0;
				}
			}
			if (game[pIdx] == wall) {
				System.out.println("벽을 격파하시겠습니까?");
				System.out.println("1.격파 2.돌아가기");
				int set = sc.nextInt();
				if (set < 1 || set > 2) {
					System.out.println("입력 오류");
					continue;
				}
				if (set == 2) {
					System.out.println("되돌아갑니다");
					pIdx = idx;
				}else {
					System.out.println("🎈🎈🎈🎈");
					System.out.println("🎊격★파🎊");
					System.out.println("🎈🎈🎈🎈");
				}
			}
			game[pIdx] = player;
		}
		sc.close();
		
		
		
		
	}

}
