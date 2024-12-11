package _level2시험;

import java.util.Random;
import java.util.Scanner;

public class _09문제2 {

	public static void main(String[] args) {

		/*
		   [문제]
		  		1. 손님을 태워 목적지까지 이동
		  		2. -10~10사이의 랜덤 숫자 2개 저장 목적지로 설정
		  		3. 메뉴는 아래와 같다
		  		 1)속도 : 1~3
		  		 2)방향 : 동(1)서(2)남(3)북(4)
		  		 3) 이동하기 : 설정 방향으로 설정된 속도만큼 이동
		  		4. 거리 1칸 당 50원 요금
		 */
		
		Random rd = new Random();
		Scanner sc = new Scanner(System.in);
		int priceTotal = 0;
		int speed = 0;
		int dir = 0;
		int x = 0;
		int y = 0;
		int menu = 0;
		while (true) {
			int price = 0;
			int dx = rd.nextInt(21) - 10;
			int dy = rd.nextInt(21) - 10;
			while (true) {
				System.out.printf("현재위치 ( %d , %d )\n", x, y);
				System.out.printf("목적지 ( %d , %d )\n", dx, dy);
				System.out.println("속도 : " + speed + "  방향 : " + dir);
				System.out.println("현재요금 : " + price + "  총 요금 : " + priceTotal);
				System.out.println("1.속도설정 2.방향설정 3.이동 0.종료");
				menu = sc.nextInt();
				if (menu < 0 || menu > 3) {
					System.out.println("입력오류");
					continue;
				} else if (menu == 3 && (speed == 0 || dir == 0)) {
					System.out.println("속도 또는 방향 미설정");
				} else if (menu == 1) {
					while (true) {
						System.out.print("속도(1~3) >> ");
						speed = sc.nextInt();
						if (speed < 1 || speed > 3) {
							System.out.println("입력오류");
							continue;
						}
						break;
					}
				} else if (menu == 2) {
					while (true) {
						System.out.println("방향 >> 동(1)서(2)남(3)북(4)");
						dir = sc.nextInt();
						if (dir < 1 || dir > 4) {
							System.out.println("입력오류");
							continue;
						}
						break;
					}
				} else if (menu == 3) {
					switch (dir) {
					case 1:	x += speed;	break;
					case 2:	x -= speed;	break;
					case 3:	y -= speed;	break;
					case 4:	y += speed;	break;
					}
					price += speed * 50;
					speed = 0;
					dir = 0;
					if (x == dx && y == dy) {
						priceTotal += price;
						System.out.println("목적지 도착");
						break;
					}
				} else if (menu == 0) {
					System.out.println("프로그램 종료");
					break;
				}
			}
			if (menu != 0) {
				continue;
			}
			break;
		}
		sc.close();
		
		
		
		//소요 시간 : 분 초
	}
}
