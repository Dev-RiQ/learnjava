package level7시험;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

class Item {
	int itemNo;
	String name;
	int price;

	int getItemNo() {
		return itemNo;
	}

	String getName() {
		return name;
	}

	int getPrice() {
		return price;
	}

	Item(String itemNo, String name, String price) {
		this.itemNo = Integer.parseInt(itemNo);
		this.name = name;
		this.price = Integer.parseInt(price);
	}

	@Override
	public String toString() {
		return name;
	}

}

class User {
	int userNo;
	String name;

	int getUserNo() {
		return userNo;
	}

	String getName() {
		return name;
	}

	User(String userNo, String name) {
		this.userNo = Integer.parseInt(userNo);
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}
}

class Cart {
	int userNo;
	int itemNo;

	int getUserNo() {
		return userNo;
	}

	int getItemNo() {
		return itemNo;
	}

	Cart(String userNo, String itemNo) {
		this.userNo = Integer.parseInt(userNo);
		this.itemNo = Integer.parseInt(itemNo);
	}
}

class ItemDAO {
	Item[] itemList;

	ItemDAO(String idata) {
		String[] itemTemp = idata.split(",");
		int size = itemTemp.length;
		itemList = new Item[size];
		for (int i = 0; i < size; i++) {
			String[] info = itemTemp[i].split("/");
			itemList[i] = new Item(info[0], info[1], info[2]);
		}
	}

	Item[] getItemList() {
		return itemList;
	}
}

class UserDAO {
	User[] userList;

	UserDAO(String udata) {
		String[] userTemp = udata.split(",");
		int size = userTemp.length;
		userList = new User[size];
		for (int i = 0; i < size; i++) {
			String[] info = userTemp[i].split("/");
			userList[i] = new User(info[0], info[1]);
		}
	}

	User[] getUserList() {
		return userList;
	}
}

class CartDAO {
	Cart[] cartList;
	UserDAO udao;
	ItemDAO idao;

	void init(String idata, String udata, String cdata) {
		udao = new UserDAO(udata);
		idao = new ItemDAO(idata);
		String[] cartTemp = cdata.split("\n");
		int size = cartTemp.length;
		cartList = new Cart[size];
		for (int i = 0; i < size; i++) {
			String[] info = cartTemp[i].split("/");
			cartList[i] = new Cart(info[0], info[1]);
		}
	}

	String getDataQuiz1() {
		String data = "";
		User[] uList = udao.getUserList();
		Item[] iList = idao.getItemList();
		for (int i = 0; i < uList.length; i++) {
			data += uList[i] + "==>";
			data += getPersonalUserCarts(iList, uList, i);
			data = data.substring(0, data.length() - 1) + "\n";
		}
		return data;
	}

	String getPersonalUserCarts(Item[] iList, User[] uList, int idx) {
		String data = "";
		for (int i = 0; i < iList.length; i++) {
			int cnt = 0;
			for (int k = 0; k < cartList.length; k++) {
				boolean isMatch = uList[idx].getUserNo() == cartList[k].getUserNo()
						&& cartList[k].getItemNo() == iList[i].getItemNo();
				if (isMatch)
					cnt++;
			}
			if (cnt != 0)
				data += iList[i] + "," + cnt + ",";
		}
		return data;
	}

	String getDataQuiz2() {
		String data = "";
		User[] uList = udao.getUserList();
		Item[] iList = idao.getItemList();
		for (int i = 0; i < iList.length; i++) {
			data += iList[i] + "==>";
			data += getBuyingUsers(uList, iList, i);
			data = data.substring(0, data.length() - 1) + "\n";
		}
		return data;
	}

	String getBuyingUsers(User[] uList, Item[] iList, int idx) {
		String data = "";
		for (int i = 0; i < uList.length; i++)
			for (int k = 0; k < cartList.length; k++) {
				boolean isMatch = uList[i].getUserNo() == cartList[k].getUserNo()
						&& cartList[k].getItemNo() == iList[idx].getItemNo();
				if (isMatch) {
					data += uList[i].getName() + ",";
					break;
				}
			}
		return data;
	}

	void saveData(String fileName, String data) {
		String filePath = System.getProperty("user.dir") + "\\src\\level7시험\\" + fileName;
		try (FileWriter fw = new FileWriter(filePath)) {
			fw.write(data);
			System.out.println(filePath + "저장 성공");
		} catch (Exception e) {
			System.out.println(filePath + "저장 실패");
		}
	}

	void loadData(String fileName) {
		String filePath = System.getProperty("user.dir") + "\\src\\level7시험\\" + fileName;
		try (FileReader fr = new FileReader(filePath); BufferedReader br = new BufferedReader(fr)) {
			System.out.println(filePath + "불러오기 성공");
			printData(br);
		} catch (Exception e) {
			System.out.println(filePath + "불러오기 실패");
		}
	}

	void printData(BufferedReader br) throws Exception {
		String data = "";
		while (true) {
			String getData = br.readLine();
			if (getData == null)
				break;
			data += getData + "\n";
		}
		System.out.println(data);
	}

	// 유저이름==>품목명,갯수,품목명,갯수
	void quiz1() {
		String data = getDataQuiz1();
		saveData("quiz1.txt", data);
		loadData("quiz1.txt");
	}

	// 품목명==>유저이름,유저이름
	void quiz2() {
		String data = getDataQuiz2();
		saveData("quiz2.txt", data);
		loadData("quiz2.txt");
	}

	void run(String idata, String udata, String cdata) {
		init(idata, udata, cdata);
		System.out.println("====문제1====");
		quiz1();
		System.out.println("====문제2====");
		quiz2();
	}
}

public class _04 {

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
	// 소요 시간 : 55분 53초
}
