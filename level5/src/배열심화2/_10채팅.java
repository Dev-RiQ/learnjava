package 배열심화2;

public class _10채팅 {

	public static void main(String[] args) {

		/*
		 	철수 왼쪽 정렬, 영희 오륵쪽 정렬로 출력
		 	대화 한줄 길이 20칼
		 */
		String[][] wordList = {
				{"철수","영희야 안녕"},
				{"영희","철수야 안녕"},
				{"철수","오늘 점심 같이 먹을래?"},
				{"영희","아니 약속있어."},
				{"영희","다음에 먹자."},
				{"철수","그래 다음에 먹자."}
		};
		int space = 32;
		for (int i = 0; i < wordList.length; i++) {
			if(wordList[i][0].equals("철수")) {
				System.out.println(wordList[i][1]);
			}else {
				for(int k = 0;k<space;k++) {
					if(space - k == wordList[i][1].length()) {
						System.out.println(wordList[i][1]);
						break;
					}
					System.out.print(" ");
				}
			}
		}
		space = 38;
		for(int j = 1;j<7;j++) {
			System.out.println("==============12월 "+j+"일================");
			for (int i = 0; i < wordList.length; i++) {
				int cnt = 0;
				if(j==6&&i==1) {
					i=3;
				}
				for (int k = 0; k < wordList[i][1].length(); k++) {
					char i1 = wordList[i][1].charAt(k);
					cnt += ((i1 < '0' || i1 > '9') && (i1 < 'A' || i1 > 'Z') && (int) i1 > 255)? 2 : 1;
				}
				if(wordList[i][0].equals("영희")) {
					for (int k = 0; k < space - cnt; k++) {
						System.out.print(" ");
					}
				}
				System.out.println(wordList[i][1]);
				if(j==6&&i==3) {
					break;
				}
			}
		}
		System.out.println("?");
	}

}
