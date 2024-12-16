package 배열심화3;

import java.util.Scanner;

public class _16연쇄폭파 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int size = 5;
		int bomb = 9;
		int bombEvent = 8;
		int wall = 4;
		int bombLen = 1;
		int map[][] = {
				{ 0, 0, 0, 0, 0 },
				{ 0, 0, 4, 4, 0 },
				{ 0, 0, 0, 0, 0 },
				{ 4, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0 }
		};
		int cnt = 0; // 설치된 폭탄 개수
		int bombs[][] = new int[99][2]; // 순서대로 터짐 (연쇄이면 같이 터짐)
		bombs[0][0] = 4;
		bombs[0][1] = 4;
		bombs[1][0] = 3;
		bombs[1][1] = 4;
		bombs[2][0] = 4;
		bombs[2][1] = 1;
		bombs[3][0] = 4;
		bombs[3][1] = 2;
		bombs[4][0] = 3;
		bombs[4][1] = 3;

		for (int i = 0; i < size; i++) {
			if(bombs[i][0] != 0 && bombs[i][1] != 0) {
				map[bombs[i][0]-1][bombs[i][1]-1] = 9;
				cnt++;
			}
		}
		while (true) {
			System.out.println("cnt : " + cnt);
			for (int i = 0; i < size; i++) {
				for (int k = 0; k < size; k++) {
					if (map[i][k] == wall)
						System.out.print(" □ ");
					else if (map[i][k] == bomb)
						System.out.print(" ● ");
					else
						System.out.print(" + ");
				}
				System.out.println();
			}
			if (cnt == 0)
				break;
			while (true) {
				System.out.print("5. BOMB !! >> ");
				int sel = sc.nextInt();
				if (sel != 5)
					continue;
				break;
			}
			int[][] temp = new int[99][2];
			int idx = 0;
			int idx2 = 0;
			int cntTemp = 0;
			while (cnt != 0) {
				boolean isMore = false;
				map[bombs[0][0]-1][bombs[0][1]-1] = bombEvent;
				for (int i = bombs[0][0] - 1 - bombLen; i <= bombs[0][0] - 1 + bombLen; i++) {
					if (i < 0) 
						i = 0;
					if (i >= size) 
						break;
					if (map[i][bombs[0][1]-1] == bomb) {
						boolean isHave = false;
						for(int k = 0;k<size;k++) {
							if(temp[k][0] == i + 1 && temp[k][1]==bombs[0][1]) {
								isHave = true;
								break;
							}
						}
						if(isHave)
							continue;
						temp[idx][0] = i + 1;
						temp[idx++][1] = bombs[0][1];
						cntTemp ++;
					}
					map[i][bombs[0][1] - 1] = bombEvent;
				}
				for (int i = bombs[0][1] - 1 - bombLen; i <= bombs[0][1] - 1 + bombLen; i++) {
					if (i < 0) 
						i = 0;
					if (i >= size) 
						break;
					if (map[bombs[0][0] - 1][i] == bomb) {
						boolean isHave = false;
						for(int k = 0;k<size;k++) {
							if(temp[k][0] == bombs[0][0] && temp[k][1]==i + 1) {
								isHave = true;
								break;
							}
						}
						if(isHave) 
							continue;
						temp[idx][0] = bombs[0][0];
						temp[idx++][1] = i + 1;
						cntTemp++;
					}
					if (i != bombs[0][1] - 1) 
						map[bombs[0][0] - 1][i] = bombEvent;
				}
				cnt--;
				for (int i = 0; i < cnt; i++)
					bombs[i] = bombs[i + 1];
				bombs[cnt] = new int[2];
				if(cntTemp > 0) 
					isMore = true;
				if (!isMore) 
					break;
				for (int i = 0; i < 99; i++) {
					if (temp[idx2][0]!=0 && temp[idx2][1] != 0 && temp[idx2][0] == bombs[i][0] && temp[idx2][1] == bombs[i][1]) {
						int tempB1 = bombs[i][0];
						int tempB2 = bombs[i][1];
						for (int k = i; k >0; k--) {
							bombs[k][0] = bombs[k-1][0];
							bombs[k][1] = bombs[k-1][1];
						}
						bombs[0][0] = tempB1;
						bombs[0][1] = tempB2;
						break;
					}
				}
				temp[idx2] = new int[2];
				idx2++;
				cntTemp--;
			}
			for (int i = 0; i < size; i++) {
				for (int k = 0; k < size; k++) {
					if (map[i][k] == wall)
						System.out.print(" □ ");
					else if (map[i][k] == bomb)
						System.out.print(" ● ");
					else if (map[i][k] == bombEvent) {
						System.out.print("▒▒▒");
						map[i][k] = 0;
					}else 
						System.out.print(" + ");
				
				}
				System.out.println();
			}
		}
		sc.close();
	}

}
