package level4시험;

import java.util.Arrays;
import java.util.Scanner;

public class _01 {

	public static void main(String[] args) {

		/*
		 	배열 컨트롤러 2단계
		 	1. 추가
		 	2. 삭제(인덱스)
		 	3. 삭제(값)
		 	4. 삽입
		 */
		Scanner sc = new Scanner(System.in);
		int[] score = null;
		int count = 0;
		int value = 0;
		int index = -1;
		int idxCheck = 0;
		while (true) {
			System.out.println(Arrays.toString(score));
			System.out.println("[벡터 컨트롤러]");
			System.out.println("[1]추가");
			System.out.println("[2]삭제(인덱스)");
			System.out.println("[3]삭제(값)");
			System.out.println("[4]삽입");
			System.out.println("[0]종료");
			System.out.print("메뉴 선택 >> ");
			int sel = sc.nextInt();
			if (sel == 0) {
				System.out.println("프로그램 종료");
				break;
			}
			if (sel < 1 || sel > 4) {
				System.out.println("입력 오류");
				continue;
			}
			if ((sel == 2 || sel == 3 || sel == 4) && count == 0) {
				System.out.println("처리할 데이터 없음");
				continue;
			}
			if (sel == 1 || sel == 3 || sel == 4) {
				while (true) {
					System.out.print("값 입력 >> ");
					value = sc.nextInt();
					if (value == 0) {
						System.out.println("0 제외 입력");
						continue;
					}
					if (sel == 3) {
						boolean isHave = false;
						for (int i = 0; i < count; i++) {
							if (score[i] == value) {
								isHave = true;
								break;
							}
						}
						if (!isHave) {
							System.out.println("존재하지 않는 값");
							continue;
						}
					}
					break;
				}
			}
			if (sel == 2 || sel == 4) {
				System.out.print("인덱스 입력 >> ");
				index = sc.nextInt();
				if (index < 0 || index > count - 1) {
					System.out.println("존재하지 않는 index 범위");
					continue;
				}
			}
			if (sel == 1) {
				if (count == 0) {
					score = new int[count + 1];
					score[count++] = value;
				} else {
					int[] temp = score;
					score = new int[count + 1];
					for (int i = 0; i < count; i++) {
						score[i] = temp[i];
					}
					score[count++] = value;
				}
			} else if (sel == 2 || sel == 3) {
				idxCheck = 0;
				int[] temp = score;
				score = new int[count - 1];
				for (int i = 0; i < count; i++) {
					if (sel == 2 && i != index) {
						score[idxCheck++] = temp[i];
					}
					if (sel == 3 && temp[i] != value) {
						score[idxCheck++] = temp[i];
					}
				}
				count--;
			} else if (sel == 4) {
				idxCheck = 0;
				int[] temp = score;
				score = new int[++count];
				for (int i = 0; i < count; i++) {
					if (i == index) {
						score[i] = value;
					} else {
						score[i] = temp[idxCheck++];
					}
				}
			}
		}
		sc.close();
		// 소요 시간 : 30분 1초
	}

}
