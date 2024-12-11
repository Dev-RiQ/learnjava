package _01;

import java.util.Scanner;

public class _010배열회전 {

	public static void main(String[] args) {

		/*
		[문제]
		배열의 크기를 입력받고
		배열을 1~N까지 채운 뒤에
		회전 각도(90, 180, 270)를 입력 받아
		입력받은 각도만큼 배열을 회전시키시오.
		*/
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.print("배열 크기 설정 (0. 종료) >> ");
			int size = sc.nextInt();
			if(size == 0) {
				System.out.println("종료");
				break;
			}
			if(size<0) {
				System.out.println("양수 값을 입력하세요");
				continue;
			}
			int[][] set = new int[size][size];
			for(int i = 0;i<set.length;i++) {
				for(int k = 0;k<set.length;k++) {
					set[i][k] = (i*size)+(k+1);
					System.out.printf("%5d",set[i][k]);
				}
				System.out.println();
			}
			int turn = 0;
			while(true) {
				System.out.print("회전 각도 설정 (0.취소) >>");
				turn = sc.nextInt();
				if(turn == 0) {
					System.out.println("회전 취소");
					break;
				}
				if(turn<0 || turn>360) {
					System.out.println("1~360 사이의 값을 입력하세요");
					continue;
				}
				if(turn%90 != 0) {
					System.out.println("90,180,270,360으로만 돌릴 수 있음");
					continue;
				}
				int[][] temp = new int[size][size];
				for(int i = 0;i<size;i++) {
					for(int k = 0;k<size;k++) {
						temp[i][k] = set[i][k];
					}
				}
				for(int i = 0;i<size;i++) {
					for(int k = 0;k<size;k++) {
						if(turn == 90) {
							set[i][k] = temp[size-1-k][i];
						}else if(turn==180) {
							set[i][k] = temp[size-1-i][size-1-k];
						}else if(turn==270) {
							set[i][k] = temp[k][size-1-i];
						}
						System.out.printf("%5d",set[i][k]);
					}
					System.out.println();
				}
			}
		}
		sc.close();
	}

}
