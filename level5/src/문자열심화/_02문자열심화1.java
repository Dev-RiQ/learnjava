package 문자열심화;

public class _02문자열심화1 {

	/*
	 	향상된 for문
	 	
	 	for(배열요소타입 이름 : 배열이름){
	 	
	 	}
	 */
	
	public static void main(String[] args) {

		String nameData = "";
		nameData += "100001/이만수\n";
		nameData += "100002/이영희\n";
		nameData += "100003/유재석\n";
		nameData += "100004/박명수\n";
		nameData += "100005/차은우\n";
		nameData += "100006/박연미\n";

		String moneyData = "";
		moneyData += "100001/600\n";
		moneyData += "100003/7000\n";
		moneyData += "100001/100\n";
		moneyData += "100002/400\n";
		moneyData += "100001/600\n";
		moneyData += "100004/900\n";
		moneyData += "100001/130\n";
		moneyData += "100003/200\n";
		moneyData += "100002/700\n";
		moneyData += "100002/900\n";
		moneyData += "100004/800\n";

		String[] userDatas = nameData.split("\n");
		String[] moneyDatas = moneyData.split("\n");
		String[][] users = new String[userDatas.length][];
		String[][] moneys = new String[moneyDatas.length][];
		int idx = 0;
		for(String temp : moneyDatas) { // 자동으로 0번부터 배열 끝까지 돌려줌
			moneys[idx++] = temp.split("/");
		}
//		for (int i = 0; i < moneys.length; i++) {
//			moneys[i] = moneyDatas[i].split("/");
//		}
		idx = 0;
		for(String temp : userDatas) { // 자동으로 0번부터 배열 끝까지 돌려줌
			users[idx++] = temp.split("/");
		}
//		for (int i = 0; i < users.length; i++) {
//			users[i] = userDatas[i].split("/");
//		}
		String userData = "";
		for (String[] money : moneys) {
			for (String[] user : users) {
				if (money[0].equals(user[0])) {
					userData += String.format("%s/%s/%s\n",user[0], user[1], money[1]);
				}
			}
		}
		System.out.println(userData);
	}

}
