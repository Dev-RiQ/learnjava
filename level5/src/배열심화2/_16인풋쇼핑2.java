package 배열심화2;

public class _16인풋쇼핑2 {

	public static void main(String[] args) {

//		String[] nameList = { "새우깡", "감자깡", "고래밥" };
		int[][] dataList = {
				{ 1000, 3 },
				{ 2300, 1 },
				{ 3100, 1 }
		};
		int total = 0;
		int[] input = { 1, 2, 2, 0, 0, 2, 1, 1 };
		int[] sell = new int[dataList.length];
		for (int i = 0; i < input.length; i++) {
			if (dataList[input[i]][1] == 0) {
				continue;
			}
			dataList[input[i]][1]--;
			sell[input[i]]++;
			total += dataList[input[i]][0];
		}
		System.out.println("총 판매 : " + total);
	}

}
