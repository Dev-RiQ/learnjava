package 파일;

import java.io.File;
import java.io.FileWriter;

class User {
	int userNo;
	String userID;
	String userPW;
	int userLV;
	String fieldStage;

	int getUserNo() {
		return userNo;
	}

	String getUserID() {
		return userID;
	}

	int getUserLV() {
		return userLV;
	}

	String getFieldNo() {
		return fieldStage;
	}

	User(String userNo, String userID, String userPW, String userLV, String fieldStage) {
		this.userNo = Integer.parseInt(userNo);
		this.userID = userID;
		this.userPW = userPW;
		this.userLV = Integer.parseInt(userLV);
		this.fieldStage = fieldStage;
	}

}

class Field {
	String fieldStage;
	String fieldName;
	int fieldLV;

	String getFieldNo() {
		return fieldStage;
	}

	String getFieldName() {
		return fieldName;
	}

	int getFieldLV() {
		return fieldLV;
	}

	Field(String fieldStage, String fieldName, String fieldLV) {
		this.fieldStage = fieldStage;
		this.fieldName = fieldName;
		this.fieldLV = Integer.parseInt(fieldLV);
	}

}

class Item {
	int itemNo;
	String itemName;
	int itemPrice;

	int getItemNo() {
		return itemNo;
	}

	String getItemName() {
		return itemName;
	}

	int getItemPrice() {
		return itemPrice;
	}

	Item(String itemNo, String itemName, String itemPrice) {
		this.itemNo = Integer.parseInt(itemNo);
		this.itemName = itemName;
		this.itemPrice = Integer.parseInt(itemPrice);
	}

}

class Cart {
	int userNo;
	int itemNo;
	int itemCnt;

	int getUserNo() {
		return userNo;
	}

	int getItemNo() {
		return itemNo;
	}

	int getItemCnt() {
		return itemCnt;
	}

	Cart(String userNo, String itemNo, String itemCnt) {
		this.userNo = Integer.parseInt(userNo);
		this.itemNo = Integer.parseInt(itemNo);
		this.itemCnt = Integer.parseInt(itemCnt);
	}

}

class UserDAO {

	User[] uList;

	User[] getuList() {
		return uList;
	}

	UserDAO(String[][] userData) {
		uList = new User[userData.length];
		for (int i = 0; i < uList.length; i++) {
			String[] info = userData[i];
			uList[i] = new User(info[0], info[1], info[2], info[3], info[4]);
		}
	}
}

class FieldDAO {

	Field[] fList;

	Field[] getfList() {
		return fList;
	}

	FieldDAO(String fieldData) {
		String[] data = fieldData.split("\n");
		fList = new Field[data.length];
		for (int i = 0; i < fList.length; i++) {
			String[] info = data[i].split("/");
			fList[i] = new Field(info[0], info[1], info[2]);
		}
	}
}

class ItemDAO {

	Item[] iList;

	Item[] getiList() {
		return iList;
	}

	ItemDAO(String[][] itemData) {
		iList = new Item[itemData.length];
		for (int i = 0; i < iList.length; i++) {
			String[] info = itemData[i];
			iList[i] = new Item(info[0], info[1], info[2]);
		}
	}
}

class CartDAO {

	Cart[] cList;

	Cart[] getcList() {
		return cList;
	}

	CartDAO(String cartData) {
		String[] data = cartData.split("\n");
		cList = new Cart[data.length];
		for (int i = 0; i < cList.length; i++) {
			String[] info = data[i].split("/");
			cList[i] = new Cart(info[0], info[1], info[2]);
		}
	}

}

class GameService {

	UserDAO udao;
	FieldDAO fdao;
	ItemDAO idao;
	CartDAO cdao;

	GameService(String[][] userData, String fieldData, String[][] itemData, String cartData) {
		udao = new UserDAO(userData);
		fdao = new FieldDAO(fieldData);
		idao = new ItemDAO(itemData);
		cdao = new CartDAO(cartData);
	}

	int[] getUserItemCnt(Cart[] cList, Item[] iList, User[] uList, int idx) {
		int[] userItemCnt = new int[iList.length];
		for (int i = 0; i < iList.length; i++) {
			int cnt = 0;
			for (int k = 0; k < cList.length; k++)
				if (uList[idx].getUserNo() == cList[k].getUserNo() && cList[k].getItemNo() == iList[i].getItemNo())
					cnt += cList[k].getItemCnt();
			userItemCnt[i] = cnt;
		}
		return userItemCnt;
	}

	int getUserPrice(Cart[] cList, Item[] iList, User[] uList, int idx) {
		int price = 0;
		for (int i = 0; i < iList.length; i++)
			for (int k = 0; k < cList.length; k++)
				if (uList[idx].getUserNo() == cList[k].getUserNo() && cList[k].getItemNo() == iList[i].getItemNo())
					price += iList[i].getItemPrice() * cList[k].getItemCnt();
		return price;
	}

	String getUserFieldName(User user, Field[] fList) {
		String fieldName = "";
		for (int i = 0; i < fList.length; i++)
			if (fList[i].getFieldNo().equals(user.getFieldNo()))
				fieldName = fList[i].getFieldName();
		return fieldName;
	}

	int getUserFieldLV(User user, Field[] fList) {
		int fieldLV = 0;
		for (int i = 0; i < fList.length; i++)
			if (fList[i].getFieldNo().equals(user.getFieldNo()))
				fieldLV = fList[i].getFieldLV();
		return fieldLV;
	}

	String getUserFieldSuit(User user, int fieldLV) {
		int differenceLV = user.getUserLV() - fieldLV;
		if (differenceLV < -5)
			return "미달";
		else if (differenceLV > 5)
			return "여유";
		return "적정";
	}

	String setInfo() {
		String info = "";
		for (int i = 0; i < udao.getuList().length; i++) {
			User[] uList = udao.getuList();
			Field[] fList = fdao.getfList();
			Item[] iList = idao.getiList();
			Cart[] cList = cdao.getcList();
			info += "==== ";
			info += uList[i].getUserNo();
			info += "번 회원 (";
			info += uList[i].getUserID();
			info += ") ====\n";
			info += "LV : ";
			info += uList[i].getUserLV();
			info += "\n";
			info += "Stage : ";
			info += uList[i].getFieldNo();
			info += "\n";
			info += "Field : ";
			info += getUserFieldName(uList[i], fList);
			info += " (";
			int fieldLV = getUserFieldLV(uList[i], fList);
			info += getUserFieldSuit(uList[i], fieldLV);
			info += ")\n";
			info += "==== 아이템 구매 이력서 ====\n";
			int[] cnt = getUserItemCnt(cList, iList, uList, i);
			for (int k = 0; k < cnt.length; k++)
				if (cnt[k] != 0) {
					info += iList[k].getItemName();
					info += " : ";
					info += cnt[k];
					info += "개\n";
				}
			info += " => 총 이용 금액 : ";
			info += getUserPrice(cList, iList, uList, i);
			info += "원\n";
			info += "============================\n\n";
		}
		return info;
	}

	void saveInfo() {
		String info = setInfo();
		String path = System.getProperty("user.dir");
		String packagePath = path + "\\src\\파일\\";
		String fileName = "userInfo.txt";
		String filePath = packagePath + fileName;

		File file = new File(filePath);
		try (FileWriter fw = new FileWriter(file)) {
			fw.write(info);
			System.out.println(fileName + " 저장 완료");
			System.out.println("저장 경로 : " + filePath);
		} catch (Exception e) {
			System.out.println("저장 실패");
			e.printStackTrace();
		}
	}

	void run() {
		// [문제] 출력 예시와 같이 데이터를 통합하여 해당 파일과 같은 패키지 내에 userInfo.txt 생성하기
		// (필드 옆의 괄호는 userLV와 fieldLV과 -5~5레벨 차이면 적정, -5레벨 초과면 미달, +5레벨 초과면 여유)
		saveInfo();
	}
}

public class _00연습 {

	public static void main(String[] args) {

		// User, Game, Item, Cart 항목의 VO 및 DAO 클래스 생성
		// 해당 클래스들을 통합할 수 있는 GameService 클래스 생성
		
		// **** 클래스 간의 데이터 변경 및 불러오기는 간접접근을 이용
		// **** 각 클래스 모두 생성자 이용하여 인스턴스 생성
		// **** 기존에 주어진 멤버변수 외의 변수는 생성하지 않는다. 

		// userData = {회원번호, 아이디, 비밀번호, 현재레벨 ,필드번호(현재스테이지)}
		// {userNo, userID, userPW, userLV, fieldStage}

		// fieldData = 필드번호/필드명/추천레벨
		// fieldStage/fieldName/fieldLV

		// itemData = {아이템번호, 아이템명, 아이템가격}
		// {itemNo, itemName, itemPrice}

		// cartData = 회원번호/아이템번호/구매수량
		// userNo/itemNo/itemCnt

		String[][] userData = {
				{ "1001", "qwer", "1111", "1", "1-0" },
				{ "1002", "asdf", "2222", "94", "1-10" },
				{ "1003", "zxcv", "3333", "34", "1-2" },
				{ "1004", "tyui", "4444", "21", "1-2" },
				{ "1005", "ghjk", "5555", "67", "1-8" }
		};
		
		String fieldData = "";
		fieldData += "1-0/튜토리얼/1\n";
		fieldData += "1-1/골렘의 사원/10\n";
		fieldData += "1-2/요정의 숲/20\n";
		fieldData += "1-3/골드비치/30\n";
		fieldData += "1-4/엘리넬/40\n";
		fieldData += "1-5/드레이크의 슾지/50\n";
		fieldData += "1-6/로얄카투스의 사막/60\n";
		fieldData += "1-7/C-2/70\n";
		fieldData += "1-8/관계자외 출입금지/80\n";
		fieldData += "1-9/푸른켄타로우스의 전장/90\n";
		fieldData += "1-10/불과 어둠의 전장/100";
		
		String[][] itemData = {
				{ "101", "엘릭서 100개", "1000" },
				{ "102", "10만 골드", "3000" },
				{ "103", "스킬북 Lv.1", "1200" },
				{ "104", "스킬북 Lv.2", "1800" },
				{ "105", "직업 변경권", "2300" }
		};
		
		String cartData = "";
		cartData += "1001/101/13\n";
		cartData += "1002/103/2\n";
		cartData += "1001/103/31\n";
		cartData += "1004/104/1\n";
		cartData += "1002/105/1\n";
		cartData += "1001/102/74\n";
		cartData += "1001/104/111\n";
		cartData += "1001/105/1\n";
		cartData += "1002/104/48\n";
		cartData += "1005/102/50\n";
		cartData += "1001/103/13\n";
		cartData += "1005/103/11\n";
		cartData += "1003/102/999\n";
		cartData += "1004/105/1\n";
		cartData += "1005/101/9";
		
		GameService gs = new GameService(userData, fieldData, itemData, cartData);
		gs.run();
	}

}
