package 배열심화2;

public class _19인형뽑기 {

	public static void main(String[] args) {

		int[][] machine = {
				{ 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 3 },
				{ 0, 2, 0, 0, 3 },
				{ 3, 1, 3, 0, 1 },
				{ 1, 4, 2, 0, 2 },
				{ 4, 1, 4, 0, 4 },
				{ 2, 1, 4, 3, 3 }
		};
		String[] nameList = { "호랑이", "곰", "사자", "기린" };
		int[] input = { 1, 0, 0, 3, 3, 4, 4 };
		for (int sel : input) {
			boolean isNone = true;
			for (int[] find : machine) {
				if (find[sel] != 0) {
					System.out.printf("%d ==> [%d:%s]\n", sel, find[sel], nameList[find[sel] - 1]);
					find[sel] = 0;
					isNone = false;
					break;
				}
			}
			if (isNone) {
				System.out.printf("%d ==> [0:꽝]\n", sel);
			}
		}
	}

}
