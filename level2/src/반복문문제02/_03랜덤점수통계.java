package 반복문문제02;

import java.util.Random;

public class _03랜덤점수통계 {

	public static void main(String[] args) {

		/*
		 	1. 10회 반복을 한다.
		 	2. 1~100사이의 랜덤 숫자를 저장한다.(학생의 성적)
		 	3. 성적이 60점 이상이면 합격생이다.
		 	---------------
		 	1. 전교생(10명)의 총점과 평균을 출력한다.
		 	2. 합격자 수를 출력한다.
		 	3. 1등 학생의 번호와 성적을 출력한다.
		 */
		
		Random rd = new Random();

		int i = 1;
		int max = 10;
		int scoreTotal = 0;
		int pass = 0;
		int win = 0;
		int scoreWin = 0;

		while (i <= max) {
			int score = rd.nextInt(100) + 1;
			System.out.println(i + "번\t" + score);
			scoreTotal += score;
			if (score >= 60) {
				pass += 1;
			}
			if (score > scoreWin) {
				scoreWin = score;
				win = i;
			}
			i += 1;
		}

		double scoreAvg = scoreTotal * 1.0 / max;
		System.out.print("총점 : " + scoreTotal);
		System.out.printf("\t평균 : %.2f", scoreAvg);
		System.out.println("\n합격생수 : " + pass);
		System.out.println("1등 학생번호 : " + win + ", 점수 : " + scoreWin);
	}
}
