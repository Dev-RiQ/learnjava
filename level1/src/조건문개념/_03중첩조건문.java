package 조건문개념;

import java.util.Scanner;

public class _03중첩조건문 {

	public static void main(String[] args) {

		/*
		 	[개념]
		 	중첩 조건문 : if 안에 if 또 있다..!
		 */
		
		//3개 이상 들어갈 경우 가독성 하락
//		if(true) {
//			if(true) {
//				if(true) {
//					if(true) {
//						//......
//					}
//				}
//			}
//		}
		
		Scanner sc = new Scanner(System.in);

		System.out.println("가위(0) / 바위(1) / 보(2) 중 원하는 숫자 하나를 입력하세요.");
		int com = 1;
		int me = sc.nextInt();

		//오류 설정
		boolean err = me < 0 || me > 2;
		if (err) {
			System.out.println("\n입력 오류");
		}
		
		if(!err) { // 중복되는 조건(&&) 통합하기
			if (com > me) {
				System.out.println("\n내가 졌다.");
			}
			if (com == me) {
				System.out.println("\n비겼다.");
			}
			if (com < me) {
				System.out.println("\n내가 이겼다.");
			}
			
		}

		sc.close();
		
		
	}

}
