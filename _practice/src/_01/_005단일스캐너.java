package _01;

import java.util.Arrays;
import java.util.Scanner;

public class _005단일스캐너 {
	
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
				while(true) {
					int size = data.length;
					if(size == 0) {
						System.out.println("더 이상 삭제할 데이터 없음");
						break;
					}
					System.out.println(Arrays.toString(data));
					System.out.print("삭제 값 입력 (0. 나가기) >> ");
					int input = sc.nextInt();
					if(input == 0) {
						break;
					}
					data = deleteValue(data, input);
					if(size == data.length) {
						System.out.println("입력 값 없음");
					}else {
						System.out.println("삭제 완료");
					}
				}
				System.out.println("삭제 종료");
			}else if(sel == 3) {
				
			}else{
				
			}
		}
		sc.close();
		
	}
	public static int[] deleteValue(int[] a,int b) {
		int[] arr = a;
		int size = arr.length;
		for(int i = 0 ; i < size;i++) {
			if(arr[i] == b) {
				int[] temp = arr;
				arr = new int[size-1];
				int idx = 0;
				for(int k = 0;k<size;k++) {
					if(k!=i) {
						arr[idx++] = temp[k];
					}
				}
				size--;
				i--;
			}
		}
		return arr ;
	}
}
