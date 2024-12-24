package 클래스배열_문제;

import java.util.Scanner;

public class _09클배카트2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		String[] userIdList = { "aaa", "bbb", "ccc" };
		String[] itemNameList = { "사과", "칸쵸", "귤", "감" };
		int[] itemPriceList = { 10000, 2000, 6500, 3300 };

		String[] cartUserIdList = { "aaa", "ccc", "aaa", "bbb", "aaa", "ccc" };
		String[] cartItemNameList = { "칸쵸", "귤", "칸쵸", "사과", "감", "사과" };

		User[] uList = new User[userIdList.length];
		Item[] iList = new Item[itemNameList.length];
		Cart[] cList = new Cart[cartItemNameList.length];

		for (int i = 0; i < iList.length; i++) {
			Item it = new Item();
			it.name = itemNameList[i];
			it.price = itemPriceList[i];

			iList[i] = it;
		}

		for (int i = 0; i < cList.length; i++) {
			Cart c = new Cart();
			c.itemName = cartItemNameList[i];
			c.userId = cartUserIdList[i];

			for (Item it : iList) {
				if (c.itemName.equals(it.name))
					c.itemPrice = it.price;
			}

			cList[i] = c;
		}

		for (int i = 0; i < uList.length; i++) {
			User u = new User();
			u.id = userIdList[i];

			for (Cart c : cList) {
				if (c.userId.equals(u.id))
					u.priceTotal += c.itemPrice;
			}

			uList[i] = u;
		}

		while (true) {
			System.out.println("================");
			System.out.println("[0] 종료");
			System.out.println("[1] 전체출력");
			System.out.println("[2] 회원 aaa가 주문한 각 아이템 이름과 가격들을 출력");
			System.out.println("[3] 카트내용을 전부출력 (회원 별 아이템 전체와 아이템 가격을 출력)");
			System.out.println("[4] 주문한 아이템 갯수가 가장많은 회원출력");
			System.out.println("[5] 주문한 아이템 총액이 가장큰 회원출력");
			int sel = sc.nextInt();
			if (sel == 0) {
				System.out.println("종료");
				break;
			}
			if (sel < 1 || sel > 5) {
				System.out.println("입력오류");
				continue;
			}
			switch (sel) {
			case 1:
				System.out.println("==== 회원 ====");
				for (User u : uList)
					System.out.println(u.id);

				System.out.println("==== 아이템 ====");
				for (Item i : iList)
					System.out.printf("%s \t %d \n", i.name, i.price);

				System.out.println("==== 장바구니 ====");
				for (Cart c : cList)
					System.out.printf("%s \t %s \n", c.userId, c.itemName);
				break;

			case 2:
				String userName = uList[0].id;
				System.out.printf("==== %s 주문 목록 ==== \n", userName);
				for (Cart c : cList)
					if (c.userId.equals(userName))
						System.out.printf("%s \t %d원 \n", c.itemName, c.itemPrice);
				break;

			case 3:
				System.out.println("==== 장바구니 ====");
				for (Cart c : cList)
					System.out.printf("%s \t %s \t %d원 \n", c.userId, c.itemName, c.itemPrice);
				break;

			case 4:
				int maxOrder = 0;
				for (User u : uList) {
					int order = 0;
					for (Cart c : cList) {
						if (c.userId.equals(u.id))
							order++;
					}
					if (maxOrder < order)
						maxOrder = order;
				}

				System.out.printf("======= 최대 주문 갯수 : %d개 =======\n", maxOrder);
				for (User u : uList) {
					int order = 0;
					for (Cart c : cList) {
						if (c.userId.equals(u.id))
							order++;
					}
					if (maxOrder == order)
						System.out.printf("============ %s 회원님 ============\n", u.id);
				}
				break;

			case 5:
				int maxMoney = 0;
				for (User u : uList) {
					if (maxMoney < u.priceTotal)
						maxMoney = u.priceTotal;
				}

				System.out.printf("======= 최대 주문 금액 : %d원 =======\n", maxMoney);
				for (User u : uList) {
					if (maxMoney == u.priceTotal)
						System.out.printf("============== %s 회원님 ==============\n", u.id);
				}
				break;
			}
		}
		sc.close();
	}

}
