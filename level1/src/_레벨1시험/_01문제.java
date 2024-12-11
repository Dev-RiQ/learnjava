package _레벨1시험;

public class _01문제 {

	public static void main(String[] args) {

		/*
		 	[문제1]
		 		철수네 반 학생은 16명이다.
		 		8명은 양로원에 봉사활동을 다녀왔고
		 		4명은 지하철 봉사활동을 다녀왔다.
		 		봉사활동을다녀오지 않은 학생의 비율은 몇% 인지 구하시오.
		 	[정답]
		 		25%
		 */
		
		int student = 16;
		int volYang = 8;
		int volSub = 4;
		int volNot = student - volSub - volYang;

		double volNotRatio = volNot * 1.0 / student * 100;

		System.out.println(volNotRatio + " %");

		//시간 : 3분 40초
		
		
	}

}
