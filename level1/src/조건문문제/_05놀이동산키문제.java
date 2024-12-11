package 조건문문제;

import java.util.Scanner;

public class _05놀이동산키문제 {

	public static void main(String[] args) {

		//중첩 if
		//놀이동산 입장제한
		//조건 1) 130 이상 "입장"
		//조건 2) 120~130 사이면 부모님과 동반하에 입장가능
				// 부모님과 같이 왔니? 1. yes 2. no
				//1 -> 입장 2 -> 입장 불가
		//조건 3) 120 미만 "입장불가"
		
		Scanner sc = new Scanner(System.in);

		System.out.print("키를 입력하세요 >> ");
		int tall = sc.nextInt();

		if (tall >= 130) {
			System.out.println("\n입장");
		}
		if (tall < 120) {
			System.out.println("\n입장불가");
		}
		if (tall >= 120 && tall < 130) {
			System.out.println("\n부모님과 같이 왔는가? (yes = 1 / no = 2)");
			int yesNo = sc.nextInt();
			if (yesNo == 1) {
				System.out.println("\n입장");
			}
			if (yesNo == 2) {
				System.out.println("\n입장불가");
			}
			if (yesNo != 1 && yesNo != 2) {
				System.out.println("\n입력오류");
			}

		}
		
		
		sc.close();
	}

}
