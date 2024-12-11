package 배열심화개념;

import java.util.Arrays;
import java.util.Scanner;

public class _07배열컨트롤러2단계 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int[] score = null;
		int count = 0;
		while (true) {
			System.out.println("[벡터 컨트롤러]");
			System.out.println(Arrays.toString(score));
			System.out.println("[1]추가");
			System.out.println("[2]삭제(인덱스)");
			System.out.println("[3]삭제(값)");
			System.out.println("[4]삽입");
			System.out.println("[0]종료");
			int sel = sc.nextInt();
			if (sel == 0) {
				System.out.println("종료");
				break;
			}
			if (sel < 1 || sel > 4) {
				System.out.println("입력오류");
				continue;
			}
			if (sel == 1) {
				System.out.print("[추가] 값 >> ");
				int value = sc.nextInt();
				if (value == 0) {
					System.out.println("0 제외 입력");
					continue;
				}
				if (score == null) {
					score = new int[count + 1];
				} else {
					int[] temp = score;
					score = new int[count + 1];
					for (int i = 0; i < count; i++) {
						score[i] = temp[i];
					}
					temp = null;
				}
				score[count] = value;
				count++;
				System.out.println(value + " 추가 완료\n");
			} else if (sel == 2) {
				if (score == null) {
					System.out.println("삭제할 데이터가 없습니다.\n");
				} else {
					System.out.print("[삭제] 인덱스 >> ");
					int idx = sc.nextInt();
					if (idx < 0 || idx >= count) {
						System.out.println("해당 인덱스가 존재하지 않음");
						continue;
					}
					if (count == 1) {
						score = null;
						continue;
					}
					int[] temp = score;
					score = new int[count - 1];
					int index = 0;
					for (int i = 0; i < count; i++) {
						if (i != idx) {
							score[index++] = temp[i];
						}
					}
					temp = null;
					count--;
					System.out.println("인덱스 " + idx + "번 삭제 완료\n");
				}
			} else if (sel == 3) {
				if (score == null) {
					System.out.println("삭제할 데이터가 없습니다.\n");
				} else {
					System.out.print("[삭제] 값 >> ");
					int value = sc.nextInt();
					boolean rs = false;
					for (int i = 0; i < count; i++) {
						if (score[i] == value) {
							rs = true;
							break;
						}
					}
					if (!rs) {
						System.out.println("해당 값이 존재하지 않음");
						continue;
					}
					if (count == 1) {
						score = null;
						continue;
					}
					int[] temp = score;
					score = new int[count - 1];
					int index = 0;
					for (int i = 0; i < count; i++) {
						if (temp[i] != value) {
							score[index++] = temp[i];
						}
					}
					temp = null;
					count--;
					System.out.println("값 " + value + " 삭제 완료\n");
				}
			} else if (sel == 4) {
				if (score == null) {
					System.out.println("삽입할 곳이 없습니다.\n");
				} else {
					System.out.print("[삽입] 값 >> ");
					int value = sc.nextInt();
					if (value == 0) {
						System.out.println("0 제외 입력");
						continue;
					}
					System.out.print("[삽입] 인덱스 >> ");
					int idx = sc.nextInt();
					if (idx >= count || idx < 0) {
						System.out.println("범위 오류");
						continue;
					}
					int[] temp = score;
					score = new int[count + 1];
					int index = 0;
					for (int i = 0; i < count+1; i++) {
						if (i == idx) { 
							score[i] = value;
						}else {
							score[i] = temp[index++];
						}
					}
					temp = null;
					count++;
					System.out.println("값 " + value + " 인덱스 " + idx + "에 삽입 완료\n");
				}
			}
		}
		sc.close();
	}

}
