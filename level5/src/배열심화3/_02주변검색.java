package 배열심화3;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class _02주변검색 {

	public static void main(String[] args) {

		
		/*
		 	지뢰찾기
		 */
		Scanner sc = new Scanner(System.in);
		Random rd = new Random();
		int mapSize = 3;
		int cntMine = 0;
		int[][] mine = new int[mapSize][mapSize];
		for(int i = 0;i<mine.length;i++) {
			for(int k = 0;k<mine.length;k++) {
				int rdNum = rd.nextInt(10);
				rdNum = rdNum<8? 0:9;
				mine[i][k] =rdNum; 
				if(rdNum == 9) {
					cntMine ++;
				}
			}
		}
//		int[][] mine = {
//				{ 9, 0, 0, 0, 9, 9, 0, 0 ,9 },
//				{ 0, 0, 0, 0, 0, 0, 9, 0, 0 },
//				{ 0, 0, 0, 0, 0, 9, 0, 0, 9 },
//				{ 0, 0, 0, 0, 0, 9, 0, 0 ,9 },
//				{ 9, 0, 9, 0, 9, 0, 9, 0, 0 },
//				{ 0, 0, 0, 0, 0, 0, 0, 0, 0 },
//				{ 0, 0, 0, 0, 0, 0, 0, 0, 0 },
//				{ 0, 0, 0, 0, 0, 0, 0, 0, 0 },
//				{ 0, 0, 0, 0, 0, 0, 0, 0, 0 }
//		};
		int size = mine.length;
		for (int i = 0; i < size; i++) {
			System.out.println(Arrays.toString(mine[i]));
		}
		System.out.println();
		int nine = 9;
		boolean[][] isCheck = new boolean[size][size];
		int idx1 = 0;
		int idx2 = 0;
		while (true) {
			boolean isEnd = true;
			for (int i = 0; i < size; i++) {
				for (int k = 0; k < size; k++) {
					if (!isCheck[i][k]&&mine[i][k] == 0) {
						idx1 = i;
						idx2 = k;
						isCheck[i][k] = true;
						isEnd = false;
						break;
					}
				}
				if(!isEnd) {
					break;
				}
			}
			if (!isEnd) {
				int idx1S = idx1 == 0 ? 0 : idx1 - 1;
				int idx2S = idx2 == 0 ? 0 : idx2 - 1;
				int idx1E = idx1 == size - 1 ? size - 1 : idx1 + 1;
				int idx2E = idx2 == size - 1 ? size - 1 : idx2 + 1;
				for (int j = idx1S; j <= idx1E; j++) {
					for (int l = idx2S; l <= idx2E; l++) {
						if (mine[j][l] == nine) {
							mine[idx1][idx2]++;
						}
					}
				}
			} else {
				break;
			}
		}
		boolean[][] isInput = new boolean[size][size];
		int y = -1;
		int x = -1;
		boolean gameOver = false;
		boolean win = false;
		while(true) {
			System.out.print("      ");
			for(int i = 0 ;i<size;i++) {
				System.out.print((i<10?" ":"")+i+" ");
			}
			System.out.println();
			System.out.println();
			int cntOver = 0;
			for (int i = 0; i < size; i++) {
				System.out.print(i<10? " "+ i + "    ":i + "    ");
				for (int k = 0; k < size; k++) {
					System.out.print(isInput[i][k]? (mine[i][k]==0?"   ":" "+mine[i][k]+" "):"[ ]");
				}
				System.out.println();
			}
			if(win) {
				System.out.println("다 찾음");
				break;
			}
			if(gameOver) {
				System.out.println("지뢰 밟음");
				break;
			}
			while(true) {
				for(int i = 0;i<2;i++) {
					System.out.print("좌표 입력 >> ");
					int idx = sc.nextInt();
					if(idx > size-1 || idx<0 ) {
						System.out.println("입력 오류");
						i--;
						continue;
					}
					if(i==0) {
						y = idx;
					}else {
						x = idx;
					}
				}
				if(isInput[y][x]) {
					System.out.println("이미 입력한 칸");
					continue;
				}
				isInput[y][x] = true;
				int[][] ys = new int[size*size][8];
				int[][] xs = new int[size*size][8];
				for(int i = 0;i<ys.length;i++) {
					for(int k = 0;k<ys[i].length;k++) {
						ys[i][k] = -1;
						xs[i][k] = -1;
					}
				}
				boolean[][] check = new boolean[size][size];
				int cntY = 0;
				int cntX = 0;
				while(true) {
					boolean isDone = true;
					if(mine[y][x]==0) {
						int idx1S = y == 0 ? 0 : y - 1;
						int idx2S = x == 0 ? 0 : x - 1;
						int idx1E = y == size - 1 ? size - 1 : y + 1;
						int idx2E = x == size - 1 ? size - 1 : x + 1;
						for (int j = idx1S; j <= idx1E; j++) {
							for (int l = idx2S; l <= idx2E; l++) {
								isInput[j][l] = true;
								if(!(l==x && j==y)&& mine[j][l] == 0 && !check[j][l]) {
										ys[cntY][cntX] = j;
										xs[cntY][cntX] = l;
										cntX++;
								}
							}
						}
					}
					cntX = 0;
					cntY++;
					for(int i = 0;i<cntY;i++) {
						for(int k = 0;k<8;k++) {
							if(ys[i][k]!=-1&& !check[ys[i][k]][xs[i][k]]) {
								y = ys[i][k];
								x = xs[i][k];
								check[y][x] = true;
								isDone = false;
								break;
							}
						}
						if(!isDone) {
							break;
						}
					}
					if(isDone || cntY>size*size-1) {
						break;
					}
				}
				break;
			}
			for(int i= 0;i<isInput.length;i++) {
				for(int k= 0;k<isInput[i].length;k++) {
					if(!isInput[i][k]) {
						cntOver ++;
					}
				}
			}
			if(mine[y][x]==9) {
				gameOver = true;
			}
			if(cntOver == cntMine) {
				win = true;
			}
			
		}
		sc.close();
	}

}
