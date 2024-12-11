package 반복문문제02;

import java.util.Random;
import java.util.Scanner;

public class _13코인게임 {

	public static void main(String[] args) {
		
		/*
		 	내 자금 3500원
		 	
		 	1. 0 또는 1의 랜덤 숫자를 저장한다.
		 	2. 0은 동전의 앞면, 1은 동전의 뒷면이다.
		 	3. 동전의 앞뒷면을 맞추는 게임이다.
		 	4. 정답을 맞추면 500원 이득
		 		틀리면 700원 손해
		 		연속 두번 정답이면 두배
		 	5. 게임이 끝날때마다 게임을 계속할지 종료할지 선택한다. (1.yes 2.no)
		 	6. 게임 종료 후, 남은 자금을 출력
		 	7. 남은 돈이 0원이면 (혹은 마이너스) 자동으로 게임 종료
		 */
		
		Random rd = new Random();
		Scanner sc = new Scanner(System.in);
		int money = 3500;
		int winCnt = 0;
		int round = 1;

		while (true) {
			System.out.println("[ round " + round + " ]");
			int rdNum = rd.nextInt(2);
			System.out.print("0.앞면 1.뒷면 입력 >> ");
			int inputNum = sc.nextInt();
			if (inputNum != 0 && inputNum != 1) {
				System.out.println("입력오류\n");
				continue;
			}
			System.out.printf("동전 : %d \n", rdNum);
			if (rdNum == inputNum) {
				System.out.println("정답 !");
				winCnt += 1;
				if (winCnt == 2) {
					money += (1000);
					System.out.println("+1000!!");
				} else {
					money += 500;
					System.out.println("+500!!");
				}
			} else {
				System.out.println("오답 ㅠ");
				System.out.println("-700..");
				winCnt = 0;
				money -= 700;
			}
			if (money <= 0) {
				break;
			}
			System.out.println("money = " + money);
			int sel = 0;
			while (true) {
				System.out.println("게임을 계속 하시겠습니까?");
				System.out.print("1. yes  2. no >>");
				sel = sc.nextInt();
				System.out.println("");
				if (sel != 1 && sel != 2) {
					System.out.println("입력오류\n");
					continue;
				}
				break;
			}
			if (sel == 2) {
				break;
			}
			round += 1;
		}
		System.out.println("게임종료");
		System.out.println("최종 money = " + money);
		sc.close();
	}

}
