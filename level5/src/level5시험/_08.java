package level5시험;

import java.util.Scanner;

public class _08 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		String[][] board = null;
		int count = 0;
		int pageSize = 3;
		int curPageNum = 1;

		while (true) {
			int startRow = (curPageNum - 1) * 3 + 1;
			int endRow = startRow + pageSize - 1;
			if (endRow > count) {
				endRow = count;
			}
			int pageCount = (count == 0 ? count : (count - 1)) / 3 + 1;
			System.out.println("=================================");
			System.out.println("=          콘솔 게시판          =");
			System.out.println("=================================");
			if (board == null) {
				System.out.println();
				System.err.println("    등록된 게시물이 없습니다.");
				System.out.println();
			} else {
				System.out.println("[번호 / 제목][총 게시물 개수 : " + count + "]");
				for (int i = startRow - 1; i < endRow; i++) {
					System.out.printf("[%-2d]  /  %s\n", i + 1, board[i][0]);
				}
				System.out.println();
			}
			System.out.printf("           [ %d / %d ]\n", curPageNum, pageCount);
			System.out.println("       [1. 이전] [2. 이후]");
			System.out.println("=================================");
			System.out.println("[3.글쓰기][4.삭제하기][5.내용확인]");
			System.out.print("메뉴 선택 > ");
			int sel = sc.nextInt();
			if (sel == 0) {
				System.out.println("프로그램 종료");
				break;
			}
			if (sel < 1 || sel > 5) {
				System.err.println("입력 오류");
				continue;
			}
			if (sel == 1) {
				if (curPageNum == 1) {
					System.err.println("이전 페이지가 없습니다.");
					continue;
				}
				curPageNum--;
			} else if (sel == 2) {
				if (curPageNum == pageCount) {
					System.err.println("다음 페이지가 없습니다.");
					continue;
				}
				curPageNum++;
			} else if (sel == 3) {
				System.out.println("[글쓰기]");
				System.out.print("제목 : ");
				sc.nextLine();
				String title = sc.nextLine();
				System.out.print("내용 : ");
				String text = sc.nextLine();
				if (board == null) {
					board = new String[1][2];
				} else {
					String[][] temp = board;
					board = new String[count + 1][2];
					for (int i = 0; i < count; i++) {
						board[i][0] = temp[i][0];
						board[i][1] = temp[i][1];
					}
				}
				board[count][0] = title;
				board[count][1] = text;
				System.out.println("\"" + title + "\"글이 추가되었습니다.");
				curPageNum = count / pageSize + 1;
				count++;
			} else if (sel == 4) {
				if (board == null) {
					System.err.println("삭제할 게시물이 없습니다.");
					continue;
				}
				while (true) {
					System.out.print("삭제할 게시물 번호 > ");
					int del = sc.nextInt();
					if (del > count) {
						System.err.println("존재하지 않는 게시물 번호입니다.");
						continue;
					}
					if (del < 1) {
						System.err.println("1 이상의 값을 입력하세요");
						continue;
					}
					if (del < startRow || del > endRow) {
						System.err.println("현재 페이지의 게시물만 삭제 가능합니다.");
						continue;
					}
					if (count == 1) {
						board = null;
					} else {
						String[][] temp = board;
						board = new String[count - 1][2];
						int idx = 0;
						for (int i = 0; i < count; i++) {
							if (i != del - 1) {
								board[idx][0] = temp[i][0];
								board[idx++][1] = temp[i][1];
							}
						}
					}
					System.out.println(del + "번 게시물 삭제가 완료되었습니다.");
					count--;
					curPageNum = (count - 1) / pageSize + 1;
					break;
				}
			} else if (sel == 5) {
				if (board == null) {
					System.err.println("확인 할 게시물이 없습니다.");
					continue;
				}
				while (true) {
					System.out.print("확인할 게시물 번호 > ");
					int show = sc.nextInt();
					if (show > count) {
						System.err.println("존재하지 않는 게시물 번호입니다.");
						continue;
					}
					if (show < 1) {
						System.err.println("1 이상의 값을 입력하세요");
						continue;
					}
					if (show < startRow || show > endRow) {
						System.err.println("현재 페이지의 게시물만 확인 가능합니다.");
						continue;
					}
					System.out.println("=================================");
					System.out.printf("  제목 : %s\n", board[show - 1][0]);
					System.out.println("=================================");
					System.out.printf("  내용 : %s\n", board[show - 1][1]);
					System.out.println();
					System.out.println("=================================");
					break;
				}
			}
		}
		sc.close();
		// 소요 시간 : 47분 56초
	}

}
