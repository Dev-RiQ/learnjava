package 배열2문제;

import java.util.Random;
import java.util.Scanner;

public class _99오목 {

	public static void main(String[] args) {

		boolean[][] com = new boolean[25][25];
		boolean[][] me = new boolean[25][25];
		boolean[][] total = new boolean[25][25];
		Scanner sc = new Scanner(System.in);
		Random rd = new Random();
		int turn = 1;
		int xCom = com.length;
		int yCom = com.length;
		int xMe = me.length;
		int yMe = me.length;
		int x = total.length;
		int y = total.length;
		int endCnt = 0;
		while (true) {
			// 판 셋팅
			for (int i = 5; i < 20; i++) {
				System.out.println();
				if(i<10) {
					System.out.print((19 -i));
				} else {
					System.out.print(" " + (19 -i));
				}
				for(int j = 5;j<20; j++) {
					if (total[i][j] == false) {
						System.out.print(" ·");
					}
					if (total[i][j] == true && com[i][j] == true) {
						System.out.print(" ○");
					}
					if (total[i][j] == true && me[i][j] == true) {
						System.out.print(" ●");
					}
				}
			}
			System.out.println();
			System.out.print("  ");
			for(int i = 5; i<20;i++) {
				if(i<16) {
					System.out.print(" "+(i-5));
				}else {
					System.out.print(i-5);
				}
			}
			System.out.println();
			boolean win = false;
			int cnt = 0;
			//me 승리
			if(!win) {
				for(int i = 0;i<me.length;i++) {
					for(int j = 0;j<me.length;j++) {
						if(me[i][j]) {
							cnt++;
						}else {
							cnt = 0;
						}
						if(cnt == 5) {
							win = true;
							break;
						}
					}
					if(win) {
						break;
					}
				}
			}
			cnt = 0;
			if(!win) {
				for(int i = 0;i<me.length;i++) {
					for(int j = 0;j<me.length;j++) {
						if(me[j][i]) {
							cnt++;
						}else {
							cnt = 0;
						}
						if(cnt == 5) {
							win = true;
							break;
						}
					}
					if(win) {
						break;
					}
				}
			}
			cnt = 0;
			if(!win) { //대각 아래
				for(int i = 0;i<me.length;i++) {
					for(int j = 0;j<me.length;j++) {
						if(me[j][i]) {
							cnt++;
							i++;
						}else {
							i-=cnt;
							cnt = 0;
						}
						if(cnt == 5) {
							win = true;
							i-=cnt;
							break;
						}
					}
					if(win) {
						break;
					}
				}
			}
			cnt = 0;
			if(!win) { //대각 위
				for(int i = me.length-1;i>=0;i--) {
					for(int j = 0;j<me.length;j++) {
						if(me[j][i]) {
							cnt++;
							i--;
						}else {
							i+=cnt;
							cnt = 0;
						}
						if(cnt == 5) {
							win = true;
							i+=cnt;
							break;
						}
					}
					if(win) {
						break;
					}
				}
			}
			//com 승리
			cnt = 0;
			if(!win) {
				for(int i = 0;i<me.length;i++) {
					for(int j = 0;j<me.length;j++) {
						if(com[i][j]) {
							cnt++;
						}else {
							cnt = 0;
						}
						if(cnt == 5) {
							win = true;
							break;
						}
					}
					if(win) {
						break;
					}
				}
			}
			cnt = 0;
			if(!win) {
				for(int i = 0;i<me.length;i++) {
					for(int j = 0;j<me.length;j++) {
						if(com[j][i]) {
							cnt++;
						}else {
							cnt = 0;
						}
						if(cnt == 5) {
							win = true;
							break;
						}
					}
					if(win) {
						break;
					}
				}
			}
			cnt = 0;
			if(!win) { //대각 아래
				for(int i = 0;i<me.length;i++) {
					for(int j = 0;j<me.length;j++) {
						if(com[j][i]) {
							cnt++;
							i++;
						}else {
							i-=cnt;
							cnt = 0;
						}
						if(cnt == 5) {
							win = true;
							i-=cnt;
							break;
						}
					}
					if(win) {
						break;
					}
				}
			}
			cnt = 0;
			if(!win) { //대각 위
				for(int i = me.length-1;i>=0;i--) {
					for(int j = 0;j<me.length;j++) {
						if(com[j][i]) {
							cnt++;
							i--;
						}else {
							i+=cnt;
							cnt = 0;
						}
						if(cnt == 5) {
							win = true;
							i+=cnt;
							break;
						}
					}
					if(win) {
						break;
					}
				}
			}
			if(win) {
				if(turn == 0) {
					System.out.println("승리");
				}else {
					System.out.println("패배");
				}
				break;
			}
			//판 출력 직후 종료 조건
			if (endCnt == 225) {
				System.out.println("무승부");
				break;
			}
			//me, com 입력 셋팅
			while (true) {
				if (turn == 1) {
					System.out.println("me turn !");
					System.out.print("x >> ");
					xMe = sc.nextInt();
					System.out.print("y >> ");
					yMe = sc.nextInt();
					x = xMe;
					y = yMe;
				} else {
					xCom = xMe + rd.nextInt(3)-1;
					yCom = yMe + rd.nextInt(3)-1;
					x = xCom;
					y = yCom;
					
				}
				if (x < 0 || x > 14||y < 0 || y > 14) {
					if(turn == 1) {
						System.out.println("0~14 사이 값 입력");
					}
					continue;
				}
				if (total[total.length -6 -y][x+5] == true) {
					if (turn == 1) {
						System.out.println("이미 놓여있는 자리입니다.");
					}
					continue;
				}
				if (turn == 0) {
					System.out.println("com turn !");
					System.out.println("x >> "+xCom);
					System.out.println("y >> "+yCom);
				}
				total[total.length -6 -y][5+x] = true;
				endCnt ++;
				if (turn == 1) {
					me[total.length -6 -y][x+5] = true;
					turn = 0;
				} else {
					com[total.length -6 -y][x+5] = true;
					turn = 1;
				}
				break;
			}
		}
		System.out.println("게임 종료");
		sc.close();
		
	}

}
