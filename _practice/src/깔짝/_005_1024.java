package 깔짝;

import java.util.Random;
import java.util.Scanner;

import _01.BACKGROUND;
import _01.FONT;

public class _005_1024 {
	
	public static int rdNum() {
		Random rd = new Random();
		int num = rd.nextInt(100000);
		num = num%100<1 ? 8 : num%10<2 ? 4 : 2;
		return num;
	}
	public static int[] rdIdx() {
		Random rd = new Random();
		int[] idx = {rd.nextInt(4),rd.nextInt(4)};
		return idx;
	}
	public static int[][] rdAdd(int[][] a){
		int[][] rdAdd = new int[4][4];
		rdAdd = a;
		while(true) {
			int[] rd = rdIdx();
			if(a[rd[0]][rd[1]]==0) {
				a[rd[0]][rd[1]] = rdNum();
				break;
			}
		}
		return rdAdd;
	}
	public static boolean rdNonAdd(int[][] a, int[][] b) {
		boolean isMatch = true;
		for(int i = 0 ; i<4;i++) {
			for(int k = 0 ; k<4;k++) {
				if(a[i][k]!=b[i][k]) {
					isMatch = false;
					break;
				}
			}
		}
		return isMatch;
	}
	public static int max = 0;
	public static void maxSet(int[][] a) {
		for(int i = 0 ; i<4;i++) {
			for(int k = 0 ; k<4;k++) {
				if(max<a[i][k]) {
					max = a[i][k];
				}
			}
		}
	}
	public static int score = 0;
	public static void scoreSet(int a) {
		int temp = a;
		int cntDiv2 = 1;
		while(temp != 2) {
			temp /= 2;
			cntDiv2 ++;
		}
		score += Math.pow(2, cntDiv2 + 1);
	}
	public static int[][] start () {
		int[][] startMap = new int[4][4];
		startMap = rdAdd(startMap);
		return startMap;
	}
	public static void showMap(int[][] a) {
		showColor();
		System.out.println("┏━━━━━━━━━━━━━━━━┳━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("┃                ┃                      ┃");
		System.out.print("┃    1024 GAME   ┃");
		System.out.printf(" 현재 점수 : %7d",score);
		System.out.println("  ┃");
		System.out.println("┃                ┃                      ┃");
		for(int i = 0; i<4;i++) {
			if(i==0) {
				System.out.println("┠━━━━━━━━━┳━━━━━━┻━━┳━━━━━━━━━┳━━━━━━━━━┫");
			}
			for(int k = 0;k<4;k++) {
				System.out.print(k==0? "┃         ┃":"         ┃");
			}
			System.out.println();
			for(int k = 0;k<4;k++) {
				int cnt = showSet(a[i][k]);
				int cnt1 = cnt/2;
				int cnt2 = cnt - cnt/2;
				System.out.print("┃  ");
				for(int j = 0;j<cnt1;j++) {
					System.out.print(" ");
				}
				System.out.print(a[i][k]==0?" ":a[i][k]);
				for(int j = 0;j<cnt2;j++) {
					System.out.print(" ");
				}
				System.out.print(k!=3?"  ":"  ┃");
			}
			System.out.println();
			for(int k = 0;k<4;k++) {
				System.out.print(k==0? "┃         ┃":"         ┃");
			}
			System.out.println();
			System.out.print(i==3? "┠━━━━━━━━━┻━━━━━━━━━┻━━━━━━━━━┻━━━━━━━━━┫":"┠━━━━━━━━━╋━━━━━━━━━╋━━━━━━━━━╋━━━━━━━━━┫");
			System.out.println();
		}
	}
	public static void showKey() {
		System.out.println("┃              ┏━━━━━━━━━┓              ┃");
		System.out.println("┃              ┃    ^    ┃              ┃");
		System.out.println("┃              ┃    W    ┃              ┃");
		System.out.println("┃  ┏━━━━━━━━━┓ ┃         ┃ ┏━━━━━━━━━┓  ┃");
		System.out.println("┃  ┃         ┃ ┗━━━━━━━━━┛ ┃         ┃  ┃");
		System.out.println("┃  ┃ <  A    ┃             ┃    D  > ┃  ┃");
		System.out.println("┃  ┃         ┃ ┏━━━━━━━━━┓ ┃         ┃  ┃");
		System.out.println("┃  ┗━━━━━━━━━┛ ┃         ┃ ┗━━━━━━━━━┛  ┃");
		System.out.println("┃              ┃    S    ┃              ┃");
		System.out.println("┃              ┃    ⅴ    ┃              ┃");
		System.out.println("┃              ┗━━━━━━━━━┛              ┃");
		System.out.print("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
		showColorReset();
	}
	public static void showEnd() {
		showColor();
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("┃                                       ┃");
		System.out.println("┃              게임 종료                ┃");
		System.out.println("┃                                       ┃");
		System.out.println("┠━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┫");
		System.out.println("┃                                       ┃");
		System.out.printf("┃           최대 숫자 : %5d           ┃\n",max);
		System.out.println("┃                                       ┃");
		System.out.printf("┃             점수    : %5d           ┃\n",score-2);
		System.out.println("┃                                       ┃");
		System.out.printf("┃           이동 횟수 : %5d           ┃\n",moveCnt-1);
		System.out.println("┃                                       ┃");
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
		showColorReset();
	}
	public static int showSet(int a) {
		int cnt = 0;
		if(a/10 == 0) {	cnt = 4;
		}else if(a/100 == 0) { cnt = 3;
		}else if(a/1000 == 0) { cnt = 2;
		}else if(a/10000 == 0) { cnt = 1;}
		
		return cnt;
	}
	public static void showColor() {
		System.out.print(BACKGROUND.WHITE_BRIHT(""));
		System.out.print(FONT.BLACK_BOLD(""));
	}
	public static void showColorReset() {
		System.out.print(FONT.RESET());
	}
	public static int moveCnt = 0;
	public static int[][] move (int[][] a, String b) {
		int[][] map = new int[4][4];
		map = a;
		if(b.equals("a")) {
			map = dragLeft(map);
		}else if(b.equals("d")) {
			map = dragRight(map);
		}else if(b.equals("w")) {
			map = dragUp(map);
		}else if(b.equals("s")) {
			map = dragDown(map);
		}
		if(!rdNonAdd(a,map)) {
			moveCnt++;
			score += 2;
		}
		return map;
	}
	public static int[][] dragLeft(int[][] a) {
		int[][] rsLeft = new int[4][4];
		for(int i = 0;i<rsLeft.length;i++) {
			int sumIdx = -1;
			int idx = -1;
			for(int k = 0;k<rsLeft[i].length;k++) {
				if(a[i][k]==0) {
					continue;
				}
				rsLeft[i][++idx] = a[i][k];
				if(sumIdx!=idx-1&&idx>0&&rsLeft[i][idx-1] == rsLeft[i][idx]) {
					rsLeft[i][idx-1]+=rsLeft[i][idx];
					if(countRepeat == 0) {
						scoreSet(rsLeft[i][idx-1]);
					}
					rsLeft[i][idx--] = 0;
					sumIdx = idx;
				}
			}
		}
		maxSet(rsLeft);
		if(gameOver(a,rsLeft,"Left")) {
			rsLeft = end();
		}else {
			if(!rdNonAdd(a,rsLeft)) {
				rsLeft = rdAdd(rsLeft);
			}
		}
		return rsLeft;
	}
	public static int[][] dragRight(int[][] a) {
		int[][] rsRight = new int[4][4];
		for(int i = 0;i<rsRight.length;i++) {
			int sumIdx = 5;
			int idx = 4;
			for(int k = rsRight.length-1;k>=0;k--) {
				if(a[i][k]==0) {
					continue;
				}
				rsRight[i][--idx] = a[i][k];
				if(sumIdx!=idx+1&&idx<3&&rsRight[i][idx+1] == rsRight[i][idx]) {
					rsRight[i][idx+1]+=rsRight[i][idx];
					if(countRepeat == 0) {
						scoreSet(rsRight[i][idx+1]);
					}
					rsRight[i][idx++] = 0;
					sumIdx = idx;
				}
			}
		}
		maxSet(rsRight);
		if(gameOver(a,rsRight,"Right")) {
			rsRight = end();
		}else {
			if(!rdNonAdd(a,rsRight)) {
				rsRight = rdAdd(rsRight);
			}
		}
		return rsRight;
	}
	public static int[][] dragUp(int[][] a) {
		int[][] rsUp = new int[4][4];
		for(int i = 0;i<rsUp.length;i++) {
			int sumIdx = -1;
			int idx = -1;
			for(int k = 0;k<rsUp[i].length;k++) {
				if(a[k][i]==0) {
					continue;
				}
				rsUp[++idx][i] = a[k][i];
				if(sumIdx!=idx-1&&idx>0&&rsUp[idx-1][i] == rsUp[idx][i]) {
					rsUp[idx-1][i]+=rsUp[idx][i];
					if(countRepeat == 0) {
						scoreSet(rsUp[idx-1][i]);
					}
					rsUp[idx--][i] = 0;
					sumIdx = idx;
				}
			}
		}
		maxSet(rsUp);
		if(gameOver(a,rsUp,"Up")) {
			rsUp = end();
		}else {
			if(!rdNonAdd(a,rsUp)) {
				rsUp = rdAdd(rsUp);
			}
		}
		return rsUp;
	}
	public static int[][] dragDown(int[][] a) {
		int[][] rsDown = new int[4][4];
		for(int i = 0;i<rsDown.length;i++) {
			int sumIdx = 5;
			int idx = 4;
			for(int k = rsDown.length-1;k>=0;k--) {
				if(a[k][i]==0) {
					continue;
				}
				rsDown[--idx][i] = a[k][i];
				if(sumIdx!=idx+1&&idx<3&&rsDown[idx+1][i] == rsDown[idx][i]) {
					rsDown[idx+1][i]+=rsDown[idx][i];
					if(countRepeat == 0) {
						scoreSet(rsDown[idx+1][i]);
					}
					rsDown[idx++][i] = 0;
					sumIdx = idx;
				}
			}
		}
		maxSet(rsDown);
		if(gameOver(a,rsDown,"Down")) {
			rsDown = end();
		}else {
			if(!rdNonAdd(a,rsDown)) {
				rsDown = rdAdd(rsDown);
			}
		}
		return rsDown;
	}
	public static int countRepeat = 0;
	public static boolean gameOver(int[][] a,int[][] b, String c) {
		boolean isOver = true;
		boolean isFull = true;
		int cnt = 0;
		for(int i = 0 ; i<4 ; i++) {
			for(int k = 0 ; k<4 ; k++) {
				if(a[i][k] != b[i][k] || a[i][k] ==0) {
					isFull = false;
					break;
				}
				cnt++;
			}
			if(!isFull) {
				break;
			}
		}
		if(cnt!=16) {
			isOver = false;
		}
		if(!isOver) {
			countRepeat = 0;
		}
		if(isOver && countRepeat < 4) {
			countRepeat++;
			if(c.equals("Down")) {
				dragLeft(a);
			}else if(c.equals("Left")) {
				dragRight(a);
			}else if(c.equals("Right")) {
				dragUp(a);
			}else if(c.equals("Up")) {
				dragDown(a);
			}
		}
		isOver = countRepeat == 4? true: false;
		return isOver;
		
	}	
	public static int[][] end() {
		int[][] endMap = new int[4][4];
		return endMap;
	}	
	public static boolean out(int[][] a) {
		boolean out = true;
		for(int i = 0;i<4;i++) {
			for(int k = 0;k<4;k++) {
				if(a[i][k] != 0) {
					out = false;
					break;
				}
			}
			if(!out) {
				break;
			}
		}
		return out;
	}	
	public static boolean programOut(int[][] a) {
		boolean programOut = false;
		if(out(a)) {
			programOut = true;
			showEnd();
		}
		return programOut;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] map = start();
		while(true) {
			showMap(map);
			showKey();
			String input = sc.next();
			map = move(map,input);
			if(programOut(map)) {
				break;
			}
		}
		sc.close();			
	}

}
