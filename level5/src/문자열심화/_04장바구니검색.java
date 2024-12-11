package 문자열심화;

public class _04장바구니검색 {

	public static void main(String[] args) {

		String itemData = "1001/고래밥,1002/새우깡,1003/칸쵸";
		String userData = "3001/이만수,3002/김철민,3003/이영희";

		String cartData = "";
		cartData += "3001/1001\n";
		cartData += "3001/1001\n";
		cartData += "3003/1002\n";
		cartData += "3001/1001\n";
		cartData += "3001/1003\n";
		cartData += "3003/1002\n";
		cartData += "3003/1001\n";
		cartData += "3002/1001";

		String[] cartDatas = cartData.split("\n");
		String[] itemDatas = itemData.split(",");
		String[] userDatas = userData.split(",");
		String[][] buys = new String[itemDatas.length][cartDatas.length];
		String[][] carts = new String[cartDatas.length][2];
		String[][] items = new String[itemDatas.length][2];
		String[][] users = new String[userDatas.length][2];
		for (int i = 0; i < carts.length; i++) {
			carts[i] = cartDatas[i].split("/");
		}
		for (int i = 0; i < items.length; i++) {
			items[i] = itemDatas[i].split("/");
		}
		for (int i = 0; i < users.length; i++) {
			users[i] = userDatas[i].split("/");
		}
		for (int i = 0; i < buys.length; i++) {
			for (int k = 0; k < buys[i].length; k++) {
				for (int j = 0; j < users.length; j++) {
					if (items[i][0].equals(carts[k][1]) && carts[k][0].equals(users[j][0])) {
						buys[i][k] = users[j][1];
					}
				}
			}
		}
		for (int i = 0; i < buys.length; i++) {
			for (int k = 0; k < buys[i].length; k++) {
				for (int j = k + 1; j < buys[i].length; j++) {
					if (buys[i][k] != null && buys[i][k].equals(buys[i][j])) {
						buys[i][j] = null;
					}
				}
			}
		}
		String buyData = "";
		for (int i = 0; i < buys.length; i++) {
			int cnt = 0;
			buyData += items[i][1] + "(";
			for (int k = 0; k < buys[i].length; k++) {
				if (buys[i][k] != null) {
					buyData += (cnt != 0 ? ", " : "") + buys[i][k];
					cnt++;
				}
			}
			buyData += ")\n";
		}
		System.out.println(buyData);
		
	}

}
