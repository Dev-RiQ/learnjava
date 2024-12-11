package _level2시험;

import java.util.Random;

public class _06문제 {

	public static void main(String[] args) {

		/*
		   [문제]
		  		1. 랜덤 10회 반복
		  		2. 50~100 사이의 랜덤 숫자 저장(학생의 성적)
		  		3. 성적이 60점 이상이면 합격
		  		
		  		전교생의 총점 평균 출력
		  		합격자수 출력
		  		1등 학생의 번호 성적 출력
		  		2등 학생 번호 성적 출력
		 */
		
		Random rd = new Random();
		int i = 1;
		int cnt = 0;
		double avg = 0;
		int sum = 0;
		int score1st = 0;
		int score2nd = 0;
		int num1st = 0;
		int num2nd = 0;
		int score = 0;
		while(i<=10) {
			score = rd.nextInt(51)+50;
			System.out.println(i + " "+ score);
			if(score >=60) {
				cnt+=1;
			}
			if(score1st<score) {
				score2nd = score1st;
				num2nd = num1st;
				score1st = score;
				num1st = i;
			}
			if(score2nd<score&&score<score1st) {
				score2nd = score;
				num2nd = i;
			}
			i+=1;
			sum+=score;
		}
		avg = sum*1.0 / 10;
		System.out.println("총점 : "+sum);
		System.out.printf("평균 : %.2f \n",avg);
		System.out.println("합격자 수 : "+cnt);
		System.out.printf("1등 학생 : %d번, %d점 \n",num1st,score1st);
		System.out.printf("2등 학생 : %d번, %d점 \n",num2nd,score2nd);
		
		
		//소요 시간 : 11분 23초
	}

}
