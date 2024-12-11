package 조건문문제;

import java.util.Random;
import java.util.Scanner;

public class _17가위바위보2단계 {

	public static void main(String[] args) {

		/*
		 	[문제]
		 		가위(0) 바위(1) 보(2)
		 		1. com은 랜덤으로 0~2
		 		2. me는 0~2 입력
		 		3. com과 me 비교 
		 		
		 		1)비겼다.
		 		2)내가 이겼다.
		 		3)내가 졌다.
		 */
	
		Scanner sc =new Scanner(System.in);
		Random rd = new Random();
		
		int com = rd.nextInt(3);
		System.out.print("가위(0) 바위(1) 보(2) 게임 \n0,1,2 중 하나를 입력하세요 >> ");
		int me = sc.nextInt();
		
		if (me <= 2 && me >= 0) {
			System.out.printf("com : %d me : %d\n", com, me);
			if (com == me) {
				System.out.println("비겼다.");
			} else if (com - me == -1 || com - me == 2) {
				System.out.println("내가 이겼다.");
			} else {
				System.out.println("내가 졌다.");
			}
		} else {
			System.out.println("0,1,2중에 입력하세요.");
		}
////		============================================== 조건 제일 치기 귀찮은거 else로 보내버리기.
//		
//		if (com - me == 1 || com - me == -2) {
//			System.out.println("내가 졌다.");
//		}else if (com - me == 0) {
//			System.out.println("비겼다.");
//		}else {
//			System.out.println("내가 이겼다.");
//		}
//	
////		==============================================
//		
//		if (com - me == 1 || com - me == -2) {
//			System.out.println("내가 졌다.");
//		}else if (com - me == -1 || com - me ==2) {
//			System.out.println("내가 이겼다.");
//		}else {
//			System.out.println("비겼다.");
//		}
//		
////		============================================== sout 으로 결합해서 위
//		
//		if (com - me == 0 ) {
//			System.out.println("비겼다.");
//		}else if((com - me)*(com - me) == 1) {
//			if(com>me) {
//				System.out.println("내가 졌다.");
//			}else {
//				System.out.println("내가 이겼다.");
//			}
//		}else {
//			if(com>me) {
//				System.out.println("내가 이겼다.");
//			}else {
//				System.out.println("내가 졌다.");
//			}
//		}
//		
////		============================================== com - me 로 결합해서 위
//		if (com == 0 && me == 0 || com == 1 && me == 1 || com ==2 && me ==2) {
//			System.out.println("비겼다.");
//		}else if (com - me == 1) {
//			System.out.println("내가 졌다.");
//		}else if (com - me == 2) {
//			System.out.println("내가 이겼다.");
//		}else if (com - me == -1){
//			System.out.println("내가 이겼다.");
//		}else {
//			System.out.println("내가 졌다.");
//		}
		
		sc.close();
	}

}
