package 기초03문제;

import java.util.Scanner;

public class _15과락 {

	public static void main(String[] args) {

		/*
		 * [문제]
		 * 		사용자에게 각각 국어 영어 수학 점수를 입력받고
		 * 		3과목의 평균이 60점 이상이면 합격이다.
		 * 		단, 한 과목이라도 50점 미만이면 불합격.
		 * 		국어 100, 영어 87, 수학 49는 합격인가 불합격인가?
		 */
		
		Scanner scan = new Scanner(System.in);

		System.out.print("국어 점수를 입력하세요 >");
		int kor = scan.nextInt();
		
		System.out.print("\n영어 점수를 입력하세요 >");
		int eng = scan.nextInt();
		
		System.out.print("\n수학 점수를 입력하세요 >");
		int math = scan.nextInt();

		double avg = (kor + eng + math) * 1.0 / 3;
		boolean pass = avg >= 60 && kor >= 50 && eng >= 50 && math >= 50;

		System.out.printf("\n국 : %d점 \n영 : %d점 \n수 : %d점 \n평균 : %.2f점\n",kor,eng,math,avg);
		System.out.println("\n합격?\n" + pass);

		scan.close();
		
	}

}
