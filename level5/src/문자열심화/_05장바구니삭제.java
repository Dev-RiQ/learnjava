package 문자열심화;

public class _05장바구니삭제 {

	public static void main(String[] args) {

//		String item = "칸쵸/새우깡/고래밥/콜라/사이다";
//		String id = "qwer/abcd/java";
		String cart = "";
		cart += "qwer/고래밥\n";
		cart += "qwer/새우깡\n";
		cart += "abcd/콜라\n";
		cart += "java/칸쵸\n";
		cart += "qwer/칸쵸\n";
		cart += "java/고래밥\n";
		cart += "abcd/사이다\n";
		String[][] input = { // 삭제 요청
				{ "qwer", "3" },
				{ "abcd", "1" }
		};
		String[] cartDatas = cart.split("\n");
		String[][] carts = new String[cartDatas.length][2];
		for (int i = 0; i < carts.length; i++) {
			carts[i] = cartDatas[i].split("/");
		}
		String[] inputIds = new String[input.length];
		String[] inputNums = new String[input.length];
		for (int i = 0; i < input.length; i++) {
			inputIds[i] = input[i][0];
			inputNums[i] = input[i][1];
		}
		for (int i = 0; i < input.length; i++) {
			int cnt = 0;
			for (int k = 0; k < carts.length; k++) {
				if (carts[k] != null && inputIds[i].equals(carts[k][0])) {
					cnt++;
				}
				if ((cnt + "").equals(inputNums[i])) {
					carts[k] = null;
					break;
				}
			}
		}
		cart = "";
		for (int i = 0; i < carts.length; i++) {
			if (carts[i] != null) {
				cart += String.format("%s/%s\n", carts[i][0], carts[i][1]);
			}
		}
		System.out.println(cart);
	}

}
