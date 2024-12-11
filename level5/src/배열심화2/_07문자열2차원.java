package 배열심화2;

import java.util.Arrays;

public class _07문자열2차원 {

	public static void main(String[] args) {

		/*
		 	userData는 회원번호와 이름이다
		 	pointData는 포인트 점수오 ㅏ회원번호이다
		 	번호가 여러개면 누적
		 	점수가 가장 높은 회원 이름 출력
		 */
		String userData = "1001/김철수철수\n";
		userData += "10023/이만수르\n";
		userData += "1/1빠요~\n";
		userData += "1003/경찰청철창살\n";
		userData += "1002223/홍\n";
		userData += "1000/김치찌개\n";
		userData += "9876/응우옌 띠옌\n";
		userData += "11/모닝빵";

		String pointData = "101,1001\n";
		pointData += "1,10023\n";
		pointData += "199,1003\n";
		pointData += "1,1001\n";
		pointData += "999999,1000\n";
		pointData += "5,1001\n";
		pointData += "2092011034,9876\n";
		pointData += "12,11\n";
		pointData += "12,11\n";
		pointData += "12,11\n";
		pointData += "12,11\n";
		pointData += "10,1003\n";
		pointData += "1,1001\n";
		pointData += "2,1002";
		String[] userDatas = userData.split("\n");
		String[] pointDatas = pointData.split("\n");
		String[][] userNum = new String[userDatas.length][];
		for (int i = 0; i < userDatas.length; i++) {
			userNum[i] = userDatas[i].split("/");
		}
		String[][] pointNum = new String[pointDatas.length][];
		for (int i = 0; i < pointDatas.length; i++) {
			pointNum[i] = pointDatas[i].split(",");
		}
		String[][] temp = new String[userNum.length][userNum[0].length];
		temp = userNum;
		userNum = new String[userNum.length][userNum[0].length + 1];
		int idx = 0;
		for (int i = 0; i < userNum.length; i++) {
			for (int k = 0; k < userNum[i].length; k++) {
				if (i < temp.length && k < temp[i].length) {
					userNum[i][k] = temp[i][k];
				}
			}
			for (int j = 0; j < pointNum.length; j++) {
				if (userNum[i][2] == null) {
					userNum[i][2] = "0";
				}
				if (userNum[i][0].equals(pointNum[j][1])) {
					userNum[i][2] = "" + (Integer.parseInt(userNum[i][2]) + Integer.parseInt(pointNum[j][0]));
				}

			}
			for (int k = 0; k < i; k++) {
				if (Integer.parseInt(userNum[i][2]) < Integer.parseInt(userNum[k][2])) {
					break;
				}
				idx = i;
			}
			System.out.println(Arrays.toString(userNum[i]));
		}
		System.out.println();
		System.out.println("===========     V.I.P     ===========");
		System.out.printf("%s번 회원 %s, %s점\n", userNum[idx][0], userNum[idx][1], userNum[idx][2]);
		System.out.println("=====================================");
		
		
	}

}
