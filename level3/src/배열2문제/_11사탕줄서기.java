package 배열2문제;

import java.util.Arrays;

public class _11사탕줄서기 {

	public static void main(String[] args) {

		/*
		 	[문제]
		 		아래 배열은 각 병에 들어있는 사탕의 양이다.
		 		사탕의 종류는 전부 다르고 한 사람마다 한병에서
		 		25개씩 나누어 주려고 한다.
		 		남은 사탕은 옆으로 옮겨서 다른 사람한테 나눠줄 수 있다.
		 		나눠줄 수 있는 사람 수를 사람수 배열에 저장하시오
		 		
		 		3. 남은거 옆으로 옮김
		 		
		 */
		//
//		1.무슨 배열이 있구나
	//	2. 배열의 각 값은 사탕의 양
		int[] candy = { 97, 53, 36, 22 };
		int[] people = new int[4];
		int size = candy.length;
		//3. 이 사탕을 25개씩 나눠준다
		
		//5.나눠준 사람 수 따로 배열 저장 
		for(int i =0; i<size;i++) {   //i = 3;
			people[i] = candy[i]/25; //{ 0, 75, 36, 22 };
			candy[i] = candy[i]%25; //{ 0, 0 , 36, 22 };
			//4.남은거 다음 배열로 넘겨준다 (30개 -25개  5개 arr[1]->arr[2])
			if(i<3) {
				candy[i+1] = candy[i+1] + candy[i];//{ 0, 0 , 36 + 0 , 22 };
				candy[i] = 0;//{ 0 , 0 , 36, 22 };
			}
				
			}
		
		
//		for (int i = 0; i < size; i++) {
//			people[i] = candy[i] / divNum;
//			candy[i] %= divNum;
//			if (i < size - 1) {
//				candy[i + 1] += candy[i];
//				candy[i] = 0;
//			}
//		}
		System.out.println("남은 사탕 수 = "+Arrays.toString(candy));
		System.out.println("나눠 준 사람 수 = "+Arrays.toString(people));
		
		
	}

}
