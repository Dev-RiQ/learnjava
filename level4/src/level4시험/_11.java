package level4시험;

public class _11 {

	public static void main(String[] args) {
		/*
		 	현재 택시는 5,5 위치에 있다.
		 	배열의 왼쪽 세로 줄은 속도
		 	오른쪽 세로 줄은 방향
		 	arr배열은 택시가 매번 이동한 내용을 기록한 것
		 	6번 모두 이동한 후 택시의 위치는?
		 */
		String[][] arr = {
				{"4","북"},
				{"2","동"},
				{"1","남"},
				{"5","서"},
				{"4","서"},
				{"2","동"}
		};
		int x = 5;
		int y = 5;
		for (int i = 0; i < arr.length; i++) {
			int v = Integer.parseInt(arr[i][0]);
			if (arr[i][1].equals("동")) {
				x += v;
			} else if (arr[i][1].equals("서")) {
				x -= v;
			} else if (arr[i][1].equals("남")) {
				y -= v;
			} else if (arr[i][1].equals("북")) {
				y += v;
			}
		}
		System.out.printf("택시 위치 : %d, %d", x, y);
		// 소요 시간 : 4분 6초
	}

}
