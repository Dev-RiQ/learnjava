package 배열심화3;

import java.util.Scanner;

public class _11콘솔게시판2단계 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[][] board = null; // 0:제목 1:내용
		int count = 0; // 전체 게시글 수
		int pageSize = 3; // 한 페이지에 보여줄 게시글 수
		int curPageNum = 1; // 현재 페이지 번호
		int pageCount = 1; // 전체 페이지 개수
		int startRow = 1; // 현재 페이지의 게시글 시작 번호
		int endRow = 0; // 현재 페이지의 게시글 마지막 번호
		// 보이는 페이지에서만 삭제, 내용 확인 가능
		while (true) {
			System.out.println();
			System.out.println("---------------------------");
			System.out.print("[번호] - 제목");
			System.out.printf("      [총 게시글 %d 개]\n", count);
			System.out.println("---------------------------");
			System.out.println();
			if (board == null) {
				System.out.println("등록된 게시물이 없습니다.");
				System.out.println();
			} else {
				for (int i = startRow; i <= endRow; i++) {
					System.out.printf("[%4d] - %s\n", i, board[i - 1][0]);
					System.out.println();
				}
			}
			System.out.println("---------------------------");
			System.out.printf("현제 페이지 [%d / %d]\n", curPageNum, pageCount);
			System.out.println("---------------------------");
			System.out.println("[1]이전");
			System.out.println("[2]이후");
			System.out.println("[3]추가하기");
			System.out.println("[4]삭제하기");
			System.out.println("[5]내용확인");
			System.out.print("번호 입력 (0.종료) >> ");
			int sel = sc.nextInt();
			sc.nextLine();
			if (sel == 0) {
				System.out.println("프로그램 종료");
				break;
			}
			if ((sel == 4 || sel == 5) && board == null) {
				System.out.println("등록된 글이 없습니다.");
				continue;
			}
			if (sel < 1 || sel > 5) {
				System.out.println("입력 오류");
				continue;
			}
			if (sel == 1) {
				if (curPageNum == 1) {
					System.out.println("이전 페이지가 없습니다.");
					continue;
				}
				curPageNum--;
			} else if (sel == 2) {
				if (curPageNum == pageCount) {
					System.out.println("다음 페이지가 없습니다.");
					continue;
				}
				curPageNum++;
			} else if (sel == 3) {
				System.out.print("제목 : ");
				String title = sc.nextLine();
				System.out.print("내용 : ");
				String script = sc.nextLine();
				count++;
				if (board == null) {
					board = new String[count][];
				} else {
					String[][] temp = board;
					board = new String[count][];
					int idx = 0;
					for (String[] paste : temp) {
						board[idx++] = paste;
					}
				}
				String temp[] = {title, script};
				board[count - 1] = temp;
			} else if (sel == 4) {
				System.out.print("삭제할 번호 >> ");
				int del = sc.nextInt();
				if (del < 1 || del > count) {
					System.out.println("존재하지 않는 번호입니다.");
					continue;
				}
				if (del < startRow || del > endRow) {
					System.out.println("현재 페이지에 없는 번호입니다.");
					continue;
				}
				if(count==1) {
					board = null;
				}else {
					String[][] temp = board;
					board = new String[count - 1][];
					int idx = 0;
					for (int i = 0; i < count; i++) {
						if (i != del - 1) {
							board[idx++] = temp[i];
						}
					}
				}
				count--;
			} else if (sel == 5) {
				System.out.print("확인할 번호 >> ");
				int show = sc.nextInt();
				if (show < 1 || show > count) {
					System.out.println("존재하지 않는 번호입니다.");
					continue;
				}
				if (show < startRow || show > endRow) {
					System.out.println("현재 페이지에 없는 번호입니다.");
					continue;
				}
				System.out.println("-------------------");
				System.out.printf("[%4d] - %s\n", show, board[show - 1][0]);
				System.out.println("-------------------");
				System.out.println(" " + board[show - 1][1]);
				System.out.println("-------------------");

			}
			if(count != 0) {
				pageCount = count / pageSize + (count % pageSize == 0 ? 0 : 1);
			}
			if(curPageNum>pageCount && curPageNum != 1) {
				curPageNum--;
			}
			startRow = 1 + (curPageNum - 1) * pageSize;
			endRow = startRow + pageSize - 1;
			if (endRow > count) {
				endRow = count;
			}
		}
		sc.close();
	}
}
