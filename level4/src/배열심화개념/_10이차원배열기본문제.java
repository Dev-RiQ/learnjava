package 배열심화개념;

import java.util.Arrays;

public class _10이차원배열기본문제 {

	public static void main(String[] args) {

//		int[][] arr = {
//				{10,20,30},
//				{10,20,30,40,50},
//				{10,20,30,40}
//		};
//		위와 같은 배열을 반복문으로 만들기
		int row = 3; // 주소값 저장할 방 갯수 지정
		int[][] test = new int[row][]; // 주소값 저장할 방의 주소 먼저 생성
		int[] list = { 3, 5, 4 }; // 주소값 당 할당 갯수(예정)
		for (int i = 0; i < test.length; i++) { 
			test[i] = new int[list[i]];  // 미리 만든 빈 방에 i번째 주소값 1개씩 생성
			for (int k = 0; k < list[i]; k++) {  // 생성된 i번째 주소값에 칸 만큼 숫자 넣기
				test[i][k] = (k + 1) * 10;
			}
			System.out.println(Arrays.toString(test[i]));
		}
	}

}
