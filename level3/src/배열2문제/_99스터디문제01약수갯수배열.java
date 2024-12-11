package 배열2문제;

import java.util.Arrays;
import java.util.Random;

public class _99스터디문제01약수갯수배열 {

	public static void main(String[] args) {

		/*
		 	[문제] 약수 갯수 배열
		 		10~100 범위의 랜덤 값을 두개 지정한다.
		 		두 랜덤 값의 약수 갯수를 서로 다른 배열의 범위로 설정하고
		 		각각의 약수를 서로 다른 배열에 저장후 출력한다.
		 		(ex. 10의 약수의 갯수 = 4 ==> int[] a1 = new int[4];
		 			 11의 약수의 갯수 = 2 ==> int[] a1 = new int[2];)
		 		랜덤 돌릴때 마다 범위가 자동 변경 되게 만들기.
		 	[예시]
		 		rd1 = 77, rd2 = 88 
				rd1 약수 갯수 = 4, rd2 약수 갯수 = 8 
				a1 = [1, 7, 11, 77]
				a2 = [1, 2, 4, 8, 11, 22, 44, 88]
		 */
		Random rd = new Random();
		//10~100 범위의 랜덤 값을 두개 지정한다. (int rd1,2만들어서 랜덤 범위 10~100 넣고 저장.
		int rd1 = rd.nextInt(91) + 10;
		int rd2 = rd.nextInt(91) + 10;
		System.out.printf("rd1 = %d, rd2 = %d \n", rd1, rd2);
		//두 랜덤 값의 약수 갯수 (cnt있어야할거같고, 근데 값 두개니까 cnt1,2  반복문으로 나머지 0일떄 카운팅
		int cnt1 = 0;
		int cnt2 = 0;
		for (int i = 1; i <= 100; i++) {
			if (rd1 % i == 0) {
				cnt1++;
			}
			if (rd2 % i == 0) {
				cnt2++;
			}
		}
		System.out.printf("rd1 약수 갯수 = %d, rd2 약수 갯수 = %d \n", cnt1, cnt2);
		//를 서로 다른 배열의 범위로 설정하고 (배열 2개 만들어서 범위를 cnt로 설정
		int[] a1 = new int[cnt1];
		int[] a2 = new int[cnt2];
		int idx1 = 0;
		int idx2 = 0;
		//각각의 약수를 서로 다른 배열에 저장후 출력한다. (약수 어차피 아까 한거 복붙, a1[i] = i 
		for (int i = 1; i <= 100; i++) {
			if (rd1 % i == 0) {
				a1[idx1] = i;
				idx1++;
			}
			if (rd2 % i == 0) {
				a2[idx2] = i;
				idx2++;
			}
		}
		System.out.println("a1 = " + Arrays.toString(a1));
		System.out.println("a2 = " + Arrays.toString(a2));
		
		
	}

}
