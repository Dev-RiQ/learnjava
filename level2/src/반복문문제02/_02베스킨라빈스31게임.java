package 반복문문제02;

import java.util.Scanner;

public class _02베스킨라빈스31게임 {

	public static void main(String[] args) {

		/*
		 	1. p1과 p2는 번갈아가면서 1~3을 입력한다
		 	2. br은 p1과 p2의 입력값을 누적해서 저장한다.
		 	3. br이 31을 넘으면 게임은 종료된다.
		 	4. 승리자를 출력한다.
		 */
		Scanner sc = new Scanner(System.in);
		int br = 0;
		int turn = 1;
		
		while(true) {
			System.out.println("[현재 숫자 : " + br + "]");
			System.out.println("[플레이어 p" + turn + " 턴]");
			System.out.print("1-3 사이의 숫자를 입력 >> ");
			int input = sc.nextInt();
			System.out.println("===================");
			if (input < 1 || input > 3) {
				System.out.println("입력 오류\n");
				continue; // 해당 반복문 처음으로 되돌아간다 
			} 
			br += input;
			if (turn == 1) {
				turn = 2;
			} else {
				turn = 1;
			}
			if (br >= 31) {
				System.out.println("[승리자 : p" + turn + "]");
				break;
			}
		}
		
		while (true) {
			System.out.println("[현재 숫자 : " + br + "]");
			System.out.println("[플레이어 p" + turn + " 턴]");
			System.out.print("1-3 사이의 숫자를 입력 >> ");
			int input = sc.nextInt();
			System.out.println("===================");
			if (input < 1 || input > 3) {
				System.out.println("입력 오류\n");
				continue; // 해당 반복문 처음으로 되돌아간다 
			} 
			br += input;
			if(input == 1) {
				System.out.println("[p"+turn+" : "+br + "]\n");
			}else if (input==2) {
				System.out.println("[p"+turn+" : "+(br-1)+"  "+br + "]\n");
			}else if (input == 3) {
				System.out.println("[p"+turn+" : "+(br-2) +"  "+(br-1)+ "  "+br + "]\n");
			}
			
			if (turn == 1) {
				turn = 2;
			} else {
				turn = 1;
			}
			
			if (br >= 31) {
				System.out.println("[승리자 : p" + turn + "]");
				break;
			}
		}
		sc.close();

	}

}
