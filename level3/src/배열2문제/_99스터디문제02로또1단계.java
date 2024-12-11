package 배열2문제;

import java.util.Arrays;
import java.util.Random;

public class _99스터디문제02로또1단계 {

	public static void main(String[] args) {

		/*
		 	[문제] 로또 1단계
		 		1~45 범위의 중복 없는 랜덤 값을 서로 다른 두 개의 배열에 각각 6개씩 저장한다.
		 		두 배열 모두 오름차순으로 정렬한다.
		 		두 배열을 비교하여 값이 일치하면 새로운 배열에 순차적으로 저장한 후 갯수를 측정한다.
		 		갯수와 맞춘 번호를 출력하고, 당첨여부와 등수를 출력한다.
		 		 	1) 값 일치 6개 = 1등
		 		 	2) 값 일치 5개 = 2등
		 		 	3) 값 일치 4개 = 3등
		 		 	4) 값 일치 3개 = 4등
		 		 	5) 값 일치 3개 미만 = 낙첨
		 		 	// 낙첨이 아니면 등수 출력 전에 "당첨되었습니다!" 출력
		 	[예시1]
		 		rd1 = [7, 38, 15, 22, 34, 12]
				rd2 = [43, 44, 30, 2, 40, 14]
				맞춘 갯수 : 0개

				낙첨
			[예시2]
				rd1 = [33, 25, 12, 9, 20, 45]
				rd2 = [20, 37, 33, 10, 18, 25]
				맞춘 갯수 : 3개
				맞춘 번호 : 20, 33, 25
				당첨되었습니다!
				4등
			[예시3]
				rd1 = [1, 4, 3, 2, 5, 6]
				rd2 = [4, 6, 3, 5, 2, 1]
				맞춘 갯수 : 6개
				맞춘 번호 : 4, 6, 3, 5, 2, 1
				당첨되었습니다!
				1등
		 */
		
		int[] rd1 = new int[6];
		int[] rd2 = new int[6];
		int[] match = new int[6];
		Random rd = new Random();
		boolean[] check1 = new boolean[46];
		boolean[] check2 = new boolean[46];
		//랜덤 1
		for (int i = 0; i < rd1.length; i++) {
			rd1[i] = rd.nextInt(45) + 1;
			if (check1[rd1[i]]) {
				i--;
			} else {
				check1[rd1[i]] = true;
			}
		}
		System.out.println("rd1 = " + Arrays.toString(rd1));
		//랜덤 2
		for (int i = 0; i < rd2.length; i++) {
			rd2[i] = rd.nextInt(45) + 1;
			if (check2[rd2[i]]) {
				i--;
			} else {
				check2[rd2[i]] = true;
			}
		}
		System.out.println("rd2 = " + Arrays.toString(rd2));
		//일치 카운팅
		int cnt = 0;
		int idx = 0;
		for(int i = 0; i<rd2.length;i++) {
			if (check1[rd2[i]]) {
				cnt++;
				match[idx++] = rd2[i];
			}
		}
		System.out.println("맞춘 갯수 : " + cnt + "개");
		//일치 번호 출력
		if (cnt > 0) {
			System.out.print("맞춘 번호 : ");
		}
		cnt = 0;
		for (int i = 0; i < match.length; i++) {
			if (match[i] != 0) {
				System.out.print(cnt == 0 ? match[i] : ", " + match[i]);
				cnt++;
			}
		}
		System.out.println("");
		//당첨 여부 및 등수
		if (cnt < 3) {
			System.out.println("낙첨");
		} else {
			System.out.println("당첨되었습니다!");
			System.out.println(7 - cnt + "등");
		}
		
	}

}
