package 문자열기본문제;

public class _04문자열문제2 {

	public static void main(String[] args) {
		
		String userData = "1001,1002,1003,1004";
		int user = 1003;
		String[] userDatas = userData.split(",");
		boolean isEqual = false;
		for (int i = 0; i < userDatas.length; i++) {
			if ((user + "").equals(userDatas[i])) {
				isEqual = true;
				break;
			}
		}
		System.out.println(isEqual);
	}
}
