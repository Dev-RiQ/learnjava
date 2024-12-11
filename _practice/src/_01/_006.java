package _01;

import java.util.Arrays;
import java.util.Scanner;

public class _006 {
	
	public static int[] deleteValue(int[] a) {
		Scanner del = new Scanner(System.in);
		int[] b = a;
		int size = b.length;
		while(true) {
			boolean isHave = false;
			System.out.println(Arrays.toString(b));
			if(size == 0) {
				System.out.println("삭제할 데이터 없음");
				System.out.println("삭제 종료");
				break;
			}
			System.out.print("삭제 값 입력 >> ");
			int input = del.nextInt();
			for(int i = 0 ; i < size;i++) {
				if(b[i] == input) {
					isHave = true;
					int[] temp = b;
					b = new int[size-1];
					int idx = 0;
					for(int k = 0;k<size;k++) {
						if(k!=i) {
							b[idx++] = temp[k];
						}
					}
					size--;
					i--;
				}
			}
			if(!isHave) {
				System.out.println("삭제할 데이터 없음");
			}else {
				System.out.println("삭제 완료");
			}
		}
		del.close();
		return b ;
	}

}
