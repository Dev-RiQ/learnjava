package level5시험;

public class _07 {

	public static void main(String[] args) {

		int size = 5;
		int[][] map = new int[size][size];
		int num = 1;
		int col = 0;
		int row = 0;
		int dir = 0;
		while (num != size * size + 1) {
			if (map[col][row] == 0) {
				map[col][row] = num++;
			}
			int pCol = col;
			int pRow = row;
			int pDir = dir;
			switch (dir) {
			case 0:
				pRow++;
				break;
			case 1:
				pCol++;
				break;
			case 2:
				pRow--;
				break;
			case 3:
				pCol--;
				break;
			}
			if (pRow > size - 1 || (pRow < size && dir == 0 && map[pCol][pRow] != 0)) {
				dir = 1;
			} else if (pCol > size - 1 || (pCol < size && dir == 1 && map[pCol][pRow] != 0)) {
				dir = 2;
			} else if (pRow < 0 || (pRow >= 0 && dir == 2 && map[pCol][pRow] != 0)) {
				dir = 3;
			} else if (pCol < 0 || (pCol >= 0 && dir == 3 && map[pCol][pRow] != 0)) {
				dir = 0;
			}
			if (pDir == dir) {
				col = pCol;
				row = pRow;
			}
		}
		for (int[] mapCol : map) {
			for (int mapRow : mapCol) {
				System.out.printf("%-2d ", mapRow);
			}
			System.out.println();
		}

		// 소요 시간 : 18분 03초
	}

}
