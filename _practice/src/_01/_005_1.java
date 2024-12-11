package _01;

import java.util.Arrays;
import java.util.Scanner;

public class _005_1 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] data = { 5, 5, 6, 8, 2, 6 };
		while (true) {
			System.out.println("1. 추가");
			System.out.println("2. 삭제 값");
			System.out.println("3. 삭제 인덱스");
			System.out.println("4. 삽입");
			System.out.println("0. 종료");
			System.out.print("메뉴 선택 >> ");
			int sel = sc.nextInt();
			if(sel == 0) {
				System.out.println("프로그램 종료");
				break;
			}
			if(sel<1||sel>4) {
				System.out.println("입력 오류");
				continue;
			}
			if(sel == 1) {
				
			}else if(sel == 2) {
				int[] b = data;
				int size = b.length;
				while(true) {
					boolean isHave = false;
					System.out.println(Arrays.toString(b));
					if(size == 0) {
						System.out.println("더 이상 삭제할 데이터 없음");
						System.out.println("삭제 종료");
						break;
					}
					System.out.print("삭제 값 입력 >> ");
					int input = sc.nextInt();
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
						System.out.println("입력 값 없음");
					}else {
						System.out.println("삭제 완료");
					}
				}
			}else if(sel == 3) {
				
			}else{
				
			}
		}
	
		sc.close();
	}
}
