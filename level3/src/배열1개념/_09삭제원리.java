package 배열1개념;

import java.util.Arrays;
import java.util.Scanner;

public class _09삭제원리 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int arr[] = { 21, 1, 67, 2, 0 };
		int cnt = 4;
		System.out.println(Arrays.toString(arr));
		while (true) {
			int idx = arr.length;
			int num = 0;
			System.out.println("1.인덱스 기반 삭제");
			System.out.println("2.값 기반 삭제");
			int sel = sc.nextInt();
			if (sel < 1 || sel > 2) {
				System.out.println("입력 오류");
				continue;
			}
			if (sel == 1) {
				System.out.print("인덱스 >> ");
				idx = sc.nextInt();
			} else {
				System.out.print("값 >> ");
				num = sc.nextInt();
				for (int i = 0; i < cnt; i++) {
					if (arr[i] == num) {
						idx = i;
						break;
					}
				}
			}
			if (sel == 1 && (idx < 0 || idx >= cnt) || sel == 2 && idx == arr.length) {
				System.out.println("존재하지 않는 값입니다");
				continue;
			}
			for (int i = idx; i < cnt-1; i++) {
				arr[i] = arr[i + 1];
			}
			cnt--;
			arr[cnt]=0;
			System.out.println("삭제 완료");
			System.out.println(Arrays.toString(arr));
			System.out.print("[");
			for (int i = 0; i < cnt; i++) {
				System.out.print(i == 0 ? arr[i] : ", " + arr[i]);
			}
			System.out.println("]");
			if (cnt == 0) {
				System.out.println("종료 : 더 이상 삭제할 데이터가 없습니다");
				break;
			}
		}
		
		
		int arr3[] = { 21, 1, 67, 2, 0 };
		cnt = 4;
		System.out.println(Arrays.toString(arr3));
		while (true) {
			int idx = arr3.length;
			int num = 0;
			System.out.println("1.인덱스 기반 삭제");
			System.out.println("2.값 기반 삭제");
			int sel = sc.nextInt();
			if (sel < 1 || sel > 2) {
				System.out.println("입력 오류");
				continue;
			}
			if (sel == 1) {
				System.out.print("인덱스 >> ");
				idx = sc.nextInt();
				if (idx < 0 || idx >= cnt) {
					System.out.println("해당 인덱스는 값이 존재하지 않습니다");
					continue;
				}
			} else {
				idx = arr3.length;
				System.out.print("값 >> ");
				num = sc.nextInt();
				if(num==0) {
					System.out.println("0을 제외한 값을 입력하세요");
					continue;
				}
				for (int i = 0; i < arr3.length; i++) {
					if (arr3[i] == num) {
						idx = i;
						break;
					}
				}
				if (idx == arr3.length) {
					System.out.println("해당 값은 존재하지 않습니다");
					continue;
				}
			}
			for (int i = idx; i < cnt; i++) {
				arr3[i] = arr3[i + 1];
			}
			cnt--;
			System.out.println("삭제 완료");
			System.out.println(Arrays.toString(arr3));
			System.out.print("[");
			for(int i = 0;i<cnt;i++) {
				System.out.print(i==0? arr3[i] : ", "+arr3[i]);
			}
			System.out.println("]");
			if (cnt == 0) {
				System.out.println("종료 : 더 이상 삭제할 데이터가 없습니다");
				break;
			}
		}
		sc.close();
	}

}
