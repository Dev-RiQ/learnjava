package 배열1문제;

import java.util.Random;

public class _03학생성적관리1단계 {

	public static void main(String[] args) {

		//1. arr배열에 1~100점 사이 랜덤 정수 5개 저장
		//2. 전교생의 총점과 평균 출력
		//3. 성적이 60점 이상이면 합격, 학격생 수 출력
		
		Random rd = new Random();
		int set = 5;
		int[] arr = new int[set];
		int cnt = 0;
		int sum = 0;
		for (int i = 0; i < arr.length; i += 1) {
			arr[i] = rd.nextInt(100) + 1;
			System.out.print(arr[i] + " ");
			if (arr[i] >= 60) {
				cnt += 1;
			}
			sum += arr[i];
		}
		double avg = sum * 1.0 / arr.length;
		System.out.println();
		System.out.println("총점 : " + sum);
		System.out.printf("평균 : %.2f \n",avg);
		System.out.println("합격생 수 : " + cnt + "명");
		
	}

}
