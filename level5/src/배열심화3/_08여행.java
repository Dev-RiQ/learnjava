package 배열심화3;

public class _08여행 {

	public static void main(String[] args) {

		int[][] map = {
				{ 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 7, 7, 7, 7, 0, 0 },
				{ 0, 7, 0, 0, 7, 0, 0 },
				{ 0, 7, 0, 8, 7, 0, 0 },
				{ 0, 0, 0, 0, 7, 0, 0 },
				{ 0, 0, 0, 0, 7, 7, 0 },
				{ 0, 0, 0, 0, 0, 0, 0 }
		};
		int dir = 0;
		int input[] = { 1, 1, 2, 1, 1, 2, 1, 1, 3, 1, 1 };
		String[] draw = { "▲", "▶", "▼", "◀" };
		String[] msg = { "전진", "좌회전", "우회전" };
		String[] point = { "북", "동", "남", "서" };
		int y = 3;
		int x = 3;
		for (int move : input) {
			for (int[] showR : map) {
				for (int showC : showR) {
					System.out.print(showC == 0 ? " □ " : showC == 7 ? " ■ " : " " + draw[dir] + " ");
				}
				System.out.println();
			}
			if (move == 1) {
				int py = y;
				int px = x;
				if (dir == 0) {
					py--;
				} else if (dir == 1) {
					px++;
				} else if (dir == 2) {
					py++;
				} else if (dir == 3) {
					px--;
				}
				if (map[py][px] == 0) {
					map[y][x] = 0;
					y = py;
					x = px;
					map[y][x] = 8;
				}
			} else {
				dir += move == 2 ? -1 : +1;
				if (dir < 0) {
					dir = 3;
				} else if (dir > 3) {
					dir = 0;
				}
			}
			System.out.println("=================");
			System.out.printf("input %d msg %s dir %s *****\n", move, msg[move - 1], point[dir]);
		}
		for (int[] showR : map) {
			for (int showC : showR) {
				System.out.print(showC == 0 ? " □ " : showC == 7 ? " ■ " : " " + draw[dir] + " ");
			}
			System.out.println();
		}
	}

}
