package 깔짝;

import java.util.Random;
import java.util.Scanner;

import _01.FONT;

public class _009랜덤미로콘솔플레이 {

	public static int size;
	public static int[][] map;
	public static int cntLeft;
	public static int yy;
	public static int xx;

	public static void setMap(int a) {
		size = a;
		map = new int[size][size];
		cntLeft = (size / 2) * (size / 2) - 2;
		yy = 0;
		xx = 1;
		map[0][1] = 8;
		map[1][1] = 1;
		map[size - 2][size - 2] = 1;
		map[size - 1][size - 2] = 9;
		setLoad();
	}

	public static void setLoad() {
		Random rd = new Random();
		int y = 1;
		int x = 1;
		int cntRs = 0;
		while (cntLeft != 0) {
			boolean isMove = false;
			int py = y;
			int px = x;
			int pyB = y;
			int pxB = x;
			int set = move();
			switch (set) {
			case 0:
				if (py > 2) {
					isMove = true;
					y--;
					py -= 2;
				}
				break;
			case 1:
				if (py < size - 3) {
					isMove = true;
					y++;
					py += 2;
				}
				break;
			case 2:
				if (px > 2) {
					isMove = true;
					x--;
					px -= 2;
				}
				break;
			case 3:
				if (px < size - 3) {
					isMove = true;
					x++;
					px += 2;
				}
				break;
			}
			if (isMove) {
				if (map[py][px] != 1) {
					map[y][x] = 1;
					map[py][px] = 1;
					y = py;
					x = px;
					cntLeft--;
				} else {
					y = pyB;
					x = pxB;
					cntRs++;
				}
			}
			if (cntRs > 20) {
				cntRs = 0;
				while (true) {
					int rdIdx1 = rd.nextInt(size / 2) * 2 + 1;
					int rdIdx2 = rd.nextInt(size / 2) * 2 + 1;
					if (map[rdIdx1][rdIdx2] == 1 && !(rdIdx1 == 1 && rdIdx2 == 2)
							&& !(rdIdx1 == size - 2 && rdIdx2 == size - 2)) {
						y = rdIdx1;
						x = rdIdx2;
					} else {
						continue;
					}
					break;
				}
			}
		}
		int rdNum = rd.nextInt(2);
		if (rdNum == 0) {
			map[size - 2][size - 3] = 1;
		} else {
			map[size - 3][size - 2] = 1;
		}
	}

	public static void showMap() {
		System.out.println();
		System.out.println("START");
		System.out.println("  🔽");
		System.out.print(FONT.RED_BRIGHT(""));
		for (int[] col : map) {
			for (int row : col) {
				System.out.print(row == 1 ? "  " : row == 8 ? FONT.WHITE("")+"方"+FONT.RED_BRIGHT("") : row == 9 ? "  " : "🧱");
			}
			System.out.println();
		}
		System.out.print(FONT.RESET());
		for(int i = 0 ; i<size-2;i++) {
			System.out.print("  ");
		}
		System.out.println("🔽");
		for(int i = 0 ; i<size-2;i++) {
			System.out.print(i==0? " ":"  ");
		}
		System.out.println("END");
	}

	public static int move() {
		Random rd = new Random();
		int move = rd.nextInt(4);
		return move;
	}
	
	public static void playerMove(String a) {
		int pyy = yy;
		int pxx = xx;
		boolean isCol = true;
		switch (a) {
		case "w":
			pyy--;
			break;
		case "s":
			pyy++;
			break;
		case "a":
			pxx--;
			break;
		case "d":
			pxx++;
			break;
		default: 
			System.out.println("잘못된 키 입력입니다.");
			isCol = false;
			break;
		}
		if(isCol) {
			if(pyy < 0 || pxx < 0 || pyy > size-1 || pxx > size - 1 || map[pyy][pxx] == 0) {
				System.out.println("움직일 수 없습니다.");
			}else {
				map[yy][xx] = 1;
				yy = pyy;
				xx = pxx;
				map[yy][xx] = 8;
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.print("미로 크기 입력 (3 이상) >> ");
			int set = sc.nextInt() * 2 + 1;
			if (set < 7) {
				System.out.println("3 이상의 값을 입력하세요.");
				continue;
			}
			setMap(set);
			break;
		}
		while(true) {
			showMap();
			if(map[size - 1][size - 2] == 8) {
				System.out.println("탈출 성공 !");
				break;
			}
			System.out.println("        w.상");
			System.out.println("a.좌    s.하    d.우");
			sc.nextLine();
			String dir = sc.next();
			playerMove(dir);
		}
		sc.close();
	}

}
