      package 반복문문제02;

import java.util.Random;
import java.util.Scanner;

public class _17카카오택시 {

	public static void main(String[] args) {

		/*
		 	1. 손님을 태워 목적지까지 이동하는 게임
		 	2. -10~10 사이의 랜덤 숫자 2개를 저장해 목적지로 설정한다.
		 	3. 메뉴는 아래와 같다.
		 		1)속도설정 : 1~3까지 가능
		 		2)방향설정 : 동(1)서(2)남(3)북(4)
		 		3)이동하기 : 설정된 방향으로 설정된 속도만큼 이동
		 	4. 거리 1칸 당 50원씩 추가되어 도착시 요금도 출력한다.
		 	5. 도착하면 다시 -10~10 사이의 랜덤 목적지가 설정된다.
		 	//속도나 방향이 0이면 이동 불가
		 */
		
		int dir = 0;
		int x = 0;
		int y = 0;
		int speed = 0;
		int cost = 0;
		int costTotal = 0;
		int costPer1 = 50;
		int xx = 0;
		int yy = 0;

		Random rd = new Random();
		Scanner sc = new Scanner(System.in);

		int dx = rd.nextInt(21) - 10;
		int dy = rd.nextInt(21) - 10;
		int menu = 0;

		while (true) {
			System.out.printf("\n[목  적  지] (%d , %d)\n", dx, dy);
			System.out.printf("[현 재 위 치] (%d , %d)\n", x, y);
			System.out.printf("[방      향] : %d [속      도] :%d\n", dir, speed);
			System.out.printf("[현 재 요 금] : %d [전 체 수 익] : %d\n", cost, costTotal);
			System.out.println("========================");
			while (true) {
				System.out.println("[1.속도] [2.방향] [3.이동] [0.종료]");
				System.out.print("메뉴 선택 >>");
				menu = sc.nextInt();
				if (menu < 0 || menu > 3) {
					System.out.println("메뉴 선택 오류");
					continue;
				}
				break;
			}
			if (menu == 0) {
				System.out.println("프로그램 종료");
				break;
			} else if (menu == 1) {
				while (true) {
					System.out.print("속도(1~3) >> ");
					speed = sc.nextInt();
					if (speed < 1 || speed > 3) {
						System.out.println("속도 입력 오류");
						continue;
					}
					break;
				}
			} else if (menu == 2) {
				while (true) {
					System.out.println("방향을 입력하세요");
					System.out.println("[1.북(+Y)][2.동(+X)][3.남(-Y)][4.서(-X)]");
					dir = sc.nextInt();
					if (dir < 1 || dir > 4) {
						System.out.println("방향 입력 오류");
						continue;
					}
					break;
				}
			} else {
				if (dir == 0 || speed == 0) {
					System.out.println("속도 또는 방향 미설정");
					continue;
				} else {
					xx = dx - x;
					yy = dy - y;
					x = dx;
					y = dy;
					if (xx < 0) {
						xx = -xx;
					}
					if (yy < 0) {
						yy = -yy;
					}
					cost = costPer1 * (xx + yy);
					costTotal += cost;
					dx = rd.nextInt(21) - 10;
					dy = rd.nextInt(21) - 10;
					System.out.println("목적지에 도착했습니다.");
					System.out.printf("지불요금은 %d원입니다.\n", cost);
					System.out.println("안녕히가세요.");
					System.out.println("========================");
					System.out.println("새로운 목적지로 설정됩니다.");
				}
			}

		}
		sc.close();
		
		
		
	}

}
