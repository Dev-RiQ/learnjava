package 배열2문제;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class _14게임1to4 {

	public static void main(String[] args) {

		/*
		 	[문제]
		 		arr배열에 1~4 사이 숫자 중복없이 저장
		 		사용자는 1부터 순서대로 해당 위치 값을 입력한다
		 		정답을 맞추면 해당 값은 9로 변경되어 모든 값이 9가 되면 게임종료
		 */
		
		Scanner sc = new Scanner(System.in);
		Random rd = new Random();
		int[] arr = new int[4];
		boolean[] check = new boolean[4];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = rd.nextInt(4)+1;
			if (check[arr[i]-1]) {
				i--;
			} else {
				check[arr[i]-1] = true;
			}
		}
//		for (int i = 0; i < arr.length; i++) {
//			int index = rd.nextInt(4);
//			if (check[index]) {
//				i--;
//			} else {
//				arr[index] = i + 1;
//				check[index] = true;
//			}
//		}
		int cnt = 0;
		while (true) {
			System.out.println(Arrays.toString(arr));
			System.out.print("index 입력 : ");
			int idx = sc.nextInt();
			System.out.print("num 입력 : ");
			int num = sc.nextInt();
			if (num < 1 || num > 4 || idx < 0 || idx > 3) {
				System.out.println("입력 오류");
				continue;
			}
			if (arr[idx] == num) {
				System.out.println("정답");
				arr[idx] = 9;
				cnt++;
			} else {
				System.out.println("오답");
			}
			if (cnt == 4) {
				System.out.println("게임 종료");
				break;
			}
		}
		sc.close();
	}

}
