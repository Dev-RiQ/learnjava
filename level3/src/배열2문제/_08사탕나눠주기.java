package 배열2문제;

import java.util.Arrays;

public class _08사탕나눠주기 {

	public static void main(String[] args) {

		/*
		 	[문제]
		 		아래 배열은 각 병에 들어있는 사탕의 양이다.
		 		사탕의 종류는 전부 다르고 한 사람당 한 병에서 25개씩 나눠주려 한다.
		 		남은 사탕은 옆으로 옮기지 않고 오로지 한 종류씩만 나눠준다고 할 때,
		 		나눠줄 수 있는 사람 수를 사람 수 배열에 저장하시오,.
		 		나눠주고 남은 사탕은 나머지 배열에 순차적으로 저장하시오.
		 		
		 		1. 배열이 있다. 각 index항목이 사탕의 양이다.
		 		2. 1인당 25개씩 나눠준다.
		 		3. 나눠주고 남은건 그대로 둔다
		 		4.나눠준 사람수를 배열에 저장한다
		 		5. 나눠주고 남은 사탕 나머지 배열에 저장한다.
		 		
		 		
		 		
		 */
		int[] candy = { 80, 53, 36, 22 };
		int[] people = new int[4]; // 나눠준 사람수
		int[] remainCandy = new int[4]; // 나눠주고 남은 사탕 수

		for (int i = 0; i < candy.length; i++) {
			people[i] = candy[i] / 25; //몫 => 사람수
			remainCandy[i] = candy[i]%25 ;
		}
		System.out.println(Arrays.toString(people));
		System.out.println(Arrays.toString(remainCandy));
		
		
		
		
		
	}

}
