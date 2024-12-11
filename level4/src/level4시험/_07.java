package level4시험;

import java.util.Arrays;
import java.util.Scanner;

public class _07 {

	public static void main(String[] args) {

		//값을 입력받고 삭제
		//같은 값 한번에 삭제
		Scanner sc = new Scanner(System.in);
		int[] data = { 5, 5, 6, 8, 2, 6 };
		int cntAfter = data.length;
		int cntBefore = data.length;
		while (true) {
			System.out.println(Arrays.toString(data));
			if (cntAfter == 0) {
				System.out.println("모든 값이 삭제되었습니다.");
				break;
			}
			System.out.print("삭제 값 입력 >> ");
			int input = sc.nextInt();
			for (int i = 0; i < cntBefore; i++) {
				if (data[i] == input) {
					int[] temp = data;
					data = new int[cntBefore - 1];
					int idx = 0;
					for (int k = 0; k < cntBefore; k++) {
						if (k != i) {
							data[idx++] = temp[k];
						}
					}
					cntBefore--;
					i--;
				}
			}
			if (cntBefore == cntAfter) {
				System.out.println("없는 값입니다");
				continue;
			}
			cntAfter = cntBefore;
		}
		sc.close();
		// 소요 시간 : 12분 10초
	}

}
