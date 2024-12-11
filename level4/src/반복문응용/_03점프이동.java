package 반복문응용;

import java.util.Random;

public class _03점프이동 {

	public static void main(String[] args) {

		/*
		 	map배열은 게임의 지도를 의미하고, 그 값은 추가로 이동할 수 있는 거리를 의미
		 	player 변수는 map배열의 현재 위치 의미
		 	주사위(1~3)을 랜덤 저장해, player위치를 출력
		 */
		Random rd = new Random();
		int[] map = { 0, 3, 0, 3, 0, 0, -1, 1, 0, 0 };
		int player = 0;
		int dice = rd.nextInt(3) + 1;
		System.out.println("주사위 : " + dice);
		System.out.println("player는 " + dice + "칸 이동한다.");
		player += dice;
		while (true) {
			if (map[player] != 0) {
				System.out.println("map[" + player + "]은 " + map[player] + "이므로 " + (map[player] < 0 ? "뒤로 " : "추가로 ")
						+ (map[player] < 0 ? -map[player] : map[player]) + "칸을 더 이동한다.");
				player += map[player];
				continue;
			}
			break;
		}
		System.out.println("즉 player의 위치는 " + player + "가 된다.");
		
	}

}
