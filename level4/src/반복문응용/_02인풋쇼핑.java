package 반복문응용;

public class _02인풋쇼핑 {

	public static void main(String[] args) {

//		String[] nameList = { "새우깡", "감자깡", "고래밥" };
		int[] priceList = { 1000, 2100, 3300 };
		int[] countList = { 3, 1, 1 };
		int[] input = { 1, 2, 2, 0, 0, 2, 1, 1 };
		int[] sel = { 0, 0, 0 };
		int priceTotal = 0;
		for (int i = 0; i < input.length; i++) {
			if (countList[input[i]] > 0) {
				countList[input[i]]--;
				sel[input[i]]++;
				priceTotal += priceList[input[i]];
			}
		}
		System.out.println(priceTotal + "원");
	}

}
