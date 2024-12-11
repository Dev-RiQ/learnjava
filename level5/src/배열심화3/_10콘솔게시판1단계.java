package 배열심화3;

import java.util.Scanner;

public class _10콘솔게시판1단계 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int count = 14;
		int pageSize = 3;
		int curPageNum = 1;
		int pageCount = 0;
		int startRow = 1;
		int endRow = 0;
		System.out.println("현재 페이지에 보여줄 게시글 숫자 ");
		pageSize = sc.nextInt();
		if (pageSize < 1 || pageSize > count) {
			System.out.println("페이지 숫자 설정 오류 기본값 3으로 재설정");
			pageSize = 3;
		}
		pageCount = count / pageSize + (count % pageSize == 0 ? 0 : 1);
		endRow = pageSize;
		while (true) {
			for (int k = startRow; k <= endRow; k++) {
				System.out.printf("[%2d번 게시물]\n", k);
			}
			System.out.printf("[이전 : 1] [페이지 %d/%d] [이후 : 2]\n", curPageNum, pageCount);
			int move = sc.nextInt();
			if(move == 0) {
				System.out.println("게시판 종료");
				break;
			}
			if (move < 1 || move > 2) {
				System.out.println("1,2 중 선택");
				continue;
			}
			if (move == 1 && curPageNum == 1) {
				System.out.println("이전 페이지 없음");
				continue;
			}
			if (move == 2 && curPageNum == pageCount) {
				System.out.println("다음 페이지 없음");
				continue;
			}
			curPageNum += move == 1 ? -1 : 1;
			startRow = 1 + (curPageNum - 1) * pageSize;
			endRow = pageSize + (curPageNum - 1) * pageSize;
			if (endRow > count) {
				endRow = count;
			}
		}
		sc.close();
	}

}
