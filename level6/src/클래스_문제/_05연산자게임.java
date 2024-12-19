package 클래스_문제;

import java.util.Scanner;

class MathGame{
	int[][] arr = {
			{ 5, 9, 0 },
			{ 3, 7, 1 },
			{ 8, 4, 2 },
			{ 4, 4, 3 },
			{ 2, 2, 0 },
			{ 4, 6, 0 },
			{ 9, 2, 3 }
	};
	int answerCnt;
}

public class _05연산자게임 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		MathGame mg = new MathGame();

		for (int i = 0; i < mg.arr.length; i++) {
			int n1 = mg.arr[i][0];
			int n2 = mg.arr[i][1];
			int cal = mg.arr[i][2];
			int ans = 0;
			switch(cal) {
			case 0: ans = n1 + n2; break;
			case 1: ans = n1 - n2; break;
			case 2: ans = n1 * n2; break;
			case 3: ans = n1 % n2; break;
			}
			System.out.println("[ 연산자게임 ][score : " + mg.answerCnt + "]");
			System.out.println("------------------------");
			System.out.printf("%d번 문제 )  %d ? %d = %d\n", i + 1, n1, n2, ans);
			System.out.println("[1] + [2] - [3] * [4] %");
			System.out.println("------------------------");
			System.out.print("정답 >> ");
			int sel = sc.nextInt();
			if (sel < 1 || sel > 4) {
				System.out.println("입력 오류");
				i--;
				continue;
			}
			int myAns = 0;
			switch(sel) {
			case 1: myAns = n1 + n2; break;
			case 2: myAns = n1 - n2; break;
			case 3: myAns = n1 * n2; break;
			case 4: myAns = n1 % n2; break;
			}
			if (myAns == ans) {
				mg.answerCnt++;
				System.out.println("[ 정답입니다 ! ]");
			} else {
				System.out.printf("[ 오답입니다.. (정답은 %d번) ]\n", cal + 1);
			}
			System.out.println();
		}
		System.out.println("[최종 점수 : " + mg.answerCnt + "]");
		sc.close();
	}

}
