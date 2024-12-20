package 클래스_문제;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

class AddGame {
	int[] game = new int[6];
	int[] idx = new int[3];
	int[] myIdx = new int[3];
	int total = 0;
}

public class _07더하기게임 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Random rd = new Random();
		AddGame ag = new AddGame();
		for (int i = 0; i < ag.game.length; i++) {
			ag.game[i] = rd.nextInt(10) + 1;
			for (int k = 0; k < i; k++) {
				if (ag.game[i] == ag.game[k]) {
					i--;
					break;
				}
			}
		}
		for (int i = 0; i < ag.idx.length; i++) {
			ag.idx[i] = rd.nextInt(ag.game.length);
			for (int k = 0; k < i; k++) {
				if (ag.idx[i] == ag.idx[k]) {
					i--;
					break;
				}
			}
		}
		for (int i = 0; i < ag.idx.length; i++) {
			ag.total += ag.game[ag.idx[i]];
		}

		int myAns = 0;
		System.out.println("======== 숫자 카드 ========");
		System.out.println(Arrays.toString(ag.game));
		System.out.println("===========================");
		System.out.println("문제 : " + ag.total);
		System.out.println("======== 정답 카드 ========");
		System.out.println(Arrays.toString(ag.idx));
		for (int i = 0; i < ag.myIdx.length; i++) {
			System.out.print((i + 1) + "번 인덱스 >> ");
			int selIdx = sc.nextInt();
			if (selIdx < 0 || selIdx > ag.game.length - 1) {
				System.out.println("존재하지 않는 인덱스");
				i--;
				continue;
			}
			boolean isHave = false;
			for (int k = 0; k < i; k++) {
				if (ag.myIdx[i] == ag.myIdx[k]) {
					isHave = true;
					break;
				}
			}
			if (isHave) {
				System.out.println("이미 선택한 인덱스");
				i--;
				continue;
			}
			ag.myIdx[i] = selIdx;
			myAns += ag.game[selIdx];
		}
		if (myAns == ag.total) {
			System.out.println("정답");
		} else {
			System.out.print("오답 ");
			System.out.println("[당신의 합은" + myAns + "]");
		}
		sc.close();
	}

}
