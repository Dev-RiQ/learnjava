package 메서드문제;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

class ScoreMg {

	Scanner sc = new Scanner(System.in);

	int[] scores;

	void setRandomScore(int[] a) {
		Random rd = new Random();
		scores = new int[a.length];
		for (int i = 0; i < a.length; i++)
			scores[i] = rd.nextInt(100) + 1;
		System.out.println("scores = " + Arrays.toString(scores));
	}

	void printSumAndAverager(int[] arr) {
		int totalScore = 0;
		double averageTotalScore = 0;
		for (int a : arr)
			totalScore += a;
		averageTotalScore = totalScore * 1.0 / arr.length;
		System.out.printf("총점 : %d , 평균 : %.1f \n", totalScore, averageTotalScore);
	}

	void printPassStuCnt(int[] arr) {
		int cntScoreOver60 = 0;
		for (int a : arr)
			if (a >= 60)
				cntScoreOver60++;
		System.out.printf("합격생 수 : %d \n", cntScoreOver60);
	}

	void printScorebyIndex(int[] arr) {
		while (true) {
			System.out.print("인덱스 입력 : ");
			int index = sc.nextInt();
			if (index < 0 || index > arr.length - 1) {
				System.out.println("존재하지 않는 인덱스입니다.");
				continue;
			}
			System.out.printf("성적 : %d \n", arr[index]);
			break;
		}
	}

	void printIndexbyScore(int[] arr) {
		while (true) {
			System.out.print("성적 입력 : ");
			int score = sc.nextInt();
			boolean isHave = false;
			for (int i = 0; i < arr.length; i++)
				if (arr[i] == score) {
					System.out.printf("인덱스 : %d \n", i);
					isHave = true;
				}
			if (!isHave) {
				System.out.println("존재하지 않는 성적입니다.");
				continue;
			}
			break;
		}
	}

	void printScorebyHakbun(int[] arr, int[] arr2) {
		while (true) {
			System.out.print("학번 입력 : ");
			int hakbun = sc.nextInt();
			int index = -1;
			for (int i = 0; i < arr2.length; i++)
				if (arr2[i] == hakbun)
					index = i;
			if (index == -1) {
				System.out.println("존재하지 않는 학번입니다.");
				continue;
			}
			System.out.printf("성적 : %d \n", arr[index]);
			break;
		}
	}

	void printFirstGradeStu(int[] arr, int[] arr2) {
		int index = 0;
		int max = 0;
		for (int i = 0; i < arr.length; i++)
			if (max < arr[i]) {
				max = arr[i];
				index = i;
			}
		System.out.printf("1등 학번 : %d , 성적 : %d \n", arr2[index], arr[index]);
	}

}

public class _04메서드기본문제3 {

	public static void main(String[] args) {

		int[] hakbuns = { 1001, 1002, 1003, 1004, 1005 };
		int[] scores = new int[5];
		ScoreMg test = new ScoreMg();

		// 1) scores배열에 1~100점 사이의 랜덤 정수 5개 저장
		test.setRandomScore(scores);
		scores = test.scores;
		// 2) 전교생 총점과 평균 출력
		test.printSumAndAverager(scores);
		// 3) 성적이 60점 이상이면 합격, 합격생 수 출력
		test.printPassStuCnt(scores);
		// 4) 인덱스 입력받아 성적 출력
		test.printScorebyIndex(scores);
		// 5) 성적 입력받아 인덱스 출력
		test.printIndexbyScore(scores);
		// 6) 학번 입력받아 성적출력
		test.printScorebyHakbun(scores, hakbuns);
		// 7) 1등 학생의 학번과 성적 출력
//		test.printFirstGradeStu(scores, hakbuns);
		test.sc.close();
	}

}
