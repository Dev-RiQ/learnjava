package 배열1개념;

import java.util.Arrays;
import java.util.Scanner;

public class _11배열컨트롤러1단계 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int[] arr = new int[5];
		int cnt = 0;
		while (true) {
			int idx = arr.length;
			int num = 0;
			System.out.println(Arrays.toString(arr));
			System.out.println("[벡터 컨트롤러]");
			System.out.println("[1]추가");
			System.out.println("[2]수정");
			System.out.println("[3]삭제(값)");
			System.out.println("[4]삽입");
			System.out.println("[0]종료");

			int sel = sc.nextInt();
			if (sel == 0) {
				System.out.println("=== 종료 ===");
				break;
			}
			if (sel < 1 || sel > 4) {
				System.out.println("메뉴 입력 오류");
				continue;
			}
			if (cnt == 0 && sel != 1) {
				System.out.println("등록된 값이 없습니다");
				continue;
			}
			if ((sel == 1 || sel == 4) && cnt == 5) {
				System.out.println("저장 공간 부족");
				continue;
			}
			if (sel == 2 || sel == 4) {
				System.out.print("인덱스 입력 >> ");
				idx = sc.nextInt();
				if (idx < 0 || idx >= cnt) {
					System.out.println("인덱스 범위 오류");
					continue;
				}
			}
			System.out.print("값 입력 >> ");
			num = sc.nextInt();
			if (num == 0) {
				System.out.println("0 제외 입력");
				continue;
			}
			//중복 값 불가능 조항 추가 시
//			boolean same = false;
//			for(int i = 0;i<arr.length;i++) {
//				if(arr[i] == num) {
//					same = true;
//					break;
//				}
//			}
//			if(same) {
//				System.out.println("같은 값 입력 불가");
//				continue;
//			}
			if (sel == 1) {
				arr[cnt++] = num;
			} else if (sel == 2) {
				arr[idx] = num;
			} else if (sel == 3) {
				for (int i = 0; i < cnt; i++) {
					if (arr[i] == num) {
						idx = i;
						//break 없으면 중복일때 뒤에서부터 지워짐(있으면 앞에서부터)
						break;
					}
				}
				if (idx == arr.length) {
					System.out.println("해당 값이 존재하지 않습니다");
					continue;
				}
				//중복 값 가능할때, 한번에 지우려면 상위 for 안에 break 떼고 2중으로 넣으면 됨
				for (int i = idx; i < cnt - 1; i++) {
					arr[i] = arr[i + 1];
				}
				arr[--cnt] = 0;
			} else {
				for (int i = cnt++; i > idx; i--) {
					arr[i] = arr[i - 1];
				}
				arr[idx] = num;
			}
		}
		sc.close();
		
		
	}

}
