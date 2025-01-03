package 클래스배열문제;

class Item {
	int itemNo;
	String name;
	int price;

	Item(String itemNo, String name, String price) {
		this.itemNo = Integer.parseInt(itemNo);
		this.name = name;
		this.price = Integer.parseInt(price);
	}

	int getItemNo() {
		return itemNo;
	}

	@Override
	public String toString() {
		return name;
	}
}

class ItemDAO {
	Item[] itemList;
	int size;

	ItemDAO(String itemData) {
		String[] itemDatas = itemData.split(",");
		size = itemDatas.length;
		itemList = new Item[size];
		setItemList(itemDatas);
	}

	void setItemList(String[] itemDatas) {
		for (int i = 0; i < size; i++) {
			String[] iData = itemDatas[i].split("/");
			itemList[i] = new Item(iData[0], iData[1], iData[2]);
		}
	}

	Item[] getItemList() {
		return itemList;
	}
}

class User {
	int userNo;
	String name;

	User(String userNo, String name) {
		this.userNo = Integer.parseInt(userNo);
		this.name = name;
	}

	int getUserNo() {
		return userNo;
	}

	@Override
	public String toString() {
		return name;
	}
}

class UserDAO {
	User[] userList;
	int size;

	UserDAO(String userData) {
		String[] userDatas = userData.split(",");
		size = userDatas.length;
		userList = new User[size];
		setUserList(userDatas);
	}

	void setUserList(String[] userDatas) {
		for (int i = 0; i < size; i++) {
			String[] uData = userDatas[i].split("/");
			userList[i] = new User(uData[0], uData[1]);
		}
	}

	User[] getUserList() {
		return userList;
	}
}

class Cart {
	int userNo;
	int itemNo;

	Cart(String userNo, String itemNo) {
		this.userNo = Integer.parseInt(userNo);
		this.itemNo = Integer.parseInt(itemNo);
	}

	int getUserNo() {
		return userNo;
	}

	int getItemNo() {
		return itemNo;
	}
}

class CartDAO {
	Cart[] cartList;
	UserDAO udao;
	ItemDAO idao;
	int size;

	void init(String itemData, String userData, String cartData) {
		udao = new UserDAO(userData);
		idao = new ItemDAO(itemData);
		String[] cartDatas = cartData.split("\n");
		size = cartDatas.length;
		cartList = new Cart[size];
		setCartList(cartDatas);
	}

	void setCartList(String[] cartDatas) {
		for (int i = 0; i < size; i++) {
			String[] cData = cartDatas[i].split("/");
			cartList[i] = new Cart(cData[0], cData[1]);
		}
	}

	// 회원별 아이템 구매 목록 출력
	void quiz1() {
		System.out.println("[문제 1] 회원별 아이템 구매 목록 출력");
		printQuiz1();
	}

	void printQuiz1() {
		for (User user : udao.getUserList()) {
			System.out.print(user + " ==> ");
			matchItem(user);
			System.out.print("\n");
		}
	}

	void matchItem(User user) {
		int idx = 0;
		for (Item item : idao.getItemList()) {
			int cnt = 0;
			cnt = getItemCnt(user, item, cnt, idx);
			if (cnt != 0) {
				System.out.print(" x" + cnt);
				idx++;
			}
		}
	}

	int getItemCnt(User user, Item item, int cnt, int idx) {
		for (Cart cart : cartList)
			if (user.getUserNo() == cart.getUserNo() && cart.getItemNo() == item.getItemNo())
				printItem(item, cnt++, idx);
		return cnt;
	}

	void printItem(Item item, int cnt, int idx) {
		if (cnt == 0)
			System.out.print((idx != 0 ? ", " : "") + item);
	}

	// 아이템별 구입 회원 이름 출력
	void quiz2() {
		System.out.println("[문제 2] 아이템별 구입 회원 이름 출력");
		printQuiz2();
	}

	void printQuiz2() {
		for (Item item : idao.getItemList()) {
			System.out.print(item + " ==> ");
			matchUser(item);
			System.out.print("\n");
		}
	}

	void matchUser(Item item) {
		int idx = 0;
		for (User user : udao.getUserList())
			idx = getUserCnt(user, item, idx);
	}

	int getUserCnt(User user, Item item, int idx) {
		for (Cart cart : cartList)
			if (user.getUserNo() == cart.getUserNo() && cart.getItemNo() == item.getItemNo()) {
				System.out.print((idx++ != 0 ? ", " : "") + user);
				break;
			}
		return idx;
	}

	void run(String itemData, String userData, String cartData) {
		init(itemData, userData, cartData);
		quiz1();
		System.out.println();
		quiz2();
	}
}

public class _08장바구니 {

	public static void main(String[] args) {

		String itemData = "1001/고래밥/1200,1002/새우깡/2300,1003/칸쵸/1500";
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

		CartDAO cdao = new CartDAO();
		cdao.run(itemData, userData, cartData);
	}

}
