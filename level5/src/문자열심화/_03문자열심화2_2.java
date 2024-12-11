package 문자열심화;

public class _03문자열심화2_2 {

	public static void main(String[] args) {

		String data = "";
		data += "100001/이만수/600\n";
		data += "100003/유재석/7000\n";
		data += "100001/이만수/100\n";
		data += "100002/이영희/400\n";
		data += "100001/이만수/600\n";
		data += "100004/박명수/900\n";
		data += "100001/이만수/130\n";
		data += "100003/유재석/200\n";
		data += "100002/이영희/700\n";
		data += "100002/이영희/900\n";
		data += "100004/박명수/800\n";
		String[] datas = data.split("\n");
		int size = datas.length;
		String[] numList = new String[size];
		String[] nameList = new String[size];
		int[] moneyList = new int[size];
		int idx = 0;
		for(String temp : datas) { 
			numList[idx] = temp.split("/")[0];
			nameList[idx] = temp.split("/")[1];
			moneyList[idx] = Integer.parseInt(temp.split("/")[2]);
			idx++;
		}
		String[] tempNums = new String[size]; 
		int cnt = 0;
		for(int i = 0;i<size;i++) {
			boolean isSame = false;
			for(int k = 0;k<i;k++) {
				if(numList[i].equals(numList[k])) {
					isSame = true;
					break;
				}
			}
			if(!isSame) {
			tempNums[cnt++] = numList[i];
			}
		}
		String[][] userData = new String[cnt][3];
		String result = "";
		for(int i = 0;i<cnt;i++) {
			int money = 0;
			userData[i][0] = tempNums[i];
			for(int k = 0;k<size;k++) {
				if(numList[k].equals(tempNums[i])) {
					userData[i][1] = nameList[k];
					money += moneyList[k];
				}
			}
			userData[i][2] = money+"";
//			result += userData[i][0] + "  " + userData[i][1] + "  " + userData[i][2] + "원\n";
			result += String.format("%s  %s  %s원\n", userData[i][0] ,userData[i][1],userData[i][2]);
		}
		System.out.println(result);
	}

}
