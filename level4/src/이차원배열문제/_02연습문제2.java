package 이차원배열문제;

import java.util.Arrays;
import java.util.Scanner;

public class _02연습문제2 {

	public static void main(String[] args) {

		int[][] arr = new int[3][3];
		int size = arr.length;

		for (int i = 0; i < size; i++) {
			for (int k = 0; k < size; k++) {
				arr[i][k] = 10 * size * i + (k + 1) * 10;
			}
		}
		Scanner sc = new Scanner(System.in);
		while (true) {
			for (int i = 0; i < size; i++) {
				System.out.println(Arrays.toString(arr[i]));
			}
			System.out.println("1.값 찾기");
			System.out.println("2.인덱스 찾기");
			System.out.println("3.가장 큰 값의 인덱스 찾기");
			System.out.println("4.값 교체");
			System.out.println("0.종료");
			System.out.print("메뉴 선택 >> ");
			int sel = sc.nextInt();
			if (sel == 0) {
				System.out.println("종료");
				break;
			}
			if (sel < 1 || sel > 4) {
				System.out.println("입력 오류");
				continue;
			}
			System.out.println();
			if (sel == 1) {
				// 인덱스 2개 입력받아 값 출력
				while (true) {
					System.out.print("인덱스 1 >>");
					int idx1 = sc.nextInt();
					System.out.print("인덱스 2 >>");
					int idx2 = sc.nextInt();
					if (idx1 < 0 || idx1 >= size || idx2 < 0 || idx2 >= size) {
						System.out.println("인덱스 범위 오류");
						continue;
					}
					System.out.println(arr[idx1][idx2]);
					break;
				}
			} else if (sel == 2) {
				// 값을 입력받아 인덱스 2개 출력
				while (true) {
					System.out.print("값 >>");
					int value = sc.nextInt();
					boolean isEqual = false;
					for (int i = 0; i < size; i++) {
						for (int k = 0; k < size; k++) {
							if (arr[i][k] == value) {
								System.out.printf("인덱스 1 : %d \n인덱스 2 : %d", i, k);
								isEqual = true;
								break;
							}
						}
						if (isEqual) {
							break;
						}
					}
					if (!isEqual) {
						System.out.println("해당 값 없음");
						continue;
					}
					break;
				}
				System.out.println();
			} else if (sel == 3) {
				// 가장 큰 값의 인덱스 2개 출력\
				int max = 0;
				int idx1 = -1;
				int idx2 = -1;
				for (int i = 0; i < size; i++) {
					for (int k = 0; k < size; k++) {
						if (max < arr[i][k]) {
							max = arr[i][k];
							idx1 = i;
							idx2 = k;
						}
					}
				}
				System.out.printf("가장 큰 값 = %d의 \n인덱스 1 : %d \n인덱스 2 : %d", arr[idx1][idx2], idx1, idx2);
				System.out.println();
			} else {
				// 값 2개를 입력받아 값 교체 => 둘 중 하나라도 없으면 불가능
				while (true) {
					System.out.print("값 1 >>");
					int value1 = sc.nextInt();
					System.out.print("값 2 >>");
					int value2 = sc.nextInt();
					if (value1 == value2) {
						System.out.println("같은 값 입력 불가");
						continue;
					}
					int value1idx1 = -1;
					int value1idx2 = -1;
					int value2idx1 = -1;
					int value2idx2 = -1;
					for (int i = 0; i < size; i++) {
						for (int k = 0; k < size; k++) {
							if (arr[i][k] == value1) {
								value1idx1 = i;
								value1idx2 = k;
							}
							if (arr[i][k] == value2) {
								value2idx1 = i;
								value2idx2 = k;
							}
						}
						if (!(value1idx1 == -1 || value2idx1 == -1)) {
							break;
						}
					}
					if (value1idx1 == -1 || value2idx1 == -1) {
						System.out.println("입력값이 존재하지 않음");
					} else {
						int temp = arr[value1idx1][value1idx2];
						arr[value1idx1][value1idx2] = arr[value2idx1][value2idx2];
						arr[value2idx1][value2idx2] = temp;
						break;
					}

				}
			}
			System.out.println();
		}
		sc.close();
		
	}

}
