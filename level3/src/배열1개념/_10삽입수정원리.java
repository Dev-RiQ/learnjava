package 배열1개념;

import java.util.Arrays;
import java.util.Scanner;

public class _10삽입수정원리 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int[] arr = { 21, 1, 67, 2, 0 };

		int cnt = 4;
		while (true) {
			int insIdx = arr.length;
			int insNum = 0;
			System.out.println(Arrays.toString(arr));
			System.out.println("1.수정(인덱스)");
			System.out.println("2.삽입(값)");
			int num = sc.nextInt();
			if (num == -100) {
				break;
			}
			if (num < 1 || num > 2) {
				System.out.println("입력 오류");
				continue;
			}
			if (num == 1) {
				System.out.print("수정 인덱스 >> ");
				insIdx = sc.nextInt();
				if (insIdx < 0 || insIdx >= cnt) {
					System.out.println("범위 에러");
					continue;
				}
				System.out.print("값 입력 >> ");
				insNum = sc.nextInt();
				if (insNum == 0) {
					System.out.println("0 입력 불가");
				}
				arr[insIdx] = insNum;
			} else {
				if (cnt == 5) {
					System.out.println("값을 추가할 수 없습니다");
					continue;
				}
				System.out.println("삽입 인덱스 >> ");
				insIdx = sc.nextInt();
				if (insIdx < 0 || insIdx >= cnt) {
					System.out.println("범위 에러");
					continue;
				}
				for (int i = cnt; i > insIdx; i--) {
					arr[i] = arr[i - 1];
				}
				System.out.print("값 입력 >> ");
				insNum = sc.nextInt();
				if (insNum == 0) {
					System.out.println("0 입력 불가");
				}
				cnt++;
			}
			arr[insIdx] = insNum;
		}
		System.out.println("종료");
		
		
		

		
		int[] arr2 = { 21, 1, 67, 2, 0 };
		cnt = 4;
		while (true) {
			System.out.println(Arrays.toString(arr2));
			System.out.println("1.수정(인덱스)");
			System.out.println("2.삽입(값)");
			int num = sc.nextInt();
			if (num == -100) {
				break;
			}
			if (num < 1 || num > 2) {
				System.out.println("메뉴 선택 오류");
				continue;
			}
			if (num == 2 && cnt == 5) {
				System.out.println("값을 추가할 자리가 없습니다");
				continue;
			}
			System.out.print("인덱스 >> ");
			int insIdx = sc.nextInt();
			if (insIdx >= cnt || insIdx < 0) {
				System.out.println("인덱스 범위 오류");
				continue;
			}
			System.out.print("값 입력 >> ");
			int insNum = sc.nextInt();
			if (insNum == 0) {
				System.out.println("값 0 입력 불가");
				continue;
			}
			if (num == 2) {
				for (int i = cnt; i > insIdx; i--) {
					arr2[i] = arr2[i - 1];
				}
				cnt++;
			}
			arr2[insIdx] = insNum;
		}
		System.out.println("종료");
		sc.close();
		
	}

}
