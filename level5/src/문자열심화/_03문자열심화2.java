package 문자열심화;

public class _03문자열심화2 {

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
		String[][] user = new String[datas.length][3];
		int cnt = 0;
		for (int i = 0; i < user.length; i++) {
			String[] temp = datas[i].split("/");
			boolean isDupl = false;
			for (int k = 0; k < cnt; k++) {
				if (user[k][0].equals(temp[0])) {
					isDupl = true;
					user[k][2] = (Integer.parseInt(user[k][2]) + Integer.parseInt(temp[2])) + "";
					break;
				}
			}
			if(!isDupl) {
				user[cnt][0] = temp[0];
				user[cnt][1] = temp[1];
				user[cnt][2] = temp[2];
				cnt++;
			}
		}
		for(String[] print : user) {
			if(print[0] != null) {
				System.out.printf("%s  %s  %s원\n", print[0], print[1], print[2]);
			}
		}
//		String[][] userTotal = new String[cnt][user[0].length];
//		boolean[] isInput = new boolean[user.length];
//		int idx = 0;
//		for (int i = 0; i < user.length; i++) {
//			if (!isInput[i]) {
//				userTotal[idx] = user[i];
//				isInput[i] = true;
//			} else {
//				continue;
//			}
//			for (int k = i + 1; k < user.length; k++) {
//				if (!isInput[k] && user[i][0].equals(user[k][0])) {
//					
//					isInput[k] = true;
//				}
//			}
//			idx++;
//		}
	}

}
