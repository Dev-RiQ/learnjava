package 배열심화2;

import java.util.Random;

public class _02시험지나눠주기 {

	public static void main(String[] args) {

		/*
		 	아래 2차원 배열은 3학년 1반의 학생 수를 표현한 것으로
		 	세로4 가로5의 총 학생 수는 20명이다.
		 	배열 안의 각각의 값들은 각 학생별 시험을 보기 위한 필요 페이지 수이다.
		 	학생마다 필요한 페이지 수가 다르다.
		 	
		 	시험지를 인덱스 위치(0,0)부터 나눠주려 할 때
		 	지그재그 형태로 전달하려 한다
		 	
		 	첫줄은 앞에서 뒤로
		 	둘째줄은 뒤에서 앞으로
		 	....
		 	
		 	랜덤 학생수(1~20)을 저장하고,
		 	각 학생별로 필요한 페이지 수의 합을 출력한다
		 */
		Random rd = new Random();
		int[][] arr = {
				{3,1,5,4,1},
				{1,6,4,2,8},
				{2,3,5,5,2},
				{6,1,7,1,2}
		};
		int rdNum = rd.nextInt(20) + 1;
		System.out.print("랜덤 숫자 : " + rdNum + " => ");
		int page = 0;
		boolean isEnd = false;
		for (int i = 0; i < arr.length; i++) {
			System.out.print("{");
			for (int k = 0; k < arr[i].length; k++) {
				if (rdNum == 0) {
					isEnd = true;
					break;
				}
				page += i % 2 == 0 ? arr[i][k] : arr[i][arr[i].length - 1 - k];
				rdNum--;
				System.out.print(k != 0 ? " + " : "");
				System.out.print(i % 2 == 0 ? arr[i][k] : arr[i][arr[i].length - 1 - k]);
			}
			System.out.print("}");
			System.out.print(isEnd ? " = " + page : " + ");
			if (isEnd) {
				break;
			}
		}
	}

}
