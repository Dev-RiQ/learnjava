package 배열2문제;

import java.util.Random;
import java.util.Scanner;

public class _21기억력게임 {

	public static void main(String[] args) {

		/*
		 	[문제]
		 		각은 숫자의 위치를 2개 입력해 정답을 맞추는 게임이다.
		 		1~5를 2번씩 사용하여 1000번 섞는다
		 		사용자가 인덱스 번호 2개를 입력해서 그 값을 비교한다
		 		두 인덱스 값이 맞으면 back에 숫자 저장,
		 		back 다차면 게임 종료
		 */
		Scanner sc = new Scanner(System.in);
		Random rd = new Random();

		int[] front = { 1, 1, 2, 2, 3, 3, 4, 4, 5, 5 }; // 앞면
		int[] back = new int[10]; // 뒷면

		for (int i = 0; i < 1000; i++) {
			int rdIdx = rd.nextInt(10);
			int temp = front[0];
			front[0] = front[rdIdx];
			front[rdIdx] = temp;
		}
		int cnt = 0;
		while (true) {
			for (int i = 0; i < 5; i++) {
				System.out.print(" " + i + " ");
			}
			System.out.println();
			for (int i = 0; i < back.length; i++) {
				System.out.print(back[i] == 0 ? "[ ]" : "[" + back[i] + "]");
				if(i==4) {
					System.out.println();
				}
			}
			System.out.println();
			for (int i = 5; i < back.length; i++) {
				System.out.print(" " + i + " ");
			}
			System.out.println();
			if (cnt == 5) {
				System.out.print("게임 종료");
				break;
			}
			System.out.print("입력 1 >> ");
			int idx1 = sc.nextInt();
			System.out.print("입력 2 >> ");
			int idx2 = sc.nextInt();
			if (idx1 < 0 || idx2 < 0 || idx1 > front.length - 1 || idx2 > front.length - 1) {
				System.out.println("카드가 존재하는 범위를 입력하세요");
				continue;
			}
			if (back[idx1] != 0 || back[idx2] != 0) {
				System.out.println("이미 뒤집어진 카드가 존재합니다");
				continue;
			}
			if (idx1 == idx2) {
				System.out.println("서로 다른 카드를 입력하세요");
				continue;
			}
			for (int i = 0; i < back.length; i++) {
				if (i == idx1 || i == idx2) {
					System.out.print("[" + front[i] + "]");
				} else {
					System.out.print(back[i] == 0 ? "[ ]" : "[" + back[i] + "]");
				}
				if(i==4) {
					System.out.println();
				}
			}
			System.out.println();
			System.out.println("===============");
			if (front[idx1] == front[idx2]) {
				back[idx1] = front[idx1];
				back[idx2] = front[idx2];
				cnt++;
			}
		}
		sc.close();
	}

}
