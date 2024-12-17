package 배열심화3;

import java.util.Random;
import java.util.Scanner;

public class _18크레이지아케이드1단계 {

	public static void main(String[] args) {

		/*
		 	맵 크기 : 7
		 	상하좌우 이동 가능하며, 폭탄 설치 e, 폭파 q로 설정
		 	벽(3) 플레이어(2) 폭탄(9) 어아탬(4)
		 	폭탄 설치된 순서로 터지며, 폭파 시 십자가 형태
		 	벽 파괴시 아이템이 랜덤 생성, 아이템 먹으면 설치 폭탄 개수 증가
		 */
		Random rd = new Random();
		Scanner sc = new Scanner(System.in);

		final int SIZE = 7;
		final int PLAYER = 2;
		final int WALL = 3;
		final int ITEM = 4;
		final int BOMBEVENT = 8;
		final int BOMB = 9;
		final int ROAD = 0;
		final String LEFT = "a";
		final String RIGHT = "d";
		final String UP = "w";
		final String DOWN = "s";
		final String INSTALL_BOMB = "e";
		final String EXPLODE_BOMB = "q";
		final String END = "0";

		int map[][] = new int[SIZE][SIZE];
		int bombLen = 1;
		int bombCnt = 4;
		int bombSet = 0;
		int wallCnt = 14;
		int wallSet = 0;
		int itemCnt = 0;
		int playerLoc1 = rd.nextInt(SIZE);
		int playerLoc2 = rd.nextInt(SIZE);
		map[playerLoc1][playerLoc2] = PLAYER;

		while (wallSet != wallCnt) {
			int rdNum1 = rd.nextInt(SIZE);
			int rdNum2 = rd.nextInt(SIZE);
			if (map[rdNum1][rdNum2] != ROAD
					|| (rdNum1 < playerLoc1 + 2 && rdNum1 > playerLoc1 - 2 && rdNum2 == playerLoc2)
					|| (rdNum1 == playerLoc1 && rdNum2 < playerLoc2 + 2 && rdNum2 > playerLoc2 - 2)) {
				continue;
			}
			map[rdNum1][rdNum2] = WALL;
			wallSet++;
		}
		int y = playerLoc1;
		int x = playerLoc2;
		int bombs[][] = new int[20][2];
		boolean isStart = true;
		boolean isDead = false;
		boolean isEnd = false;
		while (true) {
			System.out.println("----------------------------------------");
			if (wallCnt == 0 && itemCnt == 0) {
				System.out.println("             Game Clear !");
				isEnd = true;
			} else if (isDead) {
				System.out.println("             Game Over...");
			} else {
				if (isStart) {
					System.out.println("             Game Start !");
					isStart = false;
				} else {
					System.out.println("             Crazy Arcade");
				}
			}
			System.out.println("----------------------------------------");
			System.out.println("◈ 설치가능 폭탄 개수\t\t" + bombCnt);
			System.out.println("◈ 설치한 폭탄 개수  \t\t" + bombSet);
			System.out.println("◈ 남아있는 벽돌 개수\t\t" + wallCnt);
			System.out.println("◈ 획득할 아이템 개수\t\t" + itemCnt);
			System.out.println("----------------------------------------");
			for (int[] col : map) {
				for (int row : col) {
					if (row == ROAD) {
						System.out.print(" + ");
					} else if (row == WALL) {
						System.out.print(" ■ ");
					} else if (row == PLAYER) {
						System.out.print(" P ");
					} else if (row == ITEM) {
						System.out.print(" ◇ ");
					} else if (row == BOMB) {
						System.out.print(" ◐ ");
					}
				}
				System.out.println();
			}
			if (isEnd || isDead) {
				break;
			}
			System.out.println("q.폭파  w.상    e.설치");
			System.out.println("a.좌    s.하    d.우");
			String move = sc.next();
			sc.nextLine();
			int py = y;
			int px = x;
			if (move.equals(LEFT)) {
				px--;
			} else if (move.equals(RIGHT)) {
				px++;
			} else if (move.equals(UP)) {
				py--;
			} else if (move.equals(DOWN)) {
				py++;
			} else if (move.equals(INSTALL_BOMB)) {
				if (bombCnt == 0) {
					System.out.println("더 이상 놓을 수 없습니다.");
					continue;
				}
				if (map[py][px] == BOMB) {
					System.out.println("이미 놓았습니다.");
					continue;
				}
				map[py][px] = BOMB;
				bombs[bombSet][0] = py + 1;
				bombs[bombSet][1] = px + 1;
				bombCnt--;
				bombSet++;
			} else if (move.equals(EXPLODE_BOMB)) {
				if(bombSet == 0) {
					System.out.println("터트릴 폭탄이 없습니다.");
					continue;
				}
				int[][] temp = new int[99][2];
				int[][] wallTemp = new int[99][2];
				int cntTemp = 0;
				int cntWallTemp = 0;
				while (bombSet != 0) {
					boolean isMore = false;
					map[bombs[0][0] - 1][bombs[0][1] - 1] = BOMBEVENT;
					bombCnt++;
					for (int i = bombs[0][0] - 1 - bombLen; i <= bombs[0][0] - 1 + bombLen; i++) {
						if (i < 0)
							i = 0;
						if (i >= SIZE)
							break;
						if (map[i][bombs[0][1] - 1] == BOMB) {
							boolean isHave = false;
							for (int k = 0; k < SIZE; k++) {
								if (temp[k][0] == i + 1 && temp[k][1] == bombs[0][1]) {
									isHave = true;
									break;
								}
							}
							if (!isHave) {
								temp[cntTemp][0] = i + 1;
								temp[cntTemp++][1] = bombs[0][1];
							}
						}
						if (map[i][bombs[0][1] - 1] == WALL) {
							boolean isHave = false;
							for (int k = 0; k < SIZE; k++) {
								if (wallTemp[k][0] == i + 1 && wallTemp[k][1] == bombs[0][1]) {
									isHave = true;
									break;
								}
							}
							if (!isHave) {
								wallTemp[cntWallTemp][0] = i + 1;
								wallTemp[cntWallTemp++][1] = bombs[0][1];
								wallCnt--;
							}
						}
						if (i == y && bombs[0][1] - 1 == x) {
							isDead = true;
						}
						if (map[i][bombs[0][1] - 1] == ITEM) {
							itemCnt--;
						}
						map[i][bombs[0][1] - 1] = BOMBEVENT;
					}
					for (int i = bombs[0][1] - 1 - bombLen; i <= bombs[0][1] - 1 + bombLen; i++) {
						if (i < 0)
							i = 0;
						if (i >= SIZE)
							break;
						if (map[bombs[0][0] - 1][i] == BOMB) {
							boolean isHave = false;
							for (int k = 0; k < SIZE; k++) {
								if (temp[k][0] == bombs[0][0] && temp[k][1] == i + 1) {
									isHave = true;
									break;
								}
							}
							if (!isHave) {
								temp[cntTemp][0] = bombs[0][0];
								temp[cntTemp++][1] = i + 1;
							}
						}
						if (map[bombs[0][0] - 1][i] == WALL) {
							boolean isHave = false;
							for (int k = 0; k < SIZE; k++) {
								if (wallTemp[k][0] == bombs[0][0] && wallTemp[k][1] == i + 1) {
									isHave = true;
									break;
								}
							}
							if (!isHave) {
								wallTemp[cntWallTemp][0] = bombs[0][0];
								wallTemp[cntWallTemp++][1] = i + 1;
								wallCnt--;
							}
						}
						if (i != bombs[0][1] - 1) {
							if (bombs[0][0] - 1 == y && i == x) {
								isDead = true;
							}
							if (map[bombs[0][0] - 1][i] == ITEM) {
								itemCnt--;
							}
						map[bombs[0][0] - 1][i] = BOMBEVENT;
						}
					}
					bombSet--;
					for (int i = 0; i < bombSet; i++)
						bombs[i] = bombs[i + 1];
					bombs[bombSet] = new int[2];
					if (cntTemp > 0)
						isMore = true;
					if (!isMore)
						break;
					boolean isIn = false;
					for (int k = 0; k <= cntTemp; k++) {
						for (int i = 0; i < bombSet; i++) {
							if (temp[k][0] != 0 && temp[k][1] != 0 && temp[k][0] == bombs[i][0]
									&& temp[k][1] == bombs[i][1]) {
								int tempB1 = bombs[i][0];
								int tempB2 = bombs[i][1];
								for (int j = i; j > 0; j--) {
									bombs[j][0] = bombs[j - 1][0];
									bombs[j][1] = bombs[j - 1][1];
								}
								bombs[0][0] = tempB1;
								bombs[0][1] = tempB2;
								isIn = true;
								temp[k] = new int[2];
								cntTemp--;
								break;
							}
						}
						if (isIn) {
							break;
						}
					}
				}
				for (int i = 0; i < SIZE; i++) {
					for (int k = 0; k < SIZE; k++) {
						if (map[i][k] == ROAD) {
							System.out.print(" + ");
						} else if (map[i][k] == WALL) {
							System.out.print(" ■ ");
						} else if (map[i][k] == PLAYER) {
							System.out.print(" P ");
						} else if (map[i][k] == ITEM) {
							System.out.print(" ◇ ");
						} else if (map[i][k] == BOMBEVENT) {
							System.out.print("▒▒▒");
							boolean isNon = true;
							for (int j = 0; j < cntWallTemp; j++) {
								int rdItem = rd.nextInt(2);
								if (i == wallTemp[j][0] - 1 && k == wallTemp[j][1] - 1) {
									if (rdItem == 0) {
										map[i][k] = ROAD;
									} else if (rdItem == 1) {
										map[i][k] = ITEM;
										itemCnt++;
									}
									isNon = false;
									break;
								}
							}
							if (isNon) {
								map[i][k] = ROAD;
							}
						} else if (map[i][k] == BOMB) {
							System.out.print(" ◐ ");
						}
					}
					System.out.println();
				}

			} else if (move.equals(END)) {
				System.out.println("종료");
				break;
			} else {
				System.out.println("입력 오류");
				continue;
			}
			if (!move.equals(INSTALL_BOMB) && !move.equals(EXPLODE_BOMB)) {
				if (py < 0 || py > SIZE - 1 || px < 0 || px > SIZE - 1 || map[py][px] == WALL || map[py][px] == BOMB) {
					System.out.println("움직일 수 없는 방향");
					continue;
				}
				if (map[y][x] != BOMB) {
					map[y][x] = ROAD;
				} else {
					map[y][x] = BOMB;
				}
				x = px;
				y = py;
				if (map[y][x] == ITEM) {
					itemCnt--;
					bombCnt++;
				}
				if (!isDead) {
					map[y][x] = PLAYER;
				}
			}

		}
		sc.close();
		
	}

}
