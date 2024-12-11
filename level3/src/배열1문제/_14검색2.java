package 배열1문제;

//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
import java.util.Scanner;
//import java.util.StringTokenizer;

public class _14검색2 {

	public static void main(String[] args) {

		/*
		 	[문제]
		 		array배열은 학번과 점수가 한 쌍으로 이루어진 데이터이다.
		 		1. 학번을 입력하면 점수 출력
		 		2. 점수를 입력하면 학번 출력
		 		예외처리) 없는 학번,점수
		 */
		Scanner sc = new Scanner(System.in);

		int[] array = { 1001, 20, 1002, 45, 1003, 54 };
		while(true) {
			int idx = array.length;
			int hakbun = 0;
			int score = 0;
			System.out.print("데이터 입력 (종료 : -1) : ");
			int input = sc.nextInt();
			if(input > 100) {
				hakbun = input;
			}else {
				score = input;
			}
			for (int i = 0; i < array.length; i += 1) {
				if (hakbun == array[i]) {
					idx = i;
					System.out.println("[ "+array[idx + 1] + "점 ]");
					break;
				}else if (score == array[i]) {
					idx = i;
					System.out.println("[ "+array[idx - 1]+" ]");
					break;
				}
			}
			if(input == -1) {
				System.out.println("종료");
				break;
			}
			if(idx == array.length) {
				System.out.println("없는 데이터");
			}
		}
		sc.close();
		
		
//		int[] array = { 1001, 20, 1002, 45, 1003, 54 };
//		int idx = array.length;
//		System.out.print("학번 입력 : ");
//		int hakbun = sc.nextInt();
//		for (int i = 0; i < array.length; i += 2) {
//			if (hakbun == array[i]) {
//				idx = i;
//			}
//		}
//		if (idx == array.length) {
//			System.out.println("없는 학번");
//		} else {
//			System.out.println(array[idx + 1]);
//		}
//		idx = array.length;
//		System.out.print("점수 입력 : ");
//		int score = sc.nextInt();
//		for (int i = 1; i < array.length; i += 2) {
//			if (score == array[i]) {
//				idx = i;
//			}
//		}
//		if (idx == array.length) {
//			System.out.println("없는 점수");
//		} else {
//			System.out.println(array[idx - 1]);
//		}
//		sc.close();
		
		
		
//		System.out.println("학번 | 점수");
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		
//		int[] array = { 1001, 20, 1002, 45, 1003, 54 };
//		int idx = array.length;
//		int hakbun = Integer.parseInt(st.nextToken());
//		int score = Integer.parseInt(st.nextToken());
//		for (int i = 0; i < array.length; i += 2) {
//			if (hakbun == array[i]) {
//				idx = i;
//			}
//		}
//		System.out.print("학번 : " + hakbun);
//		if (idx == array.length) {
//			System.out.println(" => 없는 학번");
//		} else {
//			System.out.println("[ 해당 점수 :"+array[idx + 1] + "점 ]");
//		}
//		idx = array.length;
//		for (int i = 1; i < array.length; i += 2) {
//			if (score == array[i]) {
//				idx = i;
//			}
//		}
//		System.out.print("점수 : " + score);
//		if (idx == array.length) {
//			System.out.println(" => 없는 점수");
//		} else {
//			System.out.println("[ 해당 학번 : "+array[idx - 1]+" ]");
//		}
//		br.close();
		
	}

}
