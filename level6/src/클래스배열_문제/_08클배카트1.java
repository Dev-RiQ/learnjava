package 클래스배열_문제;

class User {
	String id;
	int priceTotal;
}

class Item {
	String name;
	int price;
}

class Cart {
	String userId;
	String itemName;
	int itemPrice;
}

public class _08클배카트1 {

	public static void main(String[] args) {

		String data1 = "qwer/asdf/zxcv";
		String data2 = "새우깡,1200/감자깡,3200/고구마깡,2100";
		String data3 = "qwer,새우깡/qwer,고구마깡/asdf,감자깡/qwer,새우깡/zxcv,새우깡";

		String[] ids = data1.split("/");
		String[] items = data2.split("/");
		String[] carts = data3.split("/");

		User[] user = new User[ids.length];
		Item[] item = new Item[items.length];
		Cart[] cart = new Cart[carts.length];

		for (int i = 0; i < item.length; i++) {
			item[i] = new Item();
			String[] info = items[i].split(",");
			item[i].name = info[0];
			item[i].price = Integer.parseInt(info[1]);
		}

		for (int i = 0; i < cart.length; i++) {
			cart[i] = new Cart();
			String[] info = carts[i].split(",");
			cart[i].userId = info[0];
			cart[i].itemName = info[1];
			
			for (Item it : item) {
				if (it.name.equals(info[1]))
					cart[i].itemPrice += it.price;
			}
		}
		
		for (int i = 0; i < user.length; i++) {
			user[i] = new User();
			user[i].id = ids[i];
			
			for (Cart c : cart) {
				if (c.userId.equals(ids[i]))
					user[i].priceTotal += c.itemPrice;
			}
			System.out.printf((i != 0 ? ", " : "") + "%s(%d)", user[i].id, user[i].priceTotal);
		}
	}

}
