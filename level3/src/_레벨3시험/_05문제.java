package _레벨3시험;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class _05문제 {

	public static void main(String[] args) {

		/*
		 	[문제] 1 to 4
		 		1. arr배열에 1~4 사이의 숫자를 중복없이 저장한다
		 		2. 사용자는 1부터 순서대로 해당 위치 값을 입력한다
		 		3. 정답을 맞추면 해당 값은 9로 변경되어 모든 값이
		 		9가 되면 게임 종료
		 */
		Scanner sc = new Scanner(System.in);
		Random rd = new Random();
		int[] arr = new int[4];
		boolean[] check = new boolean[4];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = rd.nextInt(4) + 1;
			if (check[arr[i] - 1]) {
				i--;
			} else {
				check[arr[i] - 1] = true;
			}
		}
		int cnt = 0;
		while (true) {
			System.out.println(Arrays.toString(arr));
			if (cnt == 4) {
				break;
			}
			System.out.print("인덱스 입력 : ");
			int idx = sc.nextInt();
			if (idx < 0 || idx > 3) {
				System.out.println("인덱스 범위 오류");
				continue;
			}
			if (arr[idx] == 9) {
				System.out.println("이미 변경한 값입니다");
				continue;
			}
			arr[idx] = 9;
			cnt++;
		}
		System.out.println("게임 종료");
		sc.close();
		// 소요 시간 : 6분 35초
	}

}
