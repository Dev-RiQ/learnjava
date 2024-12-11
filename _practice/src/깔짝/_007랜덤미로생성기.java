package 깔짝;

import java.util.Random;
import java.util.Scanner;

public class _007랜덤미로생성기 {

	public static void map(int a) {
		Random rd = new Random();
		while(true) {
			int[][] maze = new int[2*a+1][2*a+1];
			boolean[][] load = new boolean[2*a+1][2*a+1];
			maze[0][1] = 8;
			maze[2*a][2*a-1] = 9;
			for(int i = 1;i<maze.length-1;i+=2) {
				for(int k = 1;k<maze[i].length-1;k+=2) {
					maze[i][k] = 1;
					load[i][k] = true;
					
				}
			}
			for(int i = 1;i<maze.length-2;i+=2) {
				for(int k = 1;k<maze[i].length-2;k+=2) {
					int rdNum = rd.nextInt(3);
					if(rdNum == 0) {
						maze[i][k+1] = 1;
					}else if(rdNum == 1){
						maze[i+1][k] = 1;
					}else {
						maze[i][k+1] = 1;
						maze[i+1][k] = 1;
					}
				}
			}
			for(int i = 3;i<maze.length-1;i+=2) {
				for(int k = 3;k<maze[i].length-1;k+=2) {
					int rdNum = rd.nextInt(3);
					if(rdNum == 0) {
						maze[i][k-1] = 1;
					}else if(rdNum == 1){
						maze[i-1][k] = 1;
					}else {
						maze[i][k-1] = 1;
						maze[i-1][k] = 1;
					}
				}
			}
			for(int i = 1;i<maze.length-1;i+=2) {
				for(int k = 1;k<maze[i].length-1;k+=2) {
					if(maze[i-1][k] == 1 &&maze[i][k-1] == 1 &&maze[i+1][k] == 1 &&maze[i][k+1] == 1) {
						int rdNum = rd.nextInt(4);
						if(rdNum == 0) {
							maze[i][k-1] = 0;
						}else if(rdNum == 1){
							maze[i-1][k] = 0;
						}else if(rdNum == 2){
							maze[i][k+1] = 0;
						}else {
							maze[i+1][k] = 0;
						}
						
					}
				}
			}
			for(int i = 0;i<maze.length;i++) {
				for(int k = 0;k<maze[i].length;k++) {
					System.out.print(maze[i][k] == 0?"뛟":"  ");
				}
				System.out.println();
			}
			break;
		}
			
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.print("미로 크기 선택 (5 이상) >> ");
			int size = sc.nextInt();
			if(size < 5) {
				System.out.println("5 이상 입력");
				continue;
			}
			map(size);
			break;
		}
		sc.close();
	}

}
